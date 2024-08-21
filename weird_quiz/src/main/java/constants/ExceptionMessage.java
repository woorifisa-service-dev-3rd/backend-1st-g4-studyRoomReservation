package constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ExceptionMessage {
	LOGIN_EXCEPTION("");
	
	private final String message;
}
