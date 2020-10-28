/****************************************
 * DESSOLATION MESSENGER OF DISSERVICE
 * 
 ****************************************
 * Threaded portion of TCPOperations
 * -Handles the server.accept()
 * 
 * 
 * @author Zach Jetson <zjetson@asu.edu>
 * @version 0.5
 * 
 ****************************************/
import java.net.*;
import javax.swing.*;
import java.io.*;

public class TCPOperations extends Thread{

	private static final long serialVersionUID = -3630459934770419364L;
	private static Socket clientSocket = null;
	private static Socket connectionSocket = null;
	private static ServerSocket serverSocket = null;
	private static String ipAddress = "localhost";
	private static int port = 12321;
	private static boolean isHost = false;
	private static boolean isClient = false;
	private static PrintWriter dataOUT;
	private static BufferedReader dataIN;
	//StringBuffer to be placed in dataOUT
	private static StringBuffer output = new StringBuffer();

	private static void openSOCKET(){
		ipAddress = JOptionPane.showInputDialog(null, "Who are you connecting to? \n" + "Type \"host\" if you are hosting.", "localhost");
		if (ipAddress.equalsIgnoreCase("host") )
		{
			isHost = true;
			isClient = false;
		}
		else {
			isHost = false;
			isClient = true;
		}
		if (isHost == true)
		{
			getCLIENT_PORT();
			openSERVER_SOCKET();
		}
		else if (isClient == true)
		{
			getSERVER_PORT();
			openCLIENT_SOCKET();
		}
	}
	private static void openSERVER_SOCKET(){
		GUI.serverMSG("Attempting to create server socket");
		try {
			serverSocket = new ServerSocket(port);
			GUI.serverMSG("Server Started...at Port: " + port);
			serverSocket.setSoTimeout(20000);
			connectionSocket = serverSocket.accept();
			GUI.connectionStatus = GUI.CONNECTED;
			GUI.serverMSG("Client IP & Remote Socket Address: " + connectionSocket.getRemoteSocketAddress().toString());
			GUI.serverMSG("Waiting for a client message...");
			dataIN = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			dataOUT = new PrintWriter(connectionSocket.getOutputStream(), true);
		} catch (SocketException se) {
			GUI.serverMSG("Client took too long to connect.");
		} catch (IOException e) {
			GUI.connectionStatus = GUI.OFFLINE;
			GUI.serverMSG("Error creating a socket.\n" + "Check your firewall settings.");
		}
	}
	private static void openCLIENT_SOCKET(){
		GUI.serverMSG("Attempting to connect to host");
		try {
			connectionSocket = new Socket(ipAddress, port);
			GUI.connectionStatus = GUI.CONNECTED;
			GUI.serverMSG("Connected to host...at Port: " + port);
			dataIN = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			dataOUT = new PrintWriter(connectionSocket.getOutputStream(), true);
		} catch (UnknownHostException e) {
			GUI.serverMSG("Simplex-talk: Unknown host: " + ipAddress + " : " + port);
			closeSockets();	
		} catch (SocketException se) {
			GUI.connectionStatus = GUI.OFFLINE;
			GUI.serverMSG("Host not listenting.");			
		} catch (IOException e) {
			GUI.connectionStatus = GUI.OFFLINE;
			GUI.serverMSG("Error creating a socket.\n" + "Check your firewall settings.");
		}
	}
	private static void getCLIENT_PORT(){
		String s = JOptionPane.showInputDialog(null, "Enter a port number to start connection on (between 1024-65535):", port);
		boolean repost = true;
		while(repost != false)
		{
			try
			{
				port = Integer.parseInt(s.trim());	// Convert String to int
				if (port > 1023 && port < 65536)
					repost = false;
				else
					throw new NumberFormatException();

			} catch (NumberFormatException nfe) {
				s = JOptionPane.showInputDialog(null, "INVALID ENTERY! Enter the port number:", "");
			}
		}
	}
	private static void getSERVER_PORT(){

		String s = JOptionPane.showInputDialog(null, "Enter the server port number to start connection on (between 1024-65535):", port);
		boolean repost = true;
		while(repost != false)
		{
			try
			{
				// Convert String to integer
				port = Integer.parseInt(s.trim());
				if (port > 1023 && port < 65536)
					repost = false;
				else
					throw new NumberFormatException();

			} catch (NumberFormatException nfe) {
				s = JOptionPane.showInputDialog(null, "INVALID ENTERY! Enter the port number:", "");
			}
		}
	}
	public static void TCPSend(String encrypted){
		output.append(encrypted);
	}
	
	/*********************************
	 * CLOSE STREAMS AND SOCKETS
	 *********************************/
	public static void closeSockets(){

		try {
			dataOUT.print("-1");
			serverSocket.close();
			clientSocket.close();
			connectionSocket.close();
			serverSocket = null;
			clientSocket = null;
			connectionSocket = null;
			output.setLength(0);
		}
		catch (IOException e){
			serverSocket = null;
			clientSocket = null;
			connectionSocket = null;
		}
		catch (NullPointerException e){
			serverSocket = null;
			clientSocket = null;
			connectionSocket = null;
		}
		finally {
			GUI.connectionStatus = GUI.OFFLINE;
			GUI.serverMSG("Disconnected");
		}
		isHost = false;
		isClient = false;
	}
	private void sendDATA() throws IOException{
		if (output.length() != 0){
			GUI.serverMSG("Sending Request...");
			System.out.println(output);
			dataOUT.print(output); 
			dataOUT.flush();
			output.setLength(0);
			System.out.println(output);
			System.out.println(dataOUT);
		}
	} 
	private void receiveDATA() throws IOException{
		String str;			
		try{
			str = dataIN.readLine();
			System.out.println(str);
			if (str == "-1"){
				GUI.connectionStatus = GUI.DISCONNECTING;
				GUI.serverMSG("Other user has disconnected");
			}	
			else
				Encryption.toDecrypt(str);
		} catch (IOException e) {
			GUI.serverMSG("Reading from stream failed");
		}
		//dataIN.close();
	}

	public void run(){
		do {
			if (isHost == true || isClient == true){ //SERVER OR CLIENT
				 
				try {
					//RECIEVE DATA
					if (dataIN.ready()){
						receiveDATA();
					}
					//SEND DATA
					if (output.length() != 0){
						sendDATA();
					}
				} catch (NullPointerException npe){
					//	GUI.connectionStatus = GUI.OFFLINE;
					//	GUI.serverMSG("Null pointer in server connect...");	
				} catch (IOException e1) {
					GUI.serverMSG("Error reading message");
				}


			}	else 
					openSOCKET(); //NOT CONFIGURED
			try {
				Thread.sleep(10); //STOP EATING MY PROCESSOR
			} catch (InterruptedException e) {}
		} while(GUI.connectionStatus == GUI.CONNECTING || GUI.connectionStatus == GUI.CONNECTED);
	}
}



