package proj.model;
import java.math.BigDecimal;

/**
 * @author Wendy
 * The flavor class implements icecream interface
 * and overwrite the method in icecream
 * allow to add 1 flavor at each time
 */
public class flavor implements icecream{
	
	private final String fdescription;
	private final BigDecimal fcost;

	/**
	 * [Constructor] of flavor.java
	 * get the description, price from MainUI.java
	 * and store to local variables
	 * @param fdescription is String
	 * @param fcost is BigDecimal
	 */
	public flavor(String fdescription, BigDecimal fcost){
		this.fdescription = fdescription;
		this.fcost = fcost;
	}
	
	/**
	 * [method] getDesc()
	 * according to the flavor description passed from constructor to return the total description
	 * overwrite the "getDesc" method in icecream.java
	 * @return the description of the flavor
	 */
	public String getDesc() {
		return this.fdescription;
	}

	/**
	 * [method] getcost()
	 * according to the flavor price passed from constructor to return the price
	 * overwrite the "getcost" method in icecream.java
	 * @return the cost of the flavor
	 */
	public BigDecimal getcost() {
		return this.fcost;
	}

}
