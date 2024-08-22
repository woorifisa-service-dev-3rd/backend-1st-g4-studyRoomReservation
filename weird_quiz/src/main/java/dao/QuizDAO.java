package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Quiz;

public class QuizDAO {
	
	private final Connection connection;

	public QuizDAO(Connection connection) {
		this.connection = connection;
	}
	
	public List<Quiz> findTop10OrderByRandom() {
		
		List<Quiz> ret = new ArrayList<>();
		
		final String query = "SELECT * FROM quizzes ORDER BY RAND() LIMIT 10";
		
		try (
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
		) {
			while(resultSet.next()) {
				long id = resultSet.getLong("quiz_id");
				String content = resultSet.getString("quiz_content");
				boolean isWeird = resultSet.getBoolean("is_weird");
				
				ret.add(Quiz.builder()
						.id(id)
						.content(content)
						.isWeird(isWeird)
						.build());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ret;
	}
}
