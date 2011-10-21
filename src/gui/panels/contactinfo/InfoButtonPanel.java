package gui.panels.contactinfo;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import sql.JDBCConnection;

public class InfoButtonPanel extends JPanel implements ActionListener {

	// buttons
	private JButton saveChanges;
	private JButton clear;
	//Panel
	private JPanel contactInfoPanel;
	//Database Connection
	private JDBCConnection connection;

	public InfoButtonPanel(JPanel contactInfoPanel) {
		this.setLayout(new FlowLayout());
		
		this.contactInfoPanel = contactInfoPanel;
		
		connection = new JDBCConnection();

		saveChanges = new JButton("Save Changes");
		saveChanges.addActionListener(this);
		this.add(saveChanges);

		clear = new JButton("Clear Fields");
		clear.addActionListener(this);
		this.add(clear);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == saveChanges) {
			
		} else if (e.getSource() == clear) {
			((ContactInfoPanel) contactInfoPanel).clearFields();
		}
	}

}
