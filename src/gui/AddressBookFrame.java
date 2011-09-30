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

public class AddressBookFrame extends JFrame {
	
	//**************************************
	//Class-Level Variables / GUI Components
	//**************************************
	
	//Panels
	private JPanel buttonPanel;
	private JPanel contactInfoPanel;
	private JPanel contactListPanel;
	//Layout
	private GridBagLayout gridbag;
	private GridBagConstraints c;
	//Menu Bar
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenu editMenu;
	
	public AddressBookFrame(){
		this.setTitle("Address Book");
		//this.setSize(800, 600);
		this.setResizable(false);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		

		this.setLayout(new GridBagLayout());
		
		//Declare and set menu bar
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		this.setJMenuBar(menuBar);
		
		//Declare and add button panel
		buttonPanel = new ButtonPanel();
		this.add(buttonPanel, getConstraints(1, 0, 1, 1, GridBagConstraints.CENTER));
		
		//Declare and add contact info panel
		contactInfoPanel = new ContactInfoPanel();
		this.add(contactInfoPanel, getConstraints(1, 2, 1, 1, GridBagConstraints.NORTH));
		
		
		//Declare and add contact list panel with JTree
		contactListPanel = new ContactListPanel();
		this.add(contactListPanel, getConstraints(0, 0, 1, 3, GridBagConstraints.NORTHWEST));
		
		this.pack();
		centerWindow(this);
		/*
		Dimension d = contactInfoPanel.getSize();
		System.out.println(d.width);
		System.out.println(d.height);
		*/
		}
	
	private void centerWindow(Window w){
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		setLocation((d.width-w.getWidth())/2, (d.height-w.getHeight())/2);
	}
	
	private GridBagConstraints getConstraints(int gridx, int gridy, int gridwidth, int gridheight, int anchor){
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5,5,5,5);
		c.gridx = gridx;
		c.gridy = gridy;
		c.gridwidth = gridwidth;
		c.gridheight = gridheight;
		c.anchor = anchor;
		return c;
	}
}
