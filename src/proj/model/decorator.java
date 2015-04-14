package proj.model;
import java.math.BigDecimal;

/**
 * @author Wendy
 * The decorator class extends the icecreamDecorator 
 * and allow user select 0 to unlimited number of decorator base on 1 flavor
 * the class the component wrapped object (icecream) and allow it to wrap a objeect in a object
 * each of time, it returns the description and cost according to the wrapped object
 * that is the decorator pattern
 */
public class decorator extends icecreamDecortaor{

	icecream icecream; //create the icecream object
	private String ddescription;
	private BigDecimal dcost;

	/**
	 * [constructor] of decorator.java
	 * get the description, price and the icecream object from MainUI.java
	 * and store to local variables
	 * @param icecream is object of icecream class
	 * @param ddescription is String
	 * @param dcost is BigDecimal
	 */
	public decorator(icecream icecream, String ddescription, BigDecimal dcost){
		this.icecream=icecream;
		this.ddescription = ddescription;
		this.dcost = dcost;	
	}
	
	/**
	 * [method] getDesc()
	 * according to the icecream object to return the total description
	 * overwrite the "getDesc" method in iceDecorator.java and icecream.java
	 * @return the description of the decorator
	 */
	public String getDesc() {
		return icecream.getDesc()+" & "+this.ddescription;
	}

	/**
	 * [method] getcost()
	 * according to the icecream object to return the total price
	 * overwrite the "getcost" method in iceDecorator.java and icecream.java
	 * @return the cost of the decorator
	 */	
	public BigDecimal getcost() {
		return icecream.getcost().add(this.dcost);
	}

}
