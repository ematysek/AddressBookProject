package driver;

import sql.JDBCConnection;
import gui.AddressBookFrame;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		AddressBookFrame frame = new AddressBookFrame();
		frame.setVisible(true);
		
		JDBCConnection myConnection = new JDBCConnection();
		myConnection.printAllContacts();
		
		//TODO possibly create a static method somewhere that provides a JDBCConnection 
		//object to other classes instead of constructing new ones everywhere they are needed
	
	}

}
