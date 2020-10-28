/**
 * TP1 - IFT585
 * @authors The Team : Benjamin Boudreau (08 318 402), Jean-François Ste-Marie, Jules Deliste, Nicolas Guimier
 */
package ca.usherbrooke.theteam.ift585.tp1.factory.impl;

import ca.usherbrooke.theteam.ift585.tp1.Controller;
import ca.usherbrooke.theteam.ift585.tp1.Tampon;
import ca.usherbrooke.theteam.ift585.tp1.validation.IValidationAlgorithm;
import ca.usherbrooke.theteam.ift585.tp1.simulation.Simulation;
import ca.usherbrooke.theteam.ift585.tp1.protocol.Receiver;
import ca.usherbrooke.theteam.ift585.tp1.protocol.Transmitter;
import ca.usherbrooke.theteam.ift585.tp1.ui.ConfigurationData;
import ca.usherbrooke.theteam.ift585.tp1.validation.impl.CRC;
import ca.usherbrooke.theteam.ift585.tp1.validation.impl.HammingCode;
import org.apache.log4j.Logger;

/**
 *
 * @author benjamin
 */
public class SimulationImpl implements Simulation {


	Controller controller1;
	Controller controller2;
	private static Logger log = Logger.getLogger(SimulationImpl.class);
	ConfigurationData configurationData;

	public SimulationImpl(ConfigurationData configurationData) {
		this.configurationData = configurationData;

		IValidationAlgorithm validationAlgo = null;

		switch (configurationData.getValidationAlgorithm()) {
			case CRC:
				log.info("Using CRC with "+configurationData.getCRCgenerator());
				validationAlgo = new CRC(configurationData.getCRCgenerator());
				break;
			default:
				log.error("Unknown validation algorithm - Choosing Hamming Code as Default");
			case HammingCode:
				log.info("Using HammingCode");
				validationAlgo = new HammingCode();
				break;
		}

		Tampon tamponA = new Tampon();
		Tampon tamponB = new Tampon();

		Receiver receiver1 = null;
		Transmitter transmitter1 = null;
		Receiver receiver2 = null;
		Transmitter transmitter2 = null;

		switch (configurationData.getCommunicationProtocol()) {
			case SelectiveRejection:
				transmitter1 = new ca.usherbrooke.theteam.ift585.tp1.protocol.p6.impl.TransmitterImpl(tamponA, configurationData.getInputFile1(), configurationData.getTimeout(), validationAlgo);
				receiver1 = new ca.usherbrooke.theteam.ift585.tp1.protocol.p6.impl.ReceiverImpl(tamponB, validationAlgo);
				transmitter2 = new ca.usherbrooke.theteam.ift585.tp1.protocol.p6.impl.TransmitterImpl(tamponB, configurationData.getInputFile2(), configurationData.getTimeout(), validationAlgo);
				receiver2 = new ca.usherbrooke.theteam.ift585.tp1.protocol.p6.impl.ReceiverImpl(tamponA, validationAlgo);
				break;
			default:
				log.error("Unknown communication protocol. - Choosing Global Rejection as Default");
			case GlobalRejection:
				transmitter1 = new ca.usherbrooke.theteam.ift585.tp1.protocol.p5.impl.TransmitterImpl(tamponA, configurationData.getInputFile1(), configurationData.getTimeout(), validationAlgo);
				receiver1 = new ca.usherbrooke.theteam.ift585.tp1.protocol.p5.impl.ReceiverImpl(tamponB, validationAlgo);
				transmitter2 = new ca.usherbrooke.theteam.ift585.tp1.protocol.p5.impl.TransmitterImpl(tamponB, configurationData.getInputFile2(), configurationData.getTimeout(), validationAlgo);
				receiver2 = new ca.usherbrooke.theteam.ift585.tp1.protocol.p5.impl.ReceiverImpl(tamponA, validationAlgo);
				break;
		}
		controller1= new Controller("Controller #1", transmitter1, receiver1);
		controller2= new Controller("Controller #2", transmitter2, receiver2);
	}

	@Override
	public void stop() {
		controller1.getReceiver().interrupt();
		controller1.getTransmitter().interrupt();
		controller2.getReceiver().interrupt();
		controller2.getTransmitter().interrupt();
	}

}
