package gui.panels;

import gui.listeners.DeleteActionListener;
import gui.listeners.NewContactActionListener;
import gui.listeners.NewGroupActionListener;

import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * A panel containing a button toolbox.
 * 
 * @author Eric Matysek
 * 
 */
public class ButtonPanel extends JPanel {

	// Buttons
	private JButton newContact;
	private JButton newGroup;
	private JButton delete;
	// Border
	private Border border;

	/**
	 * Constructs a new panel containing buttons.
	 */
	public ButtonPanel() {
		this.setLayout(new FlowLayout());

		newContact = new JButton("New Contact");
		newContact.addActionListener(new NewContactActionListener());
		this.add(newContact);

		newGroup = new JButton("New Group");
		newGroup.addActionListener(new NewGroupActionListener());
		this.add(newGroup);

		delete = new JButton("Delete");
		delete.addActionListener(new DeleteActionListener());
		this.add(delete);

		border = BorderFactory.createEtchedBorder();

		this.setBorder(BorderFactory.createTitledBorder(border, "Tools"));
	}

	/**
	 * @return the delete
	 */
	public JButton getDelete() {
		return delete;
	}


}
