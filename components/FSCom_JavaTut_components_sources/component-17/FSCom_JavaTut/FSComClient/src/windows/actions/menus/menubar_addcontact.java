package windows.actions.menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import socket.packet.handlers.sends.contact_handlers.AddContact_handler;

public class menubar_addcontact implements ActionListener {

	private String reponse;

	public void actionPerformed(ActionEvent e) {
	
		reponse = JOptionPane.showInputDialog(null,"Entrez l'identifiant du contact � ajouter :",
				"Nouveau contact",JOptionPane.QUESTION_MESSAGE);
		if (reponse != null && !reponse.equalsIgnoreCase(""))
		{
			AddContact_handler pck = new AddContact_handler(reponse);
			pck.Send();
		}	

	}

}
