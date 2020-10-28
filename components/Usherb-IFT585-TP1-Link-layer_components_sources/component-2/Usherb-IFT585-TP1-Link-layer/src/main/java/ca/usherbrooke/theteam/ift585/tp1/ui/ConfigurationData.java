package ca.usherbrooke.theteam.ift585.tp1.ui;

import ca.usherbrooke.theteam.ift585.tp1.enums.CommunicationProtocol;
import ca.usherbrooke.theteam.ift585.tp1.enums.ValidationAlgorithm;
import java.io.File;

/**
 * Class that enables to set the configuration data
 * to use for an execution of the application.
 * @author Jules
 */
public class ConfigurationData {

	private boolean isDirty;
	// Properties
	private String inputFile1;
	private String inputFile2;
	private ValidationAlgorithm validationAlgorithm;
	private CommunicationProtocol communicationProtocol;
	private int timeout;
	MainFrame outer;
	private String CRCgenerator;

	public ConfigurationData(MainFrame outer) {
		this.outer = outer;
	}

	/**
	 * Make object state dirty.
	 */
	private void dirty() {
		isDirty = true;
	}

	public void validate() throws IllegalArgumentException {
		// If both input files are empty
		if (getInputFile1() == null && getInputFile2() == null) {
			throw new IllegalArgumentException("Both input files cannot be empty.");
		}
		if (getInputFile1() != null && !(new File(inputFile1)).exists()) {
			throw new IllegalArgumentException("The input file #1 cannot be found. Please make sure it exists.");
		}
		if (getInputFile2() != null && !(new File(inputFile2)).exists()) {
			throw new IllegalArgumentException("The input file #2 cannot be found. Please make sure it exists.");
		}
		if (getTimeout() == 0) {
			throw new IllegalArgumentException("The timeout must be numerical and greater than 0.");
		}
		if (getValidationAlgorithm() == null) {
			throw new IllegalArgumentException("A validation algorithm must be set.");
		} else {
			if (getValidationAlgorithm() == validationAlgorithm.CRC && getCRCgenerator().isEmpty()) {
				throw new IllegalArgumentException("A CRC generator must be set.");
			}
		}
		if (getCommunicationProtocol() == null) {
			throw new IllegalArgumentException("A communication algorithm must be set.");
		}
		isDirty = false;
	}

	/**
	 * Determines if the object state is valid.
	 * @return True, because the object state has to be valid,
	 * otherwise an exception would have been thrown during validation.
	 * Validate has to be called before this method.
	 * @throws IllegalStateException If the object state is dirty.
	 */
	public boolean isValid() throws IllegalStateException {
		if (isDirty) {
			throw new IllegalStateException("The state of the ConfigurationData object is dirty. Please validate first.");
		}
		return true;
	}

	/**
	 * Getters/setters below for the class private members.
	 */
	/**
	 * @return the inputFile1
	 */
	public String getInputFile1() {
		return inputFile1;
	}

	/**
	 * @param inputFile1 the inputFile1 to set
	 */
	public void setInputFile1(String inputFile1) {
		this.inputFile1 = inputFile1;
		dirty();
	}

	/**
	 * @return the inputFile2
	 */
	public String getInputFile2() {
		return inputFile2;
	}

	/**
	 * @param inputFile2 the inputFile2 to set
	 */
	public void setInputFile2(String inputFile2) {
		this.inputFile2 = inputFile2;
		dirty();
	}

	/**
	 * @return the validationAlgorithm
	 */
	public ValidationAlgorithm getValidationAlgorithm() {
		return validationAlgorithm;
	}

	/**
	 * @param validationAlgorithm the validationAlgorithm to set
	 */
	public void setValidationAlgorithm(ValidationAlgorithm validationAlgorithm) {
		this.validationAlgorithm = validationAlgorithm;
		dirty();
	}

	/**
	 * @return the communicationProtocol
	 */
	public CommunicationProtocol getCommunicationProtocol() {
		return communicationProtocol;
	}

	/**
	 * @param communicationProtocol the communicationProtocol to set
	 */
	public void setCommunicationProtocol(CommunicationProtocol communicationProtocol) {
		this.communicationProtocol = communicationProtocol;
		dirty();
	}

	/**
	 * @return the timeout
	 */
	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
		dirty();
	}

	/**
	 * @return the CRCgenerator
	 */
	public String getCRCgenerator() {
		return CRCgenerator;
	}

	/**
	 * @param CRCgenerator the CRCgenerator to set
	 */
	public void setCRCgenerator(String CRCgenerator) {
		this.CRCgenerator = CRCgenerator;
	}
}
