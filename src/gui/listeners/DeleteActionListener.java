package gui.listeners;

import gui.panels.ContactListPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import sql.JDBCConnection;

import contacts.Contact;
import contacts.ContactList;

/**
 * Create an action listener for a specific event.
 * 
 * @author Eric Matysek
 * 
 */
public class DeleteActionListener implements ActionListener {

	private ContactListPanel contactListPanel;
	private JDBCConnection connection;

	public DeleteActionListener(JPanel contactListPanel) {
		this.contactListPanel = (ContactListPanel) contactListPanel;
		this.connection = new JDBCConnection();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		ContactList contactList = contactListPanel.getContactList();
		int index = contactListPanel.getSelectedIndex();
		if(index >= 0){
			Contact contact = contactList.get(index);
			int contactID = Integer.parseInt(contact.getID());
			connection.removeContact(contactID);
		} else {
			//TODO pop-up explaining no contact is selected.
			JOptionPane.showMessageDialog(contactListPanel, "No contact was selected", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
