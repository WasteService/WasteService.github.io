package joueur;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import programme.Factory;

import tetris.TetrisService;

public class JoueurTest {
	
	public void checkInvariants(JoueurService joueur) {
		// inv : getTetris() != null
		if(!(joueur.getTetris() != null)) {
			throw new Error("Invariant invalide");
		}
	}
	
	@Test
	public void testGetTetris() {
		JoueurService joueur = Factory.createJoueur();
		joueur.init();
		try {
			joueur.getTetris();
			assertTrue(true);
		}  catch(Error err) {
			assertTrue(true);
		}
		
		/* Invariants */
		try {
			checkInvariants((JoueurContract) joueur);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
	}
	
	@Test
	public void testInit() {
		JoueurService joueur = Factory.createJoueur();
		try {
			joueur.init();
			assertTrue(true);
		}  catch(Error err) {
			assertTrue(true);
		}
		
		/* Invariants */
		try {
			checkInvariants((JoueurContract) joueur);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
	}
	
	@Test
	public void testGoLeft() {
		JoueurService joueur = Factory.createJoueur();
		joueur.init();
		joueur.getTetris().init();
		joueur.getTetris().next();
		
		/* Captures */
		TetrisService getTetris_atPre = joueur.getTetris();
		
		try {
			joueur.goLeft();
			assertTrue(true);
		}  catch(Error err) {
			assertTrue(true);
		}
		
		/* Invariants */
		try {
			checkInvariants((JoueurContract) joueur);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* PostCondition */
		assertTrue(joueur.getTetris() == getTetris_atPre);
	}
	
	@Test
	public void testGoRight() {
		JoueurService joueur = Factory.createJoueur();
		joueur.init();
		joueur.getTetris().init();
		joueur.getTetris().next();
		
		/* Captures */
		TetrisService getTetris_atPre = joueur.getTetris();
		
		try {
			joueur.goRight();
			assertTrue(true);
		}  catch(Error err) {
			assertTrue(true);
		}
		
		/* Invariants */
		try {
			checkInvariants(joueur);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* PostCondition */
		assertTrue(joueur.getTetris() == getTetris_atPre);
	}
	
	@Test
	public void testGoDown() {
		JoueurService joueur = Factory.createJoueur();
		joueur.init();
		joueur.getTetris().init();
		joueur.getTetris().next();
		
		/* Captures */
		TetrisService getTetris_atPre = joueur.getTetris();
		
		try {
			joueur.goDown();
			assertTrue(true);
		}  catch(Error err) {
			assertTrue(true);
		}
		
		/* Invariants */
		try {
			checkInvariants((JoueurContract) joueur);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* PostCondition */
		assertTrue(joueur.getTetris() == getTetris_atPre);
	}
	
	@Test
	public void testRotateLeft() {
		JoueurService joueur = Factory.createJoueur();
		joueur.init();
		
		/* Captures */
		TetrisService getTetris_atPre = joueur.getTetris();
		
		try {
			joueur.rotateLeft();
			assertTrue(true);
		}  catch(Error err) {
			assertTrue(true);
		}
		
		/* Invariants */
		try {
			checkInvariants((JoueurContract) joueur);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* PostCondition */
		assertTrue(joueur.getTetris() == getTetris_atPre);
	}
	
	@Test
	public void testRotateRight() {
		JoueurService joueur = Factory.createJoueur();
		joueur.init();
		
		/* Captures */
		TetrisService getTetris_atPre = joueur.getTetris();
		
		try {
			joueur.rotateRight();
			assertTrue(true);
		}  catch(Error err) {
			assertTrue(true);
		}
		
		/* Invariants */
		try {
			checkInvariants((JoueurContract) joueur);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* PostCondition */
		assertTrue(joueur.getTetris() == getTetris_atPre);
	}
	
}
