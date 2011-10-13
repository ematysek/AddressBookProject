package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JDBCTest {

	private Connection connection = null;
	private final String dbClass = "com.mysql.jdbc.Driver";
	private final String dbUrl = "jdbc:mysql://www.freesql.org/addressbook";
	private final String username = "javacoder";
	private final String password = "java9312";

	public JDBCTest() {

		try {
			Class.forName(dbClass);
			connection = DriverManager.getConnection(dbUrl, username, password);
			System.out.println("sucess!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void createTable() {
		Statement statement = null;
		String state = "CREATE TABLE contactinfo(";
		state += "ID int NOT NULL, ";
		state += "firstname VARCHAR(25) NOT NULL, ";
		state += "lastname VARCHAR(50) NOT NULL, ";
		state += "address VARCHAR(255), " + "city VARCHAR(100), "
				+ "state VARCHAR(100), " + "zip INT(10), "
				+ "homephone INT(20), " + "cellphone INT(20), "
				+ "email VARCHAR(255), " + "PRIMARY KEY (ID)" +
				")";
		try {
			statement = connection.createStatement();
			statement.execute(state);
					} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<String> getColumns() {
		Statement statement = null;
		ArrayList<String> columns = new ArrayList<String>();
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("DESCRIBE contactinfo");
			while (rs.next()) {
				columns.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return columns;
	}

	public void dropTable() {
		Statement statement = null;
		try {
			statement = connection.createStatement();
			statement.execute("DROP TABLE contactinfo");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void printColumns() {
		ArrayList<String> columns = this.getColumns();
		for (int i = 0; i < columns.size(); i++) {
			System.out.println(columns.get(i));
		}
	}

}
