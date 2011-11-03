package gui.panels.contactinfo;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import contacts.Contact;

/**
 * Panel to display all Contact information
 * 
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
	// Phone Numbers
	private PhoneNumberPanel phoneNumberPanel;
	// email
	private JLabel lblEmail;
	private JTextField txtEmail;
	// jtree
	// private ContactListPanel contactListPanel; - unused
	// lower button panel
	private InfoButtonPanel infoButtonPanel;

	/**
	 * Constructs a new ContactInfoPanel to display Contact information that can
	 * be edited.
	 */
	public ContactInfoPanel() {
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

		// lower button panel
		infoButtonPanel = new InfoButtonPanel(this);
		this.add(infoButtonPanel);
	}

	/**
	 * Clears all fields on this panel and calls the clearFields() method of the
	 * phoneNumberPanel.
	 */
	public void clearFields() {
		txtFirstName.setText("");
		txtLastName.setText("");
		txtAddress.setText("");
		txtCity.setText("");
		txtState.setText("");
		txtZip.setText("");
		((PhoneNumberPanel) phoneNumberPanel).clearFields();
		txtEmail.setText("");
	}

	/**
	 * Returns a contact created from the JTextFields, 0 used as the ID because
	 * the ID is not set by the user.
	 * 
	 * @return contact the contact created from the JTextFields
	 */
	public Contact getContact() {
		Contact contact = new Contact("0", txtFirstName.getText(),
				txtLastName.getText(), txtAddress.getText(), txtCity.getText(),
				txtState.getText().toUpperCase(), txtZip.getText(),
				phoneNumberPanel.getHomePhone(),
				phoneNumberPanel.getCellPhone(), txtEmail.getText());

		return contact;
	}

	/**
	 * Returns the infoButtonPanel.
	 * 
	 * @return the infoButtonPanel
	 */
	public InfoButtonPanel getInfoButtonPanel() {
		return infoButtonPanel;
	}

	/**
	 * Returns the phone number panel
	 * 
	 * @return the phoneNumberPanel
	 */
	public JPanel getPhoneNumberPanel() {
		return phoneNumberPanel;
	}

	/**
	 * Returns the Address JTextField
	 * 
	 * @return the Address JTextField
	 */
	public JTextField getTxtAddress() {
		return txtAddress;
	}

	/**
	 * Returns the City JTextField
	 * 
	 * @return the City JTextField
	 */
	public JTextField getTxtCity() {
		return txtCity;
	}

	/**
	 * Returns the Email JTextField
	 * 
	 * @return the Email JTextField
	 */
	public JTextField getTxtEmail() {
		return txtEmail;
	}

	/**
	 * Returns the First Name JTextField
	 * 
	 * @return the First Name JTextField
	 */
	public JTextField getTxtFirstName() {
		return txtFirstName;
	}

	/**
	 * Returns the Last Name JTextField
	 * 
	 * @return the Last Name JTextField
	 */
	public JTextField getTxtLastName() {
		return txtLastName;
	}

	/**
	 * Returns the State JTextField
	 * 
	 * @return the State JTextField
	 */
	public JTextField getTxtState() {
		return txtState;
	}

	/**
	 * Returns the Zip JTextField
	 * 
	 * @return the Zip JTextField
	 */
	public JTextField getTxtZip() {
		return txtZip;
	}

	/**
	 * Populates the JTextFields using information from the provided Contact
	 * object.
	 * 
	 * @param contact
	 *            the contact whose information will be put into the text boxes
	 */
	public void populateTextFields(Contact contact) {
		// Contact Information
		String firstName = contact.getFirstName();
		String lastName = contact.getLastName();
		String address = contact.getAddress();
		String city = contact.getCity();
		String state = contact.getState();
		String zip = contact.getZip();
		// Phone numbers
		String homePhone = contact.getHomePhone();
		String homeAreaCode = "";
		String homeThreeDigits = "";
		String homeFourDigits = "";
		// Validate homephone isn't null and is 10 chars long
		if (homePhone != null) {
			if (homePhone.length() == 10) {
				homeAreaCode = homePhone.substring(0, 3);
				homeThreeDigits = homePhone.substring(3, 6);
				homeFourDigits = homePhone.substring(6, 10);
			}
		}
		String cellPhone = contact.getCellPhone();
		String cellAreaCode = "";
		String cellThreeDigits = "";
		String cellFourDigits = "";
		// Validate cellphone isn't null and is 10 chars long
		if (cellPhone != null) {
			if (cellPhone.length() == 10) {
				cellAreaCode = cellPhone.substring(0, 3);
				cellThreeDigits = cellPhone.substring(3, 6);
				cellFourDigits = cellPhone.substring(6, 10);
			}
		}
		// email
		String email = contact.getEmail();

		// Set text of text fields using contact information
		getTxtFirstName().setText(firstName);
		getTxtLastName().setText(lastName);
		getTxtAddress().setText(address);
		getTxtCity().setText(city);
		getTxtState().setText(state);
		getTxtZip().setText(zip);
		phoneNumberPanel.getHomeAreaCode().setText(homeAreaCode);
		phoneNumberPanel.getHomeThreeDigits().setText(homeThreeDigits);
		phoneNumberPanel.getHomeFourDigits().setText(homeFourDigits);
		phoneNumberPanel.getCellAreaCode().setText(cellAreaCode);
		phoneNumberPanel.getCellThreeDigits().setText(cellThreeDigits);
		phoneNumberPanel.getCellFourDigits().setText(cellFourDigits);
		getTxtEmail().setText(email);
	}

	/**
	 * Sets the contactListPanel
	 * 
	 * @param contactListPanel
	 *            The ContactListPanel to set.
	 */
	public void setContactListPanel(JPanel contactListPanel) {
		// This method is here so that this panel can receive the
		// contactListPanel and pass it to the infoButtonPanel after
		// contactListPanel has been declared.

		// this.contactListPanel = (ContactListPanel) contactListPanel; - field
		// never used

		infoButtonPanel.setContactListPanel(contactListPanel);
	}

}
