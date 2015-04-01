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
		
		String prefix = "round(";
		String suffix = ",2)";
		map.put(PlayerInfo.EFFICIENCY, prefix+"efficiency"+suffix);
		map.put(PlayerInfo.GMSC_EFF, prefix+"GmSc_eff"+suffix);
		map.put(PlayerInfo.TRUE_SHOOTING_PERCENTAGE, prefix+"true_shooting_persentage"+suffix);
		map.put(PlayerInfo.SHOOTING_EFF, prefix+"shooting_eff"+suffix);
		map.put(PlayerInfo.REBOUND_RATE, prefix+"rebound_rate"+suffix);
		map.put(PlayerInfo.OFFENSIVE_REBOUND_RATE, prefix+"offensive_rebound_rate"+suffix);
		map.put(PlayerInfo.DEFENSIVE_REBOUND_RATE, prefix+"defensive_rebound_rate"+suffix);
		map.put(PlayerInfo.ASSIST_RATE, prefix+"assist_rate"+suffix);
		map.put(PlayerInfo.STEAL_RATE, prefix+"steal_rate"+suffix);
		map.put(PlayerInfo.BLOCK_SHOT_RATE, prefix+"block_shot_rate"+suffix);
		map.put(PlayerInfo.TURN_OVER_RATE, prefix+"turn_over_rate"+suffix);
		map.put(PlayerInfo.USE_RATE, prefix+"use_rate"+suffix);
		
		prefix = "round(1.0*";
		suffix = "/num_of_match,2)";
		map.put(PlayerInfo.AVE_NUM_OF_REBOUND, prefix+"rebounds"+suffix);
		map.put(PlayerInfo.AVE_NUM_OF_ASSIST, prefix+"assists"+suffix);
		map.put(PlayerInfo.AVE_TIME_OF_PRESENCE, prefix+"presence_time"+suffix);
		map.put(PlayerInfo.AVE_NUM_OF_OFFENSE, prefix+"offences"+suffix);
		map.put(PlayerInfo.AVE_NUM_OF_DEFENSE, prefix+"defences"+suffix);
		map.put(PlayerInfo.AVE_NUM_OF_STEAL, prefix+"steals"+suffix);
		map.put(PlayerInfo.AVE_NUM_OF_BLOCK_SHOT, prefix+"block_shots"+suffix);
		map.put(PlayerInfo.AVE_NUM_OF_FOUL, prefix+"fouls"+suffix);
		map.put(PlayerInfo.AVE_NUM_OF_TURN_OVER, prefix+"turn_overs"+suffix);
		map.put(PlayerInfo.AVE_SCORING, prefix+"score"+suffix);
		map.put(PlayerInfo.AVE_NUM_OF_SHOOTING, prefix+"shootings"+suffix);
		map.put(PlayerInfo.AVE_NUM_OF_SHOT, prefix+"shots"+suffix);
		map.put(PlayerInfo.AVE_NUM_OF_THREE_POINT_SHOOTING, prefix+"three_point_shootings"+suffix);
		map.put(PlayerInfo.AVE_NUM_OF_THREE_POINT_SHOT, prefix+"three_point_shots"+suffix);
		map.put(PlayerInfo.AVE_NUM_OF_FREE_THROW_SHOOTING, prefix+"free_throw_shootings"+suffix);
		map.put(PlayerInfo.AVE_NUM_OF_FREE_THROW_SHOT, prefix+"free_throw_shots"+suffix);
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
