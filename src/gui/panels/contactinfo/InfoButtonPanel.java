package gui.panels.contactinfo;

import gui.panels.ContactListPanel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import contacts.Contact;

import sql.JDBCConnection;

public class InfoButtonPanel extends JPanel implements ActionListener {

	// buttons
	private JButton saveChanges;
	private JButton clear;
	//Panel
	private ContactInfoPanel contactInfoPanel;
	private ContactListPanel contactListPanel;
	//Database Connection
	private JDBCConnection connection;

	public InfoButtonPanel(JPanel contactInfoPanel) {
		this.setLayout(new FlowLayout());
		
		this.contactInfoPanel = (ContactInfoPanel) contactInfoPanel;
		this.contactListPanel = (ContactListPanel) contactListPanel;
		connection = new JDBCConnection();

		saveChanges = new JButton("Save Changes");
		saveChanges.setEnabled(false);
		saveChanges.addActionListener(this);
		this.add(saveChanges);

		clear = new JButton("Clear Fields");
		clear.addActionListener(this);
		this.add(clear);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == saveChanges) {
			Contact contact = contactInfoPanel.getContact();
			connection.updateContact(contact);
		} else if (e.getSource() == clear) {
			((ContactInfoPanel) contactInfoPanel).clearFields();
		}
	}

	/**
	 * @param contactListPanel2 the contactListPanel to set
	 */
	public void setContactListPanel(JPanel contactListPanel) {
		this.contactListPanel = (ContactListPanel) contactListPanel;
	}

	/**
	 * @return the saveChanges
	 */
	public JButton getSaveChanges() {
		return saveChanges;
	}

}
