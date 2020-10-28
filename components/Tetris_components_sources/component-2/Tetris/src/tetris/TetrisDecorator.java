package tetris;

import board.BoardService;

public abstract class TetrisDecorator implements TetrisService{
	TetrisService delegate;
	
	public TetrisDecorator(TetrisService f){
		this.delegate = f;
	}
	
	public int getScore(){
		return this.delegate.getScore();
	}
	
	public boolean isFinished(){
		return this.delegate.isFinished();
	}
	
	public boolean isRunning(){
		return this.delegate.isRunning();
	}
	
	public boolean needNext(){
		return this.delegate.needNext();
	}

	public BoardService getBoard(){
		return this.delegate.getBoard();
	}
	
	public void init(){
		this.delegate.init();
	}
	
	public void goLeft(){
		this.delegate.goLeft();
	}
	
	public void goRight(){
		this.delegate.goRight();
	}
	
	public void goDown(){
		this.delegate.goDown();
	}
	
	public void rotateLeft(){
		this.delegate.rotateLeft();
	}
	
	public void rotateRight(){
		this.delegate.rotateRight();
	}
	
	public void step(){
		this.delegate.step();
	}
	
	public void next(){
		this.delegate.next();
	}
}
