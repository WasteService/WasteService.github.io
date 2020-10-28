package grid;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import programme.Factory;

public class GridTest{
	
	private static GridService grid;
	
	@BeforeClass
	public static void initialize(){
		grid = Factory.createGrid();
	}
	
	@Test
	public void testinit(){
		try{
			grid.init(10,9);
			assertTrue(false);
		}catch(Error e){
			assertTrue(true);
		}
		
		grid = Factory.createGrid();
		grid.init(10,22);
		boolean oracle_post = (grid.getWidth() == 10) && (grid.getHeight() == 22);
		assertTrue(oracle_post);	
		
		for (int i=1; i<=grid.getWidth();i++){
			for(int j=1;j<=grid.getHeight();j++){
				assertTrue(!grid.isOccupied(i, j) && grid.canPut(i, j));
			}
		}
		
	}
	
	@Test
	public void testisOccupied(){
		try{
			grid.isOccupied(0, 0);
			assertTrue(false);
		}catch(Error e){
			assertTrue(true);
		}
		
		try{
			assertFalse(grid.isOccupied(1,1));
		}catch(Error e){
			assertTrue(false);
		}
		
		grid.put(1, 1);
		
		try{
			assertTrue(grid.isOccupied(1,1));
		}catch(Error e){
			assertFalse(false);
		}
		
		grid.put(grid.getWidth(), grid.getHeight());
		assertTrue(grid.isOccupied(grid.getWidth(), grid.getHeight()));
		
		grid.remove(1, 1);
		grid.remove(grid.getWidth(), grid.getHeight());
		assertTrue(!grid.isOccupied(1, 1) && !grid.isOccupied(10, 22));
	}
	
	@Test
	public void testcanPut(){
		assertFalse(grid.canPut(0, 0));
		
		assertTrue(grid.canPut(1,1));
		
		grid.put(1, 1);
		
		assertFalse(grid.canPut(1,1));
		
		grid.put(grid.getWidth(), grid.getHeight());
		assertFalse(grid.canPut(grid.getWidth(), grid.getHeight()));
		
		grid.remove(1, 1);
		grid.remove(grid.getWidth(), grid.getHeight());
		assertTrue(grid.canPut(1, 1) && grid.canPut(10, 22));
	}
	
	@Test
	public void testput(){
		grid = Factory.createGrid();
		grid.init(10, 22);
		
		grid.put(1, 1);
		assertTrue(grid.isOccupied(1, 1) && !grid.canPut(1,1));
		
		try{
			grid.put(1, 1);
			assertTrue(false);
		}catch(Error e){
			assertTrue(true);
		}
		
		grid.put(grid.getWidth(), grid.getHeight());
		assertTrue(grid.isOccupied(grid.getWidth(), grid.getHeight()) 
				&& !grid.canPut(grid.getWidth(),grid.getHeight()));
		
		try{
			grid.put(0, 0);
			assertTrue(false);
		}catch(Error e){
			assertTrue(true);
		}
		
		try{
			grid.put(grid.getWidth()+1, grid.getHeight()+1);
			assertTrue(false);
		}catch(Error e){
			assertTrue(true);
		}
	}

	@Test
	public void testremove(){
		grid.remove(1, 1);
		assertTrue(!grid.isOccupied(1, 1) && grid.canPut(1,1));
		
		grid.remove(grid.getWidth(), grid.getHeight());
		assertTrue(!grid.isOccupied(grid.getWidth(), grid.getHeight()) 
				&& grid.canPut(grid.getWidth(),grid.getHeight()));
		
		try{
			grid.remove(0, 0);
			assertTrue(false);
		}catch(Error e){
			assertTrue(true);
		}
		
		try{
			grid.remove(grid.getWidth()+1, grid.getHeight()+1);
			assertTrue(false);
		}catch(Error e){
			assertTrue(true);
		}
	}
}
