package dev.service.cloud.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
public enum ExceptionMessage {
	WRONG_PASSWORD("-1", "비밀번호가 틀렸습니다."),
	NOT_FOUND_USER("-1", "존재하지 않는 유저입니다."),
	EXIST_USER_ID("-1", "이미 존재하는 아이디입니다."),
	INVALID_INPUT("-1", "잘못된 입력입니다. 다시 입력해주세요."),
	LOGIN_EXIT("0", "로그인 종료"),
	SIGNUP_EXIT("0", "회원가입 종료");
	
	private final String code;
	private final String message;
	
}
