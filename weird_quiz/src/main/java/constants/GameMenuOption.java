package constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum GameMenuOption {
	GAME_GUIDE(1, "게임 방법"),
	GAME_PLAY(2, "게임 시작"),
	GAME_STATS(3, "기록 조회"),
	LOGOUT(4, "로그아웃");
	
	private final int id;
	private final String content;
}
