package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ContactInfoPanel extends JPanel{
	
	//**************************************
	//Class-Level Variables / GUI Components
	//**************************************
	
	//FlowLayout
	private FlowLayout flow;
	
	//First name
	private JLabel lblFirstName;
	private JTextField txtFirstName;
	//Last name
	private JLabel lblLastName;
	private JTextField txtLastName;
	//Address
	private JLabel lblAddress;
	private JTextField txtAddress;
	//City
	private JLabel lblCity;
	private JTextField txtCity;
	//State
	private JLabel lblState;
	private JTextField txtState;
	//zip
	private JLabel lblZip;
	private JTextField txtZip;
	//Telephone Number
	private JLabel telephoneNumber;
	private JLabel hyphen;
	private JTextField areaCode;
	private JTextField secondThreeDigits;
	private JTextField lastFourDigits;
	//cell number
	

	ContactInfoPanel(){
		//this.setBackground(new Color(105));
		flow = new FlowLayout();
		flow.setVgap(10);
		this.setLayout(flow);
		this.setPreferredSize(new Dimension(390, 200));
		
		//First name
		lblFirstName = new JLabel("First Name: ");
		this.add(lblFirstName);
		
		txtFirstName = new JTextField(10);
		this.add(txtFirstName);
		
		//Last name
		lblLastName = new JLabel("Last Name: ");
		this.add(lblLastName);
		
		txtLastName = new JTextField(10);
		this.add(txtLastName);
		
		//Address
		lblAddress = new JLabel("Street Address: ");
		this.add(lblAddress);
		
		txtAddress = new JTextField(25);
		this.add(txtAddress);
		
		//City
		lblCity = new JLabel("City: ");
		this.add(lblCity);
		
		txtCity = new JTextField(10);
		this.add(txtCity);
		
		//State
		lblState = new JLabel("State: ");
		this.add(lblState);
		
		txtState = new FixedTextField(2);
		this.add(txtState);
		
		//Zip
		lblZip = new JLabel("Zip: ");
		this.add(lblZip);
		
		txtZip = new FixedTextField(5);
		this.add(txtZip);
		
		//Telephone number
		telephoneNumber = new JLabel("Telephone Number: ");
		this.add(telephoneNumber);
		
		areaCode = new FixedTextField(3);
		this.add(areaCode);
		
		this.add(new JLabel("-"));
		
		secondThreeDigits = new FixedTextField(3);
		this.add(secondThreeDigits);
		
		this.add(new JLabel("-"));
		
		lastFourDigits = new FixedTextField(4);
		this.add(lastFourDigits);
		
	}
	


}
