package gui.panels.contactinfo;

import gui.Validator;

import gui.panels.ContactListPanel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

import contacts.Contact;

import sql.JDBCConnection;
import sql.MyConnection;

public class InfoButtonPanel extends JPanel implements ActionListener {

	// buttons
	private JButton saveChanges;
	private JButton clear;
	//Panel
	private ContactInfoPanel contactInfoPanel;
	private ContactListPanel contactListPanel;
	//Database Connection
	private JDBCConnection connection;
	// Field Validator
	private Validator validator;

	public InfoButtonPanel(JPanel contactInfoPanel) {
		this.setLayout(new FlowLayout());
		
		this.contactInfoPanel = (ContactInfoPanel) contactInfoPanel;
		this.contactListPanel = (ContactListPanel) contactListPanel;
		//this.connection = new JDBCConnection();
		connection = MyConnection.getConnection();

		this.saveChanges = new JButton("Save Changes");
		saveChanges.setEnabled(false);
		saveChanges.addActionListener(this);
		this.add(saveChanges);

		this.clear = new JButton("Clear Fields");
		clear.addActionListener(this);
		this.add(clear);

		validator = new Validator(contactInfoPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == saveChanges) {
			String errorMessages = validator.validateFields();
			if(errorMessages.equals("")){
				int selectedIndex = contactListPanel.getSelectedIndex();
				String contactID = connection.getSortedContactList().get(selectedIndex).getID();
				Contact contact = contactInfoPanel.getContact();
				contact.setID(contactID);
				connection.updateContact(contact);
				contactListPanel.nodeChanged(selectedIndex);
				//contactListPanel.refreshList();
			} else {
				JOptionPane.showMessageDialog(contactInfoPanel, errorMessages, "Error", JOptionPane.ERROR_MESSAGE);
			}
			
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
