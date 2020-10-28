/****************************************
 * DESSOLATION MESSENGER OF DISSERVICE
 * 
 ****************************************
 * Encryption layer for the DMOD chat app
 * 
 * 
 * @author Zach Jetson <zjetson@asu.edu>
 * @author Jason Joliet <jjoliet@asu.edu>
 * @version 1.2
 * 
 * Encrypts data going out
 * Decryption of data will be implemented
 * in the paid for edition v2.0
 ****************************************/

public final class Encryption {

	/**Receive user String input, decrypt it into the encrypted string. Send to GUI. **/
	public static void toDecrypt(String toDecrypt) {
		
//		System.out.println(toDecrypt);
//		StringBuilder decrypting = new StringBuilder(toDecrypt);
//		decrypting.reverse();
//		toDecrypt = decrypting.toString();
//		StringBuilder decrypt = new StringBuilder(toDecrypt.length());
//		char decChar;
//		
//		for (int x = 0; x < toDecrypt.length(); ++x) {
//			decChar = toDecrypt.charAt(x);
//			if ((int) decChar >= 23) {
//				decChar -= 23;
//				decrypt.append(decChar);
//			}
//			else {
//				decChar = (char)((int) decChar + 232);
//				decrypt.append(decChar);
//				}
//			}
//		
//		GUI.serverMSG(decrypt.toString());
		GUI.serverMSG(toDecrypt);
	}
	 
	/**Receive user String input, encrypt it into the encrypted string. Call TCP Operations to encapsulate and transmit packet. **/
	public static void toEncrypt(String toEncrypt) {
		
		StringBuilder encrypting = new StringBuilder(toEncrypt.length());
		
		char encChar;
		
		for (int x = 0; x < toEncrypt.length(); ++x) {
			encChar = toEncrypt.charAt(x);
			if ((int) encChar <= 255 && (int) encChar >= 0) {
				if ((int) encChar <= 232) {
					encChar += 23;
					encrypting.append(encChar);
				} else {
					encChar = (char) ((int) encChar - 233);
					encrypting.append(encChar);
				}
			}
		}
		encrypting.reverse();
		TCPOperations.TCPSend(encrypting.toString());
		
	}
}
