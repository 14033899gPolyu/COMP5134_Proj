package proj.UI;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import proj.model.decorator;
import proj.model.flavor;
import proj.model.icecream;
/**
 * @author Wendy
 * MainUI.java provide the main UI 
 * MainUI is the first page UI when user run the system
 * and the corresponding action listener to different buttons
 * and connect to another UI(SAdialog.java) to get the user input in the diaglog
 * and connect to model part to get the result of icecream description or price by using decorator pattern
 * and to put the answer in the textfield
 */

public final class MainUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton BNewIC=new JButton("New Ice Cream");
	private JButton BSystemAdmin=new JButton("System Administrator");
	private JLabel LICFlavor = new JLabel("ICE-CREAM Flavor");
	private JLabel LICDecorator = new JLabel("ICE-CREAM Decorator");
	private JLabel LICTotal = new JLabel("Total: $");
	private JTextField TFICTotalsolution = new JTextField("0");
	private JLabel LICDesc = new JLabel("Description: ");
	private JTextField TFDescsolution = new JTextField("Empty! No item selected");	
	//create panels
    private JPanel panel_flavor=new JPanel(new GridLayout(30,1));
    private JPanel panel_decorator=new JPanel(new GridLayout(30,1));
    private JPanel panel_other=new JPanel(new GridLayout(6,1));    	
    //create button for handling the newbutton event
    LinkedList<JButton> buttonlist=new LinkedList<JButton>();
    //create new icecream order (order1)
    icecream order1;

    /**
     * [constructor] of MainUI.java
     * create frame, panel with button/textfield/label (Basic GUI management)
     * set visable to show the MainUI interface for user
     * create the default button (flavor and decorator) by calling addbutton method
     * create action event of clicking new icecream button and system admin. button
     */
	public MainUI(){
	super("Ice Cream Shop");
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(900, 600);
    this.setLocation(60, 60);
    
    //create flavor panel
    this.setLayout(new BorderLayout());
    panel_flavor.setPreferredSize(new Dimension(300,20));
    panel_flavor.add(LICFlavor);
	
    //create decorator panel
    panel_decorator.setPreferredSize(new Dimension(300,20));   
    panel_decorator.add(LICDecorator);
      
    //create other (total, system admin.) panel
    panel_other.setPreferredSize(new Dimension(300,20));    
    panel_other.add(BNewIC);
    panel_other.add(BSystemAdmin);
    panel_other.add(LICDesc);   
    panel_other.add(TFDescsolution);    
    panel_other.add(LICTotal);
    panel_other.add(TFICTotalsolution);   
    
    //set visiable
    this.add(panel_flavor, BorderLayout.WEST);  
    this.add(panel_other, BorderLayout.EAST); 
    this.add(panel_decorator, BorderLayout.CENTER); 
    this.setVisible(true);
    
    //create default button (flavor & decorator)
    Addbutton("Chocolate", "12.0", "Flavor");
    Addbutton("Vanilla", "8.5", "Flavor");
    Addbutton("Oreo", "2.4", "Decorator");
    Addbutton("M&M", "3.3", "Decorator");

    //create new ice cream button event listener
    BNewIC.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			order1 = null; //set the order to null (initialize the icecream)
			//get the init. cost and description of the icecream
			TFICTotalsolution.setText((icecream.initcost).toString());
			TFDescsolution.setText(icecream.initdescription);
		}
    });
    
	//create SystemAdmin button event listener
    BSystemAdmin.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			//popup the SAdialog to ask user to inout the data and then get back the data
			SAdialog button = new SAdialog();
			
			//check click cancel or ok in another GUI, if ok (=0) then addbutton else do nothing
			if (button.getresultstatus()== 0)
			//get back the popup dialog description, price and type to add button mehtod
			Addbutton(button.getDescription(),(button.getPrice()), button.getType());
		}});        
	}
	//** end constructor

	/**
	 * [method] Addbutton
	 * This method is contains 2 parts: 
	 * 1.create button into the corresponding panel (flavor/decorator)
	 * 2.handle the click event of these button.
	 * The method use BigDecimal to handle the calculation 
	 * to prevent error of sum when perfectly accurate in using "double / float".
	 * @param desc is String
	 * @param price is String
	 * @param type is String
	 */
	private void Addbutton(final String desc, final String price, final String type){
		//use BigDecimal to handle the calculation to prevent error of sum when perfectly accurate in using "double / float"
		//change the price to BDprice in BigDecimal type
		final BigDecimal BDprice= new BigDecimal(price);
		//create button with the specific format e.g.[@description, $@price] as required
		buttonlist.add(new JButton("["+desc+", $"+price+"]"));
		
		//handle the action when these button is click
        final ActionListener listener = new ActionListener() {
 	  	   public void actionPerformed(ActionEvent evt) {	
 	  		   try{
 	  			   if (type=="Decorator"){//Decorator, 
 	  				   order1= new decorator(order1,desc,BDprice);	
 	  			   }
 	  			   else{ //flavor
 	  				   order1= new flavor(desc,BDprice);
 	  			   }
 	  			   TFDescsolution.setText(order1.getDesc());
 	  			   TFICTotalsolution.setText((order1.getcost().toString()));
 	  		   }
 	  		   catch(Exception ex){ //handle clicking decorator before clicking flavor
 	  			JPanel errorpanel = new JPanel(new GridLayout(0, 1));
 	  		    JOptionPane.showMessageDialog(errorpanel,
 	  		         "Please enter a flavor first!!!","Warning",JOptionPane.INFORMATION_MESSAGE);			 	  			
 	  		   }
 	  	   }
 	  	};			        
        
    if (type=="Flavor"){//flavor
	    panel_flavor.add(buttonlist.getLast());       	 
        panel_flavor.validate();
    }
    else //decorator
    {	 	
	    panel_decorator.add(buttonlist.getLast());
	    panel_decorator.validate();
    }	            
    buttonlist.getLast().addActionListener(listener);
	}

}
