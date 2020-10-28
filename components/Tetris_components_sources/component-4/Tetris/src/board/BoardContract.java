package board;

import block.BlockService;

public class BoardContract extends BoardDecorator {

	public BoardContract(BoardService f) {
		super(f);
	}

	public void checkInvariants(){
		BlockService block = super.getcurrentBlock();
		if (super.isBlock())
		{
			if (!(1<= super.getXblock(block.getXMin())  && super.getXblock(block.getXMax()) <= super.getgrid().getWidth()+1)) {
				throw new Error("[BOARD]invariant(1) invalide");
			}
			
			if (!(1<= super.getYblock(block.getYMin())  && super.getYblock(block.getYMax()) <= super.getgrid().getHeight()+4))
				throw new Error("[BOARD]invariant(2) invalide");
			
			if (!(super.getXMinBlock() >= 0 && super.getXMinBlock() <= super.getgrid().getWidth()))
				throw new Error("[BOARD]invariant(4) invalide");
			
			if (!(super.getYMinBlock() >=0 && super.getYMinBlock() <= super.getgrid().getHeight()+1)) //Le bloc disparait de la grille
				throw new Error("[BOARD]invariant(5) invalide");
		}
				
		if (!(super.getNbLastCleaned() >= 0)) {
				throw new Error("[BOARD]invariant(3) invalide");
		}
		
	}
	
	public boolean canRotateLeft(){
		checkInvariants();
		
		if (!isBlock())
			throw new Error("[BOARD]pre(1)(canRotateLeft) invalide");
		
		boolean result = super.canRotateLeft();
		 
		checkInvariants();
		return result;
	}
	
	public boolean canRotateRight(){
		checkInvariants();
		
		if (!isBlock())
			throw new Error("[BOARD]pre(1)(canRotateRight) invalide");
		
		boolean result = super.canRotateRight();
		 
		checkInvariants();
		return result;
	}
	
	public boolean cangoLeft(){
		checkInvariants();
		
		if (!isBlock())
			throw new Error("[BOARD]pre(1)(cangoLeft) invalide");
		
		boolean result = super.cangoLeft();
		 
		checkInvariants();
		return result;
	}
	
	public boolean cangoRight(){
		checkInvariants();
		
		if (!isBlock())
			throw new Error("[BOARD]pre(1)(cangoRight) invalide");
		
		boolean result = super.cangoRight();
		 
		checkInvariants();
		return result;
	}
	
	public boolean isBottom(){
		checkInvariants();
		
		if (!isBlock())
			throw new Error("[BOARD]pre(1)(isBottom) invalide");
		
		boolean result = super.isBottom();
		checkInvariants();
		
		return result;
	}
	
	public boolean isConflict(){
		checkInvariants();
		
		if (!isBlock())
			throw new Error("[BOARD]pre(1)(isConflict) invalide");
		
		boolean result = super.isConflict();
		checkInvariants();
		
		return result;
	}
	
	public int getXblock(int x){
		checkInvariants();
		
		if (!isBlock())
			throw new Error("[BOARD]pre(1)(getXblock) invalide");
		
		int result = super.getXblock(x);
		checkInvariants();
		
		return result;
	}
	
	public int getYblock(int y){
		checkInvariants();
		
		if (!isBlock())
			throw new Error("[BOARD]pre(1)(getYblock) invalide");
		
		int result = super.getYblock(y);
		checkInvariants();
		
		return result;
	}
	
	public int getBottomHeight(){
		checkInvariants();
		
		if (!isBlock())
			throw new Error("[BOARD]pre(1)(getBottomHeight) invalide");
		
		int result = super.getBottomHeight();
		
		checkInvariants();
		
		return result;
	}
	
	public void init(int x, int y){
		if (!(x > 0 && y > 0 && y >= x)) {
			throw new Error("[BOARD]pre(1)(init) invalide");
		}
		super.init(x, y);
		checkInvariants();
		
		//POST Grid:init
		if (!(getgrid().getWidth() == x && getgrid().getHeight() == y))
			throw new Error("[BOARD]post(1.1)(init) invalide");
		
		for (int xtemp=1;xtemp <= getgrid().getWidth();xtemp++){
			for (int ytemp=1;ytemp <= getgrid().getHeight();ytemp++){
				if (!(!getgrid().isOccupied(xtemp,ytemp) && getgrid().canPut(xtemp, ytemp)))
					throw new Error("[BOARD]post(1.2)(init) invalide");
			}
		}
		
		if (!(isBlock() == false)) {
			throw new Error("[BOARD]post(2)(init) invalide");
		}
		if (!(getgrid().getWidth() == x && getgrid().getHeight() == y)) {
			throw new Error("[BOARD]post(3)(init) invalide");
		}
		if (!(getNbLastCleaned() == 0)) {
			throw new Error("[BOARD]post(4)(init) invalide");
		}
		if (!(getXMinBlock() == 0 && getYMinBlock() == 0)) {
			throw new Error("[BOARD]post(5)(init) invalide");
		}
	}
	
	
	public void doRotateLeft(){
		if (!(isBlock() && canRotateLeft())) {
			throw new Error("[BOARD]pre(1)(doRotateLeft) invalide");
		}
		checkInvariants();
		
		//captures
		int getNbLastCleaned_atPre = getNbLastCleaned();
		boolean isBlock_atPre = isBlock();
		int getXMinBlock_atPre = getXMinBlock();
		int getYMinBlock_atPre = getYMinBlock();
		char getType_atPre = getcurrentBlock().getType();
		int getSize_atPre = getcurrentBlock().getSize();
		int getNbPos_atPre = getcurrentBlock().getNbPos();
		
		super.doRotateLeft();
		checkInvariants();
		
		if(!(super.getNbLastCleaned() == getNbLastCleaned_atPre)) {
			throw new Error("[BOARD]post(1)(doRotateLeft) invalide");
		}
		if(!(super.isBlock() == isBlock_atPre)) {
			throw new Error("[BOARD]post(2)(doRotateLeft) invalide");
		}
		if (!(super.getXMinBlock() == getXMinBlock_atPre)) {
			throw new Error("[BOARD]post(3)(doRotateLeft) invalide");
		}
		if (!(super.getYMinBlock() == getYMinBlock_atPre)) {
			throw new Error("[BOARD]post(4)(doRotateLeft) invalide");
		}
		
		//block:rotateLeft
		BlockService block = getcurrentBlock();
		if(!(block.getType() == getType_atPre)) {
			throw new Error("[BOARD]post(5.1)(doRotateLeft) invalide");
		}
		if(!(block.getSize() == getSize_atPre)) {
			throw new Error("[BOARD]post(5.2)(doRotateLeft) invalide");
		}
		if(!(block.getNbPos() == getNbPos_atPre)) {
			throw new Error("[BOARD]post(5.3)(doRotateLeft) invalide");
		}
	}

		
	public void doLeft(){
		if(!(isBlock() && cangoLeft())) {
			throw new Error("[BOARD]pre(1)(doLeft) invalide");
		}
		checkInvariants();
		
		//captures
		int getNbLastCleaned_atPre = getNbLastCleaned();
		boolean isBlock_atPre = isBlock();
		int getXMinBlock_atPre = getXMinBlock();
		int getYMinBlock_atPre = getYMinBlock();
		char getType_atPre = getcurrentBlock().getType();
		int getSize_atPre = getcurrentBlock().getSize();
		int getNbPos_atPre = getcurrentBlock().getNbPos();
		
		super.doLeft();
		checkInvariants();
		
		if(!(getSize_atPre == getcurrentBlock().getSize()))
			throw new Error("[BOARD]post(1)(doLeft) invalide");
		if(!(getType_atPre == getcurrentBlock().getType()))
			throw new Error("[BOARD]post(2)(doLeft) invalide");
		if(!(getNbPos_atPre == getcurrentBlock().getNbPos()))
			throw new Error("[BOARD]post(3)(doLeft) invalide");
		if(!(getNbLastCleaned() == getNbLastCleaned_atPre)) {
			throw new Error("[BOARD]post(4)(doLeft) invalide");
		}
		if(!(isBlock() == isBlock_atPre)) {
			throw new Error("[BOARD]post(5)(doLeft) invalide");
		}
		if (!(getXMinBlock() == getXMinBlock_atPre-1)) {
			throw new Error("[BOARD]post(6)(doLeft) invalide");
		}
		if (!(getYMinBlock() == getYMinBlock_atPre)) {
			throw new Error("[BOARD]post(7)(doLeft) invalide");
		}

	}
	
	
	public void doRotateRight(){
		if (!(isBlock() && canRotateRight())) {
			throw new Error("[BOARD]pre(1)(doRotateRight) invalide");
		}
		checkInvariants();
		
		//captures
		int getNbLastCleaned_atPre = getNbLastCleaned();
		boolean isBlock_atPre = isBlock();
		int getXMinBlock_atPre = getXMinBlock();
		int getYMinBlock_atPre = getYMinBlock();
		char getType_atPre = getcurrentBlock().getType();
		int getSize_atPre = getcurrentBlock().getSize();
		int getNbPos_atPre = getcurrentBlock().getNbPos();
		
		super.doRotateRight();
		checkInvariants();
		
		if(!(getNbLastCleaned() == getNbLastCleaned_atPre)) {
			throw new Error("[BOARD]post(1)(doRotateRight) invalide");
		}
		if(!(isBlock() == isBlock_atPre)) {
			throw new Error("[BOARD]post(2)(doRotateRight) invalide");
		}
		if (!(getXMinBlock() == getXMinBlock_atPre)) {
			throw new Error("[BOARD]post(3)(doRotateRight) invalide");
		}
		if (!(getYMinBlock() == getYMinBlock_atPre)) {
			throw new Error("[BOARD]post(4)(doRotateRight) invalide");
		}
		
		//block:rotateRight
		BlockService block = getcurrentBlock();
		if(!(block.getType() == getType_atPre)) {
			throw new Error("[BOARD]post(5.1)(doRotateRight) invalide");
		}
		if(!(block.getSize() == getSize_atPre)) {
			throw new Error("[BOARD]post(5.2)(doRotateRight) invalide");
		}
		if(!(block.getNbPos() == getNbPos_atPre)) {
			throw new Error("[BOARD]post(5.3)(doRotateRight) invalide");
		}
	}
	
	public void doRight(){
		if(!(isBlock() && cangoRight())) {
			throw new Error("[BOARD]pre(1)(doRight) invalide");
		}
		checkInvariants();
		
		//captures
		int getNbLastCleaned_atPre = getNbLastCleaned();
		boolean isBlock_atPre = isBlock();
		int getXMinBlock_atPre = getXMinBlock();
		int getYMinBlock_atPre = getYMinBlock();
		int getSize_atPre = getcurrentBlock().getSize();
		int getType_atPre = getcurrentBlock().getType();
		int getNbPos_atPre = getcurrentBlock().getNbPos();
		
		super.doRight();
		checkInvariants();
		
		if(!(getSize_atPre == getcurrentBlock().getSize()))
			throw new Error("[BOARD]post(1)(doRight) invalide");
		if(!(getType_atPre == getcurrentBlock().getType()))
			throw new Error("[BOARD]post(2)(doRight) invalide");
		if(!(getNbPos_atPre == getcurrentBlock().getNbPos()))
			throw new Error("[BOARD]post(3)(doRight) invalide");
		if(!(super.getNbLastCleaned() == getNbLastCleaned_atPre)) {
			throw new Error("[BOARD]post(4)(doRight) invalide");
		}
		if(!(super.isBlock() == isBlock_atPre)) {
			throw new Error("[BOARD]post(5)(doRight) invalide");
		}
		if (!( super.getXMinBlock() == getXMinBlock_atPre+1)) {
			throw new Error("[BOARD]post(6)(doRight) invalide");
		}
		if (!(super.getYMinBlock() == getYMinBlock_atPre)) {
			throw new Error("[BOARD]post(7)(doRight) invalide");
		}
	}
	
	
	public void doBottom(){
		if(!(isBlock())) {
			throw new Error("[BOARD]pre(1)(doBottom) invalide");
		}
		checkInvariants();
		
		//captures
		boolean isBlock_atPre = super.isBlock();
		int getXMinBlock_atPre = super.getXMinBlock();
		int getYMinBlock_atPre = super.getYMinBlock();
		int getBottomHeight_atPre = super.getBottomHeight();
		int getSize_atPre = getcurrentBlock().getSize();
		int getType_atPre = getcurrentBlock().getType();
		int getNbPos_atPre = getcurrentBlock().getNbPos();
		
		super.doBottom();
		checkInvariants();
		
		if(!(getSize_atPre == getcurrentBlock().getSize()))
			throw new Error("[BOARD]post(1)(doBottom) invalide");
		if(!(getType_atPre == getcurrentBlock().getType()))
			throw new Error("[BOARD]post(2)(doBottom) invalide");
		if(!(getNbPos_atPre == getcurrentBlock().getNbPos()))
			throw new Error("[BOARD]post(3)(doBottom) invalide");
		if(!(isBlock() == isBlock_atPre)) {
			throw new Error("[BOARD]post(4)(doBottom) invalide");
		}
		if (!(getXMinBlock() == getXMinBlock_atPre)) {
			throw new Error("[BOARD]post(5)(doBottom) invalide");
		}
		if (!(getYMinBlock() == getYMinBlock_atPre+getBottomHeight_atPre+getNbLastCleaned())) {
			throw new Error("[BOARD]post(6)(doBottom) invalide");
		}
		if(!(getBottomHeight()-getNbLastCleaned() == 0 || isBottom())) {
			throw new Error("[BOARD]post(7)(doBottom) invalide");
		}
	}
	
	
	public void step(){
		if(!(isBlock())) {
			throw new Error("[BOARD]pre(1)(step) invalide");
		}
		checkInvariants();
		
		//captures
		boolean isBlock_atPre = isBlock();
		int getXMinBlock_atPre = getXMinBlock();
		int getYMinBlock_atPre = getYMinBlock();
		int getBottomHeight_atPre = getBottomHeight();
		boolean isBottom_atPre = isBottom();
		
		super.step();
		checkInvariants();
		
		
		if (!isBottom_atPre){
			if(!(isBlock() == isBlock_atPre)) {
				throw new Error("[BOARD]post(1)(step) invalide");
			}
			if(!(getXMinBlock() == getXMinBlock_atPre)) {
				throw new Error("[BOARD]post(2)(step) invalide");
			}
			if (!(getYMinBlock() == getYMinBlock_atPre+1)) {
				throw new Error("[BOARD]post(3)(step) invalide");
			}
			if (!(getBottomHeight() == getBottomHeight_atPre-1)) {
				throw new Error("[BOARD]post(4)(step) invalide");
			}
		}
	}
	
	
	public void insert(BlockService block){
		if(!(super.isBlock() == false)) {
			throw new Error("[BOARD]pre(1)(insert) invalide");
		}
		checkInvariants();
		
		//captures
		int getSize_atPre = block.getSize();
		int getType_atPre = block.getType();
		int getNbPos_atPre = block.getNbPos();
		
		super.insert(block);
		checkInvariants();
		
		if(!(super.getcurrentBlock() == block)) {
			throw new Error("[BOARD]post(1)(insert) invalide");
		}
		if(!(isBlock())) {
			throw new Error("[BOARD]post(2)(insert) invalide");
		}
		if(!(getSize_atPre == getcurrentBlock().getSize()))
			throw new Error("[BOARD]post(3)(insert) invalide");
		if(!(getType_atPre == getcurrentBlock().getType()))
			throw new Error("[BOARD]post(4)(insert) invalide");
		if(!(getNbPos_atPre == getcurrentBlock().getNbPos()))
			throw new Error("[BOARD]post(5)(insert) invalide");
	}
	
	public void remove(){
		if(!(isBlock())) {
			throw new Error("[BOARD]pre(1)(remove) invalide");
		}
		checkInvariants();
		
		//captures
		boolean getgrid_atPre[][] = new boolean[getgrid().getWidth()][getgrid().getHeight()];
		for(int x=0;x<getgrid().getWidth();x++)
			for(int y=0;y<getgrid().getHeight();y++)
				getgrid_atPre[x][y] = getgrid().isOccupied(x+1, y+1);
		int getNbLastCleaned_atPre = getNbLastCleaned();
		
		super.remove();
		checkInvariants();
		
		if(!(super.getcurrentBlock() == null)) {
			throw new Error("[BOARD]post(1)(remove) invalide");
		}
		for(int x=0;x<getgrid().getWidth();x++)
			for(int y=0;y<getgrid().getHeight();y++)
				if (!(getgrid_atPre[x][y] == getgrid().isOccupied(x+1, y+1)))
					throw new Error("[BOARD]post(2)(remove) invalide");
		if(!(getNbLastCleaned() == getNbLastCleaned_atPre)) {
			throw new Error("[BOARD]post(3)(remove) invalide");
		}
		if(!(isBlock() == false)) {
			throw new Error("[BOARD]post(4)(remove) invalide");
		}
		if (!(getXMinBlock() == 0)) {
			throw new Error("[BOARD]post(5)(remove) invalide");
		}
		if (!(getYMinBlock() == 0)) {
			throw new Error("[BOARD]post(6)(remove) invalide");
		}
	}
	public void clean() {
		if(!(isBottom())) {
			throw new Error("[BOARD]pre(1)(clean) invalide");
		}
		if(!(isBlock()))
			throw new Error("[BOARD]pre(2)(clean) invalide");
		checkInvariants();
		
		//captures
		boolean isBlock_atPre = isBlock();
		boolean isBottom_atPre = isBottom();
		int getSize_atPre = getcurrentBlock().getSize();
		int getType_atPre = getcurrentBlock().getType();
		int getNbPos_atPre = getcurrentBlock().getNbPos();
		
		super.clean();
		checkInvariants();
		
		if(!(isBlock() == isBlock_atPre)) {
			throw new Error("[BOARD]post(1)(clean) invalide");
		}
		if(!(isBottom() == isBottom_atPre)) {
			throw new Error("[BOARD]post(2)(clean) invalide");
		}
		if(!(getSize_atPre == getcurrentBlock().getSize()))
			throw new Error("[BOARD]post(3)(clean) invalide");
		if(!(getType_atPre == getcurrentBlock().getType()))
			throw new Error("[BOARD]post(4)(clean) invalide");
		if(!(getNbPos_atPre == getcurrentBlock().getNbPos()))
			throw new Error("[BOARD]post(5)(clean) invalide");
	}
	
}
