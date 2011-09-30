package gui.panels;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * @author Eric Matysek
 * 
 */
public class ButtonPanel extends JPanel {

	private JButton newContact;
	private JButton newGroup;
	private JButton delete;

	public ButtonPanel() {
		this.setLayout(new FlowLayout());

		newContact = new JButton("New Contact");
		this.add(newContact);

		newGroup = new JButton("New Group");
		this.add(newGroup);

		delete = new JButton("Delete");
		this.add(delete);

		Border border = BorderFactory.createEtchedBorder();

		this.setBorder(BorderFactory.createTitledBorder(border, "Tools"));
	}

	/**
	 * inner class that handles actions of outer class
	 * 
	 * @author Eric Matysek
	 * 
	 */
	class ButtonPanelActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

}
