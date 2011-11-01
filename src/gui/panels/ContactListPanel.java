package gui.panels;

import gui.listeners.SelectionListener;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

import sql.JDBCConnection;

import contacts.*;

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
	private JPanel buttonPanel;

	/**
	 * Constructs a new contact list panel containing a JTree.
	 */
	public ContactListPanel(JPanel contactInfoPanel) {
		this.contactInfoPanel = contactInfoPanel;

		this.rootNode = new DefaultMutableTreeNode("Contacts");

		this.treeModel = new DefaultTreeModel(rootNode);
		
		this.connection = new JDBCConnection();

		this.contactTree = new JTree(treeModel);
		// contactTree.setPreferredSize(new Dimension(200, 500));
		contactTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		

		
//TODO replace with this.refreshList();
		this.refreshList();

		this.scrollPane = new JScrollPane(contactTree);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setPreferredSize(new Dimension(215, 413));
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.add(scrollPane);
		// this.add(contactTree);
	}
	
	public int getSelectedIndex(){
		DefaultMutableTreeNode tempNode = (DefaultMutableTreeNode) contactTree.getLastSelectedPathComponent();
		if(tempNode == null){
			return -2;
		}
		int index = rootNode.getIndex(tempNode);
		
		return index;
	}

	/**
	 * @return the contactTree
	 */
	public JTree getContactTree() {
		return contactTree;
	}

	/**
	 * @return the rootNode
	 */
	public DefaultMutableTreeNode getRootNode() {
		return rootNode;
	}

	/**
	 * @return the contactList
	 */
	public ContactList getContactList() {
		return contactList;
	}
	
	/**
	 * @param buttonPanel the buttonPanel to set
	 */
	public void setButtonPanel(JPanel buttonPanel) {
		this.buttonPanel = buttonPanel;
		contactTree.addTreeSelectionListener(new SelectionListener(this, contactInfoPanel, buttonPanel));
	}

	public void refreshList(){
		this.contactList = connection.getSortedContactList();
		System.out.println("called");
		for (int i = contactList.size() - 1; i >= 0; i--) {
			Contact c = contactList.get(i);
			treeModel.insertNodeInto(new DefaultMutableTreeNode(c.getNodeString()), rootNode, 0);
			// rootNode.add(new DefaultMutableTreeNode(c.getNodeString()));
		}
	
	}

}
