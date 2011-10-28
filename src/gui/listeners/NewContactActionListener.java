package gui.listeners;

import gui.panels.ContactListPanel;
import gui.panels.contactinfo.ContactInfoPanel;
import gui.panels.contactinfo.PhoneNumberPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import sql.JDBCConnection;

import contacts.Contact;

public class NewContactActionListener implements ActionListener{
	
	//Panels
	private ContactInfoPanel  contactInfo;
	private ContactListPanel contactList;
	//contact
	//private Contact contact;
	

	public NewContactActionListener(JPanel contactInfo, JPanel contactList){
		this.contactInfo = (ContactInfoPanel) contactInfo;
		this.contactList = (ContactListPanel) contactList;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {

		//What would we send as the ID
		Contact contact= contactInfo.getContact();
		
		JDBCConnection myConnection = new JDBCConnection();
		myConnection.addContact(contact);

	}

}
