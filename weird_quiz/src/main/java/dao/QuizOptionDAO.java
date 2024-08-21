package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.QuizOption;

public class QuizOptionDAO {

	private Connection connection;
	
	public QuizOptionDAO(Connection connection) {
		this.connection = connection;
	}
	
	public List<QuizOption> findByQuizIdOrderByOptionId(long quizId) {
		
		List<QuizOption> ret = new ArrayList<>();
		
		final String query = "SELECT * FROM quiz_options WHERE quiz_id = ? ORDER BY quiz_option_id";
		
		ResultSet resultSet = null;
		try (
			PreparedStatement preparedStatement = connection.prepareStatement(query);
		) {
			preparedStatement.setLong(1, quizId);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				int id = resultSet.getInt("quiz_option_id");
				String content = resultSet.getString("quiz_option_content");
				boolean isAnswer = resultSet.getBoolean("is_answer");
				String weirdAnswerMessage = resultSet.getString("weird_answer_message");
				
				ret.add(QuizOption.builder()
						.id(id)
						.content(content)
						.isAnswer(isAnswer)
						.weirdAnswerMessage(weirdAnswerMessage)
						.build());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return ret;
	}
}
