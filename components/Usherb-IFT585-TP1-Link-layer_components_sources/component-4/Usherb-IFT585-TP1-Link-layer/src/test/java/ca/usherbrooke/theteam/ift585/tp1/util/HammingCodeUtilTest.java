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
public class HammingCodeUtilTest extends TestCase {

	private static Logger log = Logger.getLogger(HammingCodeUtilTest.class);

	public HammingCodeUtilTest(String testName) {
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
	 * Test of encode method, of class HammingCodeUtil.
	 */
	public void testEncode_h() {
		log.debug("testEncode_h");
		String donnee = "1001000";
		String expResult = "00110010000";
		String result = HammingCodeUtil.encode(donnee);
		assertEquals(expResult, result);
	}

	/**
	 * Test of encode method, of class HammingCodeUtil.
	 */
	public void testEncode_space() {
		log.debug("testEncode_space");
		String donnee = "1001000";
		String expResult = "00110010000";
		String result = HammingCodeUtil.encode(donnee);
		assertEquals(expResult, result);
	}

	/**
	 * Test of decode method, of class HammingCodeUtil.
	 */
	public void testDecode_without_error() {
		log.debug("decode");
		String donnee = "10011000000";
		String expResult = "0100000";
		String result = HammingCodeUtil.decode(donnee);
		assertEquals(expResult, result);
	}

	/**
	 * Test of decode method, of class HammingCodeUtil.
	 */
	public void testDecode_with_error() {
		log.debug("testDecode_with_error");
		String donnee = "10011001000";
		String expResult = "0100000";
		String result = HammingCodeUtil.decode(donnee);
		assertEquals(expResult, result);
	}

	/**
	 * Test of decode method, of class HammingCodeUtil.
	 */
	public void testDecode_with_error_first_bit() {
		log.debug("testDecode_with_error_first_bit");
		String donnee = "10011000001";
		String expResult = "0100000";
		String result = HammingCodeUtil.decode(donnee);
		assertEquals(expResult, result);
	}
}
