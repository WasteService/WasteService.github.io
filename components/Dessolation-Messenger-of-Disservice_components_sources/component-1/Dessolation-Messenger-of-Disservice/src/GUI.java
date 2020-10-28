/****************************************
 * DESSOLATION MESSENGER OF DISSERVICE
 * 
 ****************************************
 * 
 * Main & GUI for the DMOD chat app
 * @author Zach Jetson <zjetson@asu.edu>
 * @author Jason Joliet <jjoliet@asu.edu>
 * 
 * @version 1.00b
 * 
 ****************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.DefaultCaret;

public class GUI extends JFrame implements Runnable {

	private static final long serialVersionUID = -6616326085742053984L;

	//GUI elements available for threading
	public static GUI guiObject = new GUI();
	
	// Non-modifiable GUI Components for Status messages - available for other classes
	public final static int OFFLINE = 0;
	public final static int CONNECTED = 1;
	public final static int CONNECTING = 2;
	public final static int DISCONNECTING = 3;
	public final static int CLOSE = 4;
	public static volatile int connectionStatus = OFFLINE;

	// Only necessary for the GUI
	private static String myName;
	private static JTextArea displayOutput = null;
	private static final String StatusMsg[] = { "Offline", "Connected", "Connecting... Please Wait ", "Disconnecting... Closing Connections", "Exiting DMOD" };
	private static JFrame mainFrame = null;
	private static JPanel contentPane = null;
	private static JMenuBar menuBar = null;
	private static JTextField userInput = null;
	private static JScrollPane scrollPanel = null;
	private static JLabel statusBar = null;
	private static JMenuItem menuConnect = new JMenuItem("Connect", KeyEvent.VK_O);
	private static JMenuItem menuDisconnect = new JMenuItem("Disconnect", KeyEvent.VK_D);
	private static StringBuffer toAppend = new StringBuffer("");

	public static void main(String[] args) {
		//TODO
		//Get IP Addresses()
		//Open network sockets()
		//Connect to client / server

		myName = JOptionPane.showInputDialog(null, "What do you want your name to be?", "ME");
		if (myName == null)
			myName = "ME";

		// Create the GUI
		guiObject.createGui();
		guiObject.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				connectionStatus = CLOSE;
				SwingUtilities.invokeLater(guiObject);
				System.exit(0);
			}	
		});
	}
	/************************** 
	 * Create GUI Elements
	 * 
	 * -Menu Bar (File),
	 * -(Connect),
	 * -(Disconnect),
	 * -(Separator),
	 * -(Clear Chat),
	 * - Text Box,
	 * - Chat Input
	 **************************/
	private void createGui() {

		mainFrame = new JFrame("Desolation Messenger of Disservice");
		statusBar = new JLabel();
		statusBar.setText(StatusMsg[connectionStatus]);
		menuBar = new JMenuBar();

		/***************************************
		 * Create Menu items, 
		 * give them Mnemonics, 
		 * and then add them to the menu bar
		 ***************************************/

		// CHAT MENU
		JMenu menuChat = new JMenu("File");
		menuChat.setMnemonic(KeyEvent.VK_F);

		// CONNECT ITEM & FUNCTION
		menuConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c) {
				connectionStatus = CONNECTING;
				openCONNECTION();
				mainFrame.repaint();
			}
		});
		menuChat.add(menuConnect);

		// DISCONNECT ITEM & FUNCTION
		menuDisconnect.setEnabled(false);
		menuDisconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent d) {
				if (connectionStatus == OFFLINE)
					;
				else{
				// Close all sockets for disconnect
				TCPOperations.closeSockets();
				mainFrame.repaint();
				}
			}
		});
		menuChat.add(menuDisconnect);
		
		// SEPERATOR
		menuChat.addSeparator();

		// CLEAR CHAT BOX
		JMenuItem menuClear = new JMenuItem("Clear Chat", KeyEvent.VK_R);
		menuClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent d) {
				displayOutput.setText("");
				
			}
		});
		menuChat.add(menuClear);
		
		menuChat.addSeparator();
		
		// EXIT & EXIT OPERATIONS
		JMenuItem menuExit = new JMenuItem("Exit", KeyEvent.VK_X);
		menuExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent exit) {
				TCPOperations.closeSockets();
				System.exit(0);
			}
		});

		menuChat.add(menuExit);
		menuBar.add(menuChat);

		contentPane = new JPanel(new BorderLayout());

		displayOutput = new JTextArea(20, 40);
		displayOutput.setCaretPosition(displayOutput.getDocument().getLength());
		// MAKE TEXTBOX SCROLL TO BOTTOM
		DefaultCaret caret = (DefaultCaret)displayOutput.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

		displayOutput.setEditable(false);
		displayOutput.setLineWrap(true);
		displayOutput.setBackground(Color.BLACK);
		displayOutput.setForeground(Color.green);
		displayOutput.setFont(new Font("Verdana", Font.BOLD, 12));
		scrollPanel = new JScrollPane(displayOutput,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		userInput = new JTextField();
		userInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = userInput.getText();
				if (!s.equals("")) {
					serverMSG(myName + " : " + s);
					userInput.selectAll();
					userInput.setText(null);
					// Send the string to be encrypted
					Encryption.toEncrypt(myName + " : " + s);
				}
			}
		});
		userInput.setBackground(Color.BLACK);
		userInput.setForeground(Color.WHITE);
		userInput.setEditable(false);

		Container content = getContentPane();
		content.setLayout(new BorderLayout());
		content.add(scrollPanel, BorderLayout.CENTER);
		content.add(userInput, BorderLayout.SOUTH);
		contentPane.add(content, BorderLayout.CENTER);
		contentPane.add(statusBar, BorderLayout.SOUTH);

		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setJMenuBar(menuBar);
		mainFrame.setContentPane(contentPane);
		mainFrame.setSize(mainFrame.getPreferredSize());
		mainFrame.pack();
		mainFrame.setVisible(true);
		displayOutput.append("Press connect in the menu bar to make a connection\n");
	}
	
	/************************** 
	 * THREADED PORTION OF GUI 
	 **************************/
	public void run() 
	{
			if (connectionStatus == OFFLINE) {	/** Status Offline	**/		
				userInput.setEditable(false);
				menuConnect.setEnabled(true);
				menuConnect.repaint();
				menuDisconnect.setEnabled(false);
				menuDisconnect.repaint();
				
			} else if (connectionStatus == CONNECTED) { /** Status Connected  **/
				userInput.setEditable(true);
				userInput.grabFocus();
				menuConnect.setEnabled(false);
				menuConnect.repaint();
				menuDisconnect.setEnabled(true);
				menuDisconnect.repaint();	
				
			} else if (connectionStatus == CONNECTING) {	/** Status Connecting **/		
				userInput.setEditable(false);
				menuConnect.setEnabled(false);
				menuConnect.repaint();
				menuDisconnect.setEnabled(false);
				menuDisconnect.repaint();	
				
			} else if (connectionStatus == DISCONNECTING) {		/** Status Disconnecting	**/
				userInput.setEditable(false);
				userInput.setText("");
				TCPOperations.closeSockets();
				menuConnect.setEnabled(true);
				menuConnect.repaint();
				menuDisconnect.setEnabled(false);
				menuDisconnect.repaint();	
				
			} else if (connectionStatus == CLOSE) {		/** Status Closing **/
				TCPOperations.closeSockets();
				mainFrame.dispose();
				menuConnect.setEnabled(false);
				menuConnect.repaint();
				menuDisconnect.setEnabled(false);
				menuDisconnect.repaint();
				mainFrame.dispose();
			}

		/****************** 
		 * Redraw the GUI 
		 ******************/
		statusBar.setText(StatusMsg[connectionStatus]);
		displayOutput.append(toAppend.toString());
		toAppend.setLength(0);
		mainFrame.repaint();
	}

	/***************************
	 * Method for a thread safe 
	 * way to output to chat box
	 * 
	 * @param printMe
	 ***************************/
	public synchronized static void serverMSG(String printMe) {
			toAppend.append(printMe+ "\n");
			SwingUtilities.invokeLater(guiObject);
	}
	
	/***************************
	 * Create a thread to handle
	 * server.accept()
	 * So GUI doesn't lock up
	 ***************************/
	private static void openCONNECTION(){
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {}
		
		TCPOperations tcpServer = new TCPOperations();
		Thread tcpServerThread = new Thread(tcpServer);
		tcpServerThread.start();
	}
}	
class ActionAdapter implements ActionListener {
	public void actionPerformed(ActionEvent e) {}
}


