package proj.UI;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/** 
 *	@author Wendy
 *	SAdialog is the dialog that ask user to input the desciption, price and select type (decorator / flavor)
 *  and it provides methods to return the corresponding data to MainUI.java
 *  The data can includes: description, type(decorator/flavor), price and status of the dialog(Ok/cancel)
 */

public final class SAdialog {
	private String description;
	private String price;
	private String type;
	private int result;
	
	private String[] icecreamtype = {"Flavor", "Decorator"};
	private JComboBox<String> comboicecreamtype = new JComboBox<String>(icecreamtype);
	private JTextField TFfield1 = new JTextField();
	private JTextField TFfield2 = new JTextField();
	private JPanel SApanel = new JPanel(new GridLayout(0, 1));

    /**
     * @Constructor of SAdialog.java
     * create frame, panel with button/textfield/label (Basic GUI management)
     * set visable to show the SAdialog dialog for user
     * If user click OK, then call validatenullinput method to check whether null input in any one textfield
     * nomatter ok / cancel, both is to close the dialog
     */
    
    SAdialog(){
    SApanel.add(comboicecreamtype);
    SApanel.add(new JLabel("New Description:  (e.g Starwberry/Oreo)"));
    SApanel.add(TFfield1);
    SApanel.add(new JLabel("New Price:   (e.g 2.0)"));
    SApanel.add(TFfield2);	      
    
    result = JOptionPane.showConfirmDialog(null, SApanel, "System Administrator page",
        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    
    //ok option
    if (result == JOptionPane.OK_OPTION) {
    	//get user input in textfield and combo box
    	description = TFfield1.getText();
    	price = TFfield2.getText();
    	type = comboicecreamtype.getSelectedItem().toString();
    	//check if textfield is empty (user not input anything in TFfield1 / TFfield2)
    	validatenullinput();
    }
    SApanel.setVisible(false); //for cancel option
    }//end constructor
    
    /**
     * [method] validatenullinput
     * this method is to check whether user blank in any textfield
     * if yes, then popup warning message to indicate not success in adding that button
     */
    //validate input (check null input in textfield)
    private void validatenullinput(){
    	if ((description.equals("")) || (price.equals(""))){
			result=1;
  			JPanel errorpanelnullinput = new JPanel(new GridLayout(0, 1));
	  		JOptionPane.showMessageDialog(errorpanelnullinput,
	  		         "New Icecream Cannot build !! \n "+
	  		         "blank in textfield ( description or price )","Warning"
	  		         ,JOptionPane.INFORMATION_MESSAGE);
    	}
    }
    
    /**
     * [method] getresultstatus()
     * @return the result status of the button pressed in the dialog(0 for OK /1 for Cancel)
     */
    protected int getresultstatus(){
		return result;	
    }
    
    /**
     * [method] getDescription()
     * @return the description that user input in the dialog
     */
    protected String getDescription(){
		return description;   	
    } 
    
    /**
     * [method] getPrice()
     * @return the price that user input in the dialog
     */   
    protected String getPrice(){
		return price;
    }    
    
    /**
     * [method] getType()
     * @return the type that user selected in the dialog
     * type can be "Decorator" or "Flavor"
     */   
    String getType(){
		return type;
    }
}
