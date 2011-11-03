package sql;

import java.util.ArrayList;

import contacts.Contact;
import contacts.ContactList;
import sql.JDBCConnection;

public class MyConnection {

	private static JDBCConnection connection;

	public MyConnection(){
		connection = new JDBCConnection();
	}
	
	public static JDBCConnection getConnection() {
		return connection;
	}

	public static void printAllContacts(){
		connection.printAllContacts();
	}

	public static ArrayList<Contact> getAllContacts(){
		return connection.getAllContacts();
	}

	public static ContactList getContactList(){
		return connection.getContactList();
	}

	public static void addContact(Contact contact) {
		connection.addContact(contact);
	}

	public static void removeContact(int id) {
		connection.removeContact(id);
	}

	public static void updateContact(Contact contact) {
		connection.updateContact(contact);
	}

	public static Contact getContact(int id) {
		return connection.getContact(id);
	}

	public static void close() {
		connection.close();
	}

}