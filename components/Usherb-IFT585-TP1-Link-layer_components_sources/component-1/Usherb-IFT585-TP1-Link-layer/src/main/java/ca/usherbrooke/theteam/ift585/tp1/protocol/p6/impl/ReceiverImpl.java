/**
 * TP1 - IFT585
 * @authors The Team : Benjamin Boudreau (08 318 402), Jean-François Ste-Marie, Jules Deliste, Nicolas Guimier
 */
package ca.usherbrooke.theteam.ift585.tp1.protocol.p6.impl;

import ca.usherbrooke.theteam.ift585.tp1.*;
import ca.usherbrooke.theteam.ift585.tp1.enums.*;
import ca.usherbrooke.theteam.ift585.tp1.protocol.Receiver;
import ca.usherbrooke.theteam.ift585.tp1.validation.IValidationAlgorithm;
import java.util.HashMap;
import org.apache.log4j.Logger;

/**
 * Class that emulates the reception of trames using the Selective Rejection algorithm.
 * @author Jules
 */
public class ReceiverImpl extends Receiver {

	private static Logger log = Logger.getLogger(ReceiverImpl.class);
	private HashMap<Integer, Trame> linkBuffer;

	/**
	 * Object constructor.
	 */
	public ReceiverImpl(Tampon tamponReceiver, IValidationAlgorithm errorAlgo) {
		super(tamponReceiver, errorAlgo);
		this.linkBuffer = new HashMap<Integer, Trame>();
	}

	@Override
	public void run() {
		// The current expected sequence to receive
		int expectedSeq = 0;
		int latestHostAck = 0;

		while (true) { // forever
			Trame trame = null;
			// Check if expected seq is in buffer
			if (linkBuffer.containsKey(expectedSeq)) {
				trame = linkBuffer.get(expectedSeq);
				linkBuffer.remove(expectedSeq);
			} else {
				// Receive a trame
				trame = receive();
			}

			switch (trame.kind) {
				case Data:
					// If trame seq is unexpected
					if (trame.seq != expectedSeq) {
						// Put trame in buffer
						linkBuffer.put(trame.seq, trame);

						// Transmit latest sequential ACK
						controller.getTransmitter().transmit(new Trame(controller, "", TrameKind.Ack, latestHostAck));
						continue;
					} // Trame seq is expected

					// Validate trame content
					try {
						if (!errorAlgo.validate(trame.contenu)) {
							// Transmit NAK
							controller.getTransmitter().transmit(new Trame(controller, "", TrameKind.Nak, trame.seq));
							continue;
						} // Trame content is valid
					} catch (Exception e) {
						log.error(e.getMessage());
						return;
					}
					try {
						trame.contenu = errorAlgo.decode(trame.contenu);
					} catch (Exception ex) {

						log.error(ex.getMessage());
						return;
					}

					// Set latest host ACK seq
					latestHostAck = trame.seq;

					Console.getInstance().logEncoded(CommunicationType.RX, controller.name, trame);

					// Increase expected seq
					expectedSeq++;

					// Transmit an ACK seq
					controller.getTransmitter().transmit(new Trame(controller, "", TrameKind.Ack, trame.seq));
					break;
				case Ack:
					controller.setLatestGuestAck(trame.seq);
					break;
				case Nak:
					controller.setNakSeq(trame.seq);
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
