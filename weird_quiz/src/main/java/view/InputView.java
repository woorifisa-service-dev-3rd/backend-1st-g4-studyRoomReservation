package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InputView {
	private final Scanner sc = new Scanner(System.in);
	

	public int readLoginMenuOption() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int readGameMenuOption() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String readUserId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String readPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	public String readUserName() {
		// TODO Auto-generated method stub
		return null;
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
