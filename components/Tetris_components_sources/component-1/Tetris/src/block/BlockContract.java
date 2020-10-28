package block;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;


public class BlockContract extends BlockDecorator {

	public BlockContract(BlockService block) {
		super(block);
	}
	

	public void checkInvariants() {
		// inv1 : getType() == 'O' || 'L' || 'J' || 'T' || 'Z' || 'S' || 'I'
		if (!((super.getType() == 'O') || (super.getType() == 'L') || (super.getType() == 'J') || (super.getType() == 'T') || (super.getType() == 'Z') || (super.getType() == 'S') || (super.getType() == 'I'))) {
			throw new Error("[BLOCK]Invariant (1) invalide");
		}
		// inv2 : getSize() == 2 || getSize() == 3 || getSize() == 4
		if (!((super.getSize() == 2) || (super.getSize() == 3) || (super.getSize() == 4))) {
			throw new Error("[BLOCK]Invariant (2) invalide");
		}
		// inv3 : 0 <= getNbPos() && getNbPos <= 4
		if (!((0 <= super.getNbPos()) && (super.getNbPos() <= 4) )) {
			throw new Error("[BLOCK]Invariant (3) invalide");
		}
		Iterator<LinkedList<Integer>> it = super.getAllPos().iterator();
		int XMin = super.getSize()+1, XMax = 0, YMin = super.getSize()+1, YMax = 0;
		LinkedList<Integer> pos;
		while(it.hasNext()) {
			pos = it.next();
			if(pos.getFirst() < XMin) {
				XMin = pos.getFirst();
			}
			if (pos.getFirst() > XMax) {
				XMax = pos.getFirst();
			}
			if(pos.getLast() < YMin) {
				YMin = pos.getLast(); 
			}
			if (pos.getLast() > YMax) {
				YMax = pos.getLast();
			}
		}
		// inv4 : getXMin() == \findmin { first(p) \in getAllPos() }
		if (!(super.getXMin() == XMin)) {
			throw new Error("[BLOCK]Invariant (4) invalide");
		}
		// inv5 : getXMax() == \findmax { first(p) \in getAllPos() }
		if (!(super.getXMax() == XMax)) {
			throw new Error("[BLOCK]Invariant (5) invalide");
		}
		// inv6 : getYMin() == \findmin { second(p) \in getAllPos() }
		if (!(super.getYMin() == YMin)) {
			throw new Error("[BLOCK]Invariant (6) invalide");
		}
		// inv7 : getYMax() == \findmax { second(p) \in getAllPos() }
		if (!(super.getYMax() == YMax)) {
			throw new Error("[BLOCK]Invariant (7) invalide");
		}
		
		// inv8 : \forall x:int, y:int \in getHasPos((x,y)) { getAllPos().contains((x,y)) }
		for(int i=1; i<= super.getSize(); i++) {
			for (int j=1; j<=super.getSize(); j++) {
				if(super.hasPos(i, j)) {
					LinkedList<Integer> paire = new LinkedList<Integer>();
					paire.addFirst(i);
					paire.addLast(j);
					if(!super.getAllPos().contains(paire)) {
						throw new Error("[BLOCK]Invariant (8) invalide");
					}
				}
			}
		}
		// inv9 : \forall x:int, y1:int, y2:int \in getHasPos((x,y1)) && getHasPos((x,y2)) { getLowPos().contains((x,max(y1,y2))) }
		for(int i=1; i<=super.getSize(); i++) {
			int max = 0;
			for(int j=1; j<=super.getSize(); j++) {
				if((super.hasPos(i, j)) && j > max) {
					max = j;					
				}
			}

			if(max >0) {
				LinkedList<Integer> paire = new LinkedList<Integer>();
				paire.addFirst(i);
				paire.addLast(max);
				if(!(super.getLowPos().contains(paire))) {
					throw new Error("[BLOCK]Invariant (9) invalide");
				}
			}
		}
	}
	

	public char getType() {
		checkInvariants();
		char type = super.getType();
		checkInvariants();
		return type;
	}
	
	public int getSize() {
		checkInvariants();
		int size = super.getSize();
		checkInvariants();
		return size;
	}
	
	public int getNbPos() {
		checkInvariants();
		int nbPos = super.getNbPos();
		checkInvariants();
		return nbPos;
	}
	
	public int getXMin() {
		checkInvariants();
		int XMin = super.getXMin();
		checkInvariants();
		return XMin;
	}

	public int getXMax() {
		checkInvariants();
		int XMax = super.getXMax();
		checkInvariants();
		return XMax;
	}
	
	public int getYMin() {
		checkInvariants();
		int YMin = super.getYMin();
		checkInvariants();
		return YMin;
	}
	
	public int getYMax() {
		checkInvariants();
		int YMax = super.getYMax();
		checkInvariants();
		return YMax;
	}
	
	public boolean hasPos(int x, int y) {
		if(!((1<=x) && (x<=super.getSize()) && (1<=y) && (y<=super.getSize()))) {
			throw new Error("[BLOCK]pre (hasPos) invalide");
		}
		checkInvariants();
		boolean hasPos = super.hasPos(x, y);
		checkInvariants();
		return hasPos;
	}
	
	public Set<LinkedList<Integer>> getAllPos() {
		checkInvariants();
		Set<LinkedList<Integer>> getAllPos = super.getAllPos();
		checkInvariants();
		return getAllPos;
	}
	
	public Set<LinkedList<Integer>> getLowPos() {
		checkInvariants();
		Set<LinkedList<Integer>> getLowPos = super.getLowPos();
		checkInvariants();
		return getLowPos;
	}

	public void init(char type) {
		if(!((type == 'O') || (type == 'L') || (type == 'J') || (type == 'T') || (type == 'Z') || (type == 'S') || (type == 'I'))) {
			throw new Error("[BLOCK]pre (init) invalide");
		}
		super.init(type);
		checkInvariants();
		if(!(super.getType() == type)) {
			throw new Error("[BLOCK]post (1) (init) invalide");
		}
		if(!(super.getNbPos() == 4)) {
			throw new Error("[BLOCK]post (2) (init) invalide");
		}
	}
	 
	public void addPos(int x, int y) {
		if(!((1<=x) && (x<=super.getSize()) && (1<=y) && (y<=super.getSize()) && (!super.hasPos(x, y)))) {
			throw new Error("[BLOCK]pre (addPos) invalide");
		}
		checkInvariants();
		char getType_atPre = super.getType();
		int getSize_atPre = super.getSize();
		int getNbPos_atPre = super.getNbPos();
		int getXMin_atPre = super.getXMin();
		int getXMax_atPre = super.getXMax();
		int getYMin_atPre = super.getYMin();
		int getYMax_atPre = super.getYMax();
		boolean[][] hasPos_atPre = new boolean[super.getSize()][super.getSize()];
		for(int i=1; i<= super.getSize(); i++) {
			for (int j=1; j<=super.getSize(); j++) {
				hasPos_atPre[i-1][j-1] = super.hasPos(i, j);
			}
		}
		Set<LinkedList<Integer>> getAllPos_atPre = new HashSet<LinkedList<Integer>>();
		Iterator<LinkedList<Integer>> it = super.getAllPos().iterator();
		while(it.hasNext()) {
			getAllPos_atPre.add(it.next());
		}		
		super.addPos(x, y);
		checkInvariants();
		if(!(super.getType() == getType_atPre)) {
			throw new Error("[BLOCK]post (1) (addPos) invalide");
		}
		if(!(super.getSize() == getSize_atPre)) {
			throw new Error("[BLOCK]post (2) (addPos) invalide");
		}
		if(!(super.getNbPos() == getNbPos_atPre+1)) {
			throw new Error("[BLOCK]post (3) (addPos) invalide");
		}
		if(!((x < getXMin_atPre && super.getXMin() == x) || (super.getXMin() == getXMin_atPre))) {
			throw new Error("[BLOCK]post (4) (addPos) invalide");
		}
		if(!((getXMax_atPre < x && super.getXMax() == x) || (super.getXMax() == getXMax_atPre))) {
			throw new Error("[BLOCK]post (5) (addPos) invalide");
		}
		if(!((y < getYMin_atPre && super.getYMin() == y) || (super.getYMin() == getYMin_atPre))) {
			throw new Error("[BLOCK]post (6) (addPos) invalide");
		}
		if(!((getYMax_atPre < y && super.getYMax() == y) || (super.getYMax() == getYMax_atPre))) {
			throw new Error("[BLOCK]post (7) (addPos) invalide");
		}
		if(!(super.hasPos(x, y))) {
			throw new Error("[BLOCK]post (8) (addPos) invalide");
		}
		for(int i=1; i<= super.getSize(); i++) {
			for (int j=1; j<=super.getSize(); j++) {
				if ((i!=x) && (j!=y)) {
					if(!(super.hasPos(i, j) == hasPos_atPre[i-1][j-1])) {
						throw new Error("[BLOCK]post (9) (addPos) invalide");
					}
				}
				
			}
		}
		it = getAllPos_atPre.iterator();
		while(it.hasNext()) {
			if(!(super.getAllPos().contains(it.next()))) {
				throw new Error("[BLOCK]post (10) (addPos) invalide");
			}
		}
		LinkedList<Integer> xy = new LinkedList<Integer>();
		xy.addFirst(x);
		xy.addLast(y);
		if(!(super.getAllPos().contains(xy))) {
			throw new Error("[BLOCK]post (11) (addPos) invalide");
		}
		
		
	}

	public void removeAllPos() {
		checkInvariants();
		int getType_atPre = super.getType();
		int getSize_atPre = super.getSize();
		super.removeAllPos();
		checkInvariants();
		if(!(super.getType() == getType_atPre)) {
			throw new Error("post (1) (removeAllPos) invalide");
		}
		if(!(super.getSize() == getSize_atPre)) {
			throw new Error("post (2) (removeAllPos) invalide");
		}
		if(!(super.getNbPos() == 0)) {
			throw new Error("post (3) (removeAllPos) invalide");
		}
		if(!(super.getXMin() == super.getSize()+1)) {
			throw new Error("post (4) (removeAllPos) invalide");
		}
		if(!(super.getXMax() == 0)) {
			throw new Error("post (5) (removeAllPos) invalide");
		}
		if(!(super.getYMin() == super.getSize()+1)) {
			throw new Error("post (6) (removeAllPos) invalide");
		}
		if(!(super.getYMax() == 0)) {
			throw new Error("post (7) (removeAllPos) invalide");
		}
		for(int i=1; i<= super.getSize(); i++) {
			for (int j=1; j<=super.getSize(); j++) {
				if(!(!(super.hasPos(i, j)))) {
					throw new Error("post (8) (removeAllPos) invalide");
				}
			}
		}
		if(!(super.getAllPos().isEmpty())) {
			throw new Error("post (9) (removeAllPos) invalide");
		}
		if(!(super.getLowPos().isEmpty())) {
			throw new Error("post (10) (removeAllPos) invalide");
		}
	}

	public void rotateLeft() {
		checkInvariants();
		int getType_atPre = super.getType();
		int getSize_atPre = super.getSize();
		int getNbPos_atPre = super.getNbPos();
		super.rotateLeft();
		checkInvariants();
		if(!(super.getType() == getType_atPre)) {
			throw new Error("post (1) (rotateLeft) invalide");
		}
		if(!(super.getSize() == getSize_atPre)) {
			throw new Error("post (2) (rotateLeft) invalide");
		}
		if(!(super.getNbPos() == getNbPos_atPre)) {
			throw new Error("post (3) (rotateLeft) invalide");
		}		
	}

	public void rotateRight() {
		checkInvariants();
		int getType_atPre = super.getType();
		int getSize_atPre = super.getSize();
		int getNbPos_atPre = super.getNbPos();
		super.rotateRight();
		checkInvariants();
		if(!(super.getType() == getType_atPre)) {
			throw new Error("post (1) (rotateRight) invalide");
		}
		if(!(super.getSize() == getSize_atPre)) {
			throw new Error("post (2) (rotateRight) invalide");
		}
		if(!(super.getNbPos() == getNbPos_atPre)) {
			throw new Error("post (3) (rotateRight) invalide");
		}
	}
	
}