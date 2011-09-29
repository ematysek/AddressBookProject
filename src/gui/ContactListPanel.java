package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class ContactListPanel extends JPanel{
	
	private JTree contactTree;
	private DefaultMutableTreeNode defaultNode;
	
	public ContactListPanel(){
		//this.setLayout(new FlowLayout());
		this.setPreferredSize(new Dimension(200,500));
		//this.setBackground(new Color(15));
		
		defaultNode = new DefaultMutableTreeNode("Contacts");
		defaultNode.add(new DefaultMutableTreeNode("contact1"));
		
		contactTree = new JTree(defaultNode);
		contactTree.setPreferredSize(new Dimension(200, 500));
		//this.add(contactTree, FlowLayout.LEFT);
		this.add(contactTree);
	}
	
}
