package gui.listeners;

import gui.panels.ContactListPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import sql.JDBCConnection;
import sql.MyConnection;
import contacts.Contact;
import contacts.ContactList;

/**
 * DeleteActionListener class creates an action listener for a specific event.
 * 
 * @author Juan Ramirez, Eric Matysek
 * 
 */
public class DeleteActionListener implements ActionListener {

	private ContactListPanel contactListPanel;
	private JDBCConnection connection;

	/**
	 * Casts panels to access their information of the contact selected from
	 * contactListpanel to delete it.
	 * 
	 * @param contactListPanel
	 */
	public DeleteActionListener(JPanel contactListPanel) {
		this.contactListPanel = (ContactListPanel) contactListPanel;
		// this.connection = new JDBCConnection();
		this.connection = MyConnection.getConnection();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		ContactList contactList = contactListPanel.getContactList();
		int index = contactListPanel.getSelectedIndex();
		if (index >= 0) {
			Contact contact = contactList.get(index);
			int contactID = Integer.parseInt(contact.getID());
			connection.removeContact(contactID);
			contactListPanel.nodeRemoved(index);
			// contactListPanel.refreshList();
		} else {
			JOptionPane.showMessageDialog(contactListPanel,
					"No contact was selected", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
