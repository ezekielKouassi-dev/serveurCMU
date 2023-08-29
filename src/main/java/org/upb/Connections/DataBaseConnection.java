package org.upb.Connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
	private static final String DB_URL = "jdbc:postgresql://localhost:5432/cmu";
	private static final String DB_USER = "postgres";
	private static final String DB_PASS = "admin";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
	}
}
