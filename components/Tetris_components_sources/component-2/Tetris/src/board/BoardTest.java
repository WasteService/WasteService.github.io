package board;

import static org.junit.Assert.assertTrue;
import grid.GridService;

import org.junit.Test;

import programme.Factory;
import block.BlockService;

public class BoardTest{
	
	private static BoardService board;
	

	@Test
	public void testinit(){
		board = Factory.createBoard();
		try{
			board.init(-1,10);
			assertTrue(false);
		}catch(Error e){
			assertTrue(true);
		}
		try{
			board.init(10,-1);
			assertTrue(false);
		}catch(Error e){
			assertTrue(true);
		}
		try{
			board.init(10,9);
			assertTrue(false);
		}catch(Error e){
			assertTrue(true);
		}
		
		try{
			board.init(10,22);
			assertTrue(true);
		}catch(Error e){
			assertTrue(false);
		}
		
		try {
			((BoardContract) board).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		assertTrue(board.isBlock() == false);
		assertTrue(board.getgrid().getWidth() == 10 && board.getgrid().getHeight() == 22);
	}
	
	
	@Test
	public void testdoRotateLeft(){
		board = Factory.createBoard();
		board.init(10, 22);
		try{
			board.doRotateLeft();
			assertTrue(false);
		}catch(Error e){
			assertTrue(true);
		}		
		BlockService block = Factory.createBlock();
		block.init('L');
		board.insert(block);
		
		BlockService getcurrentBlock_atPre = board.getcurrentBlock();
		GridService getgrid_atPre = board.getgrid();
		int getNbLastCleaned_atPre = board.getNbLastCleaned();
		boolean isBlock_atPre = board.isBlock();
		int getXMinBlock_atPre = board.getXMinBlock();
		int getYMinBlock_atPre = board.getYMinBlock();
		
		try{
			board.doRotateLeft();
			board.doRotateLeft();
			board.doRotateLeft();
			assertTrue(true);
		}catch(Error e){
			assertTrue(false);
		}
		
		try {
			((BoardContract) board).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		assertTrue(board.getcurrentBlock() == getcurrentBlock_atPre);
		assertTrue(board.getgrid() == getgrid_atPre);
		assertTrue(board.getNbLastCleaned() == getNbLastCleaned_atPre);
		assertTrue(board.isBlock() == isBlock_atPre);
		assertTrue(board.getXMinBlock() == getXMinBlock_atPre);
		assertTrue(board.getYMinBlock() == getYMinBlock_atPre);
	}
	
	
	@Test
	public void testdoLeft(){
		board = Factory.createBoard();
		board.init(10, 22);
		try{
			board.doLeft();
			assertTrue(false);
		}catch(Error e){
			assertTrue(true);
		}		
		BlockService block = Factory.createBlock();
		block.init('L');
		board.insert(block);
		
		BlockService getcurrentBlock_atPre = board.getcurrentBlock();
		GridService getgrid_atPre = board.getgrid();
		int getNbLastCleaned_atPre = board.getNbLastCleaned();
		boolean isBlock_atPre = board.isBlock();
		int getXMinBlock_atPre = board.getXMinBlock();
		int getYMinBlock_atPre = board.getYMinBlock();
		
		try{
			board.doLeft();
			board.doLeft();
			board.doLeft();
			assertTrue(true);
		}catch(Error e){
			assertTrue(false);
		}
		
		try {
			((BoardContract) board).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		assertTrue(board.getcurrentBlock() == getcurrentBlock_atPre);
		assertTrue(board.getgrid() == getgrid_atPre);
		assertTrue(board.getNbLastCleaned() == getNbLastCleaned_atPre);
		assertTrue(board.isBlock() == isBlock_atPre);
		assertTrue(board.getXMinBlock() == getXMinBlock_atPre-3);
		assertTrue(board.getYMinBlock() == getYMinBlock_atPre);
	}
	
	
	@Test
	public void testdoRotateRight(){
		board = Factory.createBoard();
		board.init(10, 22);
		try{
			board.doRotateRight();
			assertTrue(false);
		}catch(Error e){
			assertTrue(true);
		}		
		BlockService block = Factory.createBlock();
		block.init('L');
		board.insert(block);
		
		BlockService getcurrentBlock_atPre = board.getcurrentBlock();
		GridService getgrid_atPre = board.getgrid();
		int getNbLastCleaned_atPre = board.getNbLastCleaned();
		boolean isBlock_atPre = board.isBlock();
		int getXMinBlock_atPre = board.getXMinBlock();
		int getYMinBlock_atPre = board.getYMinBlock();
		
		try{
			board.doRotateRight();
			board.doRotateRight();
			board.doRotateRight();
			assertTrue(true);
		}catch(Error e){
			assertTrue(false);
		}
		
		try {
			((BoardContract) board).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		assertTrue(board.getcurrentBlock() == getcurrentBlock_atPre);
		assertTrue(board.getgrid() == getgrid_atPre);
		assertTrue(board.getNbLastCleaned() == getNbLastCleaned_atPre);
		assertTrue(board.isBlock() == isBlock_atPre);
		assertTrue(board.getXMinBlock() == getXMinBlock_atPre);
		assertTrue(board.getYMinBlock() == getYMinBlock_atPre);
	}
	

	@Test
	public void testdoRight(){
		board = Factory.createBoard();
		board.init(10, 22);
		try{
			board.doRight();
			assertTrue(false);
		}catch(Error e){
			assertTrue(true);
		}		
		BlockService block = Factory.createBlock();
		block.init('L');
		board.insert(block);
		
		BlockService getcurrentBlock_atPre = board.getcurrentBlock();
		GridService getgrid_atPre = board.getgrid();
		int getNbLastCleaned_atPre = board.getNbLastCleaned();
		boolean isBlock_atPre = board.isBlock();
		int getXMinBlock_atPre = board.getXMinBlock();
		int getYMinBlock_atPre = board.getYMinBlock();
		
		try{
			board.doRight();
			board.doRight();
			board.doRight();
			assertTrue(true);
		}catch(Error e){
			assertTrue(false);
		}
		
		try {
			((BoardContract) board).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		assertTrue(board.getcurrentBlock() == getcurrentBlock_atPre);
		assertTrue(board.getgrid() == getgrid_atPre);
		assertTrue(board.getNbLastCleaned() == getNbLastCleaned_atPre);
		assertTrue(board.isBlock() == isBlock_atPre);
		assertTrue(board.getXMinBlock() == getXMinBlock_atPre+3);
		assertTrue(board.getYMinBlock() == getYMinBlock_atPre);
	}

		
	@Test
	public void testdoBottom(){
		board = Factory.createBoard();
		board.init(10, 22);
		try{
			board.doBottom();
			assertTrue(false);
		}catch(Error e){
			assertTrue(true);
		}		
		BlockService block = Factory.createBlock();
		block.init('L');
		board.insert(block);
		
		BlockService getcurrentBlock_atPre = board.getcurrentBlock();
		GridService getgrid_atPre = board.getgrid();
		boolean isBlock_atPre = board.isBlock();
		int getXMinBlock_atPre = board.getXMinBlock();
		int getYMinBlock_atPre = board.getYMinBlock();
		int getBottomHeight_atPre = board.getBottomHeight();
		
		try{
			board.doBottom();
			assertTrue(true);
		}catch(Error e){
			assertTrue(false);
		}
		
		try {
			((BoardContract) board).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		assertTrue(board.getcurrentBlock() == getcurrentBlock_atPre);
		assertTrue(board.getgrid() == getgrid_atPre);
		assertTrue(board.isBlock() == isBlock_atPre);
		assertTrue(board.getXMinBlock() == getXMinBlock_atPre);
		assertTrue(board.getYMinBlock() == getYMinBlock_atPre+getBottomHeight_atPre);
	}
	

	@Test
	public void testStep(){
		board = Factory.createBoard();
		board.init(10, 22);
		try{
			board.step();
			assertTrue(false);
		}catch(Error e){
			assertTrue(true);
		}		
		BlockService block = Factory.createBlock();
		block.init('L');
		board.insert(block);
		
		GridService getgrid_atPre = board.getgrid();
		boolean isBlock_atPre = board.isBlock();
		int getXMinBlock_atPre = board.getXMinBlock();
		int getYMinBlock_atPre = board.getYMinBlock();
		int getBottomHeight_atPre = board.getBottomHeight();
		
		try{
			board.step();
			assertTrue(true);
		}catch(Error e){
			assertTrue(false);
		}
		
		try {
			((BoardContract) board).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		assertTrue(board.getgrid() == getgrid_atPre);
		assertTrue(board.isBlock() == isBlock_atPre);
		assertTrue(board.getXMinBlock() == getXMinBlock_atPre);
		assertTrue(board.getYMinBlock() == getYMinBlock_atPre+1);
		assertTrue(board.getBottomHeight() == getBottomHeight_atPre-1);
	}
		
	
	@Test
	public void testinsert(){
		board = Factory.createBoard();
		board.init(10, 22);
		BlockService block = Factory.createBlock();
		block.init('L');
		board.insert(block);
		BlockService block2 = Factory.createBlock();
		block2.init('J');
		try{
			board.insert(block2);
			assertTrue(false);
		}catch(Error e){
			assertTrue(true);
		}		
		
		board.remove();
		
		GridService getgrid_atPre = board.getgrid();
		
		try{
			board.insert(block2);
			assertTrue(true);
		}catch(Error e){
			assertTrue(false);
		}
		
		try {
			((BoardContract) board).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		assertTrue(board.getcurrentBlock() == block2);
		assertTrue(board.getgrid() == getgrid_atPre);
		assertTrue(board.isBlock());
	}
	
	
	@Test
	public void testremove(){
		board = Factory.createBoard();
		board.init(10, 22);
		try{
			board.remove();
			assertTrue(false);
		}catch(Error e){
			assertTrue(true);
		}		
		BlockService block = Factory.createBlock();
		block.init('L');
		board.insert(block);
		
		GridService getgrid_atPre = board.getgrid();
		int getNbLastCleaned_atPre = board.getNbLastCleaned();
		
		try{
			board.remove();
		}catch(Error e){
			assertTrue(false);
		}
		
		try {
			((BoardContract) board).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		assertTrue(board.getcurrentBlock() == null);
		assertTrue(board.getgrid() == getgrid_atPre);
		assertTrue(board.getNbLastCleaned() == getNbLastCleaned_atPre);
		assertTrue(board.isBlock() == false);
		assertTrue(board.getXMinBlock() == 0);
		assertTrue(board.getYMinBlock() == 0);
	}
	

	@Test
	public void testclean(){
		board = Factory.createBoard();
		board.init(10, 22);
		BlockService block = Factory.createBlock();
		block.init('O');
		board.insert(block);
		try{
			board.clean();
			assertTrue(false);
		}catch(Error e){
			assertTrue(true);
		}		
		
		board.doBottom();
		
		BlockService getcurrentBlock_atPre = board.getcurrentBlock();
		GridService getgrid_atPre = board.getgrid();
		
		try{
			board.clean();
		}catch(Error e){
			assertTrue(false);
		}
		
		try {
			((BoardContract) board).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		assertTrue(board.getcurrentBlock() == getcurrentBlock_atPre);
		assertTrue(board.getgrid() == getgrid_atPre);
		
		
		board = Factory.createBoard();
		board.init(10, 22);
		board.insert(block);
		try{
			board.clean();
			assertTrue(false);
		}catch(Error e){
			assertTrue(true);
		}		
		
		board.step();
		board.step();
		board.step();
		board.step();
		board.step();
		board.step();
		board.step();
		board.step();
		board.step();
		board.step();
		board.step();
		board.step();
		board.step();
		board.step();
		board.step();
		board.step();
		board.step();
		board.step();
		board.step();
		
		try{
			board.clean();
			assertTrue(false);
		}catch(Error e){
			assertTrue(true);
		}
		
		board.step();
		
		getcurrentBlock_atPre = board.getcurrentBlock();
		getgrid_atPre = board.getgrid();
		
		try{
			board.clean();
		}catch(Error e){
			assertTrue(false);
		}
		
		try {
			((BoardContract) board).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		assertTrue(board.getcurrentBlock() == getcurrentBlock_atPre);
		assertTrue(board.getgrid() == getgrid_atPre);
	}
}
