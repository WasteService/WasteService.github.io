/**
 * TP1 - IFT585
 * @authors The Team : Benjamin Boudreau (08 318 402), Jean-François Ste-Marie, Jules Deliste, Nicolas Guimier
 */
package ca.usherbrooke.theteam.ift585.tp1.util;

import java.math.BigInteger;
import org.apache.log4j.Logger;

/**
 *
 * @author Benjamin Boudreau
 */
public class CRCUtil {

	private static Logger log = Logger.getLogger(CRCUtil.class);

	static String multiplier(char multiplicateur, String multiplie) throws Exception {
		String resp;
		if (multiplicateur == '1') {
			resp = multiplie;
		} else if (multiplicateur == '0') {
			resp = multiplie.replaceAll("1", "0");
		} else {
			throw new Exception("The character given must either be a 1 or a 0.");
		}
		return resp;
	}

	static String xor(String premier, String deuxieme) {
		return new BigInteger(premier, 2).xor(new BigInteger(deuxieme, 2)).toString(2);
	}

	public static String resteDivisionPolynomiale(String divise, String polynome) throws Exception {
		/*
		log.debug(new BigInteger(divise, 2).remainder(new BigInteger(polynome, 2)).toString(2));
		return new BigInteger(divise, 2).remainder(new BigInteger(polynome, 2)).toString(2);
		 */
		String divise2 = divise.toString();
		String reste = divise2.substring(0, polynome.length());
		divise2 = divise2.substring(polynome.length());

		for (int noEtape = 1; noEtape != (divise.length() - polynome.length() + 1) + 1; ++noEtape) {
			String dividande = reste;
			log.debug("Etape #" + noEtape + ": Bit poid fort = " + dividande.charAt(0));
			String diviseur = multiplier(bitPoidFort(dividande, polynome.length()), polynome);
			log.debug("Etape #" + noEtape + ": " + dividande + " XOR " + diviseur);
			reste = xor(diviseur, dividande);
			if (!divise2.isEmpty()) {
				reste += divise2.substring(0, 1);
				divise2 = divise2.substring(1);
			}
			log.debug("Etape #" + noEtape + ": Reste = " + reste);
		}

		log.debug("resteDivisionPolynomiale = " + reste);
		return reste;
	}

	private static char bitPoidFort(String dividande, int size) {
		if (dividande.length() < size) {
			return '0';
		}
		return dividande.charAt(0);
	}
}
