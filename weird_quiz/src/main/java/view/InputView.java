package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InputView {
	private final Scanner sc = new Scanner(System.in);
	

	public int readLoginMenuOption() {
		int option = sc.nextInt();
		return option;
	}

	public int readGameMenuOption() {
		return sc.nextInt();
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

	public int readUserAnswer() {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int ret = 0;
		try {
			ret = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		
		return ret;
	}

}
