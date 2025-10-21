package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public static void main(String[] args) {
		System.out.println(DbConnection.getDb());
	}
	
	public static Connection getDb() {
		String classForName = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/homework3";
		String user = "root";
		String password = "1234";
//		String password = "passw0rd";
		Connection c = null;
		
		try {
			Class.forName(classForName);
			c = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Cannot connect to server!");
			e.printStackTrace();
		}
		
		return c;
	}

}
