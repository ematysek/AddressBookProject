package driver;

import sql.JDBCTest;
import gui.AddressBookFrame;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		AddressBookFrame frame = new AddressBookFrame();
		frame.setVisible(true);
		
		JDBCTest myConnection = new JDBCTest();
		myConnection.printColumns();
	}

}
