package dao.playerdao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import entity.PlayerInfo;

public class PlayerTranslation {

	private Map<PlayerInfo, String> map;
	
	public PlayerTranslation() {
		map = new HashMap<PlayerInfo, String>();
		map.put(PlayerInfo.AGE, "age");
		map.put(PlayerInfo.BIRTH, "birth");
		map.put(PlayerInfo.EXP, "exp");
		map.put(PlayerInfo.HEIGHT, "height");
		map.put(PlayerInfo.NAME, "player_name");
		map.put(PlayerInfo.NUM_OF_ASSIST, "assists");
		map.put(PlayerInfo.NUM_OF_BLOCK_SHOT, "block_shots");
		map.put(PlayerInfo.NUM_OF_DEFENSE, "defences");
		map.put(PlayerInfo.NUM_OF_ENTRY_FIELD, "num_of_match");
		map.put(PlayerInfo.NUM_OF_FOUL, "fouls");
		map.put(PlayerInfo.NUM_OF_OFFENSE, "offences");
		map.put(PlayerInfo.NUM_OF_REBOUND, "rebounds");
		map.put(PlayerInfo.NUM_OF_STARTING_FIELD, "num_of_start");
		map.put(PlayerInfo.NUM_OF_STEAL, "steals");
		map.put(PlayerInfo.NUM_OF_TURN_OVER, "turn_overs");
		map.put(PlayerInfo.NUMBER, "jersey_number");
		map.put(PlayerInfo.PLAYER_ID, "id");
		map.put(PlayerInfo.POSITION, "position");
		map.put(PlayerInfo.SCHOOL, "school");
		map.put(PlayerInfo.SCORING, "score");
		map.put(PlayerInfo.TEAM, "team");
		map.put(PlayerInfo.TIME_OF_PRESENCE, "presence_time");
		map.put(PlayerInfo.WEIGHT, "weight");
		map.put(PlayerInfo.NUM_OF_SHOOTING, "shootings");
		map.put(PlayerInfo.NUM_OF_SHOT, "shots");
		map.put(PlayerInfo.NUM_OF_THREE_POINT_SHOOTING, "three_point_shootings");
		map.put(PlayerInfo.NUM_OF_THREE_POINT_SHOT, "three_point_shots");
		map.put(PlayerInfo.NUM_OF_FREE_THROW_SHOOTING, "free_throw_shootings");
		map.put(PlayerInfo.NUM_OF_FREE_THROW_SHOT, "free_throw_shots");
		
		map.put(PlayerInfo.AVE_NUM_OF_REBOUND, "1.0*rebounds/num_of_match");
		map.put(PlayerInfo.AVE_NUM_OF_ASSIST, "1.0*assists/num_of_match");
		map.put(PlayerInfo.AVE_TIME_OF_PRESENCE, "1.0*presence_time/num_of_match");
		map.put(PlayerInfo.AVE_NUM_OF_OFFENSE, "1.0*offences/num_of_match");
		map.put(PlayerInfo.AVE_NUM_OF_DEFENSE, "1.0*defences/num_of_match");
		map.put(PlayerInfo.AVE_NUM_OF_STEAL, "1.0*steals/num_of_match");
		map.put(PlayerInfo.AVE_NUM_OF_BLOCK_SHOT, "1.0*block_shots/num_of_match");
		map.put(PlayerInfo.AVE_NUM_OF_FOUL, "1.0*fouls/num_of_match");
		map.put(PlayerInfo.AVE_NUM_OF_TURN_OVER, "1.0*turn_overs/num_of_match");
		map.put(PlayerInfo.AVE_SCORING, "1.0*score/num_of_match");
		map.put(PlayerInfo.AVE_NUM_OF_SHOOTING, "1.0*shootings/num_of_match");
		map.put(PlayerInfo.AVE_NUM_OF_SHOT, "1.0*shots/num_of_match");
		map.put(PlayerInfo.AVE_NUM_OF_THREE_POINT_SHOOTING, "1.0*three_point_shootings/num_of_match");
		map.put(PlayerInfo.AVE_NUM_OF_THREE_POINT_SHOT, "1.0*three_point_shots/num_of_match");
		map.put(PlayerInfo.AVE_NUM_OF_FREE_THROW_SHOOTING, "1.0*free_throw_shootings/num_of_match");
		map.put(PlayerInfo.AVE_NUM_OF_FREE_THROW_SHOT, "1.0*free_throw_shots/num_of_match");
	}
	
	public String translation(PlayerInfo playerInfo) {
		return map.get(playerInfo);
	}
	
	public PlayerInfo reverseTranslation(String string) {
		Iterator<Entry<PlayerInfo, String>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<PlayerInfo, String> entry = iterator.next();
			if (entry.getValue().equals(string)) {
				return (PlayerInfo) entry.getKey();
			}
		}
		return null;
	}
	
}
