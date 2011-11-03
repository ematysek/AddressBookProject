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
	private PhoneNumberPanel phoneNumberPanel;

	public Validator(JPanel contactInfoPnl) {
		this.contactInfo = (ContactInfoPanel) contactInfoPnl;
		this.phoneNumberPanel = (PhoneNumberPanel) contactInfo
				.getPhoneNumberPanel();
	}// end validator

	public String validateFields() {
		String errorMessage = "";
		// Checks the state
		String state = contactInfo.getTxtState().getText();
		boolean equalState = false;

		if (!state.equals("")) {
			String stateArray[] = { "AL", "AK", "AZ", "AR", "CA", "CO", "CT",
					"DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY",
					"LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE",
					"NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR",
					"PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA",
					"WV", "WI", "WY" };

			for (int count = 0; count < stateArray.length; count++) {
				if (state.compareToIgnoreCase(stateArray[count]) == 0) {
					equalState = true;

					// to break the for loop
					count = stateArray.length;
				}// end if
				else {
					equalState = false;
				}// end else
			}// end for

			if (!equalState) {
				errorMessage += "Please enter a valid State.\n";
			}
		}

		String strHomeNumber = phoneNumberPanel.getHomePhone();
		if (!strHomeNumber.equals("")) {
			if (strHomeNumber.length() == 10) {
				// Checks Home Phone number Errors
				try {
					// Checks the phone number
					Long.parseLong(strHomeNumber);
				} catch (NumberFormatException nfe) {
					// Error message
					errorMessage += "Error at Home Phone Number\n";
				}
			} else {
				errorMessage += "Please enter a 10-digit home phone number\n";
			}
		}

		String strCellNumber = phoneNumberPanel.getCellPhone();
		if (!strCellNumber.equals("")) {
			if (strCellNumber.length() != 10) {
				// Checks for Cell Phone number errors
				try {
					// Checks the phone number
					Long.parseLong(strCellNumber);
				}

				catch (NumberFormatException nfe) {
					// Error message
					errorMessage += "Error at Cell Phone Number\n";
				}
			} else {
				errorMessage += "Please enter a 10-digit cell phone number";
			}
		}

		String strZip = contactInfo.getTxtZip().getText();
		if (!strZip.equals("")) {
			// Checks zip code
			try {
				int zipCode = Integer.parseInt(strZip);
			}

			catch (NumberFormatException nfe) {
				// Error Message
				errorMessage += "Error at ZIP Code\n";
			}
		}

		// Checks Email
		String emailText = contactInfo.getTxtEmail().getText();

		if (!emailText.equals("")) {
			if (!emailText.contains("@") || !emailText.contains(".")) {
				errorMessage += "Error at Email\n";
			}
		}

		return errorMessage;
	}

}
