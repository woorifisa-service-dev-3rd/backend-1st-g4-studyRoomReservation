package service;

import java.util.List;

import model.Quiz;
import model.QuizOption;
import repository.QuizOptionRepository;
import repository.QuizRepository;

public class QuizService {
	private final QuizRepository quizRepository;
	private final QuizOptionRepository quizOptionRepository;
	
	public QuizService() {
		quizRepository = new QuizRepository();
		quizOptionRepository = new QuizOptionRepository();
	}


	public List<Quiz> selectQuizzes() {
		// 랜덤으로 퀴즈 10개 가져오기
		return quizRepository.findTop10OrderByRandom();
	}
	
	public void setQuizOptions(Quiz quiz) {
		
		quiz.setOptions(quizOptionRepository.findByQuizIdOrderByOptionId(quiz.getId()));
	}

	public boolean isCorrectAnswer(Quiz quiz, int userAnswer) {
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
