package tetris;

import static org.junit.Assert.assertTrue;
import grid.GridService;

import org.junit.Test;

import programme.Factory;

import block.BlockService;

public class TetrisTest{
	
	private static TetrisService tetris;
	
	@Test
	public void testNeedNext() {
		tetris = Factory.createTetris();
		
		try {
			tetris.needNext();
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		tetris.init();
		
		try {
			tetris.needNext();
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		try {
			((TetrisContract) tetris).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}		
		
	}
	
	@Test
	public void testInit(){
		tetris = Factory.createTetris();
		
		try{
			tetris.init();
			assertTrue(true);
		}catch(Error e){
			assertTrue(false);
		}
		
		try {
			((TetrisContract) tetris).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		assertTrue(tetris.getBoard().isBlock() == false);
		assertTrue(tetris.getBoard().getgrid().getWidth() == 10 && tetris.getBoard().getgrid().getHeight() == 22);
		assertTrue(tetris.getBoard().getNbLastCleaned() == 0);
		assertTrue(tetris.getBoard().getXMinBlock() == 0 && tetris.getBoard().getYMinBlock() == 0);
		
		assertTrue(tetris.getScore() == 0);
		assertTrue(tetris.isRunning() == true);
		assertTrue(tetris.needNext() == true);
	}
		
	@Test
	public void testGoLeft() {
		tetris = Factory.createTetris();
		tetris.init();
		tetris.next();
		
		int getScore_atPre = tetris.getScore();
		BlockService getcurrentBlock_atPre = tetris.getBoard().getcurrentBlock();
		GridService getgrid_atPre = tetris.getBoard().getgrid();
		int getNbLastCleaned_atPre = tetris.getBoard().getNbLastCleaned();
		boolean isBlock_atPre = tetris.getBoard().isBlock();
		int getXMinBlock_atPre = tetris.getBoard().getXMinBlock();
		int getYMinBlock_atPre = tetris.getBoard().getYMinBlock();
		
		try {
			tetris.goLeft();
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		try {
			((TetrisContract) tetris).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		assertTrue(tetris.getScore() == getScore_atPre);
		assertTrue(tetris.needNext() == false);
		assertTrue(tetris.isRunning());
		
		assertTrue(tetris.getBoard().getcurrentBlock() == getcurrentBlock_atPre);
		assertTrue(tetris.getBoard().getgrid() == getgrid_atPre);
		assertTrue(tetris.getBoard().getNbLastCleaned() == getNbLastCleaned_atPre);
		assertTrue(tetris.getBoard().isBlock() == isBlock_atPre);
		assertTrue(tetris.getBoard().getXMinBlock() == getXMinBlock_atPre-1);
		assertTrue(tetris.getBoard().getYMinBlock() == getYMinBlock_atPre);
	}

	@Test
	public void testGoRight() {
		tetris = Factory.createTetris();
		tetris.init();
		tetris.next();
		
		int getScore_atPre = tetris.getScore();
		BlockService getcurrentBlock_atPre = tetris.getBoard().getcurrentBlock();
		GridService getgrid_atPre = tetris.getBoard().getgrid();
		int getNbLastCleaned_atPre = tetris.getBoard().getNbLastCleaned();
		boolean isBlock_atPre = tetris.getBoard().isBlock();
		int getXMinBlock_atPre = tetris.getBoard().getXMinBlock();
		int getYMinBlock_atPre = tetris.getBoard().getYMinBlock();
		
		try {
			tetris.goRight();
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		try {
			((TetrisContract) tetris).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		assertTrue(tetris.getScore() == getScore_atPre);
		assertTrue(tetris.needNext() == false);
		assertTrue(tetris.isRunning());
		
		assertTrue(tetris.getBoard().getcurrentBlock() == getcurrentBlock_atPre);
		assertTrue(tetris.getBoard().getgrid() == getgrid_atPre);
		assertTrue(tetris.getBoard().getNbLastCleaned() == getNbLastCleaned_atPre);
		assertTrue(tetris.getBoard().isBlock() == isBlock_atPre);
		assertTrue(tetris.getBoard().getXMinBlock() == getXMinBlock_atPre+1);
		assertTrue(tetris.getBoard().getYMinBlock() == getYMinBlock_atPre);
	}

	@Test
	public void testGoDown() {
		tetris = Factory.createTetris();
		tetris.init();
		tetris.next();
		
		int getScore_atPre = tetris.getScore();
		BlockService getcurrentBlock_atPre = tetris.getBoard().getcurrentBlock();
		GridService getgrid_atPre = tetris.getBoard().getgrid();
		boolean isBlock_atPre = tetris.getBoard().isBlock();
		int getXMinBlock_atPre = tetris.getBoard().getXMinBlock();
		int getYMinBlock_atPre = tetris.getBoard().getYMinBlock();
		int getBottomHeight_atPre = tetris.getBoard().getBottomHeight();
		
		try {
			tetris.goDown();
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		try {
			((TetrisContract) tetris).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		assertTrue(tetris.getScore() == getScore_atPre+20+50*(tetris.getBoard().getNbLastCleaned()));
		assertTrue(tetris.needNext());
		assertTrue(tetris.isRunning());
		
		assertTrue(tetris.getBoard().getcurrentBlock() == getcurrentBlock_atPre);
		assertTrue(tetris.getBoard().getgrid() == getgrid_atPre);
		assertTrue(tetris.getBoard().isBlock() == isBlock_atPre);
		assertTrue(tetris.getBoard().getXMinBlock() == getXMinBlock_atPre);
		assertTrue(tetris.getBoard().getYMinBlock() == getYMinBlock_atPre+getBottomHeight_atPre);
		assertTrue(tetris.getBoard().getBottomHeight() == 0);
	}

	@Test
	public void testRotateLeft() {
		tetris = Factory.createTetris();
		tetris.init();
		tetris.next();
		
		int getScore_atPre = tetris.getScore();
		BlockService getcurrentBlock_atPre = tetris.getBoard().getcurrentBlock();
		GridService getgrid_atPre = tetris.getBoard().getgrid();
		int getNbLastCleaned_atPre = tetris.getBoard().getNbLastCleaned();
		boolean isBlock_atPre = tetris.getBoard().isBlock();
		int getXMinBlock_atPre = tetris.getBoard().getXMinBlock();
		int getYMinBlock_atPre = tetris.getBoard().getYMinBlock();
		
		try {
			tetris.rotateLeft();
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		try {
			((TetrisContract) tetris).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		assertTrue(tetris.getScore() == getScore_atPre);
		assertTrue(tetris.needNext() == false);
		assertTrue(tetris.isRunning());
		
		assertTrue(tetris.getBoard().getcurrentBlock() == getcurrentBlock_atPre);
		assertTrue(tetris.getBoard().getgrid() == getgrid_atPre);
		assertTrue(tetris.getBoard().getNbLastCleaned() == getNbLastCleaned_atPre);
		assertTrue(tetris.getBoard().isBlock() == isBlock_atPre);
		assertTrue(tetris.getBoard().getXMinBlock() == getXMinBlock_atPre);
		assertTrue(tetris.getBoard().getYMinBlock() == getYMinBlock_atPre);
	}

	@Test
	public void testRotateRight() {
		tetris = Factory.createTetris();
		tetris.init();
		tetris.next();
		
		int getScore_atPre = tetris.getScore();
		BlockService getcurrentBlock_atPre = tetris.getBoard().getcurrentBlock();
		GridService getgrid_atPre = tetris.getBoard().getgrid();
		int getNbLastCleaned_atPre = tetris.getBoard().getNbLastCleaned();
		boolean isBlock_atPre = tetris.getBoard().isBlock();
		int getXMinBlock_atPre = tetris.getBoard().getXMinBlock();
		int getYMinBlock_atPre = tetris.getBoard().getYMinBlock();
		
		try {
			tetris.rotateRight();
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		try {
			((TetrisContract) tetris).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		assertTrue(tetris.getScore() == getScore_atPre);
		assertTrue(tetris.needNext() == false);
		
		assertTrue(tetris.getBoard().getcurrentBlock() == getcurrentBlock_atPre);
		assertTrue(tetris.getBoard().getgrid() == getgrid_atPre);
		assertTrue(tetris.getBoard().getNbLastCleaned() == getNbLastCleaned_atPre);
		assertTrue(tetris.getBoard().isBlock() == isBlock_atPre);
		assertTrue(tetris.getBoard().getXMinBlock() == getXMinBlock_atPre);
		assertTrue(tetris.getBoard().getYMinBlock() == getYMinBlock_atPre);
	}

	@Test
	public void testStep() {
		tetris = Factory.createTetris();
		tetris.init();
		tetris.next();
		
		int getScore_atPre = tetris.getScore();
		boolean needNext_atPre = tetris.needNext();
		
		GridService getgrid_atPre = tetris.getBoard().getgrid();
		boolean isBlock_atPre = tetris.getBoard().isBlock();
		int getXMinBlock_atPre = tetris.getBoard().getXMinBlock();
		int getYMinBlock_atPre = tetris.getBoard().getYMinBlock();
		int getBottomHeight_atPre = tetris.getBoard().getBottomHeight();
		
		try {
			tetris.step();
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		try {
			((TetrisContract) tetris).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		assertTrue(tetris.getScore() == getScore_atPre);
		assertTrue(tetris.needNext() == needNext_atPre);		
		
		assertTrue(tetris.getBoard().getgrid() == getgrid_atPre);
		assertTrue(tetris.getBoard().isBlock() == isBlock_atPre);
		assertTrue(tetris.getBoard().getXMinBlock() == getXMinBlock_atPre);
		assertTrue(tetris.getBoard().getYMinBlock() == getYMinBlock_atPre+1);
		assertTrue(tetris.getBoard().getBottomHeight() == getBottomHeight_atPre-1);
		
		
		
		tetris = Factory.createTetris();
		tetris.init();
		tetris.next();
		tetris.goDown();
		
		getScore_atPre = tetris.getScore();
		needNext_atPre = tetris.needNext();
		
		getgrid_atPre = tetris.getBoard().getgrid();
		isBlock_atPre = tetris.getBoard().isBlock();
		getXMinBlock_atPre = tetris.getBoard().getXMinBlock();
		getYMinBlock_atPre = tetris.getBoard().getYMinBlock();
		getBottomHeight_atPre = tetris.getBoard().getBottomHeight();
		
		try {
			tetris.step();
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		try {
			((TetrisContract) tetris).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		//Car GoDown donc calcul déjà fait
		assertTrue(tetris.getScore() == getScore_atPre);
		
		assertTrue(tetris.needNext() == false);	
	}

	@Test
	public void testNext() {
		tetris = Factory.createTetris();
		
		try {
			tetris.next();
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}
		tetris.init();
		
		int getScore_atPre = tetris.getScore();
		GridService getgrid_atPre = tetris.getBoard().getgrid();
		
		try {
			tetris.next();
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		try {
			((TetrisContract) tetris).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		assertTrue(tetris.getScore() == getScore_atPre);
		assertTrue(tetris.needNext() == false);
		
		assertTrue(tetris.getBoard().getgrid() == getgrid_atPre);
		assertTrue(tetris.getBoard().isBlock());
	}


















}
