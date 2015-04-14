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
 * The test case test in selecting "TWO" decorator, which is same
 * 
 * The reason for hard-code a flavor is:
 * 		- the system NOT allow to select a decorator without a flavor !!!
 * 
 * pre-selected: flavor "Blue berry", price 34.7
 * 
 * The test case (decorator) info as following:
 * 		description: M&M ( X 2 times)
 * 		price: 9.99
 */
public class decoratorTest4 extends TestCase {

	private icecream order1; //create icecream object (order1)

	/**
	 * setup part before running testing method
	 */
	protected void setUp() throws Exception {
		
		//since must decide a flavor before selecting a decorator,
		//the design will hard-code a flavor in testing
		order1 = new flavor("Blue berry", new BigDecimal("34.7"));
		order1 = new decorator(order1,"M&M",new BigDecimal("9.99"));
		order1 = new decorator(order1,"M&M",new BigDecimal("9.99"));
	}

	/**
	 * test the method getDesc()
	 */
	public void testGetDesc() {
		String expected_desc = "Blue berry & M&M & M&M";
		assertEquals(expected_desc,order1.getDesc());
	}	
	
	/**
	 * test the method getcost()
	 */
	public void testGetcost() {
		BigDecimal expected_cost = new BigDecimal("54.68");
		assertEquals(expected_cost,order1.getcost());		
	}
	
}
