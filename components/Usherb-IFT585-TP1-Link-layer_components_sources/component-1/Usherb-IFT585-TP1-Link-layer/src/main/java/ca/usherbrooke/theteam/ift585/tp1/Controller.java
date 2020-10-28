/**
 * TP1 - IFT585
 * @authors The Team : Benjamin Boudreau (08 318 402), Jean-François Ste-Marie, Jules Deliste, Nicolas Guimier
 */
package ca.usherbrooke.theteam.ift585.tp1;

import ca.usherbrooke.theteam.ift585.tp1.protocol.Receiver;
import ca.usherbrooke.theteam.ift585.tp1.protocol.Transmitter;
import org.apache.log4j.Logger;

/**
 * Class that handles one transmitter and one receiver (with one buffer each).
 * Briefly, an emulation of a network adapter.
 * @author Jules
 */
public class Controller {

	private static Logger log = Logger.getLogger(Controller.class);
	public String name;
	private int latestGuestAck = -1;
	private int nakSeq = -1;
	private Transmitter transmitter;
	private Receiver receiver;

	/**
	 * Object constructor.
	 */
	public Controller(String name, Transmitter transmitter, Receiver receiver) {
		this.name = name;
		this.transmitter = transmitter;
		this.receiver = receiver;

		transmitter.setController(this);
		receiver.setController(this);
		transmitter.start();
		receiver.start();
	}

	public void setLatestGuestAck(int latestGuestAck) {
		this.latestGuestAck = latestGuestAck;


	}

	public int getLatestGuestAck() {
		return latestGuestAck;


	}

	public void setNakSeq(int nakSeq) {
		this.nakSeq = nakSeq;


	}

	public int getNakSeq() {
		return nakSeq;

	}

	/**
	 * @return the transmitter
	 */
	public Transmitter getTransmitter() {
		return transmitter;
	}

	/**
	 * @param transmitter the transmitter to set
	 */
	public void setTransmitter(Transmitter transmitter) {
		this.transmitter = transmitter;
	}

	/**
	 * @return the receiver
	 */
	public Receiver getReceiver() {
		return receiver;
	}

	/**
	 * @param receiver the receiver to set
	 */
	public void setReceiver(Receiver receiver) {
		this.receiver = receiver;
	}
}
