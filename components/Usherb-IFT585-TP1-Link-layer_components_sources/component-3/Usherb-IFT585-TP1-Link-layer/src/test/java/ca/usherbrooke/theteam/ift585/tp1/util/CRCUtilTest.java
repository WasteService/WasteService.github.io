/**
 * TP1 - IFT585
 * @authors The Team : Benjamin Boudreau (08 318 402), Jean-François Ste-Marie, Jules Deliste, Nicolas Guimier
 */
package ca.usherbrooke.theteam.ift585.tp1.util;

import junit.framework.TestCase;
import org.apache.log4j.Logger;

/**
 *
 * @author Benjamin Boudreau (08 318 402)
 */
public class CRCUtilTest extends TestCase {

	private static Logger log = Logger.getLogger(CRCUtilTest.class);

	public CRCUtilTest(String testName) {
		super(testName);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test of divisionPolynomiale method, of class CRCUtil.
	 * @see : http://dvsoft.developpez.com/Articles/CRC
	 */
	public void testDivisionPolynomiale_1() throws Exception {
		log.info("divisionPolynomiale #1");
		String divise = "11010110110000";
		String diviseur = "10011";
		String expResult = "1110";
		String result = CRCUtil.resteDivisionPolynomiale(divise, diviseur);
		assertEquals(expResult, result);
	}

	/**
	 * Test of divisionPolynomiale method, of class CRCUtil.
	 * @see : http://dvsoft.developpez.com/Articles/CRC
	 */
	public void testDivisionPolynomiale_1_reste_0() throws Exception {
		log.info("divisionPolynomiale #1");
		String divise = "11010110111110";
		String diviseur = "10011";
		String expResult = "0";
		String result = CRCUtil.resteDivisionPolynomiale(divise, diviseur);
		assertEquals(expResult, result);
	}

	/**
	 * Test of divisionPolynomiale method, of class CRCUtil.
	 * @see : http://docs.sylvain-nahas.com/crc.html
	 */
	public void testDivisionPolynomiale_2() throws Exception {
		log.info("divisionPolynomiale #2");
		String divise = "11001010110000";
		String diviseur = "10101";
		String expResult = "110";
		String result = CRCUtil.resteDivisionPolynomiale(divise, diviseur);
		assertEquals(expResult, result);
	}

	/**
	 * Test of divisionPolynomiale method, of class CRCUtil.
	 * @see : http://docs.sylvain-nahas.com/crc.html
	 */
	public void testDivisionPolynomiale_2_reste_0() throws Exception {
		log.info("divisionPolynomiale #2");
		String divise = "11001010110110";
		String diviseur = "10101";
		String expResult = "0";
		String result = CRCUtil.resteDivisionPolynomiale(divise, diviseur);
		assertEquals(expResult, result);
	}

	/**
	 * Test of divisionPolynomiale method, of class CRCUtil.
	 * @see http://www.commentcamarche.net/contents/base/control.php3
	 */
	public void testDivisionPolynomiale_3() throws Exception {
		log.info("divisionPolynomiale #3");
		String divise = "10110001001010100000";
		String diviseur = "1001";
		String expResult = "11";
		String result = CRCUtil.resteDivisionPolynomiale(divise, diviseur);
		assertNotSame(expResult, result);
	}

	/**
	 * Test of divisionPolynomiale method, of class CRCUtil.
	 * @see http://www.google.ca/url?sa=t&source=web&ct=res&cd=3&ved=0CBkQFjAC&url=http%3A%2F%2Fwww.cs.uiuc.edu%2Fclass%2Fsp06%2Fcs438%2Fhomeworks%2FCRC.pdf&ei=3EZ8S62THI2XtgeomfjJBQ&usg=AFQjCNHD6T5pYLDlUArnia6j-K1dHPbTFw&sig2=8MBQf1UHwo8xp4sYTTkfCg
	 */
	public void testDivisionPolynomiale_4() throws Exception {
		log.info("divisionPolynomiale #4");
		String divise = "10010110101";
		String diviseur = "1101";
		String expResult = "101";
		String result = CRCUtil.resteDivisionPolynomiale(divise, diviseur);
		assertEquals(expResult, result);
	}

	/**
	 * Test of xor method, of class CRCUtil.
	 */
	public void testXor() throws Exception {
		log.info("xor: 11010 XOR 10011 = 01001");
		String premier = "11010";
		String deuxieme = "10011";
		String expResult = "1001";
		String result = CRCUtil.xor(premier, deuxieme);
		assertEquals(expResult, result);
	}

	/**
	 * Test of multiplier method, of class CRCUtil.
	 */
	public void testMultiplier_1() throws Exception {
		log.info("multiplier #1");
		char multiplicateur = '1';
		String multiplie = "1100";
		String expResult = "1100";
		String result = CRCUtil.multiplier(multiplicateur, multiplie);
		assertEquals(expResult, result);
	}

	/**
	 * Test of multiplier method, of class CRCUtil.
	 */
	public void testMultiplier_2() throws Exception {
		log.info("multiplier #2");
		char multiplicateur = '0';
		String multiplie = "1100";
		String expResult = "0000";
		String result = CRCUtil.multiplier(multiplicateur, multiplie);
		assertEquals(expResult, result);
	}
}
