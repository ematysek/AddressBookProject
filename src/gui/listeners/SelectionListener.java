package gui.listeners;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import sql.JDBCConnection;

import contacts.Contact;
import contacts.ContactList;

import gui.panels.ContactListPanel;
import gui.panels.contactinfo.ContactInfoPanel;
import gui.panels.contactinfo.PhoneNumberPanel;

public class SelectionListener implements TreeSelectionListener {

	private JPanel contactListPanel;
	private ContactInfoPanel contactInfoPanel;
	private JDBCConnection connection;

	public SelectionListener(JPanel contactListPanel, JPanel contactInfoPanel) {
		this.contactListPanel = contactListPanel;
		this.contactInfoPanel = (ContactInfoPanel) contactInfoPanel;
		connection = new JDBCConnection();
	}

	@Override
	public void valueChanged(TreeSelectionEvent arg0) {
		// TODO line 46

		JTree tree = ((ContactListPanel) contactListPanel).getContactTree();

		//Get selected node
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

		//if node is seleted, get index of node
		if (node != null) {
			DefaultMutableTreeNode rootNode = ((ContactListPanel) contactListPanel).getRootNode();
			int index = rootNode.getIndex(node);
			if (index >= 0) {
				System.out.println(index);
				ContactList contactList = connection.getContactList();
				Contact contact = contactList.get(index); //change to connection.get(index)
				populateContactInfo(contact);
			}
		}

	}
	
	private void populateContactInfo(Contact contact){
	PhoneNumberPanel phoneNumberPanel = (PhoneNumberPanel) contactInfoPanel.getPhoneNumberPanel();
	
		//Information
		String firstName = contact.getFirstName();
		String lastName = contact.getLastName();
		String address = contact.getAddress();
		String city = contact.getCity();
		String state = contact.getState();
		String zip = contact.getZip();
		//Phone numbers
		String homePhone = contact.getHomePhone();
		String homeAreaCode = homePhone.substring(0, 3);
		String homeThreeDigits = homePhone.substring(3, 6);
		String homeFourDigits = homePhone.substring(6, 10);
		String cellPhone = contact.getCellPhone();
		String cellAreaCode = cellPhone.substring(0, 3);
		String cellThreeDigits = cellPhone.substring(3, 6);
		String cellFourDigits = cellPhone.substring(6, 10);
		//email
		String email = contact.getEmail();
		
		//Set text of text fields
		contactInfoPanel.getTxtFirstName().setText(firstName);
		contactInfoPanel.getTxtLastName().setText(lastName);
		contactInfoPanel.getTxtAddress().setText(address);
		contactInfoPanel.getTxtCity().setText(city);
		contactInfoPanel.getTxtState().setText(state);
		contactInfoPanel.getTxtZip().setText(zip);
		phoneNumberPanel.getHomeAreaCode().setText(homeAreaCode);
		phoneNumberPanel.getHomeThreeDigits().setText(homeThreeDigits);
		phoneNumberPanel.getHomeFourDigits().setText(homeFourDigits);
		phoneNumberPanel.getCellAreaCode().setText(cellAreaCode);
		phoneNumberPanel.getCellThreeDigits().setText(cellThreeDigits);
		phoneNumberPanel.getCellFourDigits().setText(cellFourDigits);
		contactInfoPanel.getTxtEmail().setText(email);
	}

}
