package gui.panels.contactinfo;

import gui.panels.ContactListPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import contacts.Contact;

/**
 * @author Eric Matysek
 * 
 */
public class ContactInfoPanel extends JPanel {

	// **************************************
	// Class-Level Variables / GUI Components
	// **************************************

	// FlowLayout
	private FlowLayout flow;

	// First name
	private JLabel lblFirstName;
	private JTextField txtFirstName;
	// Last name
	private JLabel lblLastName;
	private JTextField txtLastName;
	// Address
	private JLabel lblAddress;
	private JTextField txtAddress;
	// City
	private JLabel lblCity;
	private JTextField txtCity;
	// State
	private JLabel lblState;
	private JTextField txtState;
	// zip
	private JLabel lblZip;
	private JTextField txtZip;
	//Phone Numbers
	private PhoneNumberPanel phoneNumberPanel;
	// email
	private JLabel lblEmail;
	private JTextField txtEmail;
	//jlist
	private ContactListPanel contactListPanel;
	// lower button panel
	private InfoButtonPanel infoButtonPanel;

	public ContactInfoPanel() {
		// this.setBackground(new Color(105));
		flow = new FlowLayout();
		flow.setVgap(10);
		this.setLayout(flow);
		this.setPreferredSize(new Dimension(390, 300));

		// First name
		lblFirstName = new JLabel("First Name: ");
		this.add(lblFirstName);

		txtFirstName = new JTextField(10);
		this.add(txtFirstName);

		// Last name
		lblLastName = new JLabel("Last Name: ");
		this.add(lblLastName);

		txtLastName = new JTextField(10);
		this.add(txtLastName);

		// Address
		lblAddress = new JLabel("Street Address: ");
		this.add(lblAddress);

		txtAddress = new JTextField(25);
		this.add(txtAddress);

		// City
		lblCity = new JLabel("City: ");
		this.add(lblCity);

		txtCity = new JTextField(10);
		this.add(txtCity);

		// State
		lblState = new JLabel("State: ");
		this.add(lblState);

		txtState = new FixedTextField(2);
		this.add(txtState);

		// Zip
		lblZip = new JLabel("Zip: ");
		this.add(lblZip);

		txtZip = new FixedTextField(5);
		this.add(txtZip);

		// Phone numbers
		phoneNumberPanel = new PhoneNumberPanel();
		this.add(phoneNumberPanel);

		// Email address
		lblEmail = new JLabel("Email Address: ");
		this.add(lblEmail);

		txtEmail = new JTextField(20);
		this.add(txtEmail);

		// Empty space
		//this.add(new JLabel("                                            "));
		
		// lower button panel
		infoButtonPanel = new InfoButtonPanel(this);
		this.add(infoButtonPanel);
	}
	
	public void clearFields(){
		txtFirstName.setText("");
		txtLastName.setText("");
		txtAddress.setText("");
		txtCity.setText("");
		txtState.setText("");
		txtZip.setText("");
		((PhoneNumberPanel) phoneNumberPanel).clearFields();
		txtEmail.setText("");
	}
	
	public Contact getContact(){
		Contact contact = new Contact("0", txtFirstName.getText(), txtLastName.getText(), txtAddress.getText(), 
			txtCity.getText(), txtState.getText().toUpperCase(), txtZip.getText(), 
			phoneNumberPanel.getHomePhone(), 
			phoneNumberPanel.getCellPhone(), 
			txtEmail.getText());
			
		return contact;
	}

	/**
	 * @return the txtFirstName
	 */
	public JTextField getTxtFirstName() {
		return txtFirstName;
	}

	/**
	 * @return the txtLastName
	 */
	public JTextField getTxtLastName() {
		return txtLastName;
	}

	/**
	 * @return the txtAddress
	 */
	public JTextField getTxtAddress() {
		return txtAddress;
	}

	/**
	 * @return the txtCity
	 */
	public JTextField getTxtCity() {
		return txtCity;
	}

	/**
	 * @return the txtState
	 */
	public JTextField getTxtState() {
		return txtState;
	}

	/**
	 * @return the txtZip
	 */
	public JTextField getTxtZip() {
		return txtZip;
	}

	/**
	 * @return the phoneNumberPanel
	 */
	public JPanel getPhoneNumberPanel() {
		return phoneNumberPanel;
	}

	/**
	 * @return the txtEmail
	 */
	public JTextField getTxtEmail() {
		return txtEmail;
	}
	
	public void setContactListPanel(JPanel contactListPanel){
		this.contactListPanel = (ContactListPanel) contactListPanel;
		infoButtonPanel.setContactListPanel(contactListPanel);
	}

	/**
	 * @return the infoButtonPanel
	 */
	public InfoButtonPanel getInfoButtonPanel() {
		return infoButtonPanel;
	}

}
