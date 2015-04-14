package proj.model;
import java.math.BigDecimal;

/**
 * @author Wendy
 * The icecream class is a interface (base class for flavor and decorator)
 * allow decorator and flavor to implements it
 */
public interface icecream {

	String initdescription="Empty! No item selected";
	BigDecimal initcost= new BigDecimal(0.0);
	
	public String getDesc();
	
	public BigDecimal getcost();
	
}
