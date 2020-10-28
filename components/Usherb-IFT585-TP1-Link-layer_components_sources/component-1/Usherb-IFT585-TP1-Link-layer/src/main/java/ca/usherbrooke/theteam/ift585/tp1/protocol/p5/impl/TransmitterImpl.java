/**
 * TP1 - IFT585
 * @authors The Team : Benjamin Boudreau (08 318 402), Jean-François Ste-Marie, Jules Deliste, Nicolas Guimier
 */
package ca.usherbrooke.theteam.ift585.tp1.protocol.p5.impl;

import ca.usherbrooke.theteam.ift585.tp1.Console;
import ca.usherbrooke.theteam.ift585.tp1.Tampon;
import ca.usherbrooke.theteam.ift585.tp1.Trame;
import ca.usherbrooke.theteam.ift585.tp1.enums.CommunicationType;
import ca.usherbrooke.theteam.ift585.tp1.enums.TrameKind;
import ca.usherbrooke.theteam.ift585.tp1.protocol.Transmitter;
import ca.usherbrooke.theteam.ift585.tp1.validation.IValidationAlgorithm;
import org.apache.log4j.Logger;

/**
 * Class that emulates the transmission of trames using the Global Rejection algorithm.
 * @author Jules
 */
public class TransmitterImpl extends Transmitter {

	private static Logger log = Logger.getLogger(TransmitterImpl.class);

	/**
	 * Object constructor.
	 */
	public TransmitterImpl(Tampon tamponTransmitter, String file, int timeout, IValidationAlgorithm errorAlgo) {
		super(tamponTransmitter, file, timeout, errorAlgo);
	}

	@Override
	public void run() {
		// The current sequence to transmit
		int currentSeq = 0;

		// While we haven't transmitted all trames
		while (currentSeq < getTramesHashMap().size()) {

			// Check if we are timing out
			if (currentSeq - getController().getLatestGuestAck() > getTimeout()) {
				int newSeq = getController().getLatestGuestAck() + 1;

				// Log timeout event
				Console.getInstance().logTimeout(getController().name, currentSeq, newSeq);

				// Return to latest guest ACK
				currentSeq = newSeq;
			}

			// Transmit the trame
			transmit(new Trame(getController(), getTramesHashMap().get(currentSeq), TrameKind.Data, currentSeq++));
		}
		try {
			sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Transmits a trame to the physical layer.
	 * Logs information about the trame being sent.
	 * @param trame The trame to send.
	 */
	@Override
	public void transmit(Trame trame) {
		// If trame is null
		if (trame == null) {
			throw new IllegalArgumentException("Trame can't be null.");
		}

		Console.getInstance().logTXRX(CommunicationType.TX, getController(), trame.kind, trame);

		if (trame.kind == TrameKind.Data) {
			try {
				trame.contenu = getErrorAlgo().encode(trame.contenu);
			} catch (Exception ex) {

				log.error(ex.getMessage());
				return;
			}
		}

		getTampon().toPhysicalLayer(trame);

		if (trame.kind == TrameKind.Data) {
			Console.getInstance().logEncoded(CommunicationType.TX, getController().name, trame);
		}
	}
}
