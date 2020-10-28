package tetris;

import board.BoardService;

public interface TetrisService {
	/** Observators */
	public int getScore();
	public boolean isFinished();
	public boolean isRunning();
	public boolean needNext();
		//pre: isRunning == true
	public BoardService getBoard();
	
	/** Invariants
	 * getScore() >= 0
	 * isFinished() = !isRunning
	 */
	
	/** Constructor
	 * Initialise
	 * post: getBoard() == Board:init(10,22)
	 * post: getScore() == 0
	 * post: isRunning() == true
	 * post: needNext() == true
	 */
	public void init();
	
	/** Operators */
	/**
	 * pre: isRunning() == true
	 * post: getScore()@pre == getScore()
	 * post: needNext() == false
	 * post: isRunning() == true
	 * post: getBoard() == getBoard()@pre.doLeft()
	 */
	public void goLeft();
	
	/**
	 * pre: isRunning() == true
	 * post: getScore()@pre == getScore()
	 * post: needNext() == false
	 * post: isRunning() == true
	 * post: getBoard() == getBoard()@pre.doRight()
	 */
	public void goRight();
	
	/**
	 * pre: isRunning() == true
	 * post: getBoard()@pre.isBottom() => getScore() == getScore@pre
	 * post: !getBoard()@pre.isBottom() => getScore() == getScore()@pre + 20 + (Board:getNbLastCleaned()*50)
	 * post: !getBoard()@pre.isBottom() <=> needNext() == true
	 * post: isRunning() == true
	 * post: getBoard() == getBoard()@pre.doBottom()
	 */
	public void goDown();
	
	/**
	 * pre: isRunning() == true
	 * post: getScore()@pre == getScore()
	 * post: needNext() == false
	 * post: isRunning() == true
	 * post: getBoard() == getBoard()@pre.doRotateLeft()
	 */
	public void rotateLeft();
	
	/**
	 * pre: isRunning() == true
	 * post: getScore()@pre == getScore()
	 * post: needNext() == false
	 * post: isRunning() == true
	 * post: getBoard() == getBoard()@pre.doRotateRight()
	 */
	public void rotateRight();
	
	/**
	 * pre: isRunning() == true
	 * post: getBoard()@pre.isBottom() && needNext() => getScore() == getScore()@pre
	 * post: getBoard()@pre.isBottom() && !needNext() => getScore() == getScore()@pre + 20 + (Board:getNbLastCleaned()*50)
	 * post: getBoard()@pre.isBottom() => needNext() == false
	 * post: !getBoard()@pre.isBottom() => getScore() == getScore()@pre
	 * post: !getBoard()@pre.isBottom() => needNext() == needNext()@pre
	 * post: !getBoard()@pre.isBottom() => getBoard() == getBoard()@pre.step()
	 */
	public void step();
	
	/**
	 * pre: needNext() == true
	 * post: getScore() == getScore()@pre
	 * post: needNext() == false
	 * post: getBoard() == getBoard()@pre.insert(Block:init(Random))
	 */
	public void next();
	
}
