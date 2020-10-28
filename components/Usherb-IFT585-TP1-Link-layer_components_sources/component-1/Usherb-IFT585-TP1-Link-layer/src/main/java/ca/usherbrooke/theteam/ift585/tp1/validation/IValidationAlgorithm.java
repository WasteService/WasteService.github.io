/**
 * TP1 - IFT585
 * @authors The Team : Benjamin Boudreau (08 318 402), Jean-François Ste-Marie, Jules Deliste, Nicolas Guimier
 */
package ca.usherbrooke.theteam.ift585.tp1.validation;

/**
 *
 * @author benjamin
 */
public interface IValidationAlgorithm {

	boolean validate(String data) throws Exception;

	String encode(String data) throws Exception;

	String decode(String data) throws Exception;
}
