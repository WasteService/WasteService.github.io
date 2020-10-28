package grid;

public class GridImpl implements GridService {
	private int Width;
	private int Height;
	private boolean[][] used;
	
	
	@Override
	public boolean canPut(int x, int y) {
		if (x < 1 || x > this.Width || y < 1 || y > this.Height)
			return false;
		return !used[x-1][y-1];
	}

	@Override
	public int getHeight() {
		return this.Height;
	}

	@Override
	public int getWidth() {
		return this.Width;
	}

	@Override
	public void init(int x, int y) {
		this.Width = x;
		this.Height = y;
		this.used = new boolean[x][y];
		for(int i = 0;i<x;i++)
			for(int j = 0;j<y;j++)
				used[i][j] = false;
	}

	@Override
	public boolean isOccupied(int x, int y) {
		return used[x-1][y-1];
	}

	@Override
	public void put(int x, int y) {
		if (canPut(x,y))
			used[x-1][y-1] = true;
	}

	@Override
	public void remove(int x, int y) {
		if (isOccupied(x,y))
			used[x-1][y-1] = false;
	}

}
