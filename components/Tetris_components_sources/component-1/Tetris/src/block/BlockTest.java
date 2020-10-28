package block;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

import org.junit.Test;

import programme.Factory;

public class BlockTest {
	
	@Test
	public void testGetType() {
		BlockService blockC = Factory.createBlock();
		char Type;
		
		Type = 'O';
		blockC.init(Type);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getType() == Type);
		
		Type = 'L';
		blockC.init(Type);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getType() == Type);
		
		
		Type = 'J';
		blockC.init(Type);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getType() == Type);
		
		
		Type = 'T';
		blockC.init(Type);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getType() == Type);
		
		
		Type = 'Z';
		blockC.init(Type);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getType() == Type);
		
		
		Type = 'S';
		blockC.init(Type);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getType() == Type);
		
		
		Type = 'I';
		blockC.init(Type);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getType() == Type);
	}
	
	@Test
	public void testGetSize() {
		BlockService blockC = Factory.createBlock();
		char Type;
		
		Type = 'O';
		blockC.init(Type);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getSize() == 2);
		
		
		Type = 'L';
		blockC.init(Type);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getSize() == 3);
		
		
		Type = 'J';
		blockC.init(Type);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getSize() == 3);
		
		
		Type = 'T';
		blockC.init(Type);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getSize() == 3);
		
		
		Type = 'Z';
		blockC.init(Type);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getSize() == 3);
		
		
		Type = 'S';
		blockC.init(Type);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getSize() == 3);
		
		
		Type = 'I';
		blockC.init(Type);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getSize() == 4);	
	}
	
	@Test
	public void testGetNbPos() {
		BlockService blockC = Factory.createBlock();
		char Type;
		
		Type = 'O';
		blockC.init(Type);
		assertTrue(blockC.getNbPos() == 4);
	
		blockC.removeAllPos();
		assertTrue(blockC.getNbPos() == 0);
		
		blockC.addPos(2, 2);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getNbPos() == 1);
		
		
		Type = 'L';
		blockC.init(Type);
		assertTrue(blockC.getNbPos() == 4);
	
		blockC.removeAllPos();
		assertTrue(blockC.getNbPos() == 0);
		
		blockC.addPos(2, 2);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getNbPos() == 1);
				
		
		Type = 'J';
		blockC.init(Type);
		assertTrue(blockC.getNbPos() == 4);
	
		blockC.removeAllPos();
		assertTrue(blockC.getNbPos() == 0);
		
		blockC.addPos(2, 2);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getNbPos() == 1);
		
		
		Type = 'T';
		blockC.init(Type);
		assertTrue(blockC.getNbPos() == 4);
	
		blockC.removeAllPos();
		assertTrue(blockC.getNbPos() == 0);
		
		blockC.addPos(2, 2);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getNbPos() == 1);
				
		
		Type = 'Z';
		blockC.init(Type);
		assertTrue(blockC.getNbPos() == 4);
	
		blockC.removeAllPos();
		assertTrue(blockC.getNbPos() == 0);
		
		blockC.addPos(2, 2);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getNbPos() == 1);
		
		
		Type = 'S';
		blockC.init(Type);
		assertTrue(blockC.getNbPos() == 4);
	
		blockC.removeAllPos();
		assertTrue(blockC.getNbPos() == 0);
		
		blockC.addPos(2, 2);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getNbPos() == 1);
		
		
		Type = 'I';
		blockC.init(Type);
		assertTrue(blockC.getNbPos() == 4);
		
		blockC.removeAllPos();
		assertTrue(blockC.getNbPos() == 0);
		
		blockC.addPos(2, 2);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getNbPos() == 1);
	}
	
	@Test
	public void testGetXMin() {
		BlockService blockC = Factory.createBlock();
		char Type;
		
		Type = 'O';
		blockC.init(Type);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getXMin() == 1);
		
		
		Type = 'L';
		blockC.init(Type);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getXMin() == 2);
		
		
		Type = 'J';
		blockC.init(Type);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getXMin() == 1);
		
		
		Type = 'T';
		blockC.init(Type);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getXMin() == 1);
		
		
		Type = 'Z';
		blockC.init(Type);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getXMin() == 1);
		
		
		Type = 'S';
		blockC.init(Type);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getXMin() == 1);
		
		
		Type = 'I';
		blockC.init(Type);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getXMin() == 2);
	}
	
	@Test
	public void testGetXMax() {
		BlockService blockC = Factory.createBlock();
		char Type;
		
		Type = 'O';
		blockC.init(Type);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getXMax() == 2);
	
		
		Type = 'L';
		blockC.init(Type);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getXMax() == 3);
		
		
		Type = 'J';
		blockC.init(Type);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getXMax() == 2);
		
		
		Type = 'T';
		blockC.init(Type);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getXMax() == 3);
		
		
		Type = 'Z';
		blockC.init(Type);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getXMax() == 3);
		
		
		Type = 'S';
		blockC.init(Type);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getXMax() == 3);
		
		
		Type = 'I';
		blockC.init(Type);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getXMax() == 2);		
	}
	
	@Test
	public void testGetYMin() {
		BlockService blockC = Factory.createBlock();
		char Type;
		
		Type = 'O';
		blockC.init(Type);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getYMin() == 1);
		
		
		Type = 'L';
		blockC.init(Type);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getYMin() == 1);
		
		
		Type = 'J';
		blockC.init(Type);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getYMin() == 1);
		
		
		Type = 'T';
		blockC.init(Type);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getYMin() == 2);
		
		
		Type = 'Z';
		blockC.init(Type);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getYMin() == 2);
		
		
		Type = 'S';
		blockC.init(Type);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getYMin() == 2);
		
		
		Type = 'I';
		blockC.init(Type);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getYMin() == 1);
	}
	
	@Test
	public void testGetYMax() {
		BlockService blockC = Factory.createBlock();
		char Type;
		
		Type = 'O';
		blockC.init(Type);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getYMax() == 2);
	
		
		Type = 'L';
		blockC.init(Type);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getYMax() == 3);
		
		
		Type = 'J';
		blockC.init(Type);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getYMax() == 3);
		
		
		Type = 'T';
		blockC.init(Type);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getYMax() == 3);
		
		
		Type = 'Z';
		blockC.init(Type);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getYMax() == 3);
		
		
		Type = 'S';
		blockC.init(Type);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getYMax() == 3);
		
		
		Type = 'I';
		blockC.init(Type);
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		assertTrue(blockC.getYMax() == 4);
	}
	
	@Test
	public void testHasPos() {
		BlockService blockC = Factory.createBlock();
		char Type;
		
		Type = 'O';
		blockC.init(Type);
		
		/* Précondition non vérifiée */
		try {
			blockC.hasPos(0, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(1, 0);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(5, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(3, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(0, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition vérifiée */
		try {
			blockC.hasPos(2, 2);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		
		Type = 'L';
		blockC.init(Type);
		
		/* Précondition non vérifiée */
		try {
			blockC.hasPos(0, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(1, 0);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(5, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(3, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(0, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition vérifiée */
		try {
			blockC.hasPos(2, 2);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}		
		
		
		Type = 'J';
		blockC.init(Type);

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(0, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(1, 0);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(5, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(3, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(0, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition vérifiée */
		try {
			blockC.hasPos(2, 2);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		
		Type = 'T';
		blockC.init(Type);

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(0, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(1, 0);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(5, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(3, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(0, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition vérifiée */
		try {
			blockC.hasPos(2, 2);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
				
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		
		Type = 'Z';
		blockC.init(Type);

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(0, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(1, 0);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(5, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(3, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(0, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition vérifiée */
		try {
			blockC.hasPos(2, 2);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
			
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		
		Type = 'S';
		blockC.init(Type);

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(0, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(1, 0);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(5, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(3, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(0, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition vérifiée */
		try {
			blockC.hasPos(2, 2);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
			
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		
		Type = 'I';
		blockC.init(Type);

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(0, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(1, 0);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(5, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(3, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(0, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition vérifiée */
		try {
			blockC.hasPos(2, 2);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
	}
	
	@Test
	public void testGetAllPos() {
		BlockService blockC = Factory.createBlock();
		char Type;
		LinkedList<Integer> paire = new LinkedList<Integer>();
		
		Type = 'O';
		blockC.init(Type);
		
		paire.addFirst(1); paire.addLast(1);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
		
		paire.addFirst(1); paire.addLast(2);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
	
		paire.addFirst(2); paire.addLast(1);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
		
		paire.addFirst(2); paire.addLast(2);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
		
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		
		Type = 'L';
		blockC.init(Type);

		paire.addFirst(2); paire.addLast(1);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
		
		paire.addFirst(2); paire.addLast(2);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
	
		paire.addFirst(2); paire.addLast(3);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
		
		paire.addFirst(3); paire.addLast(3);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
		
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}		
		
		
		Type = 'J';
		blockC.init(Type);

		paire.addFirst(1); paire.addLast(3);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
		
		paire.addFirst(2); paire.addLast(1);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
	
		paire.addFirst(2); paire.addLast(2);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
		
		paire.addFirst(2); paire.addLast(3);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
			
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		
		Type = 'T';
		blockC.init(Type);

		paire.addFirst(1); paire.addLast(2);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
		
		paire.addFirst(2); paire.addLast(2);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
	
		paire.addFirst(2); paire.addLast(3);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
		
		paire.addFirst(3); paire.addLast(2);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
	
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		
		Type = 'Z';
		blockC.init(Type);

		paire.addFirst(1); paire.addLast(2);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
		
		paire.addFirst(2); paire.addLast(2);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
	
		paire.addFirst(2); paire.addLast(3);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
		
		paire.addFirst(3); paire.addLast(3);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
	
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		
		Type = 'S';
		blockC.init(Type);

		paire.addFirst(1); paire.addLast(3);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
		
		paire.addFirst(2); paire.addLast(2);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
	
		paire.addFirst(2); paire.addLast(3);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
		
		paire.addFirst(3); paire.addLast(2);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
	
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		
		Type = 'I';
		blockC.init(Type);

		paire.addFirst(2); paire.addLast(1);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
		
		paire.addFirst(2); paire.addLast(2);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
	
		paire.addFirst(2); paire.addLast(3);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
		
		paire.addFirst(2); paire.addLast(4);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
	
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
	}
	
	@Test
	public void testGetLowPos() {
		BlockService blockC = Factory.createBlock();
		char Type;
		LinkedList<Integer> paire = new LinkedList<Integer>();
		
		Type = 'O';
		blockC.init(Type);

		paire.addFirst(1); paire.addLast(2);
		assertTrue(blockC.getLowPos().contains(paire));
		paire.clear();
		
		paire.addFirst(2); paire.addLast(2);
		assertTrue(blockC.getLowPos().contains(paire));
		paire.clear();
		
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		
		Type = 'L';
		blockC.init(Type);

		paire.addFirst(2); paire.addLast(3);
		assertTrue(blockC.getLowPos().contains(paire));
		paire.clear();
		
		paire.addFirst(3); paire.addLast(3);
		assertTrue(blockC.getLowPos().contains(paire));
		paire.clear();
		
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		
		Type = 'J';
		blockC.init(Type);

		paire.addFirst(1); paire.addLast(3);
		assertTrue(blockC.getLowPos().contains(paire));
		paire.clear();
		
		paire.addFirst(2); paire.addLast(3);
		assertTrue(blockC.getLowPos().contains(paire));
		paire.clear();
			
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		
		Type = 'T';
		blockC.init(Type);

		paire.addFirst(1); paire.addLast(2);
		assertTrue(blockC.getLowPos().contains(paire));
		paire.clear();
		
		paire.addFirst(2); paire.addLast(3);
		assertTrue(blockC.getLowPos().contains(paire));
		paire.clear();
		
		paire.addFirst(3); paire.addLast(2);
		assertTrue(blockC.getLowPos().contains(paire));
		paire.clear();
	
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		
		Type = 'Z';
		blockC.init(Type);

		paire.addFirst(1); paire.addLast(2);
		assertTrue(blockC.getLowPos().contains(paire));
		paire.clear();

		paire.addFirst(2); paire.addLast(3);
		assertTrue(blockC.getLowPos().contains(paire));
		paire.clear();
		
		paire.addFirst(3); paire.addLast(3);
		assertTrue(blockC.getLowPos().contains(paire));
		paire.clear();
	
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		
		Type = 'S';
		blockC.init(Type);

		paire.addFirst(1); paire.addLast(3);
		assertTrue(blockC.getLowPos().contains(paire));
		paire.clear();
		
		paire.addFirst(2); paire.addLast(3);
		assertTrue(blockC.getLowPos().contains(paire));
		paire.clear();
		
		paire.addFirst(3); paire.addLast(2);
		assertTrue(blockC.getLowPos().contains(paire));
		paire.clear();
	
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		
		Type = 'I';
		blockC.init(Type);

		paire.addFirst(2); paire.addLast(4);
		assertTrue(blockC.getLowPos().contains(paire));
		paire.clear();
	
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
	}
	
	@Test
	public void testInit() {
		BlockService blockC = Factory.createBlock();
		char Type;
		
		/* Précondition non vérifiée */
		try {
			blockC.init('A');
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		Type = 'O';
		/* Précondition vérifiée */
		try {
			blockC.init(Type);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
	
		/* Invariants */
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == Type);
		
		/* PostCondition 2 */
		assertTrue(blockC.getNbPos() == 4);
		
		
		Type = 'L';
		/* Précondition vérifiée */
		try {
			blockC.init(Type);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
	
		/* Invariants */
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}	
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == Type);
		
		/* PostCondition 2 */
		assertTrue(blockC.getNbPos() == 4);
		
		
		Type = 'J';
		/* Précondition vérifiée */
		try {
			blockC.init(Type);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
	
		/* Invariants */
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == Type);
		
		/* PostCondition 2 */
		assertTrue(blockC.getNbPos() == 4);
		
				
		Type = 'T';
		/* Précondition vérifiée */
		try {
			blockC.init(Type);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
	
		/* Invariants */
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == Type);
		
		/* PostCondition 2 */
		assertTrue(blockC.getNbPos() == 4);
		
		
		Type = 'Z';
		/* Précondition vérifiée */
		try {
			blockC.init(Type);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
	
		/* Invariants */
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == Type);
		
		/* PostCondition 2 */
		assertTrue(blockC.getNbPos() == 4);
		
		
		Type = 'S';
		/* Précondition vérifiée */
		try {
			blockC.init(Type);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
	
		/* Invariants */
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == Type);
		
		/* PostCondition 2 */
		assertTrue(blockC.getNbPos() == 4);
		
		
		Type = 'I';
		/* Précondition vérifiée */
		try {
			blockC.init(Type);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
	
		/* Invariants */
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == Type);
		
		/* PostCondition 2 */
		assertTrue(blockC.getNbPos() == 4);
	}

	@Test
	public void testAddPos() {
		BlockService blockC = Factory.createBlock();
		char Type;
		int getType_atPre;
		int getSize_atPre;
		int getNbPos_atPre;
		int getXMin_atPre, getXMax_atPre, getYMin_atPre, getYMax_atPre;
		boolean[][] hasPos_atPre;
		Set<LinkedList<Integer>> getAllPos_atPre = new HashSet<LinkedList<Integer>>();
		Iterator<LinkedList<Integer>> it;
		LinkedList<Integer> xy = new LinkedList<Integer>();
		int x;
		int y;

		Type = 'O';
		blockC.init(Type);
		blockC.removeAllPos();
		blockC.addPos(2, 2);
		
		/* Précondition non vérifiée */
		try {
			blockC.addPos(0, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}
		
		/* Précondition non vérifiée */
		try {
			blockC.addPos(1, 0);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.addPos(5, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.addPos(3, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.addPos(0, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}
		
		/* Précondition non vérifiée */
		try {
			blockC.addPos(2, 2);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}
		
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		getNbPos_atPre = blockC.getNbPos();
		getXMin_atPre = blockC.getXMin();
		getXMax_atPre = blockC.getXMax();
		getYMin_atPre = blockC.getYMin();
		getYMax_atPre = blockC.getYMax();
		hasPos_atPre = new boolean[blockC.getSize()][blockC.getSize()];
		for(int i=1; i<=blockC.getSize(); i++) {
			for(int j=1; j<=blockC.getSize(); j++) {
				hasPos_atPre[i-1][j-1] = blockC.hasPos(i, j);
			}
		}
		it = blockC.getAllPos().iterator();
		while(it.hasNext()) {
			getAllPos_atPre.add(it.next());
		}
		x = 1;
		y = 1;
		xy.addFirst(x);
		xy.addLast(y);
		
		/* Précondition vérifiée */
		try {
			blockC.addPos(x, y);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
			
		/* Invariants */
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == getNbPos_atPre+1);
		
		/* PostCondition 4 */
		assertTrue((x < getXMin_atPre && blockC.getXMin() == x) || (blockC.getXMin() == getXMin_atPre));
		
		/* PostCondition 5 */
		assertTrue((getXMax_atPre < x && blockC.getXMax() == x) || (blockC.getXMax() == getXMax_atPre));
		
		/* PostCondition 6 */
		assertTrue((y < getYMin_atPre && blockC.getYMin() == y) || (blockC.getYMin() == getYMin_atPre));
		
		/* PostCondition 7 */
		assertTrue((getYMax_atPre < y && blockC.getYMax() == y) || (blockC.getYMax() == getYMax_atPre));
		
		/* PostCondition 8 */
		assertTrue(blockC.hasPos(x, y));
		
		/* PostCondition 9 */
		for(int i=1; i<=blockC.getSize(); i++) {
			for(int j=1; j<=blockC.getSize(); j++) {
				if((i!=x) && (j!=y)) {
					assertTrue(blockC.hasPos(i, j) == hasPos_atPre[i-1][j-1]);
				}
			}
		}
		
		/* PostCondition 10 */
		it = getAllPos_atPre.iterator();
		while(it.hasNext()) {
			assertTrue(blockC.getAllPos().contains(it.next()));
		}
		getAllPos_atPre.clear();
		
		/* PostCondition 11 */
		assertTrue(blockC.getAllPos().contains(xy));
		xy.clear();		
		
		
		Type = 'L';
		blockC.init(Type);
		blockC.removeAllPos();
		blockC.addPos(2, 2);
		
		/* Précondition non vérifiée */
		try {
			blockC.addPos(0, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}
		
		/* Précondition non vérifiée */
		try {
			blockC.addPos(1, 0);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.addPos(5, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.addPos(3, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.addPos(0, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}
		
		/* Précondition non vérifiée */
		try {
			blockC.addPos(2, 2);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}
		
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		getNbPos_atPre = blockC.getNbPos();
		getXMin_atPre = blockC.getXMin();
		getXMax_atPre = blockC.getXMax();
		getYMin_atPre = blockC.getYMin();
		getYMax_atPre = blockC.getYMax();
		hasPos_atPre = new boolean[blockC.getSize()][blockC.getSize()];
		for(int i=1; i<=blockC.getSize(); i++) {
			for(int j=1; j<=blockC.getSize(); j++) {
				hasPos_atPre[i-1][j-1] = blockC.hasPos(i, j);
			}
		}
		it = blockC.getAllPos().iterator();
		while(it.hasNext()) {
			getAllPos_atPre.add(it.next());
		}
		x = 2;
		y = 1;
		xy.addFirst(x);
		xy.addLast(y);
		
		
		/* Précondition vérifiée */
		try {
			blockC.addPos(x, y);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
	
		/* Invariants */
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == getNbPos_atPre+1);
		
		/* PostCondition 4 */
		assertTrue((x < getXMin_atPre && blockC.getXMin() == x) || (blockC.getXMin() == getXMin_atPre));
		
		/* PostCondition 5 */
		assertTrue((getXMax_atPre < x && blockC.getXMax() == x) || (blockC.getXMax() == getXMax_atPre));
		
		/* PostCondition 6 */
		assertTrue((y < getYMin_atPre && blockC.getYMin() == y) || (blockC.getYMin() == getYMin_atPre));
		
		/* PostCondition 7 */
		assertTrue((getYMax_atPre < y && blockC.getYMax() == y) || (blockC.getYMax() == getYMax_atPre));
		
		/* PostCondition 8 */
		assertTrue(blockC.hasPos(x, y));
		
		/* PostCondition 9 */
		for(int i=1; i<=blockC.getSize(); i++) {
			for(int j=1; j<=blockC.getSize(); j++) {
				if((i!=x) && (j!=y)) {
					assertTrue(blockC.hasPos(i, j) == hasPos_atPre[i-1][j-1]);
				}
			}
		}
		
		/* PostCondition 10 */
		it = getAllPos_atPre.iterator();
		while(it.hasNext()) {
			assertTrue(blockC.getAllPos().contains(it.next()));
		}
		getAllPos_atPre.clear();
		
		/* PostCondition 11 */
		assertTrue(blockC.getAllPos().contains(xy));
		xy.clear();
		
		
		Type = 'J';
		blockC.init(Type);
		blockC.removeAllPos();
		blockC.addPos(2, 2);
		
		/* Précondition non vérifiée */
		try {
			blockC.addPos(0, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}
		
		/* Précondition non vérifiée */
		try {
			blockC.addPos(1, 0);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.addPos(5, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.addPos(3, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.addPos(0, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}
		
		/* Précondition non vérifiée */
		try {
			blockC.addPos(2, 2);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}
		
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		getNbPos_atPre = blockC.getNbPos();
		getXMin_atPre = blockC.getXMin();
		getXMax_atPre = blockC.getXMax();
		getYMin_atPre = blockC.getYMin();
		getYMax_atPre = blockC.getYMax();
		hasPos_atPre = new boolean[blockC.getSize()][blockC.getSize()];
		for(int i=1; i<=blockC.getSize(); i++) {
			for(int j=1; j<=blockC.getSize(); j++) {
				hasPos_atPre[i-1][j-1] = blockC.hasPos(i, j);
			}
		}
		it = blockC.getAllPos().iterator();
		while(it.hasNext()) {
			getAllPos_atPre.add(it.next());
		}
		x = 2;
		y = 1;
		xy.addFirst(x);
		xy.addLast(y);
		
		/* Précondition vérifiée */
		try {
			blockC.addPos(x, y);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
	
		/* Invariants */
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == getNbPos_atPre+1);
		
		/* PostCondition 4 */
		assertTrue((x < getXMin_atPre && blockC.getXMin() == x) || (blockC.getXMin() == getXMin_atPre));
		
		/* PostCondition 5 */
		assertTrue((getXMax_atPre < x && blockC.getXMax() == x) || (blockC.getXMax() == getXMax_atPre));
		
		/* PostCondition 6 */
		assertTrue((y < getYMin_atPre && blockC.getYMin() == y) || (blockC.getYMin() == getYMin_atPre));
		
		/* PostCondition 7 */
		assertTrue((getYMax_atPre < y && blockC.getYMax() == y) || (blockC.getYMax() == getYMax_atPre));
		
		/* PostCondition 8 */
		assertTrue(blockC.hasPos(x, y));
		
		/* PostCondition 9 */
		for(int i=1; i<=blockC.getSize(); i++) {
			for(int j=1; j<=blockC.getSize(); j++) {
				if((i!=x) && (j!=y)) {
					assertTrue(blockC.hasPos(i, j) == hasPos_atPre[i-1][j-1]);
				}
			}
		}
		
		/* PostCondition 10 */
		it = getAllPos_atPre.iterator();
		while(it.hasNext()) {
			assertTrue(blockC.getAllPos().contains(it.next()));
		}
		getAllPos_atPre.clear();
		
		/* PostCondition 11 */
		assertTrue(blockC.getAllPos().contains(xy));
		xy.clear();
		
				
		Type = 'T';
		blockC.init(Type);
		blockC.removeAllPos();
		blockC.addPos(2, 2);
		
		/* Précondition non vérifiée */
		try {
			blockC.addPos(0, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}
		
		/* Précondition non vérifiée */
		try {
			blockC.addPos(1, 0);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.addPos(5, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.addPos(3, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.addPos(0, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}
		
		/* Précondition non vérifiée */
		try {
			blockC.addPos(2, 2);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}
		
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		getNbPos_atPre = blockC.getNbPos();
		getXMin_atPre = blockC.getXMin();
		getXMax_atPre = blockC.getXMax();
		getYMin_atPre = blockC.getYMin();
		getYMax_atPre = blockC.getYMax();
		hasPos_atPre = new boolean[blockC.getSize()][blockC.getSize()];
		for(int i=1; i<=blockC.getSize(); i++) {
			for(int j=1; j<=blockC.getSize(); j++) {
				hasPos_atPre[i-1][j-1] = blockC.hasPos(i, j);
			}
		}
		it = blockC.getAllPos().iterator();
		while(it.hasNext()) {
			getAllPos_atPre.add(it.next());
		}
		x = 1;
		y = 2;
		xy.addFirst(x);
		xy.addLast(y);
		
		/* Précondition vérifiée */
		try {
			blockC.addPos(x, y);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
	
		/* Invariants */
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == getNbPos_atPre+1);
		
		/* PostCondition 4 */
		assertTrue((x < getXMin_atPre && blockC.getXMin() == x) || (blockC.getXMin() == getXMin_atPre));
		
		/* PostCondition 5 */
		assertTrue((getXMax_atPre < x && blockC.getXMax() == x) || (blockC.getXMax() == getXMax_atPre));
		
		/* PostCondition 6 */
		assertTrue((y < getYMin_atPre && blockC.getYMin() == y) || (blockC.getYMin() == getYMin_atPre));
		
		/* PostCondition 7 */
		assertTrue((getYMax_atPre < y && blockC.getYMax() == y) || (blockC.getYMax() == getYMax_atPre));
		
		/* PostCondition 8 */
		assertTrue(blockC.hasPos(x, y));
		
		/* PostCondition 9 */
		for(int i=1; i<=blockC.getSize(); i++) {
			for(int j=1; j<=blockC.getSize(); j++) {
				if((i!=x) && (j!=y)) {
					assertTrue(blockC.hasPos(i, j) == hasPos_atPre[i-1][j-1]);
				}
			}
		}
		
		/* PostCondition 10 */
		it = getAllPos_atPre.iterator();
		while(it.hasNext()) {
			assertTrue(blockC.getAllPos().contains(it.next()));
		}
		getAllPos_atPre.clear();
		
		/* PostCondition 11 */
		assertTrue(blockC.getAllPos().contains(xy));
		xy.clear();
		
		
		Type = 'Z';
		blockC.init(Type);
		blockC.removeAllPos();
		blockC.addPos(2, 2);
		
		/* Précondition non vérifiée */
		try {
			blockC.addPos(0, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}
		
		/* Précondition non vérifiée */
		try {
			blockC.addPos(1, 0);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.addPos(5, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.addPos(3, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.addPos(0, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}
		
		/* Précondition non vérifiée */
		try {
			blockC.addPos(2, 2);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}
		
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		getNbPos_atPre = blockC.getNbPos();
		getXMin_atPre = blockC.getXMin();
		getXMax_atPre = blockC.getXMax();
		getYMin_atPre = blockC.getYMin();
		getYMax_atPre = blockC.getYMax();
		hasPos_atPre = new boolean[blockC.getSize()][blockC.getSize()];
		for(int i=1; i<=blockC.getSize(); i++) {
			for(int j=1; j<=blockC.getSize(); j++) {
				hasPos_atPre[i-1][j-1] = blockC.hasPos(i, j);
			}
		}
		it = blockC.getAllPos().iterator();
		while(it.hasNext()) {
			getAllPos_atPre.add(it.next());
		}
		x = 1;
		y = 2;
		xy.addFirst(x);
		xy.addLast(y);
		
		/* Précondition vérifiée */
		try {
			blockC.addPos(x, y);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
	
		/* Invariants */
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == getNbPos_atPre+1);
		
		/* PostCondition 4 */
		assertTrue((x < getXMin_atPre && blockC.getXMin() == x) || (blockC.getXMin() == getXMin_atPre));
		
		/* PostCondition 5 */
		assertTrue((getXMax_atPre < x && blockC.getXMax() == x) || (blockC.getXMax() == getXMax_atPre));
		
		/* PostCondition 6 */
		assertTrue((y < getYMin_atPre && blockC.getYMin() == y) || (blockC.getYMin() == getYMin_atPre));
		
		/* PostCondition 7 */
		assertTrue((getYMax_atPre < y && blockC.getYMax() == y) || (blockC.getYMax() == getYMax_atPre));
		
		/* PostCondition 8 */
		assertTrue(blockC.hasPos(x, y));
		
		/* PostCondition 9 */
		for(int i=1; i<=blockC.getSize(); i++) {
			for(int j=1; j<=blockC.getSize(); j++) {
				if((i!=x) && (j!=y)) {
					assertTrue(blockC.hasPos(i, j) == hasPos_atPre[i-1][j-1]);
				}
			}
		}
		
		/* PostCondition 10 */
		it = getAllPos_atPre.iterator();
		while(it.hasNext()) {
			assertTrue(blockC.getAllPos().contains(it.next()));
		}
		getAllPos_atPre.clear();
		
		/* PostCondition 11 */
		assertTrue(blockC.getAllPos().contains(xy));
		xy.clear();
		
		
		Type = 'S';
		blockC.init(Type);
		blockC.removeAllPos();
		blockC.addPos(2, 2);
		
		/* Précondition non vérifiée */
		try {
			blockC.addPos(0, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}
		
		/* Précondition non vérifiée */
		try {
			blockC.addPos(1, 0);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.addPos(5, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.addPos(3, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.addPos(0, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}
		
		/* Précondition non vérifiée */
		try {
			blockC.addPos(2, 2);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}
		
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		getNbPos_atPre = blockC.getNbPos();
		getXMin_atPre = blockC.getXMin();
		getXMax_atPre = blockC.getXMax();
		getYMin_atPre = blockC.getYMin();
		getYMax_atPre = blockC.getYMax();
		hasPos_atPre = new boolean[blockC.getSize()][blockC.getSize()];
		for(int i=1; i<=blockC.getSize(); i++) {
			for(int j=1; j<=blockC.getSize(); j++) {
				hasPos_atPre[i-1][j-1] = blockC.hasPos(i, j);
			}
		}
		it = blockC.getAllPos().iterator();
		while(it.hasNext()) {
			getAllPos_atPre.add(it.next());
		}
		x = 1;
		y = 3;
		xy.addFirst(x);
		xy.addLast(y);
		
		/* Précondition vérifiée */
		try {
			blockC.addPos(x, y);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
	
		/* Invariants */
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == getNbPos_atPre+1);
		
		/* PostCondition 4 */
		assertTrue((x < getXMin_atPre && blockC.getXMin() == x) || (blockC.getXMin() == getXMin_atPre));
		
		/* PostCondition 5 */
		assertTrue((getXMax_atPre < x && blockC.getXMax() == x) || (blockC.getXMax() == getXMax_atPre));
		
		/* PostCondition 6 */
		assertTrue((y < getYMin_atPre && blockC.getYMin() == y) || (blockC.getYMin() == getYMin_atPre));
		
		/* PostCondition 7 */
		assertTrue((getYMax_atPre < y && blockC.getYMax() == y) || (blockC.getYMax() == getYMax_atPre));
		
		/* PostCondition 8 */
		assertTrue(blockC.hasPos(x, y));
		
		/* PostCondition 9 */
		for(int i=1; i<=blockC.getSize(); i++) {
			for(int j=1; j<=blockC.getSize(); j++) {
				if((i!=x) && (j!=y)) {
					assertTrue(blockC.hasPos(i, j) == hasPos_atPre[i-1][j-1]);
				}
			}
		}
		
		/* PostCondition 10 */
		it = getAllPos_atPre.iterator();
		while(it.hasNext()) {
			assertTrue(blockC.getAllPos().contains(it.next()));
		}
		getAllPos_atPre.clear();
		
		/* PostCondition 11 */
		assertTrue(blockC.getAllPos().contains(xy));
		xy.clear();
		
		
		Type = 'I';
		blockC.init(Type);
		blockC.removeAllPos();
		blockC.addPos(2, 2);
		
		/* Précondition non vérifiée */
		try {
			blockC.addPos(0, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}
		
		/* Précondition non vérifiée */
		try {
			blockC.addPos(1, 0);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.addPos(5, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.addPos(3, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.addPos(0, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}
		
		/* Précondition non vérifiée */
		try {
			blockC.addPos(2, 2);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}
		
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		getNbPos_atPre = blockC.getNbPos();
		getXMin_atPre = blockC.getXMin();
		getXMax_atPre = blockC.getXMax();
		getYMin_atPre = blockC.getYMin();
		getYMax_atPre = blockC.getYMax();
		hasPos_atPre = new boolean[blockC.getSize()][blockC.getSize()];
		for(int i=1; i<=blockC.getSize(); i++) {
			for(int j=1; j<=blockC.getSize(); j++) {
				hasPos_atPre[i-1][j-1] = blockC.hasPos(i, j);
			}
		}
		it = blockC.getAllPos().iterator();
		while(it.hasNext()) {
			getAllPos_atPre.add(it.next());
		}
		x = 2;
		y = 1;
		xy.addFirst(x);
		xy.addLast(y);
		
		/* Précondition vérifiée */
		try {
			blockC.addPos(x, y);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
	
		/* Invariants */
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == getNbPos_atPre+1);
		
		/* PostCondition 4 */
		assertTrue((x < getXMin_atPre && blockC.getXMin() == x) || (blockC.getXMin() == getXMin_atPre));
		
		/* PostCondition 5 */
		assertTrue((getXMax_atPre < x && blockC.getXMax() == x) || (blockC.getXMax() == getXMax_atPre));
		
		/* PostCondition 6 */
		assertTrue((y < getYMin_atPre && blockC.getYMin() == y) || (blockC.getYMin() == getYMin_atPre));
		
		/* PostCondition 7 */
		assertTrue((getYMax_atPre < y && blockC.getYMax() == y) || (blockC.getYMax() == getYMax_atPre));
		
		/* PostCondition 8 */
		assertTrue(blockC.hasPos(x, y));
		
		/* PostCondition 9 */
		for(int i=1; i<=blockC.getSize(); i++) {
			for(int j=1; j<=blockC.getSize(); j++) {
				if((i!=x) && (j!=y)) {
					assertTrue(blockC.hasPos(i, j) == hasPos_atPre[i-1][j-1]);
				}
			}
		}
		
		/* PostCondition 10 */
		it = getAllPos_atPre.iterator();
		while(it.hasNext()) {
			assertTrue(blockC.getAllPos().contains(it.next()));
		}
		getAllPos_atPre.clear();
		
		/* PostCondition 11 */
		assertTrue(blockC.getAllPos().contains(xy));
		xy.clear();
	}
	
	@Test
	public void testRemoveAllPos() {
		BlockService blockC = Factory.createBlock();
		char Type;
		int getType_atPre;
		int getSize_atPre;

		Type = 'O';
		blockC.init(Type);
				
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		
		blockC.removeAllPos();
					
		/* Invariants */
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == 0);
		
		/* PostCondition 4 */
		assertTrue(blockC.getXMin() == blockC.getSize()+1);
		
		/* PostCondition 5 */
		assertTrue(blockC.getXMax() == 0);
		
		/* PostCondition 6 */
		assertTrue(blockC.getYMin() == blockC.getSize()+1);
		
		/* PostCondition 7 */
		assertTrue(blockC.getYMax() == 0);
		
		/* PostCondition 8 */
		for(int i=1; i<=blockC.getSize(); i++) {
			for(int j=1; j<=blockC.getSize(); j++) {
				assertTrue(!blockC.hasPos(i, j));
			}
		}
		
		/* PostCondition 9 */
		assertTrue(blockC.getAllPos().isEmpty());
		
		/* PostCondition 10 */
		assertTrue(blockC.getLowPos().isEmpty());
		
		
		Type = 'L';
		blockC.init(Type);
				
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		
		blockC.removeAllPos();
			
		/* Invariants */
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == 0);
		
		/* PostCondition 4 */
		assertTrue(blockC.getXMin() == blockC.getSize()+1);
		
		/* PostCondition 5 */
		assertTrue(blockC.getXMax() == 0);
		
		/* PostCondition 6 */
		assertTrue(blockC.getYMin() == blockC.getSize()+1);
		
		/* PostCondition 7 */
		assertTrue(blockC.getYMax() == 0);
		
		/* PostCondition 8 */
		for(int i=1; i<=blockC.getSize(); i++) {
			for(int j=1; j<=blockC.getSize(); j++) {
				assertTrue(!blockC.hasPos(i, j));
			}
		}
		
		/* PostCondition 9 */
		assertTrue(blockC.getAllPos().isEmpty());
		
		/* PostCondition 10 */
		assertTrue(blockC.getLowPos().isEmpty());
				
		
		Type = 'J';
		blockC.init(Type);
						
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		
		blockC.removeAllPos();
			
		/* Invariants */
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == 0);
		
		/* PostCondition 4 */
		assertTrue(blockC.getXMin() == blockC.getSize()+1);
		
		/* PostCondition 5 */
		assertTrue(blockC.getXMax() == 0);
		
		/* PostCondition 6 */
		assertTrue(blockC.getYMin() == blockC.getSize()+1);
		
		/* PostCondition 7 */
		assertTrue(blockC.getYMax() == 0);
		
		/* PostCondition 8 */
		for(int i=1; i<=blockC.getSize(); i++) {
			for(int j=1; j<=blockC.getSize(); j++) {
				assertTrue(!blockC.hasPos(i, j));
			}
		}
		
		/* PostCondition 9 */
		assertTrue(blockC.getAllPos().isEmpty());
		
		/* PostCondition 10 */
		assertTrue(blockC.getLowPos().isEmpty());
		
				
		Type = 'T';
		blockC.init(Type);
				
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		
		blockC.removeAllPos();
			
		/* Invariants */
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == 0);
		
		/* PostCondition 4 */
		assertTrue(blockC.getXMin() == blockC.getSize()+1);
		
		/* PostCondition 5 */
		assertTrue(blockC.getXMax() == 0);
		
		/* PostCondition 6 */
		assertTrue(blockC.getYMin() == blockC.getSize()+1);
		
		/* PostCondition 7 */
		assertTrue(blockC.getYMax() == 0);
		
		/* PostCondition 8 */
		for(int i=1; i<=blockC.getSize(); i++) {
			for(int j=1; j<=blockC.getSize(); j++) {
				assertTrue(!blockC.hasPos(i, j));
			}
		}
		
		/* PostCondition 9 */
		assertTrue(blockC.getAllPos().isEmpty());
		
		/* PostCondition 10 */
		assertTrue(blockC.getLowPos().isEmpty());
		
		
		Type = 'Z';
		blockC.init(Type);
					
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		
		blockC.removeAllPos();
			
		/* Invariants */
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == 0);
		
		/* PostCondition 4 */
		assertTrue(blockC.getXMin() == blockC.getSize()+1);
		
		/* PostCondition 5 */
		assertTrue(blockC.getXMax() == 0);
		
		/* PostCondition 6 */
		assertTrue(blockC.getYMin() == blockC.getSize()+1);
		
		/* PostCondition 7 */
		assertTrue(blockC.getYMax() == 0);
		
		/* PostCondition 8 */
		for(int i=1; i<=blockC.getSize(); i++) {
			for(int j=1; j<=blockC.getSize(); j++) {
				assertTrue(!blockC.hasPos(i, j));
			}
		}
		
		/* PostCondition 9 */
		assertTrue(blockC.getAllPos().isEmpty());
		
		/* PostCondition 10 */
		assertTrue(blockC.getLowPos().isEmpty());
		
		
		Type = 'S';
		blockC.init(Type);
				
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		
		blockC.removeAllPos();
			
		/* Invariants */
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == 0);
		
		/* PostCondition 4 */
		assertTrue(blockC.getXMin() == blockC.getSize()+1);
		
		/* PostCondition 5 */
		assertTrue(blockC.getXMax() == 0);
		
		/* PostCondition 6 */
		assertTrue(blockC.getYMin() == blockC.getSize()+1);
		
		/* PostCondition 7 */
		assertTrue(blockC.getYMax() == 0);
		
		/* PostCondition 8 */
		for(int i=1; i<=blockC.getSize(); i++) {
			for(int j=1; j<=blockC.getSize(); j++) {
				assertTrue(!blockC.hasPos(i, j));
			}
		}
		
		/* PostCondition 9 */
		assertTrue(blockC.getAllPos().isEmpty());
		
		/* PostCondition 10 */
		assertTrue(blockC.getLowPos().isEmpty());
		
		
		Type = 'I';
		blockC.init(Type);
				
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		
		blockC.removeAllPos();
			
		/* Invariants */
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == 0);
		
		/* PostCondition 4 */
		assertTrue(blockC.getXMin() == blockC.getSize()+1);
		
		/* PostCondition 5 */
		assertTrue(blockC.getXMax() == 0);
		
		/* PostCondition 6 */
		assertTrue(blockC.getYMin() == blockC.getSize()+1);
		
		/* PostCondition 7 */
		assertTrue(blockC.getYMax() == 0);
		
		/* PostCondition 8 */
		for(int i=1; i<=blockC.getSize(); i++) {
			for(int j=1; j<=blockC.getSize(); j++) {
				assertTrue(!blockC.hasPos(i, j));
			}
		}
		
		/* PostCondition 9 */
		assertTrue(blockC.getAllPos().isEmpty());
		
		/* PostCondition 10 */
		assertTrue(blockC.getLowPos().isEmpty());		
	}

	@Test
	public void testRotateLeft() {
		BlockService blockC = Factory.createBlock();
		char Type;
		int getType_atPre;
		int getSize_atPre;
		int getNbPos_atPre;

		Type = 'O';
		blockC.init(Type);
				
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		getNbPos_atPre = blockC.getNbPos();
		
		blockC.rotateLeft();
			
		/* Invariants */
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == getNbPos_atPre);
		
		
		Type = 'L';
		blockC.init(Type);
				
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		getNbPos_atPre = blockC.getNbPos();
		
		blockC.rotateLeft();
			
		/* Invariants */
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == getNbPos_atPre);
				
		
		Type = 'J';
		blockC.init(Type);
						
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		getNbPos_atPre = blockC.getNbPos();
		
		blockC.rotateLeft();
			
		/* Invariants */
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == getNbPos_atPre);
		
				
		Type = 'T';
		blockC.init(Type);
				
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		getNbPos_atPre = blockC.getNbPos();
		
		blockC.rotateLeft();
			
		/* Invariants */
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == getNbPos_atPre);
		
		
		Type = 'Z';
		blockC.init(Type);
					
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		getNbPos_atPre = blockC.getNbPos();
		
		blockC.rotateLeft();
			
		/* Invariants */
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == getNbPos_atPre);
		
		
		Type = 'S';
		blockC.init(Type);
				
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		getNbPos_atPre = blockC.getNbPos();
		
		blockC.rotateLeft();
			
		/* Invariants */
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == getNbPos_atPre);
		
		
		Type = 'I';
		blockC.init(Type);
				
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		getNbPos_atPre = blockC.getNbPos();
		
		blockC.rotateLeft();
			
		/* Invariants */
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == getNbPos_atPre);		
	}
	
	@Test
	public void testRotateRight() {
		BlockService blockC = Factory.createBlock();
		char Type;
		int getType_atPre;
		int getSize_atPre;
		int getNbPos_atPre;

		Type = 'O';
		blockC.init(Type);
				
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		getNbPos_atPre = blockC.getNbPos();
		
		blockC.rotateRight();
			
		/* Invariants */
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == getNbPos_atPre);
		
		Type = 'L';
		blockC.init(Type);
				
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		getNbPos_atPre = blockC.getNbPos();
		
		blockC.rotateRight();
			
		/* Invariants */
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == getNbPos_atPre);
				
		
		Type = 'J';
		blockC.init(Type);
						
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		getNbPos_atPre = blockC.getNbPos();
		
		blockC.rotateRight();
			
		/* Invariants */
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == getNbPos_atPre);
		
				
		Type = 'T';
		blockC.init(Type);
				
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		getNbPos_atPre = blockC.getNbPos();
		
		blockC.rotateRight();
			
		/* Invariants */
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == getNbPos_atPre);
		
		
		Type = 'Z';
		blockC.init(Type);
					
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		getNbPos_atPre = blockC.getNbPos();
		
		blockC.rotateRight();
			
		/* Invariants */
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == getNbPos_atPre);
		
		
		Type = 'S';
		blockC.init(Type);
				
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		getNbPos_atPre = blockC.getNbPos();
		
		blockC.rotateRight();
			
		/* Invariants */
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == getNbPos_atPre);
		
		
		Type = 'I';
		blockC.init(Type);
				
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		getNbPos_atPre = blockC.getNbPos();
		
		blockC.rotateRight();
			
		/* Invariants */
		try {
			((BlockContract) blockC).checkInvariants();
			assertTrue(true);
		} catch (Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == getNbPos_atPre);		
	}
}
