package gui.listeners;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import sql.JDBCConnection;

import contacts.Contact;
import contacts.ContactList;

import gui.panels.ButtonPanel;
import gui.panels.ContactListPanel;
import gui.panels.contactinfo.ContactInfoPanel;
import gui.panels.contactinfo.InfoButtonPanel;
import gui.panels.contactinfo.PhoneNumberPanel;

public class SelectionListener implements TreeSelectionListener {

	private ButtonPanel buttonPanel;
	private ContactListPanel contactListPanel;
	private ContactInfoPanel contactInfoPanel;
	private InfoButtonPanel infoButtonPanel;
	private JDBCConnection connection;

	public SelectionListener(JPanel contactListPanel, JPanel contactInfoPanel, JPanel buttonPanel) {
		this.contactListPanel = (ContactListPanel) contactListPanel;
		this.contactInfoPanel = (ContactInfoPanel) contactInfoPanel;
		this.buttonPanel = (ButtonPanel) buttonPanel;
		this.infoButtonPanel = this.contactInfoPanel.getInfoButtonPanel();
		this.connection = new JDBCConnection();
	}

	@Override
	public void valueChanged(TreeSelectionEvent tse) {
		// TODO line 38

		int selectedIndex = contactListPanel.getSelectedIndex();
		if (selectedIndex >= 0) {
			//System.out.println(index);
			if(!infoButtonPanel.getSaveChanges().isEnabled()){
				infoButtonPanel.getSaveChanges().setEnabled(true);
			}
			if(!buttonPanel.getDelete().isEnabled()){
				buttonPanel.getDelete().setEnabled(true);
			}
			ContactList contactList = connection.getContactList();
			Contact contact = contactList.get(selectedIndex); //change to connection.get(index)
			populateContactInfo(contact);
		}
		else {
			if(infoButtonPanel.getSaveChanges().isEnabled()){
				infoButtonPanel.getSaveChanges().setEnabled(false);
			}
			if(buttonPanel.getDelete().isEnabled()){
				buttonPanel.getDelete().setEnabled(false);
			}
			contactInfoPanel.clearFields();
		}
		
	}
	
	//should this method be in this class?
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
