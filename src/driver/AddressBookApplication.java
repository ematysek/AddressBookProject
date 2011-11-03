package driver;

import gui.AddressBookFrame;
import sql.MyConnection;

/**
 * Class that initializes the application.
 * 
 * @author Eric Matysek, Juan Ramirez, Jarrett Tolman, Ashley Williams
 * 
 */
public class AddressBookApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		new MyConnection();

		AddressBookFrame frame = new AddressBookFrame();
		frame.setVisible(true);
	}

}
