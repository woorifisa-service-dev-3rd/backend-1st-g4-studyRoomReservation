package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import dev.service.cloud.DBConfigurer;

public class DBUtil {

	public static Connection getConnection(String arg) {
		try {
			Properties properties = DBConfigurer.readProperties(arg);
			
			final String USER_NAME = properties.getProperty("USER_NAME");
			final String PASSWORD = properties.getProperty("PASSWORD");
			final String DB_URL = properties.getProperty("DB_URL");
			final String DATABASE = properties.getProperty("DATABASE");
			
			return DriverManager.getConnection(DB_URL + DATABASE, USER_NAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
