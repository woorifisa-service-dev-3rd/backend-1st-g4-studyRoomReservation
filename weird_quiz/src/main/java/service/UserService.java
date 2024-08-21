package service;

import dao.UserDAO;
import model.User;

import java.sql.Connection;

public class UserService {
	private Connection connection;
	private static UserDAO userDAO;

	public UserService(Connection connection) {
		this.connection = connection;
		userDAO = new UserDAO(connection);
	}

	public User login(String userId, String password) {
        User user = userDAO.findById(userId);
		if (user != null && user.getPassword().equals(password)) {
			return user;
		}
		if (user != null) {
			throw new RuntimeException("비밀번호가 틀렸습니다.");
		}
		throw new RuntimeException("존재하지 않는 유저입니다.");
	}

	public User signup(String userId, String password, String userName) {
		// 중복된 유저 체크
		User existingUser = userDAO.findById(userId);
		if (existingUser != null) {
			throw new RuntimeException("이미 존재하는 아이디입니다.");
		}

		// 새로운 유저 저장
		User newUser = new User(userId, password, userName, 0, 0, 0, 0);

		return userDAO.save(newUser);
	}

}
