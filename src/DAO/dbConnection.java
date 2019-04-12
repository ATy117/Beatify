package DAO;

import java.sql.*;

public class dbConnection {
	private final static String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private final static String URL = "jdbc:mysql://192.168.1.101:3306/beatifydb";
	private final static String USERNAME = "toto";
	private final static String PASSWORD = "password";

	private static Connection connection = null;

	private static Connection getConnection() {
		try {
			byte[] a = new byte[] {12*10+2,10*10+1,114,111,118,105,116,48,57,56};

			Class.forName(DRIVER_NAME);
			connection = DriverManager.getConnection(URL +"?autoReconnect=true&useSSL=false", USERNAME, PASSWORD);

			System.out.println("[MYSQL] CONNECTED SUCCESSFULLY");
			return connection;

		}catch(SQLException e) {
			System.out.println("[MYSQL] DID NOT CONNECT");
			e.printStackTrace();
			return null;
		}catch(ClassNotFoundException e) {
			System.out.println("[MYSQL] DID NOT CONNECT");
			e.printStackTrace();
			return null;
		}
	}

	public static Connection getInstance() {
		if (connection == null) {
			return getConnection();
		}

		return connection;
	}
}
