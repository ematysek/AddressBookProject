package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import gui.ConstraintsFactory;
import gui.panels.ButtonPanel;
import gui.panels.ContactInfoPanel;
import gui.panels.contactlist.ContactListPanel;

/**
 * @author Eric Matysek
 * 
 */
public class AddressBookFrame extends JFrame {

	// **************************************
	// Class-Level Variables / GUI Components
	// **************************************

	// Panels
	private JPanel buttonPanel;
	private JPanel contactInfoPanel;
	private JPanel contactListPanel;
	// Layout
	private GridBagLayout gridbag;
	private GridBagConstraints c;
	// Menu Bar
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenu editMenu;
	// Insets
	private Insets insets;

	public AddressBookFrame() {
		this.setTitle("Address Book");
		// this.setSize(800, 600);
		this.setResizable(false);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLayout(new GridBagLayout());

		// Declare default insets
		insets = new Insets(5, 5, 5, 5);

		// Declare and set menu bar
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		this.setJMenuBar(menuBar);

		// Declare and add button panel
		buttonPanel = new ButtonPanel();
		this.add(buttonPanel, ConstraintsFactory.getConstraints(1, 0, 1, 1,
				GridBagConstraints.CENTER, insets));

		// Declare and add contact info panel
		contactInfoPanel = new ContactInfoPanel();
		this.add(contactInfoPanel, ConstraintsFactory.getConstraints(1, 2, 1,
				1, GridBagConstraints.NORTH, insets));

		// Declare and add contact list panel with JTree
		contactListPanel = new ContactListPanel();
		this.add(contactListPanel, ConstraintsFactory.getConstraints(0, 0, 1,
				3, GridBagConstraints.NORTHWEST, insets));

		this.pack();
		centerWindow(this);
		/*
		 * Dimension d = contactInfoPanel.getSize();
		 * System.out.println(d.width); System.out.println(d.height);
		 */
	}

	/**
	 * @param window Window to center.
	 */
	private void centerWindow(Window window) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		setLocation((d.width - window.getWidth()) / 2,
				(d.height - window.getHeight()) / 2);
	}
}
