/**
 * TP1 - IFT585
 * @authors The Team : Benjamin Boudreau (08 318 402), Jean-François Ste-Marie, Jules Deliste, Nicolas Guimier
 */
package ca.usherbrooke.theteam.ift585.tp1.protocol.p5.impl;

import ca.usherbrooke.theteam.ift585.tp1.Console;
import ca.usherbrooke.theteam.ift585.tp1.Controller;
import ca.usherbrooke.theteam.ift585.tp1.Tampon;
import ca.usherbrooke.theteam.ift585.tp1.Trame;
import ca.usherbrooke.theteam.ift585.tp1.enums.CommunicationType;
import ca.usherbrooke.theteam.ift585.tp1.enums.TrameKind;
import ca.usherbrooke.theteam.ift585.tp1.protocol.Receiver;
import ca.usherbrooke.theteam.ift585.tp1.validation.IValidationAlgorithm;
import org.apache.log4j.Logger;

/**
 * Class that emulates the reception of trames using the Global Rejection algorithm.
 * @author Jules
 */
public class ReceiverImpl extends Receiver {

	private static Logger log = Logger.getLogger(ReceiverImpl.class);

	/**
	 * Object constructor.
	 */
	public ReceiverImpl(Tampon tamponReceiver, IValidationAlgorithm errorAlgo) {
		super(tamponReceiver, errorAlgo);
	}

	@Override
	public void run() {
		// The current expected sequence to receive
		int expectedSeq = 0;

		while (true) { // forever
			// Receive a trame
			Trame trame = receive();

			switch (trame.kind) {
				case Data:
					// Check if trame seq is being expected
					if (trame.seq != expectedSeq) {
						Console.getInstance().logUnexpected(getController().name, trame.seq, expectedSeq);
						continue;
					} // if seq is expectedSeq

					// Validate trame content
					try {
						if (!errorAlgo.validate(trame.contenu)) {
							continue;
						}
					} catch (Exception e) {
						log.error(e.getMessage());
						return;
					}
					try {
						trame.contenu = getErrorAlgo().decode(trame.contenu);
					} catch (Exception ex) {
						log.error(ex.getMessage());
						return;
					}

					Console.getInstance().logEncoded(CommunicationType.RX, getController().name, trame);

					// Increase expected seq
					expectedSeq++;

					// Transmit an ACK seq
					getController().getTransmitter().transmit(new Trame(getController(), "", TrameKind.Ack, trame.seq));
					break;
				case Ack:
					getController().setLatestGuestAck(trame.seq);
					break;
				default:
					break;
			}
			try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
