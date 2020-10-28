package programme;

import grid.GridService;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import joueur.JoueurService;


public class TetrisPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8545642574194371642L;
	private GridService grid;
	private JoueurService joueur;
	private JLabel score;
	
	public TetrisPanel (JoueurService joueur, JFrame fenetre){
		this.joueur = joueur;
		//this.grid = this.joueur.getTetris().getBoard().getgrid();
		this.score = new JLabel("Score: ");
		setDoubleBuffered(true);
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		this.add(score,BorderLayout.EAST);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setColor(Color.white);
		g.fillRect(10,10, 20*10, 20*22);
		g.setColor(Color.black);
		if(joueur.getTetris().isRunning()){
        for(int i=1;i<=10;i++){
        	for(int j=1;j<=22;j++){
        		if (this.grid.isOccupied(i, j))
        			g.fillRect(10+(20*(i-1)), 10+(20*(j-1)), 20, 20);
        	}
        }
		}
        g.drawRect(10, 10, 200, 440);
	}   
	
	public void setScore(int num){
		this.score.setText("Score: "+num);
	}
	
	public void setGrid(GridService grid){
		this.grid = grid;
	}
	
}
