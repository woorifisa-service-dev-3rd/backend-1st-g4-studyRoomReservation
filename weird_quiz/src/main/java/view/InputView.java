package view;

import java.util.Scanner;

public class InputView {
	private final Scanner sc = new Scanner(System.in);
	

	public int readLoginMenuOption() {
		int option = Integer.parseInt(sc.next());
		return option;
	}

	public int readGameMenuOption() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String readUserId() {
		System.out.println("아이디를 입력해주세요.");
		return sc.next();
	}

	public String readPassword() {
		System.out.println("비밀번호를 입력해주세요.");
		return sc.next();
	}

	public String readUserName() {
		System.out.println("이름을 입력해주세요.");
		return sc.next();
	}

}
