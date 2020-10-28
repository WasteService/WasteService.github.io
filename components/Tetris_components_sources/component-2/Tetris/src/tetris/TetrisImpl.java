package tetris;

import java.util.Random;

import programme.Factory;

import block.BlockService;
import board.BoardService;

public class TetrisImpl implements TetrisService {

	private int score;
	private boolean isFinished;
	private boolean isRunning;
	private boolean needNext;
	private BoardService board;
	
	@Override
	public BoardService getBoard() {
		return this.board;
	}

	@Override
	public int getScore() {
		return this.score;
	}

	@Override
	public void goDown() {
		if(this.board.getBottomHeight() != 0) {
			this.board.doBottom();
			this.score += 20 + 50*this.board.getNbLastCleaned();
			this.needNext = true;
		}
	}

	@Override
	public void goLeft() {
		if(this.board.cangoLeft()) {
			this.board.doLeft();
		}
	}

	@Override
	public void goRight() {
		if(this.board.cangoRight()) {
			this.board.doRight();
		}
	}

	@Override
	public void init() {
		this.score = 0;
		this.isFinished = false;
		this.isRunning = true;
		this.needNext = true;
		this.board = Factory.createBoard();
		this.board.init(10, 22);
	}

	@Override
	public boolean isFinished() {
		return this.isFinished;
	}

	@Override
	public boolean isRunning() {
		return this.isRunning;
	}

	@Override
	public boolean needNext() {
		return this.needNext;
	}

	@Override
	public void next() {
		Random r = new Random();
		char type;
		switch(r.nextInt(7)){
			case 0: 
				type = 'O';
				break;
			case 1:
				type = 'L';
				break;
			case 2:
				type = 'J';
				break;
			case 3:
				type = 'T';
				break;
			case 4:
				type = 'Z';
				break;
			case 5:
				type = 'S';
				break;
			default:
				type = 'I';
		}
		BlockService bloc = Factory.createBlock();
		bloc.init(type);
		this.board.insert(bloc);
		if (this.board.isConflict()){
			this.isFinished = true;
			this.isRunning = false;
		}
		this.needNext = false;
	}

	@Override
	public void rotateLeft() {
		if(this.board.canRotateLeft()) {
			this.board.doRotateLeft();
		}
	}

	@Override
	public void rotateRight() {
		if(this.board.canRotateRight()) {
			this.board.doRotateRight();
		}
	}

	@Override
	public void step() {
		if(this.board.isBottom()) {
			this.board.step();
			if (!needNext)
			{
				this.score += 20 + 50*this.board.getNbLastCleaned();
				this.needNext = true;
			}
			next();
		} else {
			this.board.step();
		}
	}

}
