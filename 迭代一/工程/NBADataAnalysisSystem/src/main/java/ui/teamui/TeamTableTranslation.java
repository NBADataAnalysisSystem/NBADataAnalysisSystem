package ui.teamui;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import entity.TeamInfo;

public class TeamTableTranslation {

	private Map<String, TeamInfo> map;
	
	public TeamTableTranslation() {
		map = new HashMap<String, TeamInfo>();
		map.put("简称", TeamInfo.ABBR_NAME);
		map.put("成立时间", TeamInfo.BUILT_TIME);
		map.put("联盟", TeamInfo.DIVISION);
		map.put("全称", TeamInfo.FULL_NAME);
		map.put("主场", TeamInfo.HOME_COURT);
		map.put("位置", TeamInfo.LOCATION);
		map.put("ID", TeamInfo.TEAM_ID);
		map.put("赛区", TeamInfo.ZONE);
	}
	
	public TeamInfo translation(String string) {
		return map.get(string);
	}
	
	public String reverseTranslation(TeamInfo playerInfo) {
		Iterator<Entry<String, TeamInfo>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, TeamInfo> entry = iterator.next();
			if (entry.getValue().equals(playerInfo)) {
				return (String) entry.getKey();
			}
		}
		return null;
	}
	
}
