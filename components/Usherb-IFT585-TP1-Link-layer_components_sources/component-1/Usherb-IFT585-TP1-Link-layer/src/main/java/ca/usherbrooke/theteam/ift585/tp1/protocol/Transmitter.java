/**
 * TP1 - IFT585
 * @authors The Team : Benjamin Boudreau (08 318 402), Jean-François Ste-Marie, Jules Deliste, Nicolas Guimier
 */
package ca.usherbrooke.theteam.ift585.tp1.protocol;

import ca.usherbrooke.theteam.ift585.tp1.Controller;
import ca.usherbrooke.theteam.ift585.tp1.Tampon;
import ca.usherbrooke.theteam.ift585.tp1.Trame;
import ca.usherbrooke.theteam.ift585.tp1.validation.IValidationAlgorithm;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author benjamin
 */
public abstract class Transmitter extends Thread {

	protected Map<Integer, String> tramesHashMap;
	protected Controller controller;
	protected Tampon tampon;
	protected int timeout;
	protected IValidationAlgorithm errorAlgo;

	public Transmitter(Tampon tamponTransmitter, String file, int timeout, IValidationAlgorithm errorAlgo) {
		this.tampon = tamponTransmitter;
		this.timeout = timeout;
		this.errorAlgo = errorAlgo;
		this.tramesHashMap = new HashMap<Integer, String>();
		readFile(file);
	}

	public abstract void transmit(Trame trame);

	/**
	 * Read the file that contains the different trames.
	 * @param file File containing the trames.
	 */
	protected void readFile(String file) {
		if (file == null) {
			return;
		}

		String line = null;
		int currentTrame = 0;
		try {
			InputStream ips = new FileInputStream(file);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			while ((line = br.readLine()) != null) {
				getTramesHashMap().put(currentTrame++, line);
			}
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @return the tramesHashMap
	 */
	public Map<Integer, String> getTramesHashMap() {
		return tramesHashMap;
	}

	/**
	 * @param tramesHashMap the tramesHashMap to set
	 */
	public void setTramesHashMap(Map<Integer, String> tramesHashMap) {
		this.tramesHashMap = tramesHashMap;
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
	 * @return the timeout
	 */
	public int getTimeout() {
		return timeout;
	}

	/**
	 * @param timeout the timeout to set
	 */
	public void setTimeout(int timeout) {
		this.timeout = timeout;
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
