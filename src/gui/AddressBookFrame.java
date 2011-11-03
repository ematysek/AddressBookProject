package gui;

import gui.panels.ButtonPanel;
import gui.panels.ContactListPanel;
import gui.panels.contactinfo.ContactInfoPanel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import sql.MyConnection;

/**
 * Frame displaying the application.
 * 
 * @author Eric Matysek
 * 
 */
public class AddressBookFrame extends JFrame {

	// **************************************
	// Class-Level Variables / GUI Components
	// **************************************

	/**
	 * Listener class that describes what to do when the application is closing.
	 * 
	 * @author Eric Matysek
	 * 
	 */
	private class ExitItemListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			exit();
		}

	}

	// Panels
	private JPanel buttonPanel;
	private JPanel contactInfoPanel;
	private JPanel contactListPanel;
	// Menu Bar
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem exitItem;

	// Insets
	private Insets insets;

	public AddressBookFrame() {
		this.setTitle("Address Book");
		this.setResizable(false);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
		this.setLayout(new GridBagLayout());

		// Declare default insets
		insets = new Insets(5, 5, 5, 5);

		// Declare and set menu bar
		menuBar = new JMenuBar();

		fileMenu = new JMenu("File");
		exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ExitItemListener());
		fileMenu.add(exitItem);

		menuBar.add(fileMenu);
		this.setJMenuBar(menuBar);

		// Declare and add contact info panel
		contactInfoPanel = new ContactInfoPanel();
		this.add(contactInfoPanel, ConstraintsFactory.getConstraints(1, 2, 1,
				1, GridBagConstraints.NORTH, insets));

		// Declare and add contact list panel with JTree
		contactListPanel = new ContactListPanel(contactInfoPanel);
		this.add(contactListPanel, ConstraintsFactory.getConstraints(0, 0, 1,
				3, GridBagConstraints.NORTHWEST, insets));

		// Pass contactListPanel to the contactInfoPanel
		((ContactInfoPanel) contactInfoPanel)
				.setContactListPanel(contactListPanel);

		// Declare and add button panel
		buttonPanel = new ButtonPanel(contactInfoPanel, contactListPanel);
		this.add(buttonPanel, ConstraintsFactory.getConstraints(1, 0, 1, 1,
				GridBagConstraints.CENTER, insets));

		// pass buttonPanel to contactListPanel
		((ContactListPanel) contactListPanel).setButtonPanel(buttonPanel);

		this.pack();
		centerWindow(this);
	}

	/**
	 * Centers the provided window.
	 * 
	 * @param window
	 *            Window to center.
	 */
	private void centerWindow(Window window) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		setLocation((d.width - window.getWidth()) / 2,
				(d.height - window.getHeight()) / 2);
	}

	/**
	 * Closes the JDBCConnection and exits the application.
	 */
	public void exit() {
		MyConnection.close();
		System.exit(0);
	}
}
