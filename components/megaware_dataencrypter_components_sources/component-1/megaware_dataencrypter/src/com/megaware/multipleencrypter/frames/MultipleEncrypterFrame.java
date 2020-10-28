/*
 * MultipleEncrypterFrame.java
 *
 * Created on March 8, 2008, 10:25 AM
 */

package com.megaware.multipleencrypter.frames;

import com.megaware.multipleencrypter.beans.DocumentFindReplaceDialog;
import com.megaware.multipleencrypter.methods.GeneralMethods;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.text.DefaultEditorKit;

/**
 *
 * @author  name
 */
public class MultipleEncrypterFrame extends javax.swing.JFrame {
    
    /** Creates new form MultipleEncrypterFrame */
    public MultipleEncrypterFrame() {
        initComponents();
        createDesktopPane();
        setEditorFontMenuItems();
        setMenuEditItemActions();
        this.changeMenuItemState(0);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                quitApplication();
            }
        });
    }

    // function to set the active child
    public void setActiveChildWindow(ChildEncrypterFrame aThis) {
        currActiveFrame=aThis;
        if(currActiveFrame==null) {
            this.changeMenuItemState(0);
        } else {
            this.changeMenuItemState(1);
        }
        
    }

    private void addNewSingleEncrypterFrame() {
        ChildEncrypterFrame frame=new ChildEncrypterFrame(this);
        frame.newFile();
        addFrameToDesktop(frame);
    }

    // function to create the desktoppane with image
    private void createDesktopPane() {
            final java.awt.Dimension d=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
            System.out.println(d);
            desktop = new javax.swing.JDesktopPane();    
        this.getContentPane().add(desktop);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuFileNew = new javax.swing.JMenu();
        menuNewFileEncryption = new javax.swing.JMenuItem();
        menuFileNewFolder = new javax.swing.JMenuItem();
        menuFileOpen = new javax.swing.JMenuItem();
        menuFileSave = new javax.swing.JMenuItem();
        menuFileSaveAs = new javax.swing.JMenuItem();
        menuFileClose = new javax.swing.JMenuItem();
        menuFileQuit = new javax.swing.JMenuItem();
        menuEdit = new javax.swing.JMenu();
        menuEditUndo = new javax.swing.JMenuItem();
        menuEditRedo = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        menuEditCut = new javax.swing.JMenuItem();
        menuEditCopy = new javax.swing.JMenuItem();
        menuEditPaste = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JSeparator();
        menuEditSelectAll = new javax.swing.JMenuItem();
        menuEditFind = new javax.swing.JMenuItem();
        menuAction = new javax.swing.JMenu();
        menuActionSetFont = new javax.swing.JMenu();
        menuActionStartEncrypt = new javax.swing.JMenuItem();
        menuActionStartDecrypt = new javax.swing.JMenuItem();
        menuActionCountCharacters = new javax.swing.JMenuItem();
        menuDetails = new javax.swing.JMenu();
        menuDetailsAbout = new javax.swing.JMenuItem();
        menuAboutLicense = new javax.swing.JMenuItem();
        menuDetailsCredits = new javax.swing.JMenuItem();
        menuAlgorithms = new javax.swing.JMenuItem();
        menuDetailsDonations = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("MegaWare Encrypter");

        menuFile.setText("File ");

        menuFileNew.setText("New Encryption");

        menuNewFileEncryption.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        menuNewFileEncryption.setText("File Encryption");
        menuNewFileEncryption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNewFileEncryptionActionPerformed(evt);
            }
        });
        menuFileNew.add(menuNewFileEncryption);

        menuFileNewFolder.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        menuFileNewFolder.setText("Folder Encryption");
        menuFileNewFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFileNewFolderActionPerformed(evt);
            }
        });
        menuFileNew.add(menuFileNewFolder);

        menuFile.add(menuFileNew);

        menuFileOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        menuFileOpen.setText("Open File");
        menuFileOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFileOpenActionPerformed(evt);
            }
        });
        menuFile.add(menuFileOpen);

        menuFileSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuFileSave.setText("Save File");
        menuFileSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFileSaveActionPerformed(evt);
            }
        });
        menuFile.add(menuFileSave);

        menuFileSaveAs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuFileSaveAs.setText("Save As");
        menuFileSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFileSaveAsActionPerformed(evt);
            }
        });
        menuFile.add(menuFileSaveAs);

        menuFileClose.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        menuFileClose.setText("Close File");
        menuFileClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFileCloseActionPerformed(evt);
            }
        });
        menuFile.add(menuFileClose);

        menuFileQuit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK));
        menuFileQuit.setText("Quit Application");
        menuFileQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFileQuitActionPerformed(evt);
            }
        });
        menuFile.add(menuFileQuit);

        jMenuBar1.add(menuFile);

        menuEdit.setText("Edit");

        menuEditUndo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        menuEditUndo.setText("Undo");
        menuEdit.add(menuEditUndo);

        menuEditRedo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        menuEditRedo.setText("Redo");
        menuEdit.add(menuEditRedo);
        menuEdit.add(jSeparator1);

        menuEditCut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        menuEditCut.setText("Cut");
        menuEditCut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditCutActionPerformed(evt);
            }
        });
        menuEdit.add(menuEditCut);

        menuEditCopy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        menuEditCopy.setText("Copy");
        menuEdit.add(menuEditCopy);

        menuEditPaste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        menuEditPaste.setText("Paste");
        menuEdit.add(menuEditPaste);
        menuEdit.add(jSeparator2);

        menuEditSelectAll.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        menuEditSelectAll.setText("Select All");
        menuEditSelectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditSelectAllActionPerformed(evt);
            }
        });
        menuEdit.add(menuEditSelectAll);

        menuEditFind.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        menuEditFind.setText("Find or Replace");
        menuEditFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditFindActionPerformed(evt);
            }
        });
        menuEdit.add(menuEditFind);

        jMenuBar1.add(menuEdit);

        menuAction.setText("Action");

        menuActionSetFont.setText("Editor Font");
        menuAction.add(menuActionSetFont);

        menuActionStartEncrypt.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        menuActionStartEncrypt.setText("Start Encrypting File");
        menuActionStartEncrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActionStartEncryptActionPerformed(evt);
            }
        });
        menuAction.add(menuActionStartEncrypt);

        menuActionStartDecrypt.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        menuActionStartDecrypt.setText("Start Decrypting File");
        menuActionStartDecrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActionStartDecryptActionPerformed(evt);
            }
        });
        menuAction.add(menuActionStartDecrypt);

        menuActionCountCharacters.setText("Count Characters");
        menuActionCountCharacters.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActionCountCharactersActionPerformed(evt);
            }
        });
        menuAction.add(menuActionCountCharacters);

        jMenuBar1.add(menuAction);

        menuDetails.setText("Program Details");

        menuDetailsAbout.setText("About the program");
        menuDetailsAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDetailsAboutActionPerformed(evt);
            }
        });
        menuDetails.add(menuDetailsAbout);

        menuAboutLicense.setText("License");
        menuAboutLicense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAboutLicenseActionPerformed(evt);
            }
        });
        menuDetails.add(menuAboutLicense);

        menuDetailsCredits.setText("Credits");
        menuDetailsCredits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDetailsCreditsActionPerformed(evt);
            }
        });
        menuDetails.add(menuDetailsCredits);

        menuAlgorithms.setText("Algorithms");
        menuAlgorithms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAlgorithmsActionPerformed(evt);
            }
        });
        menuDetails.add(menuAlgorithms);

        menuDetailsDonations.setText("Donations");
        menuDetailsDonations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDetailsDonationsActionPerformed(evt);
            }
        });
        menuDetails.add(menuDetailsDonations);

        jMenuBar1.add(menuDetails);

        setJMenuBar(jMenuBar1);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-960)/2, (screenSize.height-585)/2, 960, 585);
    }// </editor-fold>//GEN-END:initComponents

    private void menuNewFileEncryptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNewFileEncryptionActionPerformed
        addNewSingleEncrypterFrame();        
    }//GEN-LAST:event_menuNewFileEncryptionActionPerformed

    private void menuFileOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFileOpenActionPerformed
        openSingleEncrypterFrame();
    }//GEN-LAST:event_menuFileOpenActionPerformed

    private void menuFileCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFileCloseActionPerformed
        //closeFile();                  
    }//GEN-LAST:event_menuFileCloseActionPerformed

    private void menuFileQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFileQuitActionPerformed
       quitApplication();                         
    }//GEN-LAST:event_menuFileQuitActionPerformed

    private void menuFileSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFileSaveActionPerformed
        saveEncrypterFile();
    }//GEN-LAST:event_menuFileSaveActionPerformed

    private void menuFileSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFileSaveAsActionPerformed
        saveEncrypterFileAs();
    }//GEN-LAST:event_menuFileSaveAsActionPerformed

    private void menuActionStartEncryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActionStartEncryptActionPerformed
       
        ChildEncrypterFrame frame=this.getSelectedFrame();
        if(frame!=null) {
            frame.startEncryption();
        }
        
}//GEN-LAST:event_menuActionStartEncryptActionPerformed

    private void menuActionStartDecryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActionStartDecryptActionPerformed
  
        ChildEncrypterFrame frame=this.getSelectedFrame();
        if(frame!=null) {
            frame.startDecryption();
        }
    }//GEN-LAST:event_menuActionStartDecryptActionPerformed

    private void menuEditCutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditCutActionPerformed
       
    }//GEN-LAST:event_menuEditCutActionPerformed

    private void menuFileNewFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFileNewFolderActionPerformed
        showFolderEncryptionFrame();
    }//GEN-LAST:event_menuFileNewFolderActionPerformed

    private void menuEditFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditFindActionPerformed
        showFindReplaceDialog();
}//GEN-LAST:event_menuEditFindActionPerformed

    private void menuEditSelectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditSelectAllActionPerformed
        selectAllData();
    }//GEN-LAST:event_menuEditSelectAllActionPerformed

    private void menuActionCountCharactersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActionCountCharactersActionPerformed
        this.countCharacters();
    }//GEN-LAST:event_menuActionCountCharactersActionPerformed

    private void menuDetailsAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDetailsAboutActionPerformed
        showProgramDetailDialog(0);        
    }//GEN-LAST:event_menuDetailsAboutActionPerformed

    private void menuDetailsCreditsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDetailsCreditsActionPerformed
        showProgramDetailDialog(1);
    }//GEN-LAST:event_menuDetailsCreditsActionPerformed

    private void menuAlgorithmsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAlgorithmsActionPerformed
        showProgramDetailDialog(4);
    }//GEN-LAST:event_menuAlgorithmsActionPerformed

    private void menuDetailsDonationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDetailsDonationsActionPerformed
        showProgramDetailDialog(2);
    }//GEN-LAST:event_menuDetailsDonationsActionPerformed

    private void menuAboutLicenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAboutLicenseActionPerformed
        showProgramDetailDialog(3);
    }//GEN-LAST:event_menuAboutLicenseActionPerformed
   // function to show the find and replace dialog
    protected void showFindReplaceDialog() {
        ChildEncrypterFrame frame=this.getSelectedFrame();
        if(frame==null)  return;
        DocumentFindReplaceDialog dialog=new DocumentFindReplaceDialog(this,false);
        dialog.setVisible(true);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MultipleEncrypterFrame().setVisible(true);
            }
        });
    }
    
    // function to add the undo and redo action for the menuEditUndo,menuEditRedo
    public void setUndoRedoAction(Action undoaction,Action redoaction) {
        menuEditUndo.setAction(undoaction);
        menuEditRedo.setAction(redoaction);
    }

    private void openSingleEncrypterFrame() {
        ChildEncrypterFrame frame=new ChildEncrypterFrame(this);
        boolean fileopened=frame.openFile();        
        if(fileopened)
            addFrameToDesktop(frame);
        
    }
    
    private void closeFile() {
        ChildEncrypterFrame frame=(ChildEncrypterFrame)
                desktop.getSelectedFrame();
        if(frame!=null) {
            frame.closeFile();
        }
    }
    
    // function to show the program details dialog
    protected void showProgramDetailDialog(int currTab) {
        ProgramDetailsDialog dialog=new ProgramDetailsDialog(this,true);
        dialog.setCurrTab(currTab);
        dialog.setVisible(true);
    }
    
    protected void addFrameToDesktop(ChildEncrypterFrame frame) {
        frame.setVisible(true);
        try {
            desktop.add(frame);
            frame.setSelected(true);            
        } catch (Exception exception) {
               exception.printStackTrace();
        }
    }

    private void quitApplication() {
        int framecount=desktop.getAllFrames().length;
        if(framecount!=0) {
            javax.swing.JInternalFrame frames[]=desktop.getAllFrames();
            String msg="There are files open in the program . \n"+
                    "They will be closed.Do you want to continue?.\n"+
                    "The opened files are :\n\n";
            int index=1;
            for (int i = 0; i < frames.length; i++,index++) {
                JInternalFrame jInternalFrame = frames[i];
                 msg+=Integer.toString(index)+" ) "+jInternalFrame.getTitle()+"\n";
            }           
            String caption="Confirm Quit";                        
            int retval=new GeneralMethods().showConfirmationDialog(msg, caption);
            if(retval==javax.swing.JOptionPane.YES_OPTION) {
                System.exit(0);                
            }
            else {
                return;
            }
        }
        else {
            System.exit(0);
        }
    }
    
    protected void saveEncrypterFileAs() {
        ChildEncrypterFrame frame=(ChildEncrypterFrame)
                   desktop.getSelectedFrame();
        if(frame!=null) {
            frame.saveEncrypterFile(true);
        }
    }

    private void saveEncrypterFile() {
        ChildEncrypterFrame frame=(ChildEncrypterFrame)
                   desktop.getSelectedFrame();
        if(frame!=null) {
            frame.saveEncrypterFile(false);
        }
    }
    
    // function to select All Data
    private void selectAllData() {
        ChildEncrypterFrame frame=this.getSelectedFrame();
        if(frame!=null) {
            frame.selectAllText();
        }
    }
    
    // function to add menuitems to the set editor font menu in action Menu
    private void setEditorFontMenuItems() {
        for(int i=8;i<=36;i+=2) {
            javax.swing.JMenuItem item=new javax.swing.JMenuItem(Integer.toString(i));
            item.setFont(new java.awt.Font("Arial",java.awt.Font.BOLD,i)); 
            final int fontsize=i;
            item.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent ae) {
                   ChildEncrypterFrame frame=(ChildEncrypterFrame)
                   MultipleEncrypterFrame.this.desktop.getSelectedFrame();
                   if(frame!=null) {
                        frame.setEditorFont(new java.awt.Font("Arial",
                        java.awt.Font.BOLD,fontsize));
                   }
                }                    
            });
            menuActionSetFont.add(item);            
        }
    }
    
    // function to count the characters in the selected frame
    protected void countCharacters() {
        
        ChildEncrypterFrame frame=this.getSelectedFrame();
        if(frame==null) return;
        int charcount=0;
        int linecount=0;
        int wordcount=0;
        String text=frame.getText();
        char strchars[]=new char[text.length()];
        text.getChars(0, text.length(), strchars,0);
        for (int i = 0; i < strchars.length; i++) {
            char c = strchars[i];
            if(c=='\n') {
                linecount++;
                wordcount++;
            }
            else if(c==' '||c=='.') {
                wordcount++;
            }
            charcount++;
        }        
        String msg="Number of characters ------> "+Integer.toString(charcount)+"\n"+
                   "Number of words -----------> "+Integer.toString(wordcount)+"\n"+
                   "Number of lines -----------> "+Integer.toString(linecount)+"\n";
        javax.swing.JOptionPane.showMessageDialog(null, msg);
    }
    
    
    // function to change the state of menuitem 
    public void changeMenuItemState(int mode) {
        switch(mode) {
            
            case 0:// startupstate 
                  menuFileSave.setEnabled(false);  
                  menuFileSaveAs.setEnabled(false);
                  this.menuFileClose.setEnabled(false);
                  setEditMenuItemState(false);
                  setActionMenuItemState(false);                  
                  break;
                  
            case 1://file active state
                  menuFileSave.setEnabled(true);
                  menuFileSaveAs.setEnabled(true);
                  menuFileClose.setEnabled(true);
                  setActionMenuItemState(false);
                  menuActionSetFont.setEnabled(true);
                  menuActionCountCharacters.setEnabled(true);
                  this.setEditMenuItemState(true);
                  this.menuEditUndo.setEnabled(false);
                  this.menuEditRedo.setEnabled(false);
                  break;          
                  
            
                  
        }
    }
    
    // function to set the state of edit menu items in the window
    protected void setEditMenuItemState(boolean flag) {
        java.awt.Component comps[]=this.menuEdit.getMenuComponents();
        for(int i=0;i<comps.length;i++) {
            comps[i].setEnabled(flag);
        }
                
    }
    
    // function to set the state of action menu state
    protected void setActionMenuItemState(boolean flag) {
        java.awt.Component comps[]=this.menuAction.getMenuComponents();
        for(int i=0;i<comps.length;i++) {
            comps[i].setEnabled(flag);
        }
    }
    
    // function to get the currently selected SingleEncrypterFrame 
    public ChildEncrypterFrame getSelectedFrame() {
        ChildEncrypterFrame frame=(ChildEncrypterFrame)
                desktop.getSelectedFrame();
        return frame;
    }
    
    // function to set the actions for cut,copy and paste
    protected void setMenuEditItemActions() {
        
        
        Action action=new DefaultEditorKit.CutAction();        
        action.putValue(Action.NAME,"Cut");
        menuEditCut.setAction(action);
        
        action=new DefaultEditorKit.CopyAction();
        action.putValue(Action.NAME, "Copy");
        menuEditCopy.setAction(action);
        
        action=new DefaultEditorKit.PasteAction();
        action.putValue(Action.NAME,"Paste");
        menuEditPaste.setAction(action);
    } 
    
    // function to check the availability of contents from the system cliboard
    public boolean isDataAvailableFromClipBoard() {
        try {
            Object data = java.awt.Toolkit.getDefaultToolkit().getSystemClipboard().getContents(desktop);
            if (data == null) {
                return false;
            }
            return true;

        } catch (IllegalStateException exception) {
            return false;
        }

    }
    
    // function to show the encryption frame
    private void showFolderEncryptionFrame() {
        FolderEncryptionDialog dialog=new FolderEncryptionDialog(new JFrame(),true);
        dialog.setVisible(true);
    }
    
    // function to set the state of the encryptmenu item
    public void setEncrytMenuItemState(boolean state) {
        this.menuActionStartEncrypt.setEnabled(state);
    }
    
    // function to set the state of the decrypt menu item
    public void setDecryptMenuItemState(boolean state) {
        this.menuActionStartDecrypt.setEnabled(state);
    }
    
    // function to set the state of the save menu item
    public void setSaveMenuItemState(boolean state) {
        this.menuFileSave.setEnabled(state);
    }
    
    // function to set the state of the cut menuitem
    public void setCutMenuState(boolean state) {
        this.menuEditCut.setEnabled(state);
    }
    
    // function to set the state of the copy menuitem 
    public void setCopyMenuState(boolean state) {
        this.menuEditCopy.setEnabled(state);
    }
    
    // function to set the state of the paste menu item 
    public void setPasteMenuItemState(boolean state) {
        this.menuEditPaste.setEnabled(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JMenuItem menuAboutLicense;
    private javax.swing.JMenu menuAction;
    private javax.swing.JMenuItem menuActionCountCharacters;
    private javax.swing.JMenu menuActionSetFont;
    private javax.swing.JMenuItem menuActionStartDecrypt;
    private javax.swing.JMenuItem menuActionStartEncrypt;
    private javax.swing.JMenuItem menuAlgorithms;
    private javax.swing.JMenu menuDetails;
    private javax.swing.JMenuItem menuDetailsAbout;
    private javax.swing.JMenuItem menuDetailsCredits;
    private javax.swing.JMenuItem menuDetailsDonations;
    private javax.swing.JMenu menuEdit;
    private javax.swing.JMenuItem menuEditCopy;
    private javax.swing.JMenuItem menuEditCut;
    private javax.swing.JMenuItem menuEditFind;
    private javax.swing.JMenuItem menuEditPaste;
    private javax.swing.JMenuItem menuEditRedo;
    private javax.swing.JMenuItem menuEditSelectAll;
    private javax.swing.JMenuItem menuEditUndo;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenuItem menuFileClose;
    private javax.swing.JMenu menuFileNew;
    private javax.swing.JMenuItem menuFileNewFolder;
    private javax.swing.JMenuItem menuFileOpen;
    private javax.swing.JMenuItem menuFileQuit;
    private javax.swing.JMenuItem menuFileSave;
    private javax.swing.JMenuItem menuFileSaveAs;
    private javax.swing.JMenuItem menuNewFileEncryption;
    // End of variables declaration//GEN-END:variables
    private ChildEncrypterFrame currActiveFrame;

    private javax.swing.JDesktopPane desktop;
}
