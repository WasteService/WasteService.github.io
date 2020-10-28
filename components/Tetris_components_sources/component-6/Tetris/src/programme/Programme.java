package programme;

import java.awt.Graphics;

import javax.swing.JPanel;

import joueur.JoueurService;


public class Programme extends JPanel{

	private static final long serialVersionUID = 2104825133643372892L;

	private final Fenetre fenetre;
	private final JoueurService joueur;
	
	public Programme(){
		setDoubleBuffered(true);
		this.joueur = Factory.createJoueur();
		this.joueur.init();
		//this.joueur.getTetris().init();
		this.fenetre = new Fenetre(joueur);
	}
	
	public void init(){
		fenetre.setSize(320, 520);
		fenetre.setLocationRelativeTo(null);
		fenetre.setResizable(false);
		fenetre.setVisible(true);
	}
	
	public void paintComponent(Graphics g){
	    super.paintComponent(g);
	  }
	
}
