package sql;

import java.sql.*;
import java.util.*;

import contacts.*;

/**
 * description:   	this is the database connection class for the address book project.
 * 					the constructor creates the connection; the methods print all contacts,
 * 					get all contacts as an ArrayList of Contact objects, add a Contact, 
 * 					update the db entry for a Contact, remove a Contact from the db, and close the connection.
 * @author:       	jarrett n. tolman
 * @since:        	Oct 6, 2011
 * @version 		1.0
 * @see				Contact
 */




public class JDBCConnection {
	
	Connection connection = null;
	
	Properties connectionProps = new Properties();
    
    //final String dbms = "mysql";
    //final String serverName = "localhost";
    //final String portNumber = "3306";
    //final String dbName = "csc251";
    //final String driver = "com.mysql.jdbc.Driver";
    final String driver = "com.mysql.jdbc.Driver";
	final String dbUrl = "jdbc:mysql://www.freesql.org/addressbook"; // replace MY_DB with data source name
	final String username = "javacoder";
	final String password = "java9312";
	
	/**
	 * constructs the database connection according to final parameters
	 * 
	 */
	 public JDBCConnection() {
		
		connectionProps.put("user", username);
		connectionProps.put("password", password);
		
		try {
			// load the JDBC mysql bridge driver
			//Class.forName(driver).newInstance();
			// use the DriverManager to create a Connection object
			//connection = DriverManager.getConnection("jdbc:" + dbms + "://" + serverName + ":" + portNumber + "/" + dbName, connectionProps);
			
			// load the JDBC-ODBC bridge driver
			Class.forName(driver);
			// use the DriverManager to create a Connection object
			connection = DriverManager.getConnection(dbUrl, username, password);
		}	
		catch(ClassNotFoundException e) {
			System.err.println("Database driver not found");
		}
		catch(SQLException e) {
			System.err.println("Error connecting to the database: " + e);
		}
		//catch(InstantiationException e) {
		// 	System.err.println("Instantiation error");
		//}
		//catch(IllegalAccessException e) {
		//	System.err.println("Illegal access");
		//}
		
		System.out.println("Successfully connected to database");
		
	}
	
	/**
	 * prints id, first name, and last name for entire contact table
	 * 
	 */
	public void printAllContacts() {
		
		Statement statement = null;
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM contactinfo");
			while(rs.next()) {
				System.out.println(rs.getInt("id") + ": " + rs.getString("firstname") + " " + rs.getString("lastname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * returns an ArrayList of Contact objects populated by the entire contact table
	 * 
	 * @return an ArrayList of Contact objects
	 */
	public ArrayList<Contact> getAllContacts() {
		
		Statement statement = null;
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM contactinfo");
			while(rs.next()) {
				Contact temp = new Contact(Integer.toString((rs.getInt("id"))), rs.getString("firstname"), rs.getString("lastname"), rs.getString("address"), rs.getString("city"),
											rs.getString("state"), rs.getString("zip"), rs.getString("homephone"), rs.getString("cellphone"), rs.getString("email"));
				if (contacts.add(temp)) {
					System.out.println("successfully loaded " + temp.getFirstName() + " into contact array");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return contacts;
		
	}

	/**
	 * adds Contact object to contact table
	 * 
	 * @param Contact object
	 */
	public void addContact(Contact contact) {

		Statement statement = null;
		try {
			statement = connection.createStatement();
			statement.execute("INSERT INTO contactinfo (firstname, lastname, address, city, state, zip, homephone, cellphone, email) " +
					"VALUES ('"+ contact.getFirstName() + "', '" + contact.getLastName() + "', '" + contact.getAddress() + "', '" + contact.getCity() + "', '" + contact.getState() +
					"', '" + contact.getZip() + "', '" + contact.getHomePhone() + "', '" + contact.getCellPhone() + "', '" + contact.getEmail() +"')");
			System.out.println("added " + contact.getFirstName() + " " +  contact.getLastName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * removes entry designated by id from contact table
	 * 
	 * @param int id
	 */
	public void removeContact(int id) {
		
		Statement statement = null;
		try {
			statement = connection.createStatement();
			statement.execute("DELETE FROM contactinfo WHERE contact.id=" + id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * updates contact table entry for Contact
	 * 
	 * @param Contact object
	 */
	public void updateContact(Contact contact) {
		
		Statement statement = null;
		try {
			statement = connection.createStatement();
			statement.execute("UPDATE contactinfo SET firstname='" + contact.getFirstName() + "', lastname='" + contact.getLastName() + "', address='" + contact.getAddress() + 
					"', city='" + contact.getCity() + "', state='" + contact.getState() + "', zip='" + contact.getZip() + "', homephone='" + contact.getHomePhone() + 
					"', cellphone='" + contact.getCellPhone() + "', email='" + contact.getEmail() + "' WHERE contact.id=" + contact.getID());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * closes connection to the database
	 * 
	 */
	public void close() {
		
		try {
			connection.close();
			System.out.println("Connection closed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
// end JDBCConnection class	
}
