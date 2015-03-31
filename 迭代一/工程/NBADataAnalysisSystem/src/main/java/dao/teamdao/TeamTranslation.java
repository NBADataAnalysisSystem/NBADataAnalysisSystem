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
