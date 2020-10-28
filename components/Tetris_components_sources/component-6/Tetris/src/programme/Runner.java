package programme;

import javax.swing.JOptionPane;

import joueur.JoueurService;


public class Runner extends Thread implements Runnable {
	private JoueurService joueur;
	private Fenetre fenetre;
	
	public Runner(JoueurService joueur2, Fenetre fenetre){
		this.joueur = joueur2;
		this.fenetre = fenetre;
	}

	@Override
	public void run() {
		
		while(!joueur.getTetris().isFinished()){
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		fenetre.doAction(Fenetre.STEP);
		}
		//System.out.println("Fini: "+joueur.getTetris().getScore());
		String message = "Partie terminee!\nVotre score est de : "+joueur.getTetris().getScore();
		JOptionPane.showMessageDialog(null, message, "Tetris", JOptionPane.INFORMATION_MESSAGE);
		joueur.init();
	}
}
