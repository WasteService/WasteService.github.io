/*
 * FolderEncryptionFrame.java
 *
 * Created on April 12, 2008, 3:13 PM
 */

package com.megaware.multipleencrypter.frames;

import com.megaware.multipleencrypter.methods.FolderEncryptionAlgorithmMethods;
import com.megaware.multipleencrypter.methods.GeneralMethods;
import com.megaware.multipleencrypter.objects.CodeObject;
import com.megaware.multipleencrypter.objects.FolderEncryptObject;
import java.io.File;
import java.util.Vector;

/**
 *
 * @author  name
 */
public class FolderEncryptionDialog extends javax.swing.JDialog {
    
    /** Creates new form FolderEncryptionFrame */
    public FolderEncryptionDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        setInitialState();
    }

   

    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstFiles = new javax.swing.JList();
        lblSelFilesCaption = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblSelFolderCaption = new javax.swing.JLabel();
        btnSelectFolder = new javax.swing.JButton();
        txtFolderPath = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnEncrypt = new javax.swing.JButton();
        btnDecrypt = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnShowDetails = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnHelp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("FOLDER ENCRYTPTION DIALOG");

        jPanel1.setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setViewportView(lstFiles);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        lblSelFilesCaption.setText("FILES FOR ENCRYPTION");
        jPanel2.add(lblSelFilesCaption, java.awt.BorderLayout.PAGE_START);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(20, 100, 340, 310);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(java.awt.Color.orange);
        jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(java.awt.Color.orange);
        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 13));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FOLDER ENCRYPTION DIALOG");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel5.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jPanel3.add(jPanel5, java.awt.BorderLayout.NORTH);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel6.setLayout(null);

        lblSelFolderCaption.setText("Folder to encrypt");
        jPanel6.add(lblSelFolderCaption);
        lblSelFolderCaption.setBounds(10, 0, 250, 17);

        btnSelectFolder.setText("Select folder");
        btnSelectFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectFolderActionPerformed(evt);
            }
        });
        jPanel6.add(btnSelectFolder);
        btnSelectFolder.setBounds(360, 15, 210, 29);

        txtFolderPath.setEditable(false);
        jPanel6.add(txtFolderPath);
        txtFolderPath.setBounds(7, 15, 350, 27);

        jPanel3.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(20, 10, 600, 80);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel4.setLayout(null);

        btnEncrypt.setText("ENCRYPT");
        btnEncrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncryptActionPerformed(evt);
            }
        });
        jPanel4.add(btnEncrypt);
        btnEncrypt.setBounds(20, 20, 210, 29);

        btnDecrypt.setText("DECRYPT");
        btnDecrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDecryptActionPerformed(evt);
            }
        });
        jPanel4.add(btnDecrypt);
        btnDecrypt.setBounds(20, 60, 210, 29);

        btnClear.setText("CLEAR ALL VALUES");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel4.add(btnClear);
        btnClear.setBounds(20, 210, 210, 29);

        btnShowDetails.setText("Show details of folder");
        btnShowDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowDetailsActionPerformed(evt);
            }
        });
        jPanel4.add(btnShowDetails);
        btnShowDetails.setBounds(20, 240, 210, 29);

        btnRemove.setText("Remove selected file");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        jPanel4.add(btnRemove);
        btnRemove.setBounds(20, 180, 210, 29);

        btnHelp.setText("Quick Help");
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });
        jPanel4.add(btnHelp);
        btnHelp.setBounds(20, 270, 210, 29);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(370, 100, 250, 310);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-634)/2, (screenSize.height-452)/2, 634, 452);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelectFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectFolderActionPerformed
       getEncryptFolder();
    }//GEN-LAST:event_btnSelectFolderActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        this.clearAllValues(true);
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnEncryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncryptActionPerformed
        startEncryption();
    }//GEN-LAST:event_btnEncryptActionPerformed

    private void btnDecryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDecryptActionPerformed
        startDecryption();        
    }//GEN-LAST:event_btnDecryptActionPerformed

    private void btnShowDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowDetailsActionPerformed
        this.showEncryptedFolderDetails();
    }//GEN-LAST:event_btnShowDetailsActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        removeFile();
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        QuickHelpViewer help = new QuickHelpViewer(new javax.swing.JFrame(),true);
        help.setContentFile(new java.io.File(new GeneralMethods().getApplicationPath()+
                "settings/folderencryptiondialoghelp.html"));
        help.setVisible(true);
    }//GEN-LAST:event_btnHelpActionPerformed
    
    // function to get the files inside the selected folder
    protected void getFiles(File folder) {
        String subfiles[]=folder.list();       
        setEncrypted(false);
        if(subfiles!=null) {
            setFiles(new java.util.Vector());
            for (int i = 0; i < subfiles.length; i++) {
                String string = subfiles[i];
                if(string.equals("ENCRYPTIONSETTINGS.FMENCS")) {                    
                    // if the settings file is found then the folder is encrypted                    
                    this.setEncrypted(true);                                      
                    setSettingsfile(new File(folder + "/" + string));
                    this.readFolderEncryptObject();
                }                                
                getFiles().addElement(subfiles[i]);
            }
            
            // suppose the encryption settings is missing still the files may
            // be encrypted, so check for the extension and if they have 
            // .MENCF extension , they are decided as encrypted;
            if(isEncrypted()==false) {
                boolean checked=checkFilesAreEncrypted();
                if(checked==true) {
                    // files comes from an encrypted folder
                    // set encrypted=true;                                        
                    setEncrypted(true);
                }                
            } 
            
            // if files are encrypted then filter them
            if(isEncrypted()==true) {
                this.filterEncryptedFiles();
            }
            btnRemove.setEnabled(true);
            btnClear.setEnabled(true);
        }        
    }
    
    // function to refresh the list
    public void refreshList(String path) {
        this.clearAllValues(false);
        txtFolderPath.setText(path);
        getFiles(getFolderpath());
        this.addFilesToList();
    }
    
    // function to add the files to the list
    protected void addFilesToList() {
        lstModel.removeAllElements();
        for (int i = 0; i < getFiles().size(); i++) {
            Object obj = getFiles().elementAt(i);
            lstModel.addElement(obj);
        }
        lstFiles.setModel(lstModel);
    }
    
    // function to get the folder for encryption or decryption
    private void getEncryptFolder() {
        setFolderpath(new FolderEncryptionAlgorithmMethods().getEncryptFolder());
        if(getFolderpath()==null) return;
        
        txtFolderPath.setText(getFolderpath().getPath());
        getFiles(getFolderpath());
        this.addFilesToList();        
    }
    
    // function to remove the file from the list
    protected void removeFile() {
        if(lstFiles.getModel().getSize()==0) {
            return;            
        }
        int indices[]=lstFiles.getSelectedIndices();        
        if(indices==null) return;
        for (int i = indices.length-1; i >=0; i--) {
            int j = indices[i];
            lstModel.removeElementAt(j);    
            getFiles().remove(j);
        }        
        if(lstModel.size()==0)  clearAllValues(encrypted);
    }
    
    // function to check if the files ends with .MENCF extension in the files 
    // vector and if yes then set the encrytped=true;  
    private boolean checkFilesAreEncrypted() {
        boolean foundencrypted=false;
        for (int i = 0; i < files.size(); i++) {
            String file = files.elementAt(i).toString();
            
            // if file's extension if .MENCF then the folder is encrypted
            if(file.endsWith(".MENCF")) {
                foundencrypted=true;
                break;
            }            
        }
        return foundencrypted;

    }
    
    // function to filter the files list and keep only the files with extension
    // .MENCF
    protected void filterEncryptedFiles() {
        for (int i = files.size()-1; i >=0; i--) {
            String file = files.elementAt(i).toString();
            
            // if the file is not of .MENCF extension remove it
            if(!file.endsWith(".MENCF")) {
                files.removeElementAt(i);                
            }
        }
    }
    // function to set the intial state of buttons    
    private void setInitialState() {
        btnClear.setEnabled(false);
        setDecryptControlComponentState(false);
        setEncryptControlComponentState(false);
        btnRemove.setEnabled(false);
    }
    
    // function to set the caption for the labels relative to the process selected
    // if encrypted==true then encryption else decryption
    private void setLabelCaptionForProcess() {
        if(isEncrypted()==true) {            
            // if encrypted is true the possible process is DECRYPTION
            lblSelFolderCaption.setText("FOLDER FOR DECRYPTION");
            lblSelFilesCaption.setText("FILES SELECTED FOR DECRYPTION");            
        }
        else {
            // if encrypted is false the possible process is ENCRYPTION
            lblSelFolderCaption.setText("FOLDER FOR ENCRYPTION");
            lblSelFilesCaption.setText("FILES SELECTED FOR ENCRYPTION");
        }
    }
    
    // function to set the state of encryption process controls
    protected void setEncryptControlComponentState(boolean flag) {
        this.btnEncrypt.setEnabled(flag);
        
    }
    
    // function to set the state of decryption process controls
    protected void setDecryptControlComponentState(boolean flag) {
        this.btnDecrypt.setEnabled(flag);
        this.btnShowDetails.setEnabled(flag);
    }
    
    // function to read the FolderEncryptobject
    public void readFolderEncryptObject() {
        this.setObject(
                new FolderEncryptionAlgorithmMethods().readFolderEncryptObject(settingsfile));
    }
    
    public java.util.Vector getFiles() {
        return files;
    }

    public void setFiles(java.util.Vector files) {
        this.files = files;
    }

    public File getFolderpath() {
        return folderpath;
    }

    public void setFolderpath(File folderpath) {
        this.folderpath = folderpath;
    }

    public File getSettingsfile() {
        return settingsfile;
    }

    public void setSettingsfile(File settingsfile) {
        this.settingsfile = settingsfile;
    }

    public FolderEncryptObject getObject() {
        return object;
    }

    public void setObject(FolderEncryptObject object) {
        this.object = object;
    }

    public boolean isEncrypted() {
        return encrypted;
    }

    public void setEncrypted(boolean encrypted) {
        this.encrypted = encrypted;
        setLabelCaptionForProcess();
        if(encrypted==true) {            
            // set the window  for decryption           
            this.setDecryptControlComponentState(true);
            this.setEncryptControlComponentState(false);
        }
        else {
            // set the window for encryption
            this.setDecryptControlComponentState(false);
            this.setEncryptControlComponentState(true);
        }
    }
    
    // function to clear all the values 
    protected void clearAllValues(boolean confirm) {
        if(this.lstFiles.getModel().getSize()!=0&&confirm==true) {
            String msg="This will clear all the files and folder.\n"+
                    "Do you want to continue?";
            int retval=javax.swing.JOptionPane.showConfirmDialog(null, msg,
                    "Confirm Clearing",javax.swing.JOptionPane.YES_NO_CANCEL_OPTION); 
            if(retval!=javax.swing.JOptionPane.YES_OPTION) {
                return;
            }
        }        
        this.files.removeAllElements();
        this.txtFolderPath.setText("");
        lstFiles.setModel(new javax.swing.DefaultListModel());
        this.setEncryptControlComponentState(false);
        this.setDecryptControlComponentState(false);
        this.settingsfile=null;
        this.setObject(null);
        this.setFailedfiles(null);
        btnClear.setEnabled(false);
        btnRemove.setEnabled(false);
    }
    
    // function to start decryption
    private void startDecryption() {
        if(files==null) return;
        else if(files.size()==0) return;
        else {
            new FolderEncryptionAlgorithmMethods().startDecryption(this.getFolderpath().toString()
                    , files, this);
        }
    }
    
    // function to initiate encryption
     private void startEncryption() {
        if(files==null) return;
        else if(files.size()==0) return;
        else {
            new FolderEncryptionAlgorithmMethods().startEncryption(this.getFolderpath().toString()
                    , files, this);
        }
        
    }
     
     // function to return the code object from the EncryptFolderobject
     public CodeObject getCodeObjectForFolder() {
         if(this.getObject()==null) return null;                  
         return this.getObject().getCodeobj();
     }     
     
     // function to show the details of encrypted folder by reading the folder encrypt
     // object
    protected void showEncryptedFolderDetails() {
        String content="";
        if(object==null) {
            content="File containing the folder encryption details does not exists";
        }
        else if (object.getCodeobj().isDetailssaved()==false) {
            content="The details of encryption were not stored..!";
        }
        else {
            content="Encrypted folder --------> "+txtFolderPath.getText()+"\n"+
                    "Date of encryption ------> "+object.getEncryptDate()+"\n"+
                    "Algorithm(s) Used ----------> ";
            
            
             for (int i = 0; i < object.getCodeobj().getAlgorithmsused().size(); i++) {
                Object obj = object.getCodeobj().getAlgorithmsused().elementAt(i);
                content+=obj.toString()+"\n";
            }

            content+="Hint for code -----------> "+ object.getCodeobj().getHint()+"\n"+
                    "Files encrypted in the folder\n\n";
            Vector encryptedfiles=object.getFiles();
            System.out.print("encryptedfles"+encryptedfiles.size());
            if(encryptedfiles!=null)
            for(int i=0;i<encryptedfiles.size();i++) {               
               content+=Integer.toString(i+1)+" ) "+encryptedfiles.elementAt(i).toString()+"\n";
            }           
        }
        javax.swing.JOptionPane.showMessageDialog(null, content,"Encrypted files details",
                javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FolderEncryptionDialog dialog = new FolderEncryptionDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDecrypt;
    private javax.swing.JButton btnEncrypt;
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSelectFolder;
    private javax.swing.JButton btnShowDetails;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSelFilesCaption;
    private javax.swing.JLabel lblSelFolderCaption;
    private javax.swing.JList lstFiles;
    private javax.swing.JTextField txtFolderPath;
    // End of variables declaration//GEN-END:variables
    
    private java.util.Vector files=new java.util.Vector();
    private javax.swing.DefaultListModel lstModel=new javax.swing.DefaultListModel();
    private File folderpath;
    private File settingsfile;
    
    private FolderEncryptObject object;
    private boolean encrypted=false;    
    private Vector failedfiles;   

    public Vector getFailedfiles() {
        return failedfiles;
    }

    public void setFailedfiles(Vector failedfiles) {
        this.failedfiles = failedfiles;
    }

   



    
    
}