package grid;

public abstract class GridDecorator implements GridService{
	GridService delegate;
	
	public GridDecorator(GridService f){
		this.delegate = f;
	}
	
	public int getWidth(){
		return this.delegate.getWidth();
	}
	
	public int getHeight(){
		return this.delegate.getHeight();
	}
	
	public boolean isOccupied(int x, int y){
		return this.delegate.isOccupied(x, y);
	}
	
	public boolean canPut(int x, int y){
		return this.delegate.canPut(x, y);
	}
	
	public void init(int x, int y){
		this.delegate.init(x, y);
	}
	
	public void put(int x, int y){
		this.delegate.put(x, y);
	}
	
	public void remove(int x, int y){
		this.delegate.remove(x, y);
	}
	
	
}
