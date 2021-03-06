package session;

import java.awt.Image;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import socket.Sender;
import socket.packet.ConnectData;
import socket.packet.handlers.sends.Disconnect_handler;
import socket.packet.handlers.sends.client_handlers.Answer_Invit_handler;
import socket.packet.handlers.sends.client_handlers.AvatarSender_handler;
import socket.packet.objects.Avatar;
import socket.packet.objects.ClientDatas;
import socket.packet.objects.IdAndData;
import socket.packet.objects.Message;
import thread.threading;
import thread.windowthread;
import windows.SwingExtendLib.SwingEL;
import windows.forms.form_communicate;
import windows.forms.form_inscription;
import windows.forms.onglet_communicate;
import misc.Log;

public class events {

	public static void StoreStatus(Integer st)
	{
		Session.setStatus(st);
	}
	
	public static void StoreContacts(Vector<contact> packet)
	{
		Session.ClearContacts();
		for(contact ct: packet)
			Session.CreateNewContact(ct);
	}

	public static void StoreGroups(Vector<group> packet) 
	{
		Session.ClearGroups();
		
		Session.CreateNewGroup(new group(0,"Autres contacts"));
		for(group gr:packet)
			Session.CreateNewGroup(gr);
	}

	public static void ContactDisconnected(Object packet) 
	{
		Integer st = Integer.decode(packet.toString());
		for(group g : Session.getGroups())
			for(contact ct : g.getContacts())
				if(ct.getCid().equals(st))
				{
					ct.setStatus(0);
					windowthread.getFmConn().getPanContact().RefreshContactList();
					return;
				}
	}

	public static void ContactConnected(Object packet) 
	{
		if(!packet.getClass().equals((new ConnectData("",0,"",0,"")).getClass()))
			return;
		
		ConnectData cn = (ConnectData)packet;
		for(group g : Session.getGroups())
			for(contact ct : g.getContacts())
				if(ct.getCid().equals(cn.getUid()))
				{
					ct.setStatus(cn.getStatus());
					ct.setPseudo(cn.getPseudo());
					ct.setMsg_perso(cn.getPersoP());
					windowthread.getFmConn().getPanContact().RefreshContactList();
					return;
				}
	}

	public static void BlockContact(Object packet) 
	{
		if(!packet.getClass().equals((new IdAndData(0,"")).getClass()))
			return;
		
		IdAndData pck = (IdAndData)packet;
		Integer _uid = pck.getUid();
		Integer method = Integer.decode(pck.getDat());
		for(group g : Session.getGroups())
			for(contact ct : g.getContacts())
				if(ct.getCid().equals(_uid))
				{
					ct.setBlocked((method == 1) ? true: false);
					if(ct.isBlocked())
						JOptionPane.showMessageDialog(null, "Le contact " + ct.getPseudo() +  " a �t� bloqu�");
					else
						JOptionPane.showMessageDialog(null, "Le contact " + ct.getPseudo() +  " a �t� d�bloqu�");
					windowthread.getFmConn().getPanContact().RefreshContactList();
					return;
				}
	}

	public static void RecvMsg(Object packet) 
	{
		if(!packet.getClass().equals((new Message(null,null)).getClass()))
		{
			Log.outError("Malformed Msg to Transmit");
			return;
		}
		
		Message msg = (Message) packet;
		Integer _uid = msg.getDest();
		form_communicate fmSpeak = windowthread.getFmConn().getPanContact().getComm();
		if(fmSpeak == null)
		{
			windowthread.getFmConn().getPanContact().setComm(new form_communicate());
			fmSpeak = windowthread.getFmConn().getPanContact().getComm();
		}
		
		onglet_communicate ongl = fmSpeak.GetContactConvers(_uid);
		if(ongl == null)
		{
			contact ct = Session.getContactByUid(_uid);
			if(ct != null)
			{
				windowthread.getFmConn().getPanContact().getComm().AddTab(ct);
				ongl = fmSpeak.GetContactConvers(_uid);
				ongl.WriteMsg(msg.getMsg());
			}
			else
				Log.outError("Contact" + _uid + " not exist for client");
		}
		else
			ongl.WriteMsg(msg.getMsg());
	}

	public static void ContactModifyStatus(Object packet) 
	{
		if(!packet.getClass().equals((new IdAndData(0,"")).getClass()))
			return;
		
		IdAndData pck = (IdAndData)packet;
		if(pck.getUid().equals(0))
		{
			Session.setStatus(Integer.decode(pck.getDat()));
			form_communicate fmCom = windowthread.getFmConn().getPanContact().getComm();
				if(fmCom != null)
					fmCom.ChangeAllMyStatusBorder();
			windowthread.getFmConn().getPanContact().ChangeBorderStatus();
		}
		else
		{
			for(group g : Session.getGroups())
				for(contact ct : g.getContacts())
					if(ct.getCid().equals(pck.getUid()))
					{
						ct.setStatus(Integer.decode(pck.getDat()));
						windowthread.getFmConn().getPanContact().RefreshContactList();
						form_communicate fmCom = windowthread.getFmConn().getPanContact().getComm();
						if(fmCom != null)
							fmCom.ChangeConversStatusForContact(ct.getCid());
						return;
					}
		}
	}

	public static void ContactModifyPseudo(Object packet) 
	{
		if(!packet.getClass().equals((new IdAndData(null,null)).getClass()))
			return;
		
		IdAndData pck = (IdAndData) packet;
		if(pck.getUid().equals(0))
		{
			if(windowthread.getFmConn() != null)
				if(windowthread.getFmConn().getPanContact() != null)
					windowthread.getFmConn().getPanContact().ChPseudo(pck.getDat());
		}
		else
		{
			for(group g : Session.getGroups())
				for(contact ct : g.getContacts())
					if(ct.getCid().equals(pck.getUid()))
					{
						ct.setPseudo(pck.getDat());
						windowthread.getFmConn().getPanContact().RefreshContactList();
						form_communicate fmCom = windowthread.getFmConn().getPanContact().getComm();
						if(fmCom != null)
							fmCom.ChangeConversTabTitle(pck.getUid(),pck.getDat());
						return;
					}
		}
	}

	public static void ContactModifyPmsg(Object packet) 
	{
		if(!packet.getClass().equals((new IdAndData(null,null)).getClass()))
			return;
		
		IdAndData pck = (IdAndData) packet;
		if(pck.getUid().equals(0))
		{
			if(windowthread.getFmConn() != null)
				if(windowthread.getFmConn().getPanContact() != null)
					windowthread.getFmConn().getPanContact().ChPPers(pck.getDat());
		}
		else
		{
			for(group g : Session.getGroups())
				for(contact ct : g.getContacts())
					if(ct.getCid().equals(pck.getUid()))
					{
						ct.setMsg_perso(pck.getDat());
						// TODO: modify into conversation tab
						form_communicate fmCom = windowthread.getFmConn().getPanContact().getComm();
						if(fmCom != null)
							/**/;
						return;
					}
		}
	}

	public static void ContactAdded(Object packet) 
	{
		contact ct = (contact)packet;
		if(ct == null){
			Log.ShowPopup("Le contact ajout� n'existe pas !", true);
			return;
		}
		for(group g: Session.getGroups())
			if(g.getGid().equals(0))
			{
				g.AddContact(ct);
				windowthread.getFmConn().getPanContact().HardRefreshContactList();
				return;
			}
	}

	public static void ContactDeleted(Object packet) 
	{
		for(group g : Session.getGroups())
			for(contact ct : g.getContacts())
				if(ct.getCid().equals(Integer.decode(packet.toString())))
				{
					g.getContacts().remove(ct);
					windowthread.getFmConn().getPanContact().HardRefreshContactList();
					return;
				}
	}

	public static void RecvInvitation(Object packet) 
	{
		if(!packet.getClass().equals((new IdAndData(0,"")).getClass()))
			return;

		IdAndData pck = (IdAndData)packet;

		Integer answer = JOptionPane.showConfirmDialog(null, pck.getDat() + " vous a ajout�, voulez vous l'accepter ?","Nouveau contact !",JOptionPane.YES_NO_CANCEL_OPTION);
		Answer_Invit_handler arh = new Answer_Invit_handler(pck.getUid(), answer);
		Log.outError(answer.toString());
		arh.Send();
	}

	public static void ConnectionError() 
	{
		Log.ShowPopup("Erreur de connexion avec le serveur", true);
	}

	public static void BadLoginInformations() 
	{
		Log.ShowPopup("Login incorrect", true);
	}

	public static void ShowConnectedFrame() 
	{
		windowthread.SwitchPanel(2);
	}

	public static void DisconnectCurrentClient() 
	{
		Disconnect_handler pck = new Disconnect_handler();
		pck.Send();
		Sender.StopSocket();
		threading.StopSender();
	}

	public static void StoreAllDatas(Object packet) 
	{
		if(!packet.getClass().equals((new ClientDatas()).getClass()))
			return;
		ClientDatas pck = (ClientDatas) packet;
		Session.setPerso_msg(pck.getPperso());
		Session.setPseudo(pck.getPseudo());
		events.StoreGroups(pck.GetMyGroups());
		events.StoreContacts(pck.GetMyContacts());
		Session.setStatus(pck.getStatus());
		
		AvatarSender_handler pkt = new AvatarSender_handler(new ImageIcon(SwingEL.scale(
				(new ImageIcon("avatar.png")).getImage())));
		pkt.Send();
	}

	public static void GroupAdded(Object data) 
	{
		if(!data.getClass().equals((new IdAndData(0,"")).getClass()))		
			return;
		
		IdAndData pck = (IdAndData)data;
		group gr = new group(pck.getUid(), pck.getDat());
		Session.getGroups().add(gr);
		windowthread.getFmConn().getPanContact().HardRefreshContactList();		
	}

	public synchronized static void GroupDeleted(Object data) 
	{
		Integer _gid = Integer.decode(data.toString());
		if(_gid.equals(0))
			return;
		
		for(group g: Session.getGroups())
		{
			if(g.getGid().equals(_gid))
			{
				group move_gr = Session.getDefaultGroup();
				if(move_gr == null)
					return;
				
				//for(contact ct: g.getContacts())
				for(int i=0;i<g.getContacts().size();i++)
				{
					contact ct = g.getContacts().get(i);
					move_gr.AddContact(ct);
					g.getContacts().remove(ct);
				}
				
				g.getContacts().clear();
				Session.getGroups().remove(g);
				
				windowthread.getFmConn().getPanContact().HardRefreshContactList();
				return;
			}
		}
	}

	public static void GroupRenamed(Object data) 
	{
		if(!data.getClass().equals((new IdAndData(0,"")).getClass()))
			return;
		
		IdAndData pck = (IdAndData)data;
		Integer _gid = pck.getUid();
		String newName = pck.getDat();
		
		for(group g: Session.getGroups())
		{
			if(g.getGid().equals(_gid))
			{
				g.setGname(newName);
				windowthread.getFmConn().getPanContact().HardRefreshContactList();
				return;
			}
		}
	}

	public static void CreateAccountAnswer(Object data) 
	{
		Integer res = Integer.decode(data.toString());
		form_inscription fmInsc = windowthread.getFmConn().getPanConnect().getFmInsc();
		if(fmInsc == null)
			return;
		threading.StopSender();
		if(res != 1)
		{
			JOptionPane.showMessageDialog(null,"Compte d�j� existant !");
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Compte cr�� avec succ�s !");
			windowthread.getFmConn().getPanConnect().setFmInsc(null);
			fmInsc.dispose();
		}
	}

	public static void ChangeContactAvatar(Object data) 
	{
		if(data == null || !data.getClass().equals((new Avatar(0,new ImageIcon()).getClass())))
			return;
		
		Avatar av = (Avatar)data;
		if(av == null)
			return;
		
		Integer _uid = av.getUid();
		if(av.getImg() == null)
		{
			ImageIcon a = new ImageIcon ("cookie.jpg");
		    Image avatar = SwingEL.scale(a.getImage());
		    av.setImg(new ImageIcon(avatar));
		}
		
		ImageIcon img = av.getImg();
		form_communicate fmCom = windowthread.getFmConn().getPanContact().getComm();
		if(fmCom == null)
			return;
		
		fmCom.ChangeContactAvatar(_uid,img);
	}
	
	public synchronized static void ContactChangeGroup(contact ct,Integer gid) {
		for(group g: Session.getGroups()){
			//for(contact c:g.getContacts()){
			for(int i=0;i<g.getContacts().size();i++){
				contact c = g.getContacts().get(i);
				if(ct.equals(c))
					g.getContacts().remove(c);
			}
		}
		
		for(group g: Session.getGroups()){
			if(g.getGid().equals(gid)){
				g.AddContact(ct);
			return;
			}
		}
			
	}
}
