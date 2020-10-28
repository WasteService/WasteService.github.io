package board;

import block.BlockService;
import grid.GridService;

public interface BoardService {
	
	/** Observators*/
	public BlockService getcurrentBlock();
	public boolean isCleaned();
	public GridService getgrid();
	public int getNbLastCleaned();
	public boolean canRotateLeft();
		//pre: isBlock()
	public boolean canRotateRight();
		//pre: isBlock()
	public boolean cangoLeft();
		//pre: isBlock()
	public boolean cangoRight();
		//pre: isBlock()
	public boolean isBlock();
		
	public boolean isBottom();
		//pre: isBlock()
	public boolean isConflict();
		//pre: isBlock()
	public int getXblock(int x);
		//pre: x >= getcurrentBlock.getXMin() && x<= getcurrentBlock.getXMax()
	public int getYblock(int y);
		//pre: y >= getcurrentBlock.getYMin() && x<= getcurrentBlock.getYMax()
	public int getXMinBlock();
	public int getYMinBlock();
	public int getBottomHeight();
		//pre: isBlock()

	/** Invariants
	 * isBlock() <=> 1 <= getXblock(getcurrentBlock.getXMin()) && getXblock(getcurrentBlock.getXMax()) <= 
			super.getgrid().getWidth()+1
	 * isBlock() <=> 1 <= getYblock(getcurrentBlock.getYMin()) && getYblock(getcurrentBlock.getYMax()) <= 
			super.getgrid().getHeight()+4
	 * getNbLastCleaned() >= 0
	 * isBlock() <=> getXMinBlock() >= 0 && getXMinBlock() <= getgrid().getWidth()
	 * isBlock() <=> getYMinBlock() >=0 && getYMinBlock() <= getgrid().getHeight()+1
	 */
	
	/** Constructors
	 * Initialise
	 * pre: x > 0 && y > 0 && y >= x
	 * post: getgrid() = Grid:init(x, y);
	 * post: isBlock() == false
	 * post: getgrid().getWidth() == x && getgrid().getHeight() == y
	 * post: getNbLastCleaned() == 0
	 * post: getXMinBlock() == 0 && getYMinBlock() == 0
	 */
	public void init(int x, int y);
	
	
	/** Operators */
	
	/**
	 * pre: isBlock() && canRotateLeft()
	 * post: getNbLastCleaned() == getNbLastCleaned()@pre
	 * post: isBlock() == isBlock()@pre
	 * post: getXMinBlock() == getXMinBlock()@pre
	 * post: getYMinBlock() == getYMinBlock()@pre
	 * post: getcurrentBlock() == getcurrentBlock()@pre.rotateLeft()
	 */
	public void doRotateLeft();
	
	/**
	 * pre: isBlock() && cangoLeft()
	 * post: getcurrentBlock().getSize() == getcurrentBlock().getSize()@pre
	 * post: getcurrentBlock().getType() == getcurrentBlock().getType()@pre
	 * post: getcurrentBlock().getNbPos() == getcurrentBlock().getNbPos()@pre
	 * post: getNbLastCleaned() == getNbLastCleaned()@pre
	 * post: isBlock() == isBlock()@pre
	 * post: getXMinBlock() == getXMinBlock()@pre -1
	 * post: getYMinBlock() == getYMinBlock()@pre 
	 */	
	public void doLeft();
	
	/**
	 * pre: isBlock() && canRotateRight()
	 * post: getNbLastCleaned() == getNbLastCleaned()@pre
	 * post: isBlock() == isBlock()@pre
	 * post: getXMinBlock() == getXMinBlock()@pre
	 * post: getYMinBlock() == getYMinBlock()@pre
	 * post: getcurrentBlock() == getcurrentBlock()@pre.rotateRight()
	 */	
	public void doRotateRight();
	
	/**
	 * pre: isBlock() && cangoRight()
	 * post: getcurrentBlock().getSize() == getcurrentBlock().getSize()@pre
	 * post: getcurrentBlock().getType() == getcurrentBlock().getType()@pre
	 * post: getcurrentBlock().getNbPos() == getcurrentBlock().getNbPos()@pre
	 * post: getNbLastCleaned() == getNbLastCleaned()@pre
	 * post: isBlock() == isBlock()@pre
	 * post: getXMinBlock() == getXMinBlock()@pre +1
	 * post: getYMinBlock() == getYMinBlock()@pre
	 */
	public void doRight();
	
	/**
	 * pre: isBlock()
	 * post: getcurrentBlock().getSize() == getcurrentBlock().getSize()@pre
	 * post: getcurrentBlock().getType() == getcurrentBlock().getType()@pre
	 * post: getcurrentBlock().getNbPos() == getcurrentBlock().getNbPos()@pre
	 * post: isBlock() == isBlock()@pre
	 * post: getXMinBlock() == getXMinBlock()@pre
	 * post: getYMinBlock() == getYMinBlock()@pre + getBottomHeight()@pre + getNbLastCleaned()
	 * post: getBottomHeight()-getNbLastCleaned() == 0 || isBottom()
	 */
	public void doBottom();

	/**
	 * pre: isBlock()
	 * post: !isBottom()@pre <=> isBlock() == isBlock()@pre
	 * post: !isBottom()@pre <=> getXMinBlock() == getXMinBlock()@pre 
	 * post: !isBottom()@pre <=> getYMinBlock() getYMinBlock()@pre + 1
	 * post: !isBottom()@pre <=> getBottomHeight() == getBottomHeight()@pre-1
	 */
	public void step();
	
	/**
	 * pre: isBlock() == false
	 * post: getcurrentBlock() == block
	 * post: isBlock()
	 * post: getcurrentBlock().getSize() == getcurrentBlock().getSize()@pre
	 * post: getcurrentBlock().getType() == getcurrentBlock().getType()@pre
	 * post: getcurrentBlock().getNbPos() == getcurrentBlock().getNbPos()@pre
	 */
	public void insert(BlockService block);

	/**
	 * pre: isBlock()
	 * post: getcurrentBlock() == null
	 * post: \forall x in (1<=x && x<= getgrid().getWidth())
	 * 			\forall y in (1<=y && y<= getgrid().getWidth())
	 * 				getgrid().isOccupied(x,y)@pre == getgrid().isOccupied(x,y)
	 * post: getNbLastCleaned() == getNbLastCleaned()@pre
	 * post: isBlock()== false
	 * post: getXMinBlock() == 0 
	 * post: getYMinBlock() == 0
	 */
	public void remove();

	/**
	 * pre: isBottom()
	 * pre: isBlock()
	 * post: isBlock() = isBlock()@pre
	 * post: isBottom() = isBottom()@pre
	 * post: getcurrentBlock().getSize() == getcurrentBlock().getSize()@pre
	 * post: getcurrentBlock().getType() == getcurrentBlock().getType()@pre
	 * post: getcurrentBlock().getNbPos() == getcurrentBlock().getNbPos()@pre
	 */
	public void clean();

}
