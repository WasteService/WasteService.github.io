package block;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class BlockImpl implements BlockService {

	private char Type;
	private int Size;
	private int NbPos;
	private int XMin;
	private int XMax;
	private int YMin;
	private int YMax;
	private boolean[][] Pos;
	
	public char getType() {
		return this.Type;
	}
	
	public int getSize() {
		return this.Size;
	}
	
	public int getNbPos() {
		return this.NbPos;
	}
	
	public int getXMin() {
		return this.XMin;
	}

	//abscisse maxmale dans l'ensemble de getAllPos()
	public int getXMax() {
		return this.XMax;
	}
	
	public int getYMin() {
		return this.YMin;
	}
	
	public int getYMax() {
		return this.YMax;
	}
	
	public boolean hasPos(int x, int y) {
		return Pos[x-1][y-1];
	}
	
	public Set<LinkedList<Integer>> getAllPos() {
		Set<LinkedList<Integer>> AllPos = new HashSet<LinkedList<Integer>>();
		LinkedList<Integer> paire;
		
		for(int i=0; i<getSize(); i++) {
			for(int j=0; j<getSize(); j++) {
				if(Pos[i][j]) {
					paire = new LinkedList<Integer>();
					paire.addFirst(i+1);
					paire.addLast(j+1);
					AllPos.add(paire);
				}
			}
		}
		return AllPos;		
	}
	
	public Set<LinkedList<Integer>> getLowPos() {
		Set<LinkedList<Integer>> LowPos = new HashSet<LinkedList<Integer>>();
		for(int i=1; i<=getSize(); i++) {
			int max = 0;
			for(int j=1; j<=getSize(); j++) {
				if(hasPos(i,j)) {
					max = j;
				}
			}
			if(max >0) {
				LinkedList<Integer> paire = new LinkedList<Integer>();
				paire.addFirst(i);
				paire.addLast(max);
				LowPos.add(paire);
			}
		}		
		return LowPos;		
	}
	
	public void init(char type) {
		this.Type = type;
		switch(this.Type) {
		case 'O' : 
			this.Size = 2;
			break; 
		case 'L' :
			this.Size = 3;
			break;
		case 'J' : 
			this.Size = 3;
			break;
		case 'T' : 
			this.Size = 3;
			break;
		case 'Z' :
			this.Size = 3;
			break;
		case 'S' : 
			this.Size = 3;
			break;
		case 'I' : 
			this.Size = 4;
			break;
		}	
		this.Pos = new boolean[this.Size][this.Size];
		for(int i=0; i<getSize(); i++) {
			for(int j=0; j<getSize(); j++) {
				Pos[i][j] = false;
			}
		}
		this.XMin = this.Size+1;
		this.XMax = 0;
		this.YMin = this.Size+1;
		this.YMax = 0;
		this.NbPos = 0;
		switch(this.Type) {
		case 'O' :
			addPos(1, 1);
			addPos(1, 2);
			addPos(2, 1);
			addPos(2, 2);
			break; 
		case 'L' :
			addPos(2, 1);
			addPos(2, 2);
			addPos(2, 3);
			addPos(3, 3);
			break;
		case 'J' : 
			addPos(1, 3);
			addPos(2, 1);
			addPos(2, 2);
			addPos(2, 3);
			break;
		case 'T' : 
			addPos(1, 2);
			addPos(2, 2);
			addPos(2, 3);
			addPos(3, 2);
			break;
		case 'Z' :
			addPos(1, 2);
			addPos(2, 2);
			addPos(2, 3);
			addPos(3, 3);
			break;
		case 'S' : 
			addPos(1, 3);
			addPos(2, 2);
			addPos(2, 3);
			addPos(3, 2);
			break;
		case 'I' : 
			addPos(2, 1);
			addPos(2, 2);
			addPos(2, 3);
			addPos(2, 4);
			break;
		}	
	}
	
	public void addPos(int x, int y) {
		Pos[x-1][y-1] = true;
		NbPos++;
		if (x > XMax) {
			XMax = x;
		}
		if (x < XMin) {
			XMin = x;
		}
		if (y > YMax) {
			YMax = y;
		}
		if (y < YMin) {
			YMin = y;
		}
	}
	
	public void removeAllPos() {
		this.NbPos = 0;
		for(int i=0; i<Size; i++) {
			for (int j=0; j<Size; j++) {
				Pos[i][j] = false;
			}
		}
		this.XMin = this.Size+1;
		this.XMax = 0;
		this.YMin = this.Size+1;
		this.YMax = 0;		
	}
	
	public void rotateLeft() {
		switch(this.Type) {
			case 'O' : return; 
			case 'L' : 
				if((YMin == 1) && (YMax == 3)) {
					if(hasPos(3, 3)) {
						removeAllPos();
						addPos(1, 2);
						addPos(2, 2);
						addPos(3, 1);
						addPos(3, 2);
					} else { 
						removeAllPos();
						addPos(1, 2);
						addPos(1, 3);
						addPos(2, 2);
						addPos(3, 2);
					}
				} else {
					if(hasPos(3, 1)) {
						removeAllPos();
						addPos(1, 1);
						addPos(2, 1);
						addPos(2, 2);
						addPos(2, 3);
					} else { 
						removeAllPos();
						addPos(2, 1);
						addPos(2, 2);
						addPos(2, 3);
						addPos(3, 3);
					}
				}
				return;
			case 'J' : 
				if((YMin == 1) && (YMax == 3)) {
					if(hasPos(1, 3)) {
						removeAllPos();
						addPos(1, 2);
						addPos(2, 2);
						addPos(3, 2);
						addPos(3, 3);
					} else { 
						removeAllPos();
						addPos(1, 1);
						addPos(1, 2);
						addPos(2, 2);
						addPos(3, 2);
					}
				} else {
					if(hasPos(1, 1)) {
						removeAllPos();
						addPos(1, 3);
						addPos(2, 1);
						addPos(2, 2);
						addPos(2, 3);
					} else { 
						removeAllPos();
						addPos(2, 1);
						addPos(2, 2);
						addPos(2, 3);
						addPos(3, 1);
					}
				}
				return;
			case 'T' :
				if((XMin == 1) && (XMax == 3)) {
					if(hasPos(2, 3)) {
						removeAllPos();
						addPos(2, 1);
						addPos(2, 2);
						addPos(2, 3);
						addPos(3, 2);
					} else { 
						removeAllPos();
						addPos(1, 2);
						addPos(2, 1);
						addPos(2, 2);
						addPos(2, 3);
					}
				} else {
					if(hasPos(1, 2)) {
						removeAllPos();
						addPos(1, 2);
						addPos(2, 2);
						addPos(2, 3);
						addPos(3, 2);
					} else { 
						removeAllPos();
						addPos(1, 2);
						addPos(2, 1);
						addPos(2, 2);
						addPos(3, 2);
					}
				}
				return;
			case 'Z' :
				if(XMax == 3) {
					removeAllPos();
					addPos(1, 2);
					addPos(1, 3);
					addPos(2, 1);
					addPos(2, 2);
				} else {
					removeAllPos();
					addPos(1, 2);
					addPos(2, 2);
					addPos(2, 3);
					addPos(3, 3);
				}
				return;
			case 'S' :
				if(XMax == 3) {
					removeAllPos();
					addPos(1, 1);
					addPos(1, 2);
					addPos(2, 2);
					addPos(2, 3);
				} else {
					removeAllPos();
					addPos(1, 3);
					addPos(2, 2);
					addPos(2, 3);
					addPos(3, 2);
				}
				return;
			case 'I' : 
				if(XMin == XMax) {
					removeAllPos();
					addPos(1, 2);
					addPos(2, 2);
					addPos(3, 2);
					addPos(4, 2);
				} else {
					removeAllPos();
					addPos(2, 1);
					addPos(2, 2);
					addPos(2, 3);
					addPos(2, 4);
				}			
				return;
			default : return;
		}
	}
	
	public void rotateRight() {
		switch(this.Type) {
		case 'O' : return; 
		case 'L' : 
			if((YMin == 1) && (YMax == 3)) {
				if(hasPos(3, 3)) {
					removeAllPos();
					addPos(1, 2);
					addPos(1, 3);
					addPos(2, 2);
					addPos(3, 2);
				} else { 
					removeAllPos();
					addPos(1, 2);
					addPos(2, 2);
					addPos(3, 1);
					addPos(3, 2);
				}
			} else {
				if(hasPos(3, 1)) {
					removeAllPos();
					addPos(2, 1);
					addPos(2, 2);
					addPos(2, 3);
					addPos(3, 3);
				} else { 
					removeAllPos();
					addPos(1, 1);
					addPos(2, 1);
					addPos(2, 2);
					addPos(2, 3);
				}
			}
			return;
		case 'J' :
			if((YMin == 1) && (YMax == 3)) {
				if(hasPos(1, 3)) {
					removeAllPos();
					addPos(1, 1);
					addPos(1, 2);
					addPos(2, 2);
					addPos(3, 2);
				} else { 
					removeAllPos();
					addPos(1, 2);
					addPos(2, 2);
					addPos(3, 2);
					addPos(3, 3);
				}
			} else {
				if(hasPos(1, 1)) {
					removeAllPos();
					addPos(2, 1);
					addPos(2, 2);
					addPos(2, 3);
					addPos(3, 1);
				} else { 
					removeAllPos();
					addPos(1, 3);
					addPos(2, 1);
					addPos(2, 2);
					addPos(2, 3);
				}
			}
			return;
		case 'T' :
			if((XMin == 1) && (XMax == 3)) {
				if(hasPos(2, 3)) {
					removeAllPos();
					addPos(1, 2);
					addPos(2, 1);
					addPos(2, 2);
					addPos(2, 3);					
				} else { 
					removeAllPos();
					addPos(2, 1);
					addPos(2, 2);
					addPos(2, 3);
					addPos(3, 2);
				}
			} else {
				if(hasPos(1, 2)) {
					removeAllPos();
					addPos(1, 2);
					addPos(2, 1);
					addPos(2, 2);
					addPos(3, 2);
				} else { 
					removeAllPos();
					addPos(1, 2);
					addPos(2, 2);
					addPos(2, 3);
					addPos(3, 2);
				}
			}
			return;
		case 'Z' : 
			if(XMax == 3) {
				removeAllPos();
				addPos(1, 2);
				addPos(1, 3);
				addPos(2, 1);
				addPos(2, 2);
			} else {
				removeAllPos();
				addPos(1, 2);
				addPos(2, 2);
				addPos(2, 3);
				addPos(3, 3);
			}
			return;
		case 'S' : 
			if(XMax == 3) {
				removeAllPos();
				addPos(1, 1);
				addPos(1, 2);
				addPos(2, 2);
				addPos(2, 3);
			} else {
				removeAllPos();
				addPos(1, 3);
				addPos(2, 2);
				addPos(2, 3);
				addPos(3, 2);
			}
			return;
		case 'I' : 
			if(XMin == XMax) {
				removeAllPos();
				addPos(1, 2);
				addPos(2, 2);
				addPos(3, 2);
				addPos(4, 2);
			} else {
				removeAllPos();
				addPos(2, 1);
				addPos(2, 2);
				addPos(2, 3);
				addPos(2, 4);
			}
			return;
		default : return;
	}
	}

}