package programme;

import block.*;
import board.*;
import grid.*;
import tetris.*;
import joueur.*;

public class Factory {
	private static boolean useContract = true;
	
	public static BlockService createBlock(){
		BlockService BS;
		if (useContract)
			BS = new BlockContract(new BlockImpl());
		else
			BS = new BlockImpl();
		return BS;
	}
	
	public static BoardService createBoard(){
		BoardService BS;
		if (useContract)
			BS = new BoardContract(new BoardImpl());
		else
			BS = new BoardImpl();
		return BS;
	}
	
	public static GridService createGrid(){
		GridService BS;
		
		if (useContract)
			BS = new GridContract(new GridImpl());
		else
			BS = new GridImpl();
		return BS;
	}
	
	public static TetrisService createTetris(){
		TetrisService BS;
		
		if (useContract)
			BS = new TetrisContract(new TetrisImpl());
		else
			BS = new TetrisImpl();
		return BS;
	}
	
	public static JoueurService createJoueur(){
		JoueurService BS;
		
		if (useContract)
			BS = new JoueurContract(new JoueurImpl());
		else
			BS = new JoueurImpl();
		return BS;
	}
	
	public static void needToUseContract(boolean choice){
		Factory.useContract = choice;
	}
}
