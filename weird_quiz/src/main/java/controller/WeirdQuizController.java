package controller;

import model.LoginMenuOption;
import model.User;
import service.QuizService;
import service.UserService;
import view.InputView;
import view.OutputView;

public class WeirdQuizController {
	private static final UserService userService = new UserService();
	private static final QuizService quizService = new QuizService();
	private static final InputView inputView = new InputView();
	private static final OutputView outputView = new OutputView();
	
	public void run() {
		int loginMenuOption = selectLoginMenu();
		
		if(loginMenuOption == LoginMenuOption.LOGIN.getId()) {
			// 로그인
			String userId = inputView.readUserId();
			String password = inputView.readPassword();
			
			User loginUser = userService.login(userId, password);
			System.out.println(loginUser);
		}
		
		if(loginMenuOption == LoginMenuOption.SIGNUP.getId()) {
			// 회원가입
			String userId = inputView.readUserId();
			String password = inputView.readPassword();
			String userName = inputView.readUserName();
			userService.signup(userId, password, userName);
		}
		
		if(loginMenuOption == LoginMenuOption.EXIT.getId()) {
			// 종료
			
		}
	}
	
	int selectLoginMenu() {
		// 로그인 메뉴 출력
		outputView.writeLoginMenu();
		
		// 사용자 입력 받기
		int loginMenuOption = inputView.readLoginMenuOption();
		return loginMenuOption;
	}
	
	int selectGameMenu() {
		// 게임 메뉴 출력
		outputView.writeGameMenu();
		
		// 사용자 입력 받기
		int gameMenuOption = inputView.readGameMenuOption();
		
		return gameMenuOption;
	}
	
	

}
