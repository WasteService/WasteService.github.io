package board;

import grid.GridService;

import java.util.LinkedList;

import programme.Factory;

import block.BlockService;

public class BoardImpl implements BoardService {

	private BlockService block;
	private GridService grid;
	private int NbLastCleaned;
	private boolean Conflict;
	private int XMinBlock;
	private int YMinBlock;
	private boolean isCleaned;
	
	@Override
	public BlockService getcurrentBlock() {
		return this.block;
	}
	
	
	public boolean isCleaned(){
		return isCleaned;
	}
	
	
	@Override
	public GridService getgrid() {
		return this.grid;
	}
	
	
	@Override
	public int getNbLastCleaned() {
		return this.NbLastCleaned;
	}
	
		
	@Override
	public boolean canRotateLeft() {
		int[][] newPos = new int[4][2];
		
		switch(block.getType()) {
			case 'O' : return true; 
			case 'L' : 
				if((block.getYMin() == 1) && (block.getYMax() == 3)) {
					if(block.hasPos(3, 3)) {
						newPos[0][0] = 1;
						newPos[0][1] = 2;
						newPos[1][0] = 2;
						newPos[1][1] = 2;
						newPos[2][0] = 3;
						newPos[2][1] = 1;
						newPos[3][0] = 3;
						newPos[3][1] = 2;
					} else { 
						newPos[0][0] = 1;
						newPos[0][1] = 2;
						newPos[1][0] = 1;
						newPos[1][1] = 3;
						newPos[2][0] = 2;
						newPos[2][1] = 2;
						newPos[3][0] = 3;
						newPos[3][1] = 2;
					}
				} else {
					if(block.hasPos(3, 1)) {
						newPos[0][0] = 1;
						newPos[0][1] = 1;
						newPos[1][0] = 2;
						newPos[1][1] = 1;
						newPos[2][0] = 2;
						newPos[2][1] = 2;
						newPos[3][0] = 2;
						newPos[3][1] = 3;
					} else { 
						newPos[0][0] = 2;
						newPos[0][1] = 1;
						newPos[1][0] = 2;
						newPos[1][1] = 2;
						newPos[2][0] = 2;
						newPos[2][1] = 3;
						newPos[3][0] = 3;
						newPos[3][1] = 3;
					}
				}
				break;
			case 'J' : 
				if((block.getYMin() == 1) && (block.getYMax() == 3)) {
					if(block.hasPos(1, 3)) {
						newPos[0][0] = 1;
						newPos[0][1] = 2;
						newPos[1][0] = 2;
						newPos[1][1] = 2;
						newPos[2][0] = 3;
						newPos[2][1] = 2;
						newPos[3][0] = 3;
						newPos[3][1] = 3;
					} else { 
						newPos[0][0] = 1;
						newPos[0][1] = 1;
						newPos[1][0] = 1;
						newPos[1][1] = 2;
						newPos[2][0] = 2;
						newPos[2][1] = 2;
						newPos[3][0] = 3;
						newPos[3][1] = 2;
					}
				} else {
					if(block.hasPos(1, 1)) {
						newPos[0][0] = 1;
						newPos[0][1] = 3;
						newPos[1][0] = 2;
						newPos[1][1] = 1;
						newPos[2][0] = 2;
						newPos[2][1] = 2;
						newPos[3][0] = 2;
						newPos[3][1] = 3;
					} else {
						newPos[0][0] = 2;
						newPos[0][1] = 1;
						newPos[1][0] = 2;
						newPos[1][1] = 2;
						newPos[2][0] = 2;
						newPos[2][1] = 3;
						newPos[3][0] = 3;
						newPos[3][1] = 1;
					}
				}
				break;
			case 'T' :
				if((block.getXMin() == 1) && (block.getXMax() == 3)) {
					if(block.hasPos(2, 3)) {
						newPos[0][0] = 2;
						newPos[0][1] = 1;
						newPos[1][0] = 2;
						newPos[1][1] = 2;
						newPos[2][0] = 2;
						newPos[2][1] = 3;
						newPos[3][0] = 3;
						newPos[3][1] = 2;
					} else { 
						newPos[0][0] = 1;
						newPos[0][1] = 2;
						newPos[1][0] = 2;
						newPos[1][1] = 1;
						newPos[2][0] = 2;
						newPos[2][1] = 2;
						newPos[3][0] = 2;
						newPos[3][1] = 3;						
					}
				} else {
					if(block.hasPos(1, 2)) {
						newPos[0][0] = 1;
						newPos[0][1] = 2;
						newPos[1][0] = 2;
						newPos[1][1] = 2;
						newPos[2][0] = 2;
						newPos[2][1] = 3;
						newPos[3][0] = 3;
						newPos[3][1] = 2;
					} else { 
						newPos[0][0] = 1;
						newPos[0][1] = 2;
						newPos[1][0] = 2;
						newPos[1][1] = 1;
						newPos[2][0] = 2;
						newPos[2][1] = 2;
						newPos[3][0] = 3;
						newPos[3][1] = 2;
					}
				}
				break;
			case 'Z' :
				if(block.getXMax() == 3) {
					newPos[0][0] = 1;
					newPos[0][1] = 2;
					newPos[1][0] = 1;
					newPos[1][1] = 3;
					newPos[2][0] = 2;
					newPos[2][1] = 1;
					newPos[3][0] = 2;
					newPos[3][1] = 2;
				} else {
					newPos[0][0] = 1;
					newPos[0][1] = 2;
					newPos[1][0] = 2;
					newPos[1][1] = 2;
					newPos[2][0] = 2;
					newPos[2][1] = 3;
					newPos[3][0] = 3;
					newPos[3][1] = 3;
				}
				break;
			case 'S' :
				if(block.getXMax() == 3) {
					newPos[0][0] = 1;
					newPos[0][1] = 1;
					newPos[1][0] = 1;
					newPos[1][1] = 2;
					newPos[2][0] = 2;
					newPos[2][1] = 2;
					newPos[3][0] = 2;
					newPos[3][1] = 3;
				} else {
					newPos[0][0] = 1;
					newPos[0][1] = 3;
					newPos[1][0] = 2;
					newPos[1][1] = 2;
					newPos[2][0] = 2;
					newPos[2][1] = 3;
					newPos[3][0] = 3;
					newPos[3][1] = 2;
				}
				break;
			case 'I' : 			
				if(block.getXMin() == block.getXMax()) {
					newPos[0][0] = 1;
					newPos[0][1] = 2;
					newPos[1][0] = 2;
					newPos[1][1] = 2;
					newPos[2][0] = 3;
					newPos[2][1] = 2;
					newPos[3][0] = 4;
					newPos[3][1] = 2;
				} else {
					newPos[0][0] = 2;
					newPos[0][1] = 1;
					newPos[1][0] = 2;
					newPos[1][1] = 2;
					newPos[2][0] = 2;
					newPos[2][1] = 3;
					newPos[3][0] = 2;
					newPos[3][1] = 4;
				}			
				break;
			default : return false;
		}
		
		int x, y;
		for(int i=0; i<4; i++) {
				x = newPos[i][0];
				y = newPos[i][1];
				if(1 <= getXblock(x) && getXblock(x) <= grid.getWidth() && 1 <= getYblock(y) && getYblock(y) <= grid.getHeight()) {
					if(!block.hasPos(x, y) && this.grid.isOccupied(getXblock(x), getYblock(y))) {
						return false;
					}
				} else {
					return false;
				}
			
		}		
		return true;
	}


	public boolean canRotateRight() {
		int[][] newPos = new int[4][2];
		
		switch(block.getType()) {
			case 'O' : return true; 
			case 'L' : 
				if((block.getYMin() == 1) && (block.getYMax() == 3)) {
					if(block.hasPos(3, 3)) {
						newPos[0][0] = 1;
						newPos[0][1] = 2;
						newPos[1][0] = 1;
						newPos[1][1] = 3;
						newPos[2][0] = 2;
						newPos[2][1] = 2;
						newPos[3][0] = 3;
						newPos[3][1] = 2;
					} else { 
						newPos[0][0] = 1;
						newPos[0][1] = 2;
						newPos[1][0] = 2;
						newPos[1][1] = 2;
						newPos[2][0] = 3;
						newPos[2][1] = 1;
						newPos[3][0] = 3;
						newPos[3][1] = 2;
					}
				} else {
					if(block.hasPos(3, 1)) {
						newPos[0][0] = 2;
						newPos[0][1] = 1;
						newPos[1][0] = 2;
						newPos[1][1] = 2;
						newPos[2][0] = 2;
						newPos[2][1] = 3;
						newPos[3][0] = 3;
						newPos[3][1] = 3;
					} else { 
						newPos[0][0] = 1;
						newPos[0][1] = 1;
						newPos[1][0] = 2;
						newPos[1][1] = 1;
						newPos[2][0] = 2;
						newPos[2][1] = 2;
						newPos[3][0] = 2;
						newPos[3][1] = 3;
					}
				}
				break;
			case 'J' : 
				if((block.getYMin() == 1) && (block.getYMax() == 3)) {
					if(block.hasPos(1, 3)) {
						newPos[0][0] = 1;
						newPos[0][1] = 1;
						newPos[1][0] = 1;
						newPos[1][1] = 2;
						newPos[2][0] = 2;
						newPos[2][1] = 2;
						newPos[3][0] = 3;
						newPos[3][1] = 2;
					} else { 
						newPos[0][0] = 1;
						newPos[0][1] = 2;
						newPos[1][0] = 2;
						newPos[1][1] = 2;
						newPos[2][0] = 3;
						newPos[2][1] = 2;
						newPos[3][0] = 3;
						newPos[3][1] = 3;
					}
				} else {
					if(block.hasPos(1, 1)) {
						newPos[0][0] = 2;
						newPos[0][1] = 1;
						newPos[1][0] = 2;
						newPos[1][1] = 2;
						newPos[2][0] = 2;
						newPos[2][1] = 3;
						newPos[3][0] = 3;
						newPos[3][1] = 1;
					} else {
						newPos[0][0] = 1;
						newPos[0][1] = 3;
						newPos[1][0] = 2;
						newPos[1][1] = 1;
						newPos[2][0] = 2;
						newPos[2][1] = 2;
						newPos[3][0] = 2;
						newPos[3][1] = 3;
					}
				}
				break;
			case 'T' :
				if((block.getXMin() == 1) && (block.getXMax() == 3)) {
					if(block.hasPos(2, 3)) {
						newPos[0][0] = 1;
						newPos[0][1] = 2;
						newPos[1][0] = 2;
						newPos[1][1] = 1;
						newPos[2][0] = 2;
						newPos[2][1] = 2;
						newPos[3][0] = 2;
						newPos[3][1] = 3;
					} else { 
						newPos[0][0] = 2;
						newPos[0][1] = 1;
						newPos[1][0] = 2;
						newPos[1][1] = 2;
						newPos[2][0] = 2;
						newPos[2][1] = 3;
						newPos[3][0] = 3;
						newPos[3][1] = 2;						
					}
				} else {
					if(block.hasPos(1, 2)) {
						newPos[0][0] = 1;
						newPos[0][1] = 2;
						newPos[1][0] = 2;
						newPos[1][1] = 1;
						newPos[2][0] = 2;
						newPos[2][1] = 2;
						newPos[3][0] = 3;
						newPos[3][1] = 2;
					} else { 
						newPos[0][0] = 1;
						newPos[0][1] = 2;
						newPos[1][0] = 2;
						newPos[1][1] = 2;
						newPos[2][0] = 2;
						newPos[2][1] = 3;
						newPos[3][0] = 3;
						newPos[3][1] = 2;
					}
				}
				break;
			case 'Z' :
				if(block.getXMax() == 3) {
					newPos[0][0] = 1;
					newPos[0][1] = 2;
					newPos[1][0] = 1;
					newPos[1][1] = 3;
					newPos[2][0] = 2;
					newPos[2][1] = 1;
					newPos[3][0] = 2;
					newPos[3][1] = 2;
				} else {
					newPos[0][0] = 1;
					newPos[0][1] = 2;
					newPos[1][0] = 2;
					newPos[1][1] = 2;
					newPos[2][0] = 2;
					newPos[2][1] = 3;
					newPos[3][0] = 3;
					newPos[3][1] = 3;
				}
				break;
			case 'S' :
				if(block.getXMax() == 3) {
					newPos[0][0] = 1;
					newPos[0][1] = 1;
					newPos[1][0] = 1;
					newPos[1][1] = 2;
					newPos[2][0] = 2;
					newPos[2][1] = 2;
					newPos[3][0] = 2;
					newPos[3][1] = 3;
				} else {
					newPos[0][0] = 1;
					newPos[0][1] = 3;
					newPos[1][0] = 2;
					newPos[1][1] = 2;
					newPos[2][0] = 2;
					newPos[2][1] = 3;
					newPos[3][0] = 3;
					newPos[3][1] = 2;
				}
				break;
			case 'I' : 			
				if(block.getXMin() == block.getXMax()) {
					newPos[0][0] = 1;
					newPos[0][1] = 2;
					newPos[1][0] = 2;
					newPos[1][1] = 2;
					newPos[2][0] = 3;
					newPos[2][1] = 2;
					newPos[3][0] = 4;
					newPos[3][1] = 2;
				} else {
					newPos[0][0] = 2;
					newPos[0][1] = 1;
					newPos[1][0] = 2;
					newPos[1][1] = 2;
					newPos[2][0] = 2;
					newPos[2][1] = 3;
					newPos[3][0] = 2;
					newPos[3][1] = 4;
				}			
				break;
			default : return false;
		}
		
		int x, y;
		for(int i=0; i<4; i++) {
				x = newPos[i][0];
				y = newPos[i][1];
				if(1 <= getXblock(x) && getXblock(x) <= grid.getWidth() && 1 <= getYblock(y) && getYblock(y) <= grid.getHeight()) {
					if(!block.hasPos(x, y) && this.grid.isOccupied(getXblock(x), getYblock(y))) {
						return false;
					}
				} else {
					return false;
				}
			
		}		
		return true;
	}

	
	@Override
	public boolean cangoLeft() {
		for(int x=2; x<=block.getSize(); x++) {
			for(int y=1;y<=block.getSize();y++){
				if(block.hasPos(x, y)) {
					if(!block.hasPos(x-1, y) && !grid.canPut(getXblock(x)-1, getYblock(y))) {
						return false;
					}
				}
			}
		}
		for(int y=1;y<=block.getSize();y++){
			if(block.hasPos(1, y)) {
				if(!grid.canPut(getXblock(1)-1, getYblock(y))) {
					return false;
				}
			}
		}
		return true;
	}

	
	@Override
	public boolean cangoRight() {
		for(int x=1; x<=block.getSize()-1; x++) {
			for(int y=1;y<=block.getSize();y++){
				if(block.hasPos(x, y)) {
					if(!block.hasPos(x+1, y) && !grid.canPut(getXblock(x)+1, getYblock(y))) {
						return false;
					}
				}
			}
		}
		for(int y=1;y<=block.getSize();y++){
			if(block.hasPos(block.getSize(), y)) {
				if(!grid.canPut(getXblock(block.getSize())+1, getYblock(y))) {
					return false;
				}
			}
		}
		return true;
	}

	
	@Override
	public boolean isBlock() {
		return this.block != null;
	}
	
	
	@Override
	public boolean isBottom() {
		for(LinkedList<Integer> p: block.getLowPos()){
			if((getYblock(p.getLast()) == grid.getHeight()) 
					|| (!getgrid().canPut(getXblock(p.getFirst()), getYblock(p.getLast())+1)))
				return true;
		}
		return false;
	}
	
	
	public boolean isConflict(){
		return this.Conflict;
	}
	
	
	@Override
	public int getXblock(int x) {
		return this.XMinBlock+(x-1);
	}
	

	@Override
	public int getYblock(int y) {
		return this.YMinBlock+(y-1);
	}
	
	
	@Override
	public int getXMinBlock() {
		return this.XMinBlock;
	}

	
	@Override
	public int getYMinBlock() {
		return this.YMinBlock;
	}
	
	
	@Override
	public int getBottomHeight() {
		int lengthmax = grid.getHeight();
		int length;
		for(LinkedList<Integer> p: block.getLowPos()){
			int x = getXblock(p.getFirst());
			int y = getYblock(p.getLast());
			length = 0;
			while(grid.canPut(x, y+1)){
				length++;
				y++;
			}
			if (length < lengthmax)
				lengthmax = length;
		}
		return lengthmax;
	}
	
	
	@Override
	public void init(int x, int y) {
		block = null;
		grid = Factory.createGrid();
		grid.init(x, y);
		NbLastCleaned = 0;
		XMinBlock = 0;
		YMinBlock = 0;
	}
	
	
	@Override
	public void doRotateLeft() {
		for(LinkedList<Integer> p: block.getAllPos()){
			int x = getXblock(p.getFirst());
			int y = getYblock(p.getLast());
			grid.remove(x, y);
		}
		block.rotateLeft();
		for(LinkedList<Integer> p: block.getAllPos()){
			int x = getXblock(p.getFirst());
			int y = getYblock(p.getLast());
			grid.put(x, y);
		}
	}
	
	
	@Override
	public void doLeft() {
		for(LinkedList<Integer> p: block.getAllPos()){
			int x = getXblock(p.getFirst());
			int y = getYblock(p.getLast());
			grid.remove(x, y);
		}
		for(LinkedList<Integer> p: block.getAllPos()){
			int x = getXblock(p.getFirst());
			int y = getYblock(p.getLast());
			grid.put(x-1, y);
		}
		this.XMinBlock -= 1;
	}
	
	
	@Override
	public void doRotateRight() {
		for(LinkedList<Integer> p: block.getAllPos()){
			int x = getXblock(p.getFirst());
			int y = getYblock(p.getLast());
			grid.remove(x, y);
		}
		block.rotateRight();
		for(LinkedList<Integer> p: block.getAllPos()){
			int x = getXblock(p.getFirst());
			int y = getYblock(p.getLast());
			grid.put(x, y);
		}
	}
	
	
	@Override
	public void doRight() {
		for(LinkedList<Integer> p: block.getAllPos()){
			int x = getXblock(p.getFirst());
			int y = getYblock(p.getLast());
			grid.remove(x, y);
		}
		for(LinkedList<Integer> p: block.getAllPos()){
			int x = getXblock(p.getFirst());
			int y = getYblock(p.getLast());
			grid.put(x+1, y);
		}
		this.XMinBlock += 1;
	}
	
		
	@Override
	public void doBottom() {
		int length = getBottomHeight();
		for(LinkedList<Integer> p: block.getAllPos()){
			int x = getXblock(p.getFirst());
			int y = getYblock(p.getLast());
			grid.remove(x, y);
		}
		for(LinkedList<Integer> p: block.getAllPos()){
			int x = getXblock(p.getFirst());
			int y = getYblock(p.getLast());
			grid.put(x, y+length);
		}
		this.YMinBlock += length;
		clean();
		isCleaned = true;
	}

	
	@Override
	public void step() {
		if(isBottom()) {
			if (!isCleaned())
				clean();
			else
				isCleaned = false;
			remove();
		}
		else
		{
			for(LinkedList<Integer> p: block.getAllPos()){
				int x = getXblock(p.getFirst());
				int y = getYblock(p.getLast());
				grid.remove(x, y);
			}
			for(LinkedList<Integer> p: block.getAllPos()){
				int x = getXblock(p.getFirst());
				int y = getYblock(p.getLast());
			grid.put(x, y+1);
			}
			this.YMinBlock += 1;
		}
	}

	
	@Override
	public void insert(BlockService block) {
		this.block = block;
		this.XMinBlock = grid.getWidth() - (2 + block.getSize());
		this.YMinBlock = 1;
		for(LinkedList<Integer> p: block.getAllPos())
		{
			int x = getXblock(p.getFirst());
			int y = getYblock(p.getLast());
			if (!this.grid.isOccupied(x, y))
				this.grid.put(x, y);
			else{
				this.Conflict = true;
				break;
			}
		}
	}

	
	@Override
	public void remove() {
		this.block = null;
		XMinBlock = 0;
		YMinBlock = 0;
	}

		
	@Override
	public void clean() {
		this.NbLastCleaned = 0;
		boolean full;
		int min = getYblock(block.getYMin());
		int max = getYblock(block.getYMax());
		for(int j=min; j<=max; j++) {
			full = true;
			for(int i=1; i<=grid.getWidth(); i++) {
				if(!grid.isOccupied(i, j)) {
					full = false;
					break;
				}
			}
			if(full) {
				this.NbLastCleaned++;
				for(int i=1; i<=grid.getWidth(); i++) {
					grid.remove(i, j);
					for(int k=j-1; k>1; k--) {
						if(grid.isOccupied(i, k)) {
							grid.remove(i, k);
							grid.put(i, k+1);
						}
					}
				}
				this.YMinBlock += 1;
			}
		}
	}

}
