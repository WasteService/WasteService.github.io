/**
 * TP1 - IFT585
 * @authors The Team : Benjamin Boudreau (08 318 402), Jean-François Ste-Marie, Jules Deliste, Nicolas Guimier
 */
package ca.usherbrooke.theteam.ift585.tp1.validation.impl;

import ca.usherbrooke.theteam.ift585.tp1.util.CRCUtil;
import ca.usherbrooke.theteam.ift585.tp1.validation.IValidationAlgorithm;
import org.apache.log4j.Logger;

/**
 *
 * @author Benjamin Boudreau
 */
public class CRC implements IValidationAlgorithm {

	private static Logger log = Logger.getLogger(CRC.class);
	String polynomeGenerator;

	public CRC(String polynomeGenerator) {
		this.polynomeGenerator = polynomeGenerator;
	}

	@Override
	public boolean validate(String data) throws Exception {
		log.debug("validate: " + CRCUtil.resteDivisionPolynomiale(data, polynomeGenerator));
		return CRCUtil.resteDivisionPolynomiale(data, polynomeGenerator).equals("0");
	}

	@Override
	public String encode(String data) throws Exception {
		String newData = data.toString();
		for (int i = 0; i != polynomeGenerator.length(); i++) {
			newData += '0';
		}

		log.debug(newData);
		log.debug(data + fillWithZeros(CRCUtil.resteDivisionPolynomiale(newData, polynomeGenerator), polynomeGenerator.length()));
		return data + fillWithZeros(CRCUtil.resteDivisionPolynomiale(newData, polynomeGenerator), polynomeGenerator.length());
	}

	String fillWithZeros(String toFill, int size) {
		String newToFill = toFill.toString();
		for (int i = 0; i < size - toFill.length(); i++) {
			newToFill = '0' + newToFill;
		}
		return newToFill;
	}

	@Override
	public String decode(String data) {
		return data.substring(0, data.length() - polynomeGenerator.length());
	}
}
