package driver;

import sql.MyConnection;
import gui.AddressBookFrame;

public class Drive {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("1");
		MyConnection connection = new MyConnection();
		System.out.println("2");
		AddressBookFrame frame = new AddressBookFrame();
		frame.setVisible(true);
		System.out.println("3");
		//MyConnection connection = new MyConnection();
	}

}
