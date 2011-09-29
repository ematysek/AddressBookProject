package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ContactInfoPanel extends JPanel{
	
	private JLabel firstName;
	private JLabel lastName;
	
	private JTextField txtFirstName;
	private JTextField txtLastName;

	ContactInfoPanel(){
		
		firstName = new JLabel("First Name: ");
		this.add(firstName);
		
		txtFirstName = new JTextField(10);
		this.add(txtFirstName);
		
		lastName = new JLabel("Last Name: ");
		this.add(lastName);
		
		txtLastName = new JTextField(10);
		this.add(txtLastName);
		
		
		
	}

}
