/**
 * TP1 - IFT585
 * @authors The Team : Benjamin Boudreau (08 318 402), Jean-François Ste-Marie, Jules Deliste, Nicolas Guimier
 */
package ca.usherbrooke.theteam.ift585.tp1.protocol;

import ca.usherbrooke.theteam.ift585.tp1.Console;
import ca.usherbrooke.theteam.ift585.tp1.Controller;
import ca.usherbrooke.theteam.ift585.tp1.Tampon;
import ca.usherbrooke.theteam.ift585.tp1.Trame;
import ca.usherbrooke.theteam.ift585.tp1.enums.CommunicationType;
import ca.usherbrooke.theteam.ift585.tp1.validation.IValidationAlgorithm;

/**
 *
 * @author benjamin
 */
public abstract class Receiver extends Thread {

	protected Controller controller;
	protected Tampon tampon;
	protected IValidationAlgorithm errorAlgo;

	public Receiver(Tampon tamponReceiver, IValidationAlgorithm errorAlgo) {
		this.tampon = tamponReceiver;
		this.errorAlgo = errorAlgo;
	}

	/**
	 * Receves a trame from the physical layer.
	 * Logs information about the trame being received.
	 * @return The trame being received.
	 */
	protected Trame receive() {
		Trame trame = getTampon().fromPhysicalLayer();

		Console.getInstance().logTXRX(CommunicationType.RX, getController(), trame.kind, trame);

		return trame;
	}

	/**
	 * @return the controller
	 */
	public Controller getController() {
		return controller;
	}

	/**
	 * @param controller the controller to set
	 */
	public void setController(Controller controller) {
		this.controller = controller;
	}

	/**
	 * @return the tampon
	 */
	public Tampon getTampon() {
		return tampon;
	}

	/**
	 * @param tampon the tampon to set
	 */
	public void setTampon(Tampon tampon) {
		this.tampon = tampon;
	}

	/**
	 * @return the errorAlgo
	 */
	public IValidationAlgorithm getErrorAlgo() {
		return errorAlgo;
	}

	/**
	 * @param errorAlgo the errorAlgo to set
	 */
	public void setErrorAlgo(IValidationAlgorithm errorAlgo) {
		this.errorAlgo = errorAlgo;
	}
}
