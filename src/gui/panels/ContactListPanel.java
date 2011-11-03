package gui.panels;

import gui.listeners.SelectionListener;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

import sql.JDBCConnection;
import sql.MyConnection;
import contacts.Contact;
import contacts.ContactList;

/**
 * Panel containing the contact list JTree.
 * 
 * @author Eric Matysek
 * 
 */
public class ContactListPanel extends JPanel {

	// 228
	// 413

	// **************************************
	// Class-Level Variables / GUI Components
	// **************************************

	// Tree
	private JTree contactTree;
	private DefaultTreeModel treeModel;
	private DefaultMutableTreeNode rootNode;
	// Scrollpane
	private JScrollPane scrollPane;
	// Contacts
	private ContactList contactList;
	// Database Connection
	private JDBCConnection connection;
	// Panel
	private JPanel contactInfoPanel;
	// Icons
	private ImageIcon contactBookIcon;
	private ImageIcon contactIcon;

	/**
	 * Constructs a new contact list panel containing a JTree.
	 */
	public ContactListPanel(JPanel contactInfoPanel) {
		this.contactInfoPanel = contactInfoPanel;

		this.rootNode = new DefaultMutableTreeNode("Contacts");

		this.treeModel = new DefaultTreeModel(rootNode);

		// this.connection = new JDBCConnection();
		this.connection = MyConnection.getConnection();

		this.contactTree = new JTree(treeModel);
		// contactTree.setPreferredSize(new Dimension(200, 500));
		contactTree.getSelectionModel().setSelectionMode(
				TreeSelectionModel.SINGLE_TREE_SELECTION);

		// Declare Icon Images
		contactIcon = new ImageIcon("resources/ContactIcon1.jpg");
		contactBookIcon = new ImageIcon("resources/contactbookicon.jpg");

		// get tree cell renderer from contacttree and set icons
		DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer) contactTree
				.getCellRenderer();
		renderer.setLeafIcon(contactIcon);
		renderer.setClosedIcon(contactBookIcon);
		renderer.setOpenIcon(contactBookIcon);

		this.initializeTree();

		this.scrollPane = new JScrollPane(contactTree);
		scrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setPreferredSize(new Dimension(215, 413));
		scrollPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.add(scrollPane);
		// this.add(contactTree);

	}

	/**
	 * Returns the ContactList from this panel
	 * 
	 * @return the contactList
	 */
	public ContactList getContactList() {
		return contactList;
	}

	/**
	 * Returns the index of the currenly selected node, or -2 if no node is
	 * selected
	 * 
	 * @return the index of the selected node
	 */
	public int getSelectedIndex() {
		DefaultMutableTreeNode tempNode = (DefaultMutableTreeNode) contactTree
				.getLastSelectedPathComponent();
		if (tempNode == null) {
			return -2;
		}
		int index = rootNode.getIndex(tempNode);

		return index;
	}

	/**
	 * Initialize the tree nodes from the database
	 */
	private void initializeTree() {
		this.contactList = connection.getSortedContactList();
		System.out.println("called");
		for (int i = contactList.size() - 1; i >= 0; i--) {
			Contact c = contactList.get(i);
			treeModel.insertNodeInto(
					new DefaultMutableTreeNode(c.getNodeString()), rootNode, 0);
		}

	}

	/**
	 * Notifies the JTree that a node needs to be added because the database has
	 * been updated. This method retrieves the new contact list and compares it
	 * to the old contact list until a discrepancy is found.
	 */
	public void nodeAdded() {
		// find the index of the added node by comparing contact ID's
		ContactList newList = connection.getSortedContactList();
		int newNodeIndex = 0;
		for (int i = 0; i < contactList.size(); i++) {
			if (!newList.get(i).getID().equals(contactList.get(i).getID())) {
				newNodeIndex = i;
				break;
			}
		}

		// get new contact
		Contact newContact = newList.get(newNodeIndex);
		// create node from contact
		DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(
				newContact.getNodeString());
		// insert node into treemodel
		treeModel.insertNodeInto(newNode, rootNode, newNodeIndex);

		// update contactList
		this.contactList = connection.getSortedContactList();

	}

	/**
	 * Notifies the JTree to update the changed node if the first or last name
	 * has been changed on the corresponding Contact
	 * 
	 * @param selectedIndex
	 *            the index of the changed node
	 */
	public void nodeChanged(int selectedIndex) {

		// get an updated contactlist to compare old contactlist to
		ContactList newList = connection.getSortedContactList();

		// update jtree node at selected index
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) contactTree
				.getPathForRow(selectedIndex + 1).getLastPathComponent();
		String contactString = newList.get(selectedIndex).getNodeString();
		System.out.println(contactString);
		if (!node.toString().equals(contactString)) {
			System.out.println("not equal");
			DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(
					contactString);
			treeModel.removeNodeFromParent(node);
			treeModel.insertNodeInto(newNode, rootNode, selectedIndex);
			contactTree.setSelectionPath(contactTree
					.getPathForRow(selectedIndex + 1));
		}

		// update contactList with changes
		this.contactList = connection.getSortedContactList();

	}

	/**
	 * Notifies the JTree to remove a node because it has been deleted from the
	 * database
	 * 
	 * @param index
	 *            the index of the node to be deleted
	 */
	public void nodeRemoved(int index) {
		System.out.println(index);
		// remove contact from list
		this.contactList.remove(index);
		// remove node from tree
		DefaultMutableTreeNode nodeToRemove = (DefaultMutableTreeNode) contactTree
				.getPathForRow(index + 1).getLastPathComponent();
		treeModel.removeNodeFromParent(nodeToRemove);
	}

	/**
	 * Set the button panel here and pass it to the contactTree selection
	 * listener
	 * 
	 * @param buttonPanel
	 *            the buttonPanel to set
	 */
	public void setButtonPanel(JPanel buttonPanel) {
		contactTree.addTreeSelectionListener(new SelectionListener(this,
				contactInfoPanel, buttonPanel));
	}

}
