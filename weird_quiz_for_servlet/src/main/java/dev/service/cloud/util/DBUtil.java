package dev.service.cloud.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import dev.service.cloud.DBConfigurer;

public class DBUtil {

	public static Connection getConnection() {
		try {	
			final String USER_NAME = "root";
			final String PASSWORD = "mysql";
			final String DB_URL = "jdbc:mysql://localhost:3306/";
			final String DATABASE = "weird_quiz";
			final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
			
			Class.forName(DRIVER_NAME);
			
			return DriverManager.getConnection(DB_URL + DATABASE, USER_NAME, PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
