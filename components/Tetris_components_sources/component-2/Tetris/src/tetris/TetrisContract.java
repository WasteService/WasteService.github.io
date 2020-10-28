package tetris;

import grid.GridService;
import block.BlockService;
import board.BoardService;

public class TetrisContract extends TetrisDecorator {

	public TetrisContract(TetrisService f) {
		super(f);
	}
	
	public void checkInvariants(){
		if (!(super.getScore() >= 0))
			throw new Error("[TETRIS]Invariant(1) invalide");
		
		if (!(super.isFinished() != super.isRunning()))
			throw new Error("[TETRIS]Invariant(2) invalide");
	}

	public boolean needNext(){		
		if (isRunning() == false)
			throw new Error("[TETRIS]pre(1)(needNext) invalide");
		
		checkInvariants();
		
		boolean temp = super.needNext();
		
		checkInvariants();
		return temp;
	}
	
	public void init(){
		super.init();
		
		checkInvariants();
		
		//POST BOARD:init
		BoardService board = getBoard();
		if (!(getBoard().isBlock() == false)) {
			throw new Error("[TETRIS]post(1.1)(init) invalide");
		}		
		if (!(board.getgrid().getWidth() == 10 && board.getgrid().getHeight() == 22)) {
			throw new Error("[TETRIS]post(1.2)(init) invalide");
		}
		if (!(board.getNbLastCleaned() == 0)) {
			throw new Error("[TETRIS]post(1.3)(init) invalide");
		}
		if (!(board.getXMinBlock() == 0 && board.getYMinBlock() == 0)) {
			throw new Error("[TETRIS]post(1.4)(init) invalide");
		}
		
		if (!(getScore() == 0))
			throw new Error("[TETRIS]post(2)(init) invalide");
		if (!(isRunning() == true))
			throw new Error("[TETRIS]post(3)(init) invalide");
		if (!(needNext() == true))
			throw new Error("[TETRIS]post(4)(init) invalide");

	}
	
	public void goLeft(){
		if (!(isRunning() == true))
			throw new Error("[TETRIS]pre(1)(goLeft) invalide");
		
		checkInvariants();
		
		//captures
		int getScore_atPre = getScore();
		BlockService getcurrentBlock_atPre = getBoard().getcurrentBlock();
		GridService getgrid_atPre = getBoard().getgrid();
		int getNbLastCleaned_atPre = getBoard().getNbLastCleaned();
		boolean isBlock_atPre = getBoard().isBlock();
		int getXMinBlock_atPre = getBoard().getXMinBlock();
		int getYMinBlock_atPre = getBoard().getYMinBlock();
		boolean cangoLeft_atPre = getBoard().cangoLeft();
		
		super.goLeft();
		checkInvariants();
		
		if (!(getScore() == getScore_atPre))
			throw new Error("[TETRIS]post(1)(goLeft) invalide");
		if (!(needNext() == false))
			throw new Error("[TETRIS]post(2)(goLeft) invalide");
		if(!(isRunning() == true))
			throw new Error("[TETRIS]post(3)(goLeft) invalide");
		
		//POST BOARD:doLeft
		BoardService board = getBoard();
		if(!(board.getcurrentBlock() == getcurrentBlock_atPre)) {
			throw new Error("[TETRIS]post(4.1)(goLeft) invalide");
		}
		if(!(board.getgrid() == getgrid_atPre)) {
			throw new Error("[TETRIS]post(4.2)(goLeft) invalide");
		}
		if(!(board.getNbLastCleaned() == getNbLastCleaned_atPre)) {
			throw new Error("[TETRIS]post(4.3)(goLeft) invalide");
		}
		if(!(board.isBlock() == isBlock_atPre)) {
			throw new Error("[TETRIS]post(4.4)(goLeft) invalide");
		}
		if (cangoLeft_atPre)
			if (!(board.getXMinBlock() == getXMinBlock_atPre-1)) {
				throw new Error("[TETRIS]post(4.5)(goLeft) invalide");
			}
		if (!(board.getYMinBlock() == getYMinBlock_atPre)) {
			throw new Error("[TETRIS]post(4.6)(goLeft) invalide");
		}
		
	}
	
	public void goRight(){
		if (!(isRunning() == true))
			throw new Error("[TETRIS]pre(1)(goRight) invalide");
		
		checkInvariants();
		
		int getScore_atPre = getScore();
		
		BlockService getcurrentBlock_atPre = getBoard().getcurrentBlock();
		GridService getgrid_atPre = getBoard().getgrid();
		int getNbLastCleaned_atPre = getBoard().getNbLastCleaned();
		boolean isBlock_atPre = getBoard().isBlock();
		int getXMinBlock_atPre = getBoard().getXMinBlock();
		int getYMinBlock_atPre = getBoard().getYMinBlock();
		boolean cangoRight_atPre = getBoard().cangoRight();
		
		super.goRight();
		
		checkInvariants();
		
		if (!(getScore() == getScore_atPre))
			throw new Error("[TETRIS]post(1)(goRight) invalide");
		if (!(needNext() == false))
			throw new Error("[TETRIS]post(2)(goRight) invalide");
		if(!(isRunning() == true))
			throw new Error("[TETRIS]post(3)(goRight) invalide");
		
		//POST BOARD:doRight
		BoardService board = getBoard();
		if(!(board.getcurrentBlock() == getcurrentBlock_atPre)) {
			throw new Error("[TETRIS]post(4.1)(goRight) invalide");
		}
		if(!(board.getgrid() == getgrid_atPre)) {
			throw new Error("[TETRIS]post(4.2)(goRight) invalide");
		}
		if(!(board.getNbLastCleaned() == getNbLastCleaned_atPre)) {
			throw new Error("[TETRIS]post(4.3)(goRight) invalide");
		}
		if(!(board.isBlock() == isBlock_atPre)) {
			throw new Error("[TETRIS]post(4.4)(goRight) invalide");
		}
		if (cangoRight_atPre)
			if (!( board.getXMinBlock() == getXMinBlock_atPre+1)) {
				throw new Error("[TETRIS]post(4.5)(goRight) invalide");
			}
		if (!(board.getYMinBlock() == getYMinBlock_atPre)) {
			throw new Error("[TETRIS]post(4.6)(goRight) invalide");
		}
	}
	
	public void goDown(){
		if (!(isRunning() == true))
			throw new Error("[TETRIS]pre(1)(goDown) invalide");
		
		checkInvariants();
		
		boolean isBottom_atPre = getBoard().isBottom();
		int getScore_atPre = getScore();
		BlockService getcurrentBlock_atPre = getBoard().getcurrentBlock();
		GridService getgrid_atPre = getBoard().getgrid();
		boolean isBlock_atPre = getBoard().isBlock();
		int getXMinBlock_atPre = getBoard().getXMinBlock();
		int getYMinBlock_atPre = getBoard().getYMinBlock();
		int getBottomHeight_atPre = getBoard().getBottomHeight();
		
		super.goDown();
		
		checkInvariants();
		
		if (isBottom_atPre){
			if (!(getScore() == getScore_atPre))
				throw new Error("[TETRIS]post(1)(goDown) invalide");
		}
		else {
			if (!(getScore_atPre+20+50*(getBoard().getNbLastCleaned()) == getScore()))
				throw new Error("[TETRIS]post(2)(goDown) invalide");
			
			if (!(needNext() == true))
				throw new Error("[TETRIS]post(3)(goDown) invalide");
		}
		if (!(isRunning()))
			throw new Error("[TETRIS]post(4)(goDown) invalide");

		//POST BOARD:doBottom
		BoardService board = getBoard();
		if(!(board.getcurrentBlock() == getcurrentBlock_atPre)) {
			throw new Error("[TETRIS]post(5.1)(goDown) invalide");
		}
		if(!(board.getgrid() == getgrid_atPre)) {
			throw new Error("[TETRIS]post(5.2)(goDown) invalide");
		}
		if(!(board.isBlock() == isBlock_atPre)) {
			throw new Error("[TETRIS]post(5.3)(goDown) invalide");
		}
		if (!(board.getXMinBlock() == getXMinBlock_atPre)) {
			throw new Error("[TETRIS]post(5.4)(goDown) invalide");
		}
		if (!(board.getYMinBlock() == getYMinBlock_atPre+getBottomHeight_atPre+board.getNbLastCleaned())) {
			throw new Error("[TETRIS]post(5.5)(goDown) invalide");
		}
		if(!(board.getBottomHeight() == 0 || board.isBottom())) {
			throw new Error("[TETRIS]post(5.6)(goDown) invalide");
		}
	}
	
	public void rotateLeft(){
		if (!(isRunning() == true))
			throw new Error("[TETRIS]pre(1)(rotateLeft) invalide");
		
		checkInvariants();
		
		int getScore_atPre = getScore();
		BlockService getcurrentBlock_atPre = getBoard().getcurrentBlock();
		GridService getgrid_atPre = getBoard().getgrid();
		int getNbLastCleaned_atPre = getBoard().getNbLastCleaned();
		boolean isBlock_atPre = getBoard().isBlock();
		int getXMinBlock_atPre = getBoard().getXMinBlock();
		int getYMinBlock_atPre = getBoard().getYMinBlock();
		
		super.rotateLeft();
		
		checkInvariants();
		
		if (!(getScore() == getScore_atPre))
			throw new Error("[TETRIS]post(1)(rotateLeft) invalide");
		if (!(needNext() == false))
			throw new Error("[TETRIS]post(2)(rotateLeft) invalide");
		if(!(isRunning() == true))
			throw new Error("[TETRIS]post(3)(rotateLeft) invalide");
		
		//POST BOARD:doRotateLeft
		BoardService board = getBoard();
		if(!(board.getcurrentBlock() == getcurrentBlock_atPre)) {
			throw new Error("[TETRIS]post(4.1)(rotateLeft) invalide");
		}
		if(!(board.getgrid() == getgrid_atPre)) {
			throw new Error("[TETRIS]post(4.2)(rotateLeft) invalide");
		}
		if(!(board.getNbLastCleaned() == getNbLastCleaned_atPre)) {
			throw new Error("[TETRIS]post(4.3)(rotateLeft) invalide");
		}
		if(!(board.isBlock() == isBlock_atPre)) {
			throw new Error("[TETRIS]post(4.4)(rotateLeft) invalide");
		}
		if (!(board.getXMinBlock() == getXMinBlock_atPre)) {
			throw new Error("[TETRIS]post(4.5)(rotateLeft) invalide");
		}
		if (!(board.getYMinBlock() == getYMinBlock_atPre)) {
			throw new Error("[TETRIS]post(4.6)(rotateLeft) invalide");
		}
	}
	
	public void rotateRight(){
		if (!(isRunning() == true))
			throw new Error("[TETRIS]pre(1)(rotateRight) invalide");
		
		checkInvariants();
		
		int getScore_atPre = getScore();
		BlockService getcurrentBlock_atPre = getBoard().getcurrentBlock();
		GridService getgrid_atPre = getBoard().getgrid();
		int getNbLastCleaned_atPre = getBoard().getNbLastCleaned();
		boolean isBlock_atPre = getBoard().isBlock();
		int getXMinBlock_atPre = getBoard().getXMinBlock();
		int getYMinBlock_atPre = getBoard().getYMinBlock();
		
		super.rotateRight();
		
		checkInvariants();
		
		if (!(getScore() == getScore_atPre))
			throw new Error("[TETRIS]post(1)(rotateRight) invalide");
		if (!(needNext() == false))
			throw new Error("[TETRIS]post(2)(rotateRight) invalide");
		if(!(isRunning() == true))
			throw new Error("[TETRIS]post(3)(rotateRight) invalide");
		
		//POST BOARD:doRotateRight
		BoardService board = getBoard();
		if(!(board.getcurrentBlock() == getcurrentBlock_atPre)) {
			throw new Error("[TETRIS]post(4.1)(rotateRight) invalide");
		}
		if(!(board.getgrid() == getgrid_atPre)) {
			throw new Error("[TETRIS]post(4.2)(rotateRight) invalide");
		}
		if(!(board.getNbLastCleaned() == getNbLastCleaned_atPre)) {
			throw new Error("[TETRIS]post(4.3)(rotateRight) invalide");
		}
		if(!(board.isBlock() == isBlock_atPre)) {
			throw new Error("[TETRIS]post(4.4)(rotateRight) invalide");
		}
		if (!(board.getXMinBlock() == getXMinBlock_atPre)) {
			throw new Error("[TETRIS]post(4.5)(rotateRight) invalide");
		}
		if (!(board.getYMinBlock() == getYMinBlock_atPre)) {
			throw new Error("[TETRIS]post(4.6)(rotateRight) invalide");
		}
	}
	
	public void step(){
		if (!(isRunning() == true))
			throw new Error("[TETRIS]pre(1)(step) invalide");
		
		checkInvariants();
		
		int getScore_atPre = getScore();
		boolean isBottom_atPre = getBoard().isBottom();
		boolean needNext_atPre = needNext();
		
		GridService getgrid_atPre = getBoard().getgrid();
		boolean isBlock_atPre = getBoard().isBlock();
		int getXMinBlock_atPre = getBoard().getXMinBlock();
		int getYMinBlock_atPre = getBoard().getYMinBlock();
		int getBottomHeight_atPre = getBoard().getBottomHeight();
		
		super.step();
		
		checkInvariants();
		
		if(isRunning()) {
		if (isBottom_atPre){
			if (needNext_atPre) {
				if(!(getScore() == getScore_atPre))
					throw new Error("[TETRIS]post(1)(step) invalide");
			}
			else {
				if (!(getScore() == getScore_atPre + 20 + (getBoard().getNbLastCleaned()*50)))
					throw new Error("[TETRIS]post(2)(step) invalide");
			}
			if(!(needNext() == false))
				throw new Error("[TETRIS]post(3)(step) invalide");
		}
		else{
			if (!(getScore() == getScore_atPre))
				throw new Error("[TETRIS]post(4)(step) invalide");
			if (!(needNext_atPre == needNext()))
				throw new Error("[TETRIS]post(5)(step) invalide");

			//POST BOARD:step
			BoardService board = getBoard();
			if(!(board.getgrid() == getgrid_atPre)) {
				throw new Error("[TETRIS]post(6.1)(step) invalide");
			}
			if(!(board.isBlock() == isBlock_atPre)) {
				throw new Error("[TETRIS]post(6.2)(step) invalide");
			}
			if (!isBottom_atPre){
				if(!(board.getXMinBlock() == getXMinBlock_atPre)) {
					throw new Error("[TETRIS]post(6.3)(step) invalide");
				}

				if (!(board.getYMinBlock() == getYMinBlock_atPre+1)) {
					throw new Error("[TETRIS]post(6.4)(step) invalide");
				}
				if (!(board.getBottomHeight() == getBottomHeight_atPre-1)) {
					throw new Error("[TETRIS]post(6.5)(step) invalide");
				}
			}			
		}
		}
	}
	
	public void next(){
		if (!(needNext() == true))
			throw new Error("[TETRIS]pre(1)(next) invalide");
		
		checkInvariants();
		
		int getScore_atPre = getScore();
		GridService getgrid_atPre = getBoard().getgrid();
		
		super.next();
		
		checkInvariants();
		
		if (!(getScore() == getScore_atPre))
			throw new Error("[TETRIS]post(1)(next) invalide");
		if (!(needNext() == false))
			throw new Error("[TETRIS]post(2)(next) invalide");
		
		//POST BOARD:insert
		BoardService board = getBoard();
		
		if(!(board.getgrid() == getgrid_atPre)) {
			throw new Error("[TETRIS]post(3.2)(next) invalide");
		}
		if(!(board.isBlock())) {
			throw new Error("[TETRIS]post(3.3)(next) invalide");
		}
	}
}
