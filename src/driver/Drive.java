package driver;

import sql.MyConnection;
import gui.AddressBookFrame;

public class Drive {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


		MyConnection connection = new MyConnection();

		AddressBookFrame frame = new AddressBookFrame();
		frame.setVisible(true);
	}

}
