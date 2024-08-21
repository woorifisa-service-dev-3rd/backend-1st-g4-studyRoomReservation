import java.sql.Connection;

import util.DBUtil;

public class WeirdQuizApp {
	
	

	public static void main(String[] args) {
		
		// DB 커넥션
		Connection connection = DBUtil.getConnection("src/resources/jdbc.properties");

	}

}
