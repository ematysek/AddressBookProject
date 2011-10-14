package gui.listeners;

import gui.panels.ContactListPanel;
import gui.panels.contactinfo.ContactInfoPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class NewContactActionListener implements ActionListener{
	
	JPanel contactInfo;
	JPanel contactList;

	public NewContactActionListener(JPanel contactInfo, JPanel contactList){
		this.contactInfo = (ContactInfoPanel) contactInfo;
		this.contactList = (ContactListPanel) contactList;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	}

}
