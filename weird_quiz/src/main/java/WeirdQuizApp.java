import java.sql.Connection;

import util.DBUtil;
import controller.WeirdQuizController;

public class WeirdQuizApp {



	private static final WeirdQuizController controller = new WeirdQuizController();

	public static void main(String[] args) {
		controller.run();

		// DB 커넥션
		Connection connection = DBUtil.getConnection("src/resources/jdbc.properties");

	}

}
