package gui.panels;

import gui.listeners.DeleteActionListener;
import gui.listeners.NewContactActionListener;

import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * A panel containing a buttons that create and delete contacts.
 * 
 * @author Eric Matysek
 * 
 */
public class ButtonPanel extends JPanel {

	// Buttons
	private JButton newContact;
	// private JButton newGroup; Removed
	private JButton delete;
	// Border
	private Border border;

	/**
	 * Constructs a new panel containing buttons.
	 */
	public ButtonPanel(JPanel contactInfo, JPanel contactList) {
		this.setLayout(new FlowLayout());

		newContact = new JButton("New Contact");
		newContact.addActionListener(new NewContactActionListener(contactInfo,
				contactList));
		this.add(newContact);

		delete = new JButton("Delete");
		delete.setEnabled(false);
		delete.addActionListener(new DeleteActionListener(contactList));
		this.add(delete);

		border = BorderFactory.createEtchedBorder();

		this.setBorder(BorderFactory.createTitledBorder(border, "Tools"));
	}

	/**
	 * Returns the delete JButton
	 * 
	 * @return the delete JButton
	 */
	public JButton getDelete() {
		// TODO Auto-generated method stub
		return delete;
	}

}
