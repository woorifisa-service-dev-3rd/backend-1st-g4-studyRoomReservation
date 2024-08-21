package controller;

import java.sql.Connection;
import java.util.List;

import model.GameMenuOption;
import model.LoginMenuOption;
import model.Quiz;
import model.User;
import service.QuizService;
import service.UserService;
import util.DBUtil;
import view.InputView;
import view.OutputView;

public class WeirdQuizController {
	private final UserService userService;
	private final QuizService quizService;
	private final InputView inputView;
	private final OutputView outputView;
	// DB 커넥션
	private final Connection connection;
	
	public WeirdQuizController() {
		connection = DBUtil.getConnection("src/main/resources/jdbc.properties");
		
		userService = new UserService();
		quizService = new QuizService(connection);
		inputView = new InputView();
		outputView = new OutputView();
	}

	public void run() {
		
		while (true) {
			int loginMenuOption = selectLoginMenu();
			User user = null;

			if (loginMenuOption == LoginMenuOption.LOGIN.getId()) {
				// 로그인
				while (user != null) {
					user = login();
				}

				executeGame(user);

			}

			if (loginMenuOption == LoginMenuOption.SIGNUP.getId()) {
				// 회원가입
				while (user != null) {
					user = signup();
				}

				executeGame(user);
			}

			if (loginMenuOption == LoginMenuOption.EXIT.getId()) {
				// 종료
				break;
			}
		}
	}

	int selectLoginMenu() {
		// 로그인 메뉴 출력
		outputView.writeLoginMenu();

		// 사용자 입력 받기
		int loginMenuOption = inputView.readLoginMenuOption();

		return loginMenuOption;
	}

	User login() {
		String userId = inputView.readUserId();
		String password = inputView.readPassword();

		return userService.login(userId, password);
	}

	User signup() {
		// 회원가입
		String userId = inputView.readUserId();
		String password = inputView.readPassword();
		String userName = inputView.readUserName();

		return userService.signup(userId, password, userName);
	}

	int selectGameMenu() {
		// 게임 메뉴 출력
		outputView.writeGameMenu();

		// 사용자 입력 받기
		int gameMenuOption = inputView.readGameMenuOption();

		return gameMenuOption;
	}

	void guideGame() {
		outputView.writeGameGuide();
	}

	boolean playGame() {
		
		// TODO user에 게임 참여 횟수 정보 저장
		
		// 10개 퀴즈 랜덤으로 가져오기
		List<Quiz> quizzes = quizService.selectQuizzes();
		
		Quiz quiz;
		for(int i = 0; i < quizzes.size(); i++) {
			quiz = quizzes.get(i);
			
			// 퀴즈 옵션 정보 가져오기
			quizService.setQuizOptions(quiz);
			
			outputView.writeQuiz(i + 1, quiz);
			int userAnswer = inputView.readUserAnswer();
			
			// 포기
			if(userAnswer == 0) return true;

			if (quizService.isCorrectAnswer(quiz, userAnswer)) {
				// 정답일 경우
				outputView.writeCorrectAnswerMessage(i + 1, quiz);
				
				// TODO user에 정답 정보 저장
			} else {
				// 오답일 경우
				outputView.writeWrongAnswerMessage(quiz, userAnswer, i + 1);
				
				// TODO user에 정답 정보 저장
				
				return true;
			}
		}

		// 게임 성공
		outputView.writeSuccessGameMessage();
		// TODO user에 성공 정보 저장
		
		return false;
	}

	void getGameStats(User user) {
		outputView.writeGameStats(user);
	}

	void logout(User user) {
		user = null;
		outputView.writeLogoutMessage();
	}

	void executeGame(User user) {
		// 게임 메뉴 선택
		int gameMenuOption = selectGameMenu();

		// 게임 방법
		if (gameMenuOption == GameMenuOption.GAME_GUIDE.getId()) {
			guideGame();
		}

		// 게임 시작
		if (gameMenuOption == GameMenuOption.GAME_PLAY.getId()) {
			while (playGame());
		}

		// 기록 조회
		if (gameMenuOption == GameMenuOption.GAME_STATS.getId()) {
			getGameStats(user);
		}

		// 로그아웃
		if (gameMenuOption == GameMenuOption.LOGOUT.getId()) {
			logout(user);
		}
	}

}
