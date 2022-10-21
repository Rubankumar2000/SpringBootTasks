package org.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getConnectionDetails() throws SQLException {
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","System","root");
	}

}
