/**
 * TP1 - IFT585
 * @authors The Team : Benjamin Boudreau (08 318 402), Jean-François Ste-Marie, Jules Deliste, Nicolas Guimier
 */
package ca.usherbrooke.theteam.ift585.tp1;

import ca.usherbrooke.theteam.ift585.tp1.enums.CommunicationType;
import ca.usherbrooke.theteam.ift585.tp1.enums.TrameKind;
import ca.usherbrooke.theteam.ift585.tp1.ui.ConsolePanel;
import java.util.Date;

/**
 * Class that enables to log different events concerning trames.
 * @author Jules
 */
public class Console {

	private static Console instance;
	private ConsolePanel consoleFrame;

	// Singleton
	private Console() {
	}

	public static Console getInstance() {
		if (instance == null) {
			instance = new Console();
		}
		return instance;
	}

	public void clear() {
		getConsoleFrame().clear();
	}

	/**
	 * Logs a transmission or reception of any trame kinds.
	 */
	public void logTXRX(CommunicationType communicationType, Controller controller, TrameKind trameKind, Trame trame) {
		StringBuffer consoleOutput = new StringBuffer();
		String communicationTypeString = null;
		String trameKindString = null;
		switch (communicationType) {
			case TX:
				communicationTypeString = "transmits";
				break;
			case RX:
				communicationTypeString = "received  ";
				break;
			default:
				break;
		}
		switch (trameKind) {
			case Data:
				trameKindString = "DATA";
				break;
			case Ack:
				trameKindString = "ACK ";
				break;
			case Nak:
				trameKindString = "NAK ";
				break;
			default:
				break;
		}
		consoleOutput.append(String.format("%d %s %s %s [seq: %d]",
						(new Date()).getTime(),
						controller.name,
						communicationTypeString,
						trameKindString,
						trame.seq));
		if (trameKind == TrameKind.Data) {
			consoleOutput.append(String.format(" (%s)",
							trame.contenu));
		}
		getConsoleFrame().writeLine(consoleOutput.toString());
	}

	/**
	 * Logs a transmission or reception of an encoded/decoded DATA trame kind.
	 */
	public void logEncoded(CommunicationType communicationType, String controllerName, Trame trame) {
		String communicationTypeString = null;
		switch (communicationType) {
			case RX:
				communicationTypeString = "decoded";
				break;
			case TX:
				communicationTypeString = "encoded";
				break;
			default:
				break;
		}
		StringBuffer consoleOutput = new StringBuffer();
		consoleOutput.append(String.format("%d %s %s   DATA [seq: %d] (%s)",
						(new Date()).getTime(),
						controllerName,
						communicationTypeString,
						trame.seq,
						trame.contenu));
		getConsoleFrame().writeLine(consoleOutput.toString());
	}

	/**
	 * Logs when a timeout is reached on the Transmitter side.
	 */
	public void logTimeout(String controllerName, int currentSeq, int fallbackSeq) {
		StringBuffer consoleOutput = new StringBuffer();
		consoleOutput.append(String.format("%d %s reached   TMT  [seq: %d] falling back to %d",
						(new Date()).getTime(),
						controllerName,
						currentSeq,
						fallbackSeq));
		getConsoleFrame().writeLine(consoleOutput.toString());
	}

	/**
	 * Logs when an unexpected trame is handled on the Receiver side.
	 */
	public void logUnexpected(String controllerName, int currentSeq, int expectedSeq) {
		StringBuffer consoleOutput = new StringBuffer();
		consoleOutput.append(String.format("%d %s handled   UNXP [seq: %d] was expecting %d",
						(new Date()).getTime(),
						controllerName,
						currentSeq,
						expectedSeq));
		getConsoleFrame().writeLine(consoleOutput.toString());
	}

	/**
	 * @return the consoleFrame
	 */
	public ConsolePanel getConsoleFrame() {
		return consoleFrame;
	}

	/**
	 * @param consoleFrame the consoleFrame to set
	 */
	public void setConsoleFrame(ConsolePanel consoleFrame) {
		this.consoleFrame = consoleFrame;
	}
}
