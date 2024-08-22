package constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
public enum ExceptionMessage {
	WRONG_PASSWORD("비밀번호가 틀렸습니다."),
	NOT_FOUND_USER("존재하지 않는 유저입니다."),
	EXIST_USER_ID("이미 존재하는 아이디입니다."),
	INVALID_INPUT("잘못된 입력입니다. 다시 입력해주세요.");
	
	private final String message;
	
	
}
