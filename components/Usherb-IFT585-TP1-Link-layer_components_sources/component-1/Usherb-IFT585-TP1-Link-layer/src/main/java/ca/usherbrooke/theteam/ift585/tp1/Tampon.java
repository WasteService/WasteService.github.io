/**
 * TP1 - IFT585
 * @authors The Team : Benjamin Boudreau (08 318 402), Jean-François Ste-Marie, Jules Deliste, Nicolas Guimier
 */
package ca.usherbrooke.theteam.ift585.tp1;

/**
 *
 * @author Belkacem
 */
public class Tampon extends Thread {

	private Trame trame = null;
	private boolean available = false;
	static private int count = 0;

	public synchronized Trame fromPhysicalLayer() {
		while (available == false) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		available = false;
		notifyAll();
		if (count == 2) {
			String s = trame.contenu;
			trame.contenu = s.replaceFirst("0", "1");
			count = 0;
		}

		return trame;
	}

	public synchronized void toPhysicalLayer(Trame val) {
		while (available == true) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		trame = val;
		count = count + 1;
		available = true;
		notifyAll();
	}
}
