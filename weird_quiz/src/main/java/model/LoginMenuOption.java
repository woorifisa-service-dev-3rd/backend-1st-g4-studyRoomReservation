package model;

import lombok.Getter;

@Getter
public enum LoginMenuOption {
	LOGIN(1, "로그인"),
	SIGNUP(2, "회원가입"),
	EXIT(3, "종료");
	
	private final int id;
	private final String name;

	private LoginMenuOption(int id, String name) {
		this.id = id;
		this.name = name;
	}
}
