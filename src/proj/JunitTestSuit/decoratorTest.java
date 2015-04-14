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
 * The test case test in selecting "ONE" decorator only
 * 
 * The reason for hard-code a flavor is:
 * 		- the system NOT allow to select a decorator without a flavor !!!
 * 
 * pre-selected: flavor "chocolate", price 3.6
 * 
 * The test case (decorator) info as following:
 * 		description: M&M
 * 		price: 2.1
 */
public class decoratorTest extends TestCase {

	private icecream order1; //create icecream object (order1)

	/**
	 * setup part before running testing method
	 */
	protected void setUp() throws Exception {	
		//since must decide a flavor before selecting a decorator,
		//the design will hard-code a flavor in testing
		order1 = new flavor("Chocolate", new BigDecimal("3.6"));
		order1 = new decorator(order1,"M&M",new BigDecimal("2.1"));
	}

	/**
	 * test the method getDesc()
	 */
	public void testGetDesc() {
		String expected_desc = "Chocolate & M&M";
		assertEquals(expected_desc,order1.getDesc());
	}
	
	/**
	 * test the method getcost()
	 */
	public void testGetcost() {
		BigDecimal expected_cost = new BigDecimal("5.7");
		assertEquals(expected_cost,order1.getcost());		
	}
	
}
