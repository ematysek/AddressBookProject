package gui;

import javax.swing.JPanel;

import gui.panels.contactinfo.ContactInfoPanel;
import gui.panels.contactinfo.PhoneNumberPanel;

/**
 * @author Juan Ramirez
 *
 */

public class Validator {

	private ContactInfoPanel contactInfo;

	public Validator(JPanel contactInfoPnl) {
		this.contactInfo = (ContactInfoPanel) contactInfoPnl;
	}// end validator

	public String validateFields() {
		String errorMessage = "";
		// Checks the state
		String state = contactInfo.getTxtState().getText();
		boolean equalState = false;
		
		String stateArray[] = { "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE",
				"FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA",
				"ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV",
				"NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA",
				"RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV",
				"WI", "WY" };
		
		for(int count = 0 ; count < stateArray.length ; count++){
				if(state.compareToIgnoreCase(stateArray[count]) == 0){
					equalState = true;
					
					//to break the for loop
					count = stateArray.length; 
				}//end if
				else {
					equalState = false;
				}//end else			
		}//end for

		if(!equalState){
			errorMessage += "Please enter a valid State.\n";
		}
		
		// Checks Home Phone number Errors
		try {
			// Checks the phone number
			int homePhoneNumber = Integer
					.parseInt(((PhoneNumberPanel) (contactInfo)
							.getPhoneNumberPanel()).getHomeAreaCode().getText()
							+ ((PhoneNumberPanel) (contactInfo)
									.getPhoneNumberPanel())
									.getHomeThreeDigits().getText()
							+ ((PhoneNumberPanel) (contactInfo)
									.getPhoneNumberPanel()).getHomeFourDigits()
									.getText());
		}
		catch (NumberFormatException nfe) {
			// Error message
			errorMessage += "Error at Home Phone Number\n";
		}

		// Checks for Cell Phone number errors
		try {
			// Checks the phone number
			int cellPhoneNumber = Integer
					.parseInt(((PhoneNumberPanel) (contactInfo)
							.getPhoneNumberPanel()).getCellAreaCode().getText()
							+ ((PhoneNumberPanel) (contactInfo)
									.getPhoneNumberPanel())
									.getCellThreeDigits().getText()
							+ ((PhoneNumberPanel) (contactInfo)
									.getPhoneNumberPanel()).getCellFourDigits()
									.getText());
		}

		catch (NumberFormatException nfe) {
			// Error message
			errorMessage += "Error at Cell Phone Number\n";
		}

		// Checks zip code
		try {
			int zipCode = Integer.parseInt(contactInfo.getTxtZip().getText());
		}

		catch (NumberFormatException nfe) {
			// Error Message
			errorMessage += "Error at ZIP Code";
		}

		// Checks Email
		String emailText = contactInfo.getTxtEmail().getText();
		
		if(!emailText.contains("@") || !emailText.contains(".")){	
			errorMessage += "Error at Email\n";
		}
		
		return errorMessage;
	}

	private boolean contains(String atSymbol, String dotSymbol) {
		// TODO Auto-generated method stub
		return true;
	}

}

