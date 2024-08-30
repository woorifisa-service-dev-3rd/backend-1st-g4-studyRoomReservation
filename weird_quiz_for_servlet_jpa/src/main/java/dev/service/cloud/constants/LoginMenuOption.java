package dev.service.cloud.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LoginMenuOption {
	LOGIN(1, "로그인"),
	SIGNUP(2, "회원가입"),
	EXIT(3, "종료");
	
	private final int id;
	private final String content;
}
