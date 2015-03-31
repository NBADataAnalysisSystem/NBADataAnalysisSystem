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
		map.put("���", TeamInfo.ABBR_NAME);
		map.put("����ʱ��", TeamInfo.BUILT_TIME);
		map.put("����", TeamInfo.DIVISION);
		map.put("ȫ��", TeamInfo.FULL_NAME);
		map.put("����", TeamInfo.HOME_COURT);
		map.put("λ��", TeamInfo.LOCATION);
		map.put("ID", TeamInfo.TEAM_ID);
		map.put("����", TeamInfo.ZONE);
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
