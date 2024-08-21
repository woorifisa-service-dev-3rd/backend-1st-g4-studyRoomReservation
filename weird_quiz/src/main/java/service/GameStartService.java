package service;

import java.sql.Connection;
import java.util.List;

import dao.QuizDAO;
import dao.QuizOptionDAO;
import model.Quiz;
import model.QuizOption;

public class GameStartService {
	
	private Connection connection;
	
	private QuizDAO quizDAO;
	private QuizOptionDAO quizOptionDAO;
	
	public GameStartService(Connection connection) {
		this.connection = connection;
		quizDAO = new QuizDAO(connection);
		quizOptionDAO = new QuizOptionDAO(connection);
	}

	public List<Quiz> getRandomQuizList() {
		
		// 랜덤으로 퀴즈 10개 가져오기
		return quizDAO.findTop10OrderByRandom();
	}
	
	public void setQuizOptions(Quiz quiz) {
		
		quiz.setOptions(quizOptionDAO.findByQuizIdOrderByOptionId(quiz.getId()));
	}
	
	public boolean isCorrect(Quiz quiz, int userAnswer) {
		
		boolean ret;
		
		List<QuizOption> options = quiz.getOptions();
		if(quiz.isWeird()) { // 이상한 문제인 경우
			if(options.get(userAnswer - 1).isAnswer()) ret = false;
			else ret = true;
		} else { // 정상적인 문제인 경우
			if(options.get(userAnswer - 1).isAnswer()) ret = true;
			else ret = false;
		}
		
		return ret;
	}
}
