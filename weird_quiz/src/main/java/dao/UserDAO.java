package dao;

import model.User;
import util.DBUtil;

import java.sql.*;

public class UserDAO {
    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public User findById(String id) {
        final String selectQuery = "SELECT * FROM weird_quiz.user WHERE user_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(selectQuery)) {
            statement.setString(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String userId = resultSet.getString("user_id");
                    String password = resultSet.getString("password");
                    String userName = resultSet.getString("user_name");
                    long gameAttemptCount = resultSet.getLong("game_attempt_count");
                    long gameSuccessCount = resultSet.getLong("game_success_count");
                    long quizSolvedCount = resultSet.getLong("quiz_solved_count");
                    long quizCorrectCount = resultSet.getLong("quiz_correct_count");

                    // DB에서 받아온 데이터를 Todo 모델 객체로 바인딩
                    return new User(userId, userName, password, gameAttemptCount, gameSuccessCount, quizSolvedCount, quizCorrectCount);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public User save(User user) {
        final String insertQuery = "INSERT INTO weird_quiz.user(user_id, password, user_name) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            statement.setString(1, user.getUserId());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getUserName());

            statement.executeUpdate();
            return user; // 삽입된 유저 객체를 반환
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
