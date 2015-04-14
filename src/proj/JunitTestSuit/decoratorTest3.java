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
 * The test case test in selecting "THREE" decorator , 1 different 2 are same
 * 
 * The reason for hard-code a flavor is:
 * 		- the system not allow to select a decorator without a flavor !!!
 * 
 * pre-selected: flavor "Vanilla", price 20
 * 
 * The test case (decorator) info as following:
 * 		description: Fruit
 * 		price: 10
 * 
 * 		description: Cotton Candy ( X 2 times)
 * 		price: 7.8
 */

public class decoratorTest3 extends TestCase {

	private icecream order1; //create icecream object (order1)

	/**
	 * setup part before running testing method
	 */
	protected void setUp() throws Exception {		
		//since must decide a flavor before selecting a decorator,
		//the design will hard-code a flavor in testing
		order1 = new flavor("Vanilla", new BigDecimal("20"));
		order1 = new decorator(order1,"Cotton Candy",new BigDecimal("7.8"));
		order1 = new decorator(order1,"Fruit",new BigDecimal("10"));
		order1 = new decorator(order1,"Cotton Candy",new BigDecimal("7.8"));
	}

	/**
	 * test the method getDesc()
	 */
	public void testGetDesc() {
		String expected_desc = "Vanilla & Cotton Candy & Fruit & Cotton Candy";
		assertEquals(expected_desc,order1.getDesc());
	}	
	
	/**
	 * test the method getcost()
	 */
	public void testGetcost() {
		BigDecimal expected_cost = new BigDecimal("45.6");
		assertEquals(expected_cost,order1.getcost());		
	}
	
}
