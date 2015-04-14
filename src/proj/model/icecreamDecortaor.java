/**
 * 
 */
package proj.model;

import java.math.BigDecimal;

/**
 * @author Wendy
 * it is a icecreamDecorator class, which allows other decorator to extends it
 * it allows more decorator to add in anytime in future
 */
public abstract class icecreamDecortaor implements icecream {

	abstract public String getDesc();
	abstract public BigDecimal getcost();

}
