package joueur;

import programme.Factory;
import tetris.TetrisService;

public class JoueurImpl implements JoueurService {

	private TetrisService tetris;
	
	public TetrisService getTetris() {
		return this.tetris;
	}
	
	public boolean canPlay(){
		return tetris.isRunning() && !tetris.isFinished() && !tetris.needNext();
	}
	
	public void init() {
		this.tetris = Factory.createTetris();
	}
	
	public void startGame(){
		if (!canPlay())
			this.tetris.next();
	}
	
	public void goLeft() {
		if (canPlay())
			this.tetris.goLeft();
	}
	
	public void goRight() {
		if (canPlay())
			this.tetris.goRight();
	}
	
	public void goDown() {
		if (canPlay())
			this.tetris.goDown();
	}
	
	public void rotateLeft() {
		if (canPlay())
			this.tetris.rotateLeft();
	}
	
	public void rotateRight() {
		if (canPlay())
			this.tetris.rotateRight();
	}
	
}
