package gui.listeners;

import gui.panels.ButtonPanel;
import gui.panels.ContactListPanel;
import gui.panels.contactinfo.ContactInfoPanel;
import gui.panels.contactinfo.InfoButtonPanel;

import javax.swing.JPanel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import sql.JDBCConnection;
import sql.MyConnection;
import contacts.Contact;
import contacts.ContactList;

/**
 * An ActionListener that updates the displayed contact information and enables
 * buttons based on which node is selected in the JTree
 * 
 * @author Eric Matysek
 * 
 */
public class SelectionListener implements TreeSelectionListener {

	private ButtonPanel buttonPanel;
	private ContactListPanel contactListPanel;
	private ContactInfoPanel contactInfoPanel;
	private InfoButtonPanel infoButtonPanel;
	private JDBCConnection connection;

	/**
	 * Constructs a new selection listener which updates the gui based on which
	 * node is selected.
	 * 
	 * @param contactListPanel
	 *            a ContactListPanel
	 * @param contactInfoPanel
	 *            a ContactInfoPanel
	 * @param buttonPanel
	 *            a ButtonPanel
	 */
	public SelectionListener(JPanel contactListPanel, JPanel contactInfoPanel,
			JPanel buttonPanel) {
		this.contactListPanel = (ContactListPanel) contactListPanel;
		this.contactInfoPanel = (ContactInfoPanel) contactInfoPanel;
		this.buttonPanel = (ButtonPanel) buttonPanel;
		this.infoButtonPanel = this.contactInfoPanel.getInfoButtonPanel();
		// this.connection = new JDBCConnection();
		this.connection = MyConnection.getConnection();
	}

	@Override
	public void valueChanged(TreeSelectionEvent tse) {

		int selectedIndex = contactListPanel.getSelectedIndex();
		if (selectedIndex >= 0) {
			// change state of save changes button if valid node is selected
			if (!infoButtonPanel.isSaveChangesEnabled()) {
				infoButtonPanel.setSaveChangesEnabled(true);
			}
			// change state of delete button if valid node is selected
			if (!buttonPanel.getDelete().isEnabled()) {
				buttonPanel.getDelete().setEnabled(true);
			}
			// populate contactInfoPanel
			ContactList contactList = connection.getSortedContactList();
			Contact contact = contactList.get(selectedIndex);
			contactInfoPanel.populateTextFields(contact);
		} else {
			if (infoButtonPanel.isSaveChangesEnabled()) {
				infoButtonPanel.setSaveChangesEnabled(false);
			}
			if (buttonPanel.getDelete().isEnabled()) {
				buttonPanel.getDelete().setEnabled(false);
			}
			// clear fields if root node is selected
			contactInfoPanel.clearFields();
		}

	}

}
