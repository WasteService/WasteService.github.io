/**
 * TP1 - IFT585
 * @authors The Team : Benjamin Boudreau (08 318 402), Jean-François Ste-Marie, Jules Deliste, Nicolas Guimier
 */
package ca.usherbrooke.theteam.ift585.tp1.validation.impl;

import junit.framework.TestCase;
import org.apache.log4j.Logger;

/**
 *
 * @author Benjamin Boudreau
 */
public class CRCTest extends TestCase {

	private static Logger log = Logger.getLogger(CRCTest.class);

	public CRCTest(String testName) {
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
	 * Test of validate method, of class CRC.
	 */
	public void testValidate() throws Exception {
		System.out.println("validate");
		String data = "11001010110110";
		CRC instance = new CRC("10101");

		assertTrue(instance.validate(data));
	}

	/**
	 * Test of encode method, of class CRC.
	 */
	public void testEncode() throws Exception {
		System.out.println("encode");
		String data = "1100101011";
		CRC instance = new CRC("10101");
		String expResult = "110010101101100";
		String result = instance.encode(data);
		log.debug(result);
		assertEquals(expResult, result);
	}

	/**
	 * Test of decode method, of class CRC.
	 */
	public void testDecode() {
		System.out.println("decode");
		String data = "110010101100110";
		CRC instance = new CRC("10101");
		String expResult = "1100101011";
		String result = instance.decode(data);
		assertEquals(expResult, result);
	}

	/**
	 * Test of fillWithZeros method, of class CRC.
	 */
	public void testFillWithZeros() {
		System.out.println("fillWithZeros");
		String toFill = "";
		int size = 2;
		CRC instance = new CRC("");
		String expResult = "00";
		String result = instance.fillWithZeros(toFill, size);
		assertEquals(expResult, result);
	}

	/**
	 * Test of fillWithZeros method, of class CRC.
	 */
	public void testFillWithZeros_2() {
		System.out.println("fillWithZeros");
		String toFill = "allo";
		int size = 6;
		CRC instance = new CRC("");
		String expResult = "00allo";
		String result = instance.fillWithZeros(toFill, size);
		assertEquals(expResult, result);
	}
}
