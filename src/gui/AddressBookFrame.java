package gui;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;
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
	
	public AddressBookFrame(){
		this.setTitle("Address Book");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		gridbag = new GridBagLayout();
		
		buttonPanel = new ButtonPanel();
		
		contactInfoPanel = new ContactInfoPanel();
		
		contactListPanel = new ContactListPanel();
		}
	
	public void centerWindow(Window w){
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		setLocation((d.width-w.getWidth())/2, (d.height-w.getHeight())/2);
	}
}
