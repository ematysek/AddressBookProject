package gui.listeners;

import gui.Validator;
import gui.panels.ContactListPanel;
import gui.panels.contactinfo.ContactInfoPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import sql.JDBCConnection;
import sql.MyConnection;
import contacts.Contact;


/**
 * The NewContactListener class creates an action listener for a specific event.
 * 
 * @author Juan Ramirez
 * 
 */
public class NewContactActionListener implements ActionListener {

	// Panels
	private ContactInfoPanel contactInfo;
	private ContactListPanel contactList;
	// Connection
	private JDBCConnection connection;
	// Field Validator
	private Validator validator;

	/**
	 * Casts panels to access their information inputed by user to add a new
	 * contact into the database
	 * 
	 * @param contactInfo
	 * @param contactList
	 */
	public NewContactActionListener(JPanel contactInfo, JPanel contactList) {
		this.contactInfo = (ContactInfoPanel) contactInfo;
		this.contactList = (ContactListPanel) contactList;
		validator = new Validator(contactInfo);
		this.connection = MyConnection.getConnection();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		String errorMessages = validator.validateFields();
		if (errorMessages.equals("")) {
			Contact contact = contactInfo.getContact();
			// JDBCConnection myConnection = new JDBCConnection();
			connection.addContact(contact);
			contactList.nodeAdded();
		} else {
			JOptionPane.showMessageDialog(contactInfo, errorMessages, "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}

}
