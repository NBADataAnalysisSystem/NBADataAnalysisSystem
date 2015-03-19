package dao.playerdao;

import java.util.HashMap;
import java.util.Map;

import entity.player.PlayerInfo;

public class PlayerTranslation {

	private Map<PlayerInfo, String> map;
	
	public PlayerTranslation() {
		map = new HashMap<PlayerInfo, String>();
		map.put(PlayerInfo.AGE, "age");
		map.put(PlayerInfo.BIRTH, "birth");
		map.put(PlayerInfo.EXP, "exp");
		//map.put(PlayerInfo.FILE_PATH, "age");
		map.put(PlayerInfo.HEIGHT, "height");
		map.put(PlayerInfo.NAME, "player_name");
		//map.put(PlayerInfo.NUM_OF_ASSIST, "assists");
		//map.put(PlayerInfo.NUM_OF_BLOCK_SHOT, "block_shots");
		//map.put(PlayerInfo.NUM_OF_DEFENSE, "defences");
		//map.put(PlayerInfo.NUM_OF_ENTRY_FIELD, "age");
		//map.put(PlayerInfo.NUM_OF_FOUL, "age");
		//map.put(PlayerInfo.NUM_OF_OFFENSE, "age");
		//map.put(PlayerInfo.NUM_OF_REBOUND, "age");
		//map.put(PlayerInfo.NUM_OF_STARTING_FIELD, "age");
		//map.put(PlayerInfo.NUM_OF_STEAL, "age");
		//map.put(PlayerInfo.NUM_OF_TURN_OVER, "age");
		map.put(PlayerInfo.NUMBER, "jersey_number");
		map.put(PlayerInfo.PLAYER_ID, "id");
		map.put(PlayerInfo.POSITION, "position");
		map.put(PlayerInfo.SCHOOL, "school");
		//map.put(PlayerInfo.SCORING, "scoring");
		//map.put(PlayerInfo.TEAM, "age");
		//map.put(PlayerInfo.TIME_OF_PRESENCE, "age");
		map.put(PlayerInfo.WEIGHT, "weight");
	}
	
	public String translation(PlayerInfo playerInfo) {
		return map.get(playerInfo);
	}
	
}
