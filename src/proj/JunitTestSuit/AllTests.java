/**
 * 
 */
package proj.JunitTestSuit;

import junit.framework.Test;
import junit.framework.TestSuite;


/**
 * @author Wendy
 * The JUnitTest test the model part of the project
 */
public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		
		//$JUnit-BEGIN$
		
		//test icecream class
		suite.addTestSuite(icecreamTest.class);
		
		//test flavor class
		suite.addTestSuite(flavorTest.class);
		suite.addTestSuite(flavorTest2.class);
		suite.addTestSuite(flavorTest3.class);
		
		//test icecreamDecorator class
		suite.addTestSuite(icecreamDecortaorTest.class);		
		
		//test decorator class
		suite.addTestSuite(decoratorTest.class);
		suite.addTestSuite(decoratorTest2.class);
		suite.addTestSuite(decoratorTest3.class);
		suite.addTestSuite(decoratorTest4.class);
		
		//$JUnit-END$
		return suite;
	}

}
