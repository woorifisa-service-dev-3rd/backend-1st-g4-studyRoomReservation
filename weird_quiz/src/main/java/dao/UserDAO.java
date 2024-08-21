import com.sun.tools.javac.comp.Todo;
import lombok.AllArgsConstructor;
import lombok.Setter;
import model.User;

import java.sql.*;
import java.time.LocalDate;

public class UserDAO {
    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public User findById(int id) {
        final String selectQuery = "SELECT * FROM user WHERE user_id = ?";

        User user = null;
        try (PreparedStatement statement = connection.prepareStatement(selectQuery)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String userId = resultSet.getString("user_id");
                    String userName = resultSet.getString("user_name");
                    long gameAttemptCount = resultSet.getLong("game_attempt_count");
                    long gameSuccessCount = resultSet.getLong("game_success_count");
                    long quizSolvedCount = resultSet.getLong("quiz_solved_count");
                    long quizCorrectCount = resultSet.getLong("quiz_correct_count");

                    // DB에서 받아온 데이터를 Todo 모델 객체로 바인딩
                    user = new User(userId, userName, gameAttemptCount, gameSuccessCount, quizSolvedCount, quizCorrectCount);
                }
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
