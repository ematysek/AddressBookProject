package gui.panels.contactinfo;

import gui.ConstraintsFactory;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Panel containing text boxes for home and cell phone numbers.
 * 
 * @author Eric Matysek
 * 
 */
public class PhoneNumberPanel extends JPanel {

	// Insets
	private Insets insets;
	// Telephone Number
	private JLabel homePhoneNumber;
	private JTextField homeAreaCode;
	private JTextField homeThreeDigits;
	private JTextField homeFourDigits;
	// cell number
	private JLabel cellPhoneNumber;
	private JTextField cellAreaCode;
	private JTextField cellThreeDigits;
	private JTextField cellFourDigits;

	/**
	 * Constructs a new phone number panel with home and cell phone numbers.
	 */
	public PhoneNumberPanel() {
		this.setLayout(new GridBagLayout());

		// Declare default insets
		insets = new Insets(0, 0, 5, 0);

		// Telephone number
		homePhoneNumber = new JLabel("Home Phone: ");
		this.add(homePhoneNumber, ConstraintsFactory.getConstraints(0, 0, 1, 1,
				GridBagConstraints.CENTER, insets));

		homeAreaCode = new FixedTextField(3);
		this.add(homeAreaCode, ConstraintsFactory.getConstraints(1, 0, 1, 1,
				GridBagConstraints.CENTER, insets));

		this.add(new JLabel(" - "), ConstraintsFactory.getConstraints(2, 0, 1,
				1, GridBagConstraints.CENTER, insets));

		homeThreeDigits = new FixedTextField(3);
		this.add(homeThreeDigits, ConstraintsFactory.getConstraints(3, 0, 1, 1,
				GridBagConstraints.CENTER, insets));

		this.add(new JLabel(" - "), ConstraintsFactory.getConstraints(4, 0, 1,
				1, GridBagConstraints.CENTER, insets));

		homeFourDigits = new FixedTextField(4);
		this.add(homeFourDigits, ConstraintsFactory.getConstraints(5, 0, 1, 1,
				GridBagConstraints.CENTER, insets));

		// Emptyspace
		this.add(new JLabel(
				"                                                   "),
				ConstraintsFactory.getConstraints(6, 0, 1, 1,
						GridBagConstraints.CENTER, insets));

		// Cell phone
		cellPhoneNumber = new JLabel("Cell Phone: ");
		this.add(cellPhoneNumber, ConstraintsFactory.getConstraints(0, 1, 1, 1,
				GridBagConstraints.EAST, insets));

		cellAreaCode = new FixedTextField(3);
		this.add(cellAreaCode, ConstraintsFactory.getConstraints(1, 1, 1, 1,
				GridBagConstraints.CENTER, insets));

		this.add(new JLabel(" - "), ConstraintsFactory.getConstraints(2, 1, 1,
				1, GridBagConstraints.CENTER, insets));

		cellThreeDigits = new FixedTextField(3);
		this.add(cellThreeDigits, ConstraintsFactory.getConstraints(3, 1, 1, 1,
				GridBagConstraints.CENTER, insets));

		this.add(new JLabel(" - "), ConstraintsFactory.getConstraints(4, 1, 1,
				1, GridBagConstraints.CENTER, insets));

		cellFourDigits = new FixedTextField(4);
		this.add(cellFourDigits, ConstraintsFactory.getConstraints(5, 1, 1, 1,
				GridBagConstraints.CENTER, insets));
	}

	/**
	 * Clears all text boxes within this panel
	 */
	public void clearFields() {
		homeAreaCode.setText("");
		homeThreeDigits.setText("");
		homeFourDigits.setText("");
		cellAreaCode.setText("");
		cellThreeDigits.setText("");
		cellFourDigits.setText("");
	}

	/**
	 * Returns the area code of the home number
	 * 
	 * @return the homeAreaCode
	 */
	public JTextField getHomeAreaCode() {
		return homeAreaCode;
	}

	/**
	 * Returns the middle three digits of the home number
	 * 
	 * @return the homeThreeDigits
	 */
	public JTextField getHomeThreeDigits() {
		return homeThreeDigits;
	}

	/**
	 * Returns the last for digits of the home number
	 * 
	 * @return the homeFourDigits
	 */
	public JTextField getHomeFourDigits() {
		return homeFourDigits;
	}

	/**
	 * Returns the area code of the cell number
	 * 
	 * @return the cellAreaCode
	 */
	public JTextField getCellAreaCode() {
		return cellAreaCode;
	}

	/**
	 * Returns the middle three digits of the cell number
	 * 
	 * @return the cellThreeDigits
	 */
	public JTextField getCellThreeDigits() {
		return cellThreeDigits;
	}

	/**
	 * Returns the last four digits of the cell number
	 * 
	 * @return the cellFourDigits
	 */
	public JTextField getCellFourDigits() {
		return cellFourDigits;
	}

	/**
	 * Returns the home phone number
	 * 
	 * @return The home phone number by appending each group of digits
	 */
	public String getHomePhone() {
		return (homeAreaCode.getText() + homeThreeDigits.getText() + homeFourDigits
				.getText());
	}

	/**
	 * Returns the cell phone number
	 * 
	 * @return The cell phone number by appending each group of digits
	 */
	public String getCellPhone() {
		return (cellAreaCode.getText() + cellThreeDigits.getText() + cellFourDigits
				.getText());
	}
}
