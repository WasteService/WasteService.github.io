/**
 * TP1 - IFT585
 * @authors The Team : Benjamin Boudreau (08 318 402), Jean-François Ste-Marie, Jules Deliste, Nicolas Guimier
 */
package ca.usherbrooke.theteam.ift585.tp1.validation.impl;

import ca.usherbrooke.theteam.ift585.tp1.validation.IValidationAlgorithm;
import ca.usherbrooke.theteam.ift585.tp1.util.HammingCodeUtil;

/**
 *
 * @author Jean-Francois Ste-Marie
 */
public class HammingCode implements IValidationAlgorithm {

	@Override
	public boolean validate(String data) {
		return HammingCodeUtil.validate(data);
	}

	@Override
	public String encode(String data) {
		return HammingCodeUtil.encode(data);
	}

	@Override
	public String decode(String data) {
		return HammingCodeUtil.decode(data);
	}
}
