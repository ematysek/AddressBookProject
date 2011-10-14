package gui.listeners;

import gui.panels.ContactListPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

/**
 * Create an action listener for a specific event.
 * 
 * @author Eric Matysek
 * 
 */
public class DeleteActionListener implements ActionListener {

	JPanel contactList;
	
	public DeleteActionListener(JPanel contactList){
		this.contactList = (ContactListPanel) contactList;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		
	}

}
