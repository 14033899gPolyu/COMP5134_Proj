/**
 * 
 */
package proj.JunitTestSuit;

import java.math.BigDecimal;

import junit.framework.TestCase;
import proj.model.decorator;
import proj.model.flavor;
import proj.model.icecream;

/**
 * @author Wendy
 * This case test the decorator class
 * The test case test in selecting "TWO" different decorator
 * 
 * The reason for hard-code a flavor is:
 * 		- the system not allow to select a decorator without a flavor !!!
 * 
 * pre-selected: flavor "Cookie and Cream", price 7.2
 * 
 * The test case (decorator) info as following:
 * 		description: Nuts
 * 		price: 1.9
 * 
 * 		description: Jelly beans
 * 		price: 4
 */

public class decoratorTest2 extends TestCase {

	private icecream order1; //create icecream object (order1)

	/**
	 * setup part before running testing method
	 */
	protected void setUp() throws Exception {
		
		//since must decide a flavor before selecting a decorator,
		//the design will hard-code a flavor in testing
		order1 = new flavor("Cookie and Cream", new BigDecimal("7.2"));
		order1 = new decorator(order1,"Nuts",new BigDecimal("1.9"));
		order1 = new decorator(order1,"Jelly beans",new BigDecimal("4"));
	}

	/**
	 * test the method getDesc()
	 */
	public void testGetDesc() {
		String expected_desc = "Cookie and Cream & Nuts & Jelly beans";
		assertEquals(expected_desc,order1.getDesc());
	}	
	
	/**
	 * test the method getcost()
	 */
	public void testGetcost() {
		BigDecimal expected_cost = new BigDecimal("13.1");
		assertEquals(expected_cost,order1.getcost());		
	}
	
}
