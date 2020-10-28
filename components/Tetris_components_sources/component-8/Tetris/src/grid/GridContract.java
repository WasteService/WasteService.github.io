package grid;

public class GridContract extends GridDecorator {

	public GridContract(GridService f) {
		super(f);
	}
	
	public void checkInvariants(){
		for(int i=1;i<=super.getWidth();i++){
			for(int j=1;j<=super.getHeight();j++){
				if (!(super.isOccupied(i, j) != super.canPut(i, j)))
					throw new Error("[GRID]Invariant invalide(1)");
			}
		}
			
	}
	
	
	public boolean isOccupied(int x, int y){
		checkInvariants();
		if (!(x >= 1 && x <= getWidth() && y >= 1 && y <= getHeight())){
			throw new Error("[GRID]pre(1)(isOccupied) invalide");}
		boolean temp = super.isOccupied(x, y);
		checkInvariants();
		return temp;
	}
	
	public boolean canPut(int x, int y){
		checkInvariants();
		boolean temp = super.canPut(x, y);
		checkInvariants();
		return temp;
	}
	
	public void init(int x, int y){
		if (!(x > 0 && y > 0 && y >= x ))
			throw new Error("[GRID]pre(1)(init) invalide");
		
		super.init(x, y);
		
		if (!(getWidth() == x && getHeight() == y))
			throw new Error("[GRID]post(1)(init) invalide");
		
		for (int xtemp=1;xtemp <= getWidth();xtemp++){
			for (int ytemp=1;ytemp <= getHeight();ytemp++){
				if (!(!isOccupied(xtemp,ytemp) && canPut(xtemp, ytemp)))
					throw new Error("[GRID]post(2)(init) invalide");
			}
		}
		checkInvariants();
	}
	
	public void put(int x, int y){
		checkInvariants();
		if (!canPut(x, y))
			throw new Error("[GRID]pre(1)(put) invalide");
		
		if (!(x >= 1 && x <= getWidth()))
			throw new Error("[GRID]pre(2)(put) invalide");
		
		if (!(y >= 1 && y <= getHeight()))
			throw new Error("[GRID]pre(2)(put) invalide");
		
		boolean grid_atPre[][] = new boolean[getWidth()][getHeight()];
		for(int xtemp=1;xtemp<=getWidth();xtemp++)
		{
			for(int ytemp=1;ytemp<=getHeight();ytemp++){
				grid_atPre[xtemp-1][ytemp-1] = isOccupied(xtemp,ytemp);
			}
		}
	
		super.put(x, y);
		
		if (!(grid_atPre[x-1][y-1] != isOccupied(x, y)))
			throw new Error("[GRID]post(1)(put) invalide");
		
		if (canPut(x,y))
			throw new Error("[GRID]post(2)(put) invalide");
		
		for (int xtemp=1;xtemp<=getWidth();xtemp++){
			for(int ytemp=1;ytemp<=getHeight();ytemp++){
				if (xtemp != x && ytemp != y)
				{
					if (grid_atPre[xtemp-1][ytemp-1] != isOccupied(xtemp, ytemp))
						throw new Error("[GRID]post(3)(put) invalide");
					
					if (grid_atPre[xtemp-1][ytemp-1] == canPut(xtemp, ytemp))
						throw new Error("[GRID]post(4)(put) invalide");
				}
				
			}
		}
	
		checkInvariants();
	}
	
	public void remove(int x, int y){
		checkInvariants();
		if (!isOccupied(x, y)){
			throw new Error("[GRID]pre(1)(remove) invalide");
		}
		if (!(x >= 1 && x <= getWidth()))
			throw new Error("[GRID]pre(2)(remove) invalide");
		
		if (!(y >= 1 && y <= getHeight()))
			throw new Error("[GRID]pre(3)(remove) invalide");
		
		boolean grid_atPre[][] = new boolean[getWidth()][getHeight()];
		for(int xtemp=1;xtemp<=getWidth();xtemp++)
		{
			for(int ytemp=1;ytemp<=getHeight();ytemp++){
				grid_atPre[xtemp-1][ytemp-1] = isOccupied(xtemp,ytemp);
			}
		}

		super.remove(x, y);
		
		if (grid_atPre[x-1][y-1] == isOccupied(x, y))
			throw new Error("[GRID]post(1)(remove) invalide");
		
		if (!canPut(x,y))
			throw new Error("[GRID]post(2)(remove) invalide");
		
		for (int xtemp=1;xtemp<=getWidth();xtemp++){
			for(int ytemp=1;ytemp<=getHeight();ytemp++){
				if (xtemp != x && ytemp != y)
				{
					if (grid_atPre[xtemp-1][ytemp-1] != isOccupied(xtemp, ytemp))
						throw new Error("[GRID]post(3)(remove) invalide");
					
					if (grid_atPre[xtemp-1][ytemp-1] == canPut(xtemp, ytemp))
						throw new Error("[GRID]post(4)(remove) invalide");
				}
				
			}
		}

		checkInvariants();
	}

}
