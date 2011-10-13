package gui.panels;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

/**
 * Panel containing the contact list JTree.
 * 
 * @author Eric Matysek
 * 
 */
public class ContactListPanel extends JPanel {

	// **************************************
	// Class-Level Variables / GUI Components
	// **************************************

	private JTree contactTree;
	private DefaultTreeModel treeModel;
	private DefaultMutableTreeNode rootNode;
	private DefaultMutableTreeNode group1;
	private DefaultMutableTreeNode group2;

	/**
	 * Constructs a new contact list panel containing a JTree.
	 */
	public ContactListPanel() {
		// this.setBackground(new Color(15));

		rootNode = new DefaultMutableTreeNode("Contacts");

		treeModel = new DefaultTreeModel(rootNode);

		contactTree = new JTree(treeModel);
		contactTree.setPreferredSize(new Dimension(200, 500));
		contactTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

		group1 = new DefaultMutableTreeNode("group1");
		group1.add(new DefaultMutableTreeNode("contact1"));

		group2 = new DefaultMutableTreeNode("group2");
		group2.add(new DefaultMutableTreeNode("contact2"));
	
		rootNode.add(group2);
		rootNode.add(group1);

		this.add(new JScrollPane(contactTree));
		// this.add(contactTree);
	}

}
