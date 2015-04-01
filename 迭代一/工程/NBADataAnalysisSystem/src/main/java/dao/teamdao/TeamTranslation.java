package dao.teamdao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import entity.TeamInfo;

public class TeamTranslation {

	private Map<TeamInfo, String> map;
	
	public TeamTranslation() {
		map = new HashMap<TeamInfo, String>();
		map.put(TeamInfo.ABBR_NAME, "abbreviation");
		map.put(TeamInfo.BUILT_TIME, "setup_time");
		map.put(TeamInfo.DIVISION, "division");
		map.put(TeamInfo.FULL_NAME, "full_name");
		map.put(TeamInfo.HOME_COURT, "home_court");
		map.put(TeamInfo.LOCATION, "location");
		map.put(TeamInfo.TEAM_ID, "id");
		map.put(TeamInfo.ZONE, "section");
		map.put(TeamInfo.REBOUNDS, "rebounds");
		map.put(TeamInfo.ASSISTS, "assists");
		map.put(TeamInfo.PRESENCE_TIME, "presence_time");
		map.put(TeamInfo.OFFENCES, "offences");
		map.put(TeamInfo.DEFENCES, "defences");
		map.put(TeamInfo.STEALS, "steals");
		map.put(TeamInfo.BLOCK_SHOTS, "block_shots");
		map.put(TeamInfo.TURN_OVERS, "turn_overs");
		map.put(TeamInfo.FOULS, "fouls");
		map.put(TeamInfo.SCORE, "score");
		map.put(TeamInfo.SHOOTINGS, "shootings");
		map.put(TeamInfo.SHOTS, "shots");
		map.put(TeamInfo.THREE_POINT_SHOTS, "three_point_shots");
		map.put(TeamInfo.THREE_POINT_SHOOTINGS, "three_point_shootings");
		map.put(TeamInfo.FREE_THROW_SHOTS, "free_throw_shots");
		map.put(TeamInfo.FREE_THROW_SHOOTINGS, "free_throw_shootings");
		map.put(TeamInfo.NUM_OF_MATCH, "num_of_match");

		String prefix = "round(1.0*";
		String suffix = "/num_of_match,2)";
		map.put(TeamInfo.AVE_REBOUNDS, prefix+"rebounds"+suffix);
		map.put(TeamInfo.AVE_ASSISTS, prefix+"assists"+suffix);
		map.put(TeamInfo.AVE_PRESENCE_TIME, prefix+"presence_time"+suffix);
		map.put(TeamInfo.AVE_OFFENCES, prefix+"offences"+suffix);
		map.put(TeamInfo.AVE_DEFENCES, prefix+"defences"+suffix);
		map.put(TeamInfo.AVE_STEALS, prefix+"steals"+suffix);
		map.put(TeamInfo.AVE_BLOCK_SHOTS, prefix+"block_shots"+suffix);
		map.put(TeamInfo.AVE_TURN_OVERS, prefix+"turn_overs"+suffix);
		map.put(TeamInfo.AVE_FOULS, prefix+"fouls"+suffix);
		map.put(TeamInfo.AVE_SCORE, prefix+"score"+suffix);
		map.put(TeamInfo.AVE_SHOOTINGS, prefix+"shootings"+suffix);
		map.put(TeamInfo.AVE_SHOTS, prefix+"shots"+suffix);
		map.put(TeamInfo.AVE_THREE_POINT_SHOTS, prefix+"three_point_shots"+suffix);
		map.put(TeamInfo.AVE_THREE_POINT_SHOOTINGS, prefix+"three_point_shootings"+suffix);
		map.put(TeamInfo.AVE_FREE_THROW_SHOTS, prefix+"free_throw_shots"+suffix);
		map.put(TeamInfo.AVE_FREE_THROW_SHOOTINGS, prefix+"free_throw_shootings"+suffix);

	}
	
	public String translation(TeamInfo playerInfo) {
		return map.get(playerInfo);
	}
	
	public TeamInfo reverseTranslation(String string) {
		Iterator<Entry<TeamInfo, String>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<TeamInfo, String> entry = iterator.next();
			if (entry.getValue().equals(string)) {
				return (TeamInfo) entry.getKey();
			}
		}
		return null;
	}
	
}
