/**
 * 
 */
package proj.JunitTestSuit;

import java.math.BigDecimal;

import junit.framework.TestCase;
import proj.model.flavor;
import proj.model.icecream;

/**
 * @author Wendy
 * This case will test the flavor class
 * The test case will test in selecting one flavor 
 * 
 * The test case (flavor) info as following:
 * 		description: Vanilla
 * 		price: 20
 */

public class flavorTest3 extends TestCase {

	private icecream order1; //create icecream object (order1)

	/**
	 * setup part before running testing method
	 */
	protected void setUp() throws Exception {
		order1 = new flavor("Vanilla",new BigDecimal("20"));
	}

	/**
	 * test the method getDesc()
	 */
	public void testGetDesc() {
		String expected_desc = "Vanilla";
		assertEquals(expected_desc,order1.getDesc());
	}

	/**
	 * test the method getcost()
	 */
	public void testGetcost() {
		BigDecimal expected_cost = new BigDecimal("20");
		assertEquals(expected_cost,order1.getcost());
	}

}
