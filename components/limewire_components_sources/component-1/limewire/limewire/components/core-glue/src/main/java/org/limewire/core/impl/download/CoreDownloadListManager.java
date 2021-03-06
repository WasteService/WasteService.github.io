package org.limewire.core.impl.download;

import java.awt.EventQueue;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.limewire.collection.glazedlists.GlazedListsFactory;
import org.limewire.core.api.Category;
import org.limewire.core.api.download.DownloadAction;
import org.limewire.core.api.download.DownloadItem;
import org.limewire.core.api.download.DownloadListManager;
import org.limewire.core.api.download.DownloadState;
import org.limewire.core.api.download.SaveLocationException;
import org.limewire.core.api.library.RemoteFileItem;
import org.limewire.core.api.magnet.MagnetLink;
import org.limewire.core.api.search.Search;
import org.limewire.core.api.search.SearchResult;
import org.limewire.core.api.spam.SpamManager;
import org.limewire.core.impl.download.listener.ItunesDownloadListenerFactory;
import org.limewire.core.impl.download.listener.RecentDownloadListener;
import org.limewire.core.impl.library.CoreRemoteFileItem;
import org.limewire.core.impl.magnet.MagnetLinkImpl;
import org.limewire.core.impl.search.CoreSearch;
import org.limewire.core.impl.search.MediaTypeConverter;
import org.limewire.core.impl.search.RemoteFileDescAdapter;
import org.limewire.core.settings.SharingSettings;
import org.limewire.io.GUID;
import org.limewire.io.IpPort;
import org.limewire.io.IpPortSet;
import org.limewire.listener.EventListener;
import org.limewire.listener.SwingSafePropertyChangeSupport;
import org.limewire.setting.FileSetting;
import org.limewire.util.FileUtils;
import org.limewire.util.Objects;

import ca.odell.glazedlists.BasicEventList;
import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.GlazedLists;
import ca.odell.glazedlists.ObservableElementList;
import ca.odell.glazedlists.impl.ThreadSafeList;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.limegroup.bittorrent.BTMetaInfo;
import com.limegroup.bittorrent.BTTorrentFileDownloader;
import com.limegroup.gnutella.ActivityCallback;
import com.limegroup.gnutella.DownloadManager;
import com.limegroup.gnutella.Downloader;
import com.limegroup.gnutella.RemoteFileDesc;
import com.limegroup.gnutella.Downloader.DownloadStatus;
import com.limegroup.gnutella.browser.MagnetOptions;
import com.limegroup.gnutella.downloader.CoreDownloader;
import com.limegroup.gnutella.downloader.DownloadStatusEvent;
import com.limegroup.gnutella.downloader.RemoteFileDescFactory;

@Singleton
public class CoreDownloadListManager implements DownloadListManager {
    
    private static final String DOWNLOAD_ITEM = "limewire.download.glueItem";
    
	private final EventList<DownloadItem> observableDownloadItems;
	private EventList<DownloadItem> swingThreadDownloadItems;
	private final DownloadManager downloadManager;
	private final RemoteFileDescFactory remoteFileDescFactory;
	private final QueueTimeCalculator queueTimeCalculator;
    private final ActivityCallback activityCallback;
    private final SpamManager spamManager;
    private final ItunesDownloadListenerFactory itunesDownloadListenerFactory;
    private final PropertyChangeSupport changeSupport = new SwingSafePropertyChangeSupport(this);
    /**the base list - all removing and adding must be done from here.*/
    private final ThreadSafeList<DownloadItem> threadSafeDownloadItems;
    
    private static final int PERIOD = 1000;
    
    private Map<org.limewire.core.api.URN, DownloadItem> urnMap = new HashMap<org.limewire.core.api.URN, DownloadItem>();
	
	@Inject
	public CoreDownloadListManager(DownloadManager downloadManager,
            DownloadListenerList listenerList, @Named("backgroundExecutor")
            ScheduledExecutorService backgroundExecutor,
            RemoteFileDescFactory remoteFileDescFactory, ActivityCallback activityCallback, SpamManager spamManager, ItunesDownloadListenerFactory itunesDownloadListenerFactory) {
	    this.downloadManager = downloadManager;
	    this.remoteFileDescFactory = remoteFileDescFactory;
	    this.activityCallback = activityCallback;
        this.spamManager = spamManager;
        this.itunesDownloadListenerFactory = itunesDownloadListenerFactory;
        
        threadSafeDownloadItems = GlazedListsFactory.threadSafeList(new BasicEventList<DownloadItem>());
	    ObservableElementList.Connector<DownloadItem> downloadConnector = GlazedLists.beanConnector(DownloadItem.class);
	    observableDownloadItems = GlazedListsFactory.observableElementList(threadSafeDownloadItems, downloadConnector);
	    this.queueTimeCalculator = new QueueTimeCalculator(observableDownloadItems);
	    listenerList.addDownloadListener(new CoreDownloadListener(threadSafeDownloadItems, queueTimeCalculator));
	    
	  //TODO: change backgroundExecutor to listener - currently no listener for download progress
      //hack to force tables to update
	    Runnable command = new Runnable() {
            @Override
            public void run() {
                update();
            }
        };
        backgroundExecutor.scheduleAtFixedRate(command, 0, PERIOD, TimeUnit.MILLISECONDS);

	}

    // forces refresh
    private void update() {
        observableDownloadItems.getReadWriteLock().writeLock().lock();
        try {
            // TODO use TransactionList for these for performance (requires using GlazedLists from head)
            for (DownloadItem item : observableDownloadItems) {
                if (item.getState() != DownloadState.DONE &&  item instanceof CoreDownloadItem)
                    ((CoreDownloadItem) item).fireDataChanged();
            }
        } finally {
            observableDownloadItems.getReadWriteLock().writeLock().unlock();
        }
    }
	
	@Override
	public EventList<DownloadItem> getDownloads() {
		return observableDownloadItems;
	}
	
	@Override
	public EventList<DownloadItem> getSwingThreadSafeDownloads() {
	    assert EventQueue.isDispatchThread();
	    if(swingThreadDownloadItems == null) {
	        swingThreadDownloadItems = GlazedListsFactory.swingThreadProxyEventList(observableDownloadItems);
	    }
	    return swingThreadDownloadItems;
	}

	@Override
	public DownloadItem addDownload(Search search, List<? extends SearchResult> searchResults) throws SaveLocationException {
	   return addDownload(search, searchResults, null, false);
	}
	

    @Override
    public DownloadItem addDownload(Search search, List<? extends SearchResult> searchResults,
            File saveFile, boolean overwrite) throws SaveLocationException {
        // Train the spam filter even if the results weren't rated as spam
        spamManager.handleUserMarkedGood(searchResults);
        
        
        RemoteFileDesc[] files;
        List<RemoteFileDesc> alts = new ArrayList<RemoteFileDesc>();
        files = createRfdsAndAltsFromSearchResults(searchResults, alts);
        
        GUID queryGUID = null;
        if(search != null && search instanceof CoreSearch) {
            queryGUID = ((CoreSearch)search).getQueryGuid();
        }
        
        Category category = searchResults.iterator().next().getCategory();
        return createDownloader(files, alts, queryGUID, saveFile, overwrite, category);
    }
	
	private DownloadItem createDownloader(RemoteFileDesc[] files, List<RemoteFileDesc> alts,
                                          GUID queryGuid, File saveFile, boolean overwrite, Category category)
            throws SaveLocationException {
        
        File saveDir = null;
        String fileName = null;
        
        if(saveFile != null) {
            if(saveFile.isDirectory()) {
                saveDir = saveFile;
            } else {
                saveDir = saveFile.getParentFile();
                fileName = saveFile.getName();
            }
        }

        // determine per mediatype directory if saveLocation == null
        // and only pass it through if directory is different from default
        // save directory == !isDefault()
        //if (saveDir == null &&) {
            FileSetting fs = SharingSettings.getFileSettingForMediaType
            (MediaTypeConverter.toMediaType(category));
            if (!fs.isDefault()) {
                saveDir = fs.getValue();
            }
       // }
        Downloader downloader = downloadManager.download(files, alts, queryGuid, overwrite, saveDir, fileName);
        // This should have been funneled through our addDownload callback method, which
        // should have set the CoreDownloadItem.
        return (DownloadItem)downloader.getAttribute(DOWNLOAD_ITEM);
    }

    @Override
    public DownloadItem addDownload(RemoteFileItem fileItem) throws SaveLocationException {
        return addDownload(fileItem, null, false);
    }
    
    @Override
    public DownloadItem addDownload(RemoteFileItem fileItem, File saveFile, boolean overwrite) throws SaveLocationException {
        return createDownloader(new RemoteFileDesc[] { ((CoreRemoteFileItem) fileItem).getRfd() },
                RemoteFileDesc.EMPTY_LIST, null, saveFile, overwrite, fileItem.getCategory());    
    }

	private RemoteFileDesc[] createRfdsAndAltsFromSearchResults(
            List<? extends SearchResult> searchResults, List<RemoteFileDesc> altList) {
	    RemoteFileDesc[] rfds = new RemoteFileDesc[searchResults.size()];
        Set<IpPort> alts = new IpPortSet();
        
        for(int i = 0; i < searchResults.size(); i++) {
            RemoteFileDescAdapter rfdAdapter = (RemoteFileDescAdapter)searchResults.get(i);
            rfds[i] = rfdAdapter.getRfd();
            alts.addAll(rfdAdapter.getAlts());
        }        
        
        // Iterate through RFDs and remove matching alts.
        // Also store the first SHA1 capable RFD for collecting alts.
        RemoteFileDesc sha1RFD = null;
        for(int i = 0; i < rfds.length; i++) {
            RemoteFileDesc next = rfds[i];
            if(next.getSHA1Urn() != null)
                sha1RFD = next;
            alts.remove(next.getAddress()); // Removes an alt that matches the IpPort of the RFD
        }

        // If no SHA1 rfd, just use the first.
        if(sha1RFD == null)
            sha1RFD = rfds[0];
        
        // Now iterate through alts & add more rfds.
        for(IpPort next : alts) {
            altList.add(remoteFileDescFactory.createRemoteFileDesc(sha1RFD, next));
        }
        
        return rfds;
    }

	/**
	 * Adds the specified listener to the list that is notified when a 
	 * property value changes.  Listeners added from the Swing UI thread will 
	 * always receive notification events on the Swing UI thread. 
	 */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    /**
     * Removes the specified listener from the list that is notified when a 
     * property value changes.
     */
    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
    /**
     * Checks for downloads in progress, and fires a property change event if
     * all downloads are completed.
     */
    @Override
    public void updateDownloadsCompleted() {
        if (downloadManager.downloadsInProgress() == 0) {
            changeSupport.firePropertyChange(DOWNLOADS_COMPLETED, false, true);
        }
    }

    private class CoreDownloadListener implements DownloadListener {
	    
	    private final List<DownloadItem> list;
	    private final QueueTimeCalculator queueTimeCalculator;

        public CoreDownloadListener(List<DownloadItem> list, QueueTimeCalculator queueTimeCalculator){
	        this.list = list;
	        this.queueTimeCalculator = queueTimeCalculator;
	    }

        @Override
        public void downloadAdded(Downloader downloader) {
            DownloadItem item = new CoreDownloadItem(downloader, queueTimeCalculator);
            downloader.setAttribute(DOWNLOAD_ITEM, item, false);
            downloader.addListener(new TorrentListener(downloader));
            downloader.addListener(new RecentDownloadListener(downloader));
            downloader.addListener(itunesDownloadListenerFactory.createListener(downloader));
            list.add(item);
            urnMap.put(item.getUrn(), item);
        }

        @Override
        public void downloadRemoved(Downloader downloader) {
            DownloadItem item = getDownloadItem(downloader);

            if (item.getState() == DownloadState.DONE) {
                changeSupport.firePropertyChange(DOWNLOAD_COMPLETED, null, item);
            }
            
            //don't automatically remove finished downloads or downloads in error states
            if ((item.getState() != DownloadState.DONE || SharingSettings.CLEAR_DOWNLOAD.getValue()) && 
                    item.getState() != DownloadState.ERROR) {
                list.remove(item);
            }
            urnMap.remove(item.getUrn());
        }
        
        @Override
        public void downloadsCompleted() {
            changeSupport.firePropertyChange(DOWNLOADS_COMPLETED, false, true);
        }

        private DownloadItem getDownloadItem(Downloader downloader) {
            DownloadItem item = (DownloadItem)downloader.getAttribute(DOWNLOAD_ITEM);
            return item;
        }
        
        
        /**
         * Listens for downloads of .torrent files to complete. 
         * When the download finishes then the torrent download will be started.
         */
        private class TorrentListener implements EventListener<DownloadStatusEvent> {
            private final Downloader downloader;
            public TorrentListener(Downloader downloader) {
                this.downloader = Objects.nonNull(downloader, "downloader");
                if(downloader.getState() == DownloadStatus.COMPLETE) {
                    //TODO not sure why Downloader and CoreDownloader are not merged into one class.
                    //No classes implement Downloader, CoreDownloader extends Downloader, and all downloaders implement CoreDownloader
                    if(downloader instanceof CoreDownloader) {
                        handleEvent(new DownloadStatusEvent((CoreDownloader)downloader, DownloadStatus.COMPLETE));
                    }
                }
            }
            @Override
            public void handleEvent(DownloadStatusEvent event) {
                DownloadStatus downloadStatus = event.getType();
                if(DownloadStatus.COMPLETE == downloadStatus) {
                        if(downloader instanceof BTTorrentFileDownloader){
                            BTMetaInfo btMetaInfo = null;
                            try {
                            BTTorrentFileDownloader btTorrentFileDownloader = (BTTorrentFileDownloader)downloader;
                            btMetaInfo = btTorrentFileDownloader.getBtMetaInfo();
                            list.remove(getDownloadItem(downloader));
                            downloadManager.downloadTorrent(btMetaInfo, true);
                            } catch (SaveLocationException sle) {
                                final BTMetaInfo btMetaInfoCopy = btMetaInfo;
                                activityCallback.handleSaveLocationException(new DownloadAction() {
                                    @Override
                                    public void download(File saveFile, boolean overwrite)
                                            throws SaveLocationException {
                                        list.remove(getDownloadItem(downloader));
                                        downloadManager.downloadTorrent(btMetaInfoCopy, overwrite);
                                    }
                                }, sle, false);
                            }
                        } else {
                            File possibleTorrentFile = null;
                            try {
                                possibleTorrentFile = downloader.getSaveFile();
                                String fileExtension = FileUtils.getFileExtension(possibleTorrentFile);
                                if("torrent".equalsIgnoreCase(fileExtension)) {
                                    list.remove(getDownloadItem(downloader));
                                    downloadManager.downloadTorrent(possibleTorrentFile, false);
                                }
                            } catch (SaveLocationException sle) {
                                final File torrentFile = possibleTorrentFile;
                                activityCallback.handleSaveLocationException(new DownloadAction() {
                                    @Override
                                    public void download(File saveFile, boolean overwrite)
                                            throws SaveLocationException {
                                        list.remove(getDownloadItem(downloader));
                                        downloadManager.downloadTorrent(torrentFile, overwrite);
                                    }
                                }, sle, false);
                            }
                        }
                }
            }
        }
    }


    @Override
    public DownloadItem addTorrentDownload(URI uri, boolean overwrite) throws SaveLocationException {
        Downloader downloader =  downloadManager.downloadTorrent(uri, overwrite);
        DownloadItem downloadItem = (DownloadItem)downloader.getAttribute(DOWNLOAD_ITEM);
        return downloadItem;
    }
    
    @Override
    public DownloadItem addDownload(MagnetLink magnet, File saveFile, boolean overwrite) throws SaveLocationException {
        File saveDir = null;
        String fileName = null;
        
        if(saveFile != null) {
            if(saveFile.isDirectory()) {
                saveDir = saveFile;
            } else {
                saveDir = saveFile.getParentFile();
                fileName = saveFile.getName();
            }
        }
        MagnetOptions magnetOptions = ((MagnetLinkImpl)magnet).getMagnetOptions();
        Downloader downloader = downloadManager.download(magnetOptions, overwrite, saveDir, fileName);
        DownloadItem downloadItem = (DownloadItem)downloader.getAttribute(DOWNLOAD_ITEM);
        return downloadItem;
    }

    @Override
    public DownloadItem addTorrentDownload(File file, File saveFile, boolean overwrite)
            throws SaveLocationException {
        Downloader downloader = downloadManager.downloadTorrent(file, overwrite);
		return (DownloadItem)downloader.getAttribute(DOWNLOAD_ITEM);
    }

    @Override
    public boolean contains(org.limewire.core.api.URN urn) {
        return urnMap.containsKey(urn);
    }
    
    @Override
    public DownloadItem getDownloadItem(org.limewire.core.api.URN urn) {
        return urnMap.get(urn);
    }

    @Override
    public void clearFinished() {
        final List<DownloadItem> finishedItems = new ArrayList<DownloadItem>();
        threadSafeDownloadItems.getReadWriteLock().writeLock().lock();
        try {
            for (DownloadItem item : threadSafeDownloadItems) {
                if (item.getState() == DownloadState.DONE) {
                    finishedItems.add(item);
                }
            }

            threadSafeDownloadItems.removeAll(finishedItems);
        } finally {
            threadSafeDownloadItems.getReadWriteLock().writeLock().unlock();
        }
    }

    @Override
    public void remove(DownloadItem item) {
        threadSafeDownloadItems.remove(item);
    }

}