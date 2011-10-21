package gui.listeners;

import gui.panels.ContactListPanel;
import gui.panels.contactinfo.ContactInfoPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import contacts.Contact;

public class NewContactActionListener implements ActionListener{
	
	//Panels
	private JPanel contactInfo;
	private JPanel contactList;
	//contact
	//private Contact contact;
	

	public NewContactActionListener(JPanel contactInfo, JPanel contactList){
		this.contactInfo = contactInfo;
		this.contactList = (ContactListPanel) contactList;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		Contact contact;
		
		String firstName = ((ContactInfoPanel) contactInfo).getTxtFirstName().getText();
		String lastName = ((ContactInfoPanel) contactInfo).getTxtLastName().getText();
		String address = ((ContactInfoPanel) contactInfo).getTxtAddress().getText();
		//contact = new Contact(0, )
	}

}
