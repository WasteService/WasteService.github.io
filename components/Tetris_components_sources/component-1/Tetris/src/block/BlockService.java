package block;

import java.util.LinkedList;
import java.util.Set;

public interface BlockService {
	
	/* INVARIANTS */
	// inv1 : getType() == 'O' || 'L' || 'J' || 'T' || 'Z' || 'S' || 'I'
	// inv2 : getSize() == 2 || getSize() == 3 || getSize() == 4
	// inv3 : 0 <= getNbPos() && getNbPos <= 4
	// inv4 : getXMin() == \findmin { first(p) \in getAllPos() }
	// inv5 : getXMax() == \findmax { first(p) \in getAllPos() }
	// inv6 : getYMin() ==\findmin { second(p) \in getAllPos() }
	// inv7 : getYMax() == \findmax { second(p) \in getAllPos() }
	// inv8 : \forall x:int, y:int \in getHasPos((x,y)) { getAllPos().contains((x,y)) }  
	// inv9 : \forall x:int, y1:int, y2:int \in getHasPos((x,y1)) && getHasPos((x,y2)) { getLowPos().contains((x,max(y1,y2))) }
	
	/* OBSERVATORS */
	public char getType();
	
	public int getSize();
	
	public int getNbPos();
	
	public int getXMin();

	public int getXMax();
	
	public int getYMin();
	
	public int getYMax();
	
	// Pre : 1 <= x && x <= getSize() && 1 <= y && y <= getSize()
	public boolean hasPos(int x, int y);
	
	public Set<LinkedList<Integer>> getAllPos();
	
	public Set<LinkedList<Integer>> getLowPos();
	
	/* CONSTRUCTORS */
	// Pre : type == 'O' || type == 'L' ||  type == 'J' || type == 'T' || type == 'Z' || type == 'S' || type == 'I'
	// Post1 : getType() == type
	// Post2 : getNbPos() == 4
	public void init(char type);
	
	/* OPERATORS */
	// Pre : 1 <= x && x <= getSize() && 1 <= y && y <= getSize() && !hasPos(x,y)
	// Post1 : getType() == getType()@pre
	// Post2 : getSize() == getSize()@pre
	// Post3 : getNbPos() == getNbPos@pre + 1
	// Post4 : (x < getXMin()@pre && getXMin() == x) || (getXMin() == getXMin()@pre)
	// Post5 : (getXMax()@pre < x && getXMax() == x) || (getXMax() == getXMax()@pre)
	// Post6 : (y < getYMin()@pre && getYMin() == y) || (getYMin() == getYMin()@pre)
	// Post7 : (getYMax()@pre < y && getYMax() == y) || (getYMax() == getYMax()@pre)
	// Post8 : hasPos(x,y) == true
	// Post9 : \forall x1:int in [1,size], y1:int in [1,size] { x1 != x && y1 != y && hasPos(x1,y1) == hasPos(x1,y1)@pre }
	// Post10 :  \forall x1:int, y1:int \in getHasPos((x1,y1))@pre { getAllPos().contains((x1,y1)) }
	// Post11 :  getAllPos().contains((x,y))
	public void addPos(int x, int y);
	
	// Post1 : getType() == getType()@pre
	// Post2 : getSize() == getSize()@pre
	// Post3 : getNbPos() == 0
	// Post4 : getXMin() == getSize()+1
	// Post5 : getXMax() == 0
	// Post6 : getYMin() == getSize()+1
	// Post7 : getYMax() == 0	
	// Post8 : \forall x:int in [1,size] { \forall y:int in [1,size] { !hasPos(x,y) } }
	// Post9 : getAllPos() == null
	// Post10 : getLowPos() == null
	public void removeAllPos();
	
	// Post1 : getType() == getType()@pre
	// Post2 : getSize() == getSize()@pre;
	// Post3 : getNbPos() == getNbPos()@pre;
	public void rotateLeft();
	
	// Post1 : getType() == getType()@pre
	// Post2 : getSize() == getSize()@pre;
	// Post3 : getNbPos() == getNbPos()@pre;
	public void rotateRight();
	
	

}
