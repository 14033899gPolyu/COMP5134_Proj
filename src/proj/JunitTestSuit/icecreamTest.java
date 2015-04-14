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
 * The program is to test in selecting the following:
 * 
 * Flavor: chocolate, $14.0
 * Decorator: candy, $9.9 (X 2 times)
 * Decorator: jelly, $3.4
 */
public class icecreamTest extends TestCase {

	private icecream order1; //create icecream object (order1)

	/**
	 * setup part before running testing method
	 */
	protected void setUp() throws Exception {
		order1 = new flavor("Chocolate", new BigDecimal("14"));
		order1 = new decorator(order1,"candy",new BigDecimal("9.9"));	
		order1 = new decorator(order1,"candy",new BigDecimal("9.9"));	
		order1 = new decorator(order1,"jelly",new BigDecimal("3.4"));	
	}
	
	/**
	 * test the method getDesc()
	 */
	public void testGetDesc() {
		String expected_desc = "Chocolate & candy & candy & jelly";
		assertEquals(expected_desc,order1.getDesc());
	}	

	/**
	 * test the method getcost()
	 */
	public void testGetcost() {
		BigDecimal expected_cost = new BigDecimal("37.2");
		assertEquals(expected_cost,order1.getcost());		
	}
	
}
