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
 * This case test the icecreamDecorator class
 * The test case test in selecting "ONE" decorator only
 * 
 * The reason for hard-code a flavor is:
 * 		- the system NOT allow to select a decorator without a flavor !!!
 * 
 * pre-selected: flavor "Green tea", price 36
 * 
 * The test case (decorator) info as following:
 * 		description: Oreo biscuit
 * 		price: 8.9
 */
public class icecreamDecortaorTest extends TestCase {

	private icecream order1; //create icecream object (order1)

	/**
	 * setup part before running testing method
	 */
	protected void setUp() throws Exception {	
		//since must decide a flavor before selecting a decorator,
		//the design will hard-code a flavor in testing
		order1 = new flavor("Green tea", new BigDecimal("36"));
		order1 = new decorator(order1,"Oreo biscuit",new BigDecimal("8.9"));
	}

	/**
	 * test the method getDesc()
	 */
	public void testGetDesc() {
		String expected_desc = "Green tea & Oreo biscuit";
		assertEquals(expected_desc,order1.getDesc());
	}	
	
	/**
	 * test the method getcost()
	 */
	public void testGetcost() {
		BigDecimal expected_cost = new BigDecimal("44.9");
		assertEquals(expected_cost,order1.getcost());		
	}
	

}
