package constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ExceptionMessage {
	LOGIN_EXCEPTION(""),
	INVALID_INPUT("잘못된 입력입니다. 다시 입력해주세요.");
	
	private final String message;
}
