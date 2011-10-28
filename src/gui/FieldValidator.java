package gui;

import gui.panels.contactinfo.ContactInfoPanel;

import javax.swing.JPanel;

public class FieldValidator {

	private ContactInfoPanel contactInfo;
	
	public FieldValidator(JPanel contactInfo){
		this.contactInfo = (ContactInfoPanel) contactInfo;
	}
	
	public String validateFields(){
		return null;
	}
	
}
