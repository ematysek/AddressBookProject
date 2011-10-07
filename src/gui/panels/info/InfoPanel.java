package gui.panels.info;

import gui.ConstraintsFactory;
import gui.panels.contactinfo.FixedTextField;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InfoPanel extends JPanel {
	
	//This panel is just a different design idea. it is not finished.

	// **************************************
	// Class-Level Variables / GUI Components
	// **************************************

	// Layout
	private Insets insets;

	// First name
	private JLabel lblFirstName;
	private JTextField txtFirstName;
	// Last name
	private JLabel lblLastName;
	private JTextField txtLastName;
	// Address
	private JLabel lblAddress;
	private JTextField txtAddress;
	// City
	private JLabel lblCity;
	private JTextField txtCity;
	// State
	private JLabel lblState;
	private JTextField txtState;
	// zip
	private JLabel lblZip;
	private JTextField txtZip;
	// Telephone

	// email
	private JLabel lblEmail;
	private JTextField txtEmail;

	public InfoPanel() {
		this.setLayout(new GridBagLayout());
		this.setPreferredSize(new Dimension(390, 250));

		// Insets
		insets = new Insets(5, 5, 5, 5);

		// First name
		lblFirstName = new JLabel("First Name: ");
		this.add(lblFirstName, ConstraintsFactory.getConstraints(0, 0, 1, 1, 1,
				1, GridBagConstraints.EAST, insets));

		txtFirstName = new JTextField(10);
		this.add(txtFirstName, ConstraintsFactory.getConstraints(1, 0, 1, 1, 5,
				1, GridBagConstraints.WEST, insets));

		// Last name
		lblLastName = new JLabel("Last Name: ");
		this.add(lblLastName, ConstraintsFactory.getConstraints(0, 1, 1, 1, 1,
				1, GridBagConstraints.EAST, insets));

		txtLastName = new JTextField(10);
		this.add(txtLastName, ConstraintsFactory.getConstraints(1, 1, 1, 1, 5,
				1, GridBagConstraints.WEST, insets));

		// Address
		lblAddress = new JLabel("Address: ");
		this.add(lblAddress, ConstraintsFactory.getConstraints(0, 2, 1, 1, 1,
				1, GridBagConstraints.EAST, insets));

		txtAddress = new JTextField(10);
		this.add(txtAddress, ConstraintsFactory.getConstraints(1, 2, 1, 1, 5,
				1, GridBagConstraints.WEST, insets));

		// City
		lblCity = new JLabel("City: ");
		this.add(lblCity, ConstraintsFactory.getConstraints(0, 3, 1, 1, 1, 1,
				GridBagConstraints.EAST, insets));

		txtCity = new JTextField(10);
		this.add(txtCity, ConstraintsFactory.getConstraints(1, 3, 1, 1, 5, 1,
				GridBagConstraints.WEST, insets));

		// State
		lblState = new JLabel("State: ");
		this.add(lblState, ConstraintsFactory.getConstraints(0, 4, 1, 1, 1, 1,
				GridBagConstraints.EAST, insets));

		txtState = new FixedTextField(10);
		this.add(txtState, ConstraintsFactory.getConstraints(1, 4, 1, 1, 5, 1,
				GridBagConstraints.WEST, insets));

		// Zip
		lblZip = new JLabel("Zip: ");
		this.add(lblZip, ConstraintsFactory.getConstraints(0, 5, 1, 1, 1, 1,
				GridBagConstraints.EAST, insets));

		txtZip = new FixedTextField(5);
		this.add(txtZip, ConstraintsFactory.getConstraints(1, 5, 1, 1, 5, 1,
				GridBagConstraints.WEST, insets));

		// Phone numbers
		// TODO Phone numbers

		// Email
		lblEmail = new JLabel("Email: ");
		this.add(lblEmail, ConstraintsFactory.getConstraints(0, 6, 1, 1, 1, 1,
				GridBagConstraints.EAST, insets));

		txtEmail = new JTextField(10);
		this.add(txtEmail, ConstraintsFactory.getConstraints(1, 6, 1, 1, 5, 1,
				GridBagConstraints.WEST, insets));

	}
}
