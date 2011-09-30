package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Panel containing the contact list JTree.
 * @author ematyse0
 *
 */
public class ContactListPanel extends JPanel{
	
	//**************************************
	//Class-Level Variables / GUI Components
	//**************************************
	
	private JTree contactTree;
	private DefaultMutableTreeNode defaultNode;
	private DefaultMutableTreeNode group1;
	private DefaultMutableTreeNode group2;
	
	/**
	 * Constructs a new contact list panel containing a JTree.
	 */
	public ContactListPanel(){
		//this.setBackground(new Color(15));
		
		group1 = new DefaultMutableTreeNode("group1");
		group1.add(new DefaultMutableTreeNode("contact1"));
		
		group2 = new DefaultMutableTreeNode("group2");
		group2.add(new DefaultMutableTreeNode("contact2"));
		
		defaultNode = new DefaultMutableTreeNode("Contacts");
		defaultNode.add(group1);
		defaultNode.add(group2);
		
		contactTree = new JTree(defaultNode);
		contactTree.setPreferredSize(new Dimension(200, 500));
		this.add(new JScrollPane(contactTree));
		//this.add(contactTree);
	}
	
}
