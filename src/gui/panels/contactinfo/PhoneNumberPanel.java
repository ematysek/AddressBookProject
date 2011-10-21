package gui.panels.contactinfo;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.ConstraintsFactory;

/**
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
	//Phone Numbers
	private String homePhone;
	private String cellPhone;

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
	
	public void clearFields(){
		homeAreaCode.setText("");
		homeThreeDigits.setText("");
		homeFourDigits.setText("");
		cellAreaCode.setText("");
		cellThreeDigits.setText("");
		cellFourDigits.setText("");
	}

	/**
	 * @return the homeAreaCode
	 */
	public JTextField getHomeAreaCode() {
		return homeAreaCode;
	}

	/**
	 * @return the homeThreeDigits
	 */
	public JTextField getHomeThreeDigits() {
		return homeThreeDigits;
	}

	/**
	 * @return the homeFourDigits
	 */
	public JTextField getHomeFourDigits() {
		return homeFourDigits;
	}

	/**
	 * @return the cellAreaCode
	 */
	public JTextField getCellAreaCode() {
		return cellAreaCode;
	}

	/**
	 * @return the cellThreeDigits
	 */
	public JTextField getCellThreeDigits() {
		return cellThreeDigits;
	}

	/**
	 * @return the cellFourDigits
	 */
	public JTextField getCellFourDigits() {
		return cellFourDigits;
	}
	
	public String getHomePhone(){
	return (homeAreaCode.getText() + homeThreeDigits.getText() + homeFourDigits.getText());
	}
	
	public String getCellPhone(){
	return (cellAreaCode.getText() + cellThreeDigits.getText() + homeFourDigits.getText());
	}
}
