/**
 * TP1 - IFT585
 * @authors The Team : Benjamin Boudreau (08 318 402), Jean-François Ste-Marie, Jules Deliste, Nicolas Guimier
 */
package ca.usherbrooke.theteam.ift585.tp1;

import ca.usherbrooke.theteam.ift585.tp1.enums.TrameKind;

/**
 * Class representing a trame object.
 */
public class Trame {
	// Properties

	public Controller controller;
	public String contenu;
	public TrameKind kind;
	public int seq;
	public int ack;

	public Trame(Controller controller, String contenu, TrameKind kind, int seq) {
		this.controller = controller;
		this.contenu = contenu;
		this.kind = kind;
		this.seq = seq;
	}

	public Trame(Controller controller, String contenu, TrameKind kind, int seq, int ack) {
		this.controller = controller;
		this.contenu = contenu;
		this.kind = kind;
		this.seq = seq;
		this.ack = ack;
	}
}
