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
		
		map.put("篮板数", TeamInfo.REBOUNDS);
		map.put("助攻数", TeamInfo.ASSISTS);
		map.put("在场时间（秒）", TeamInfo.PRESENCE_TIME);
		map.put("防守数", TeamInfo.DEFENCES);
		map.put("进攻数", TeamInfo.OFFENCES);
		map.put("抢断数", TeamInfo.STEALS);
		map.put("盖帽数", TeamInfo.BLOCK_SHOTS);
		map.put("失误数", TeamInfo.TURN_OVERS);
		map.put("犯规数", TeamInfo.FOULS);
		map.put("得分", TeamInfo.SCORE);
		map.put("投篮命中数", TeamInfo.SHOOTINGS);
		map.put("投篮数", TeamInfo.SHOTS);
		map.put("三分球数", TeamInfo.THREE_POINT_SHOTS);
		map.put("三分球命中数", TeamInfo.THREE_POINT_SHOOTINGS);
		map.put("罚球命中数", TeamInfo.FREE_THROW_SHOOTINGS);
		map.put("罚球数", TeamInfo.FREE_THROW_SHOTS);
		map.put("比赛数", TeamInfo.NUM_OF_MATCH);
		
		map.put("场均篮板数", TeamInfo.AVE_REBOUNDS);
		map.put("场均助攻数", TeamInfo.AVE_ASSISTS);
		map.put("场均在场时间（秒）", TeamInfo.AVE_PRESENCE_TIME);
		map.put("场均防守数", TeamInfo.AVE_DEFENCES);
		map.put("场均进攻数", TeamInfo.AVE_OFFENCES);
		map.put("场均抢断数", TeamInfo.AVE_STEALS);
		map.put("场均盖帽数", TeamInfo.AVE_BLOCK_SHOTS);
		map.put("场均失误数", TeamInfo.AVE_TURN_OVERS);
		map.put("场均犯规数", TeamInfo.AVE_FOULS);
		map.put("场均得分", TeamInfo.AVE_SCORE);
		map.put("场均投篮命中数", TeamInfo.AVE_SHOOTINGS);
		map.put("场均投篮数", TeamInfo.AVE_SHOTS);
		map.put("场均三分球数", TeamInfo.AVE_THREE_POINT_SHOTS);
		map.put("场均三分球命中数", TeamInfo.AVE_THREE_POINT_SHOOTINGS);
		map.put("场均罚球命中数", TeamInfo.AVE_FREE_THROW_SHOOTINGS);
		map.put("场均罚球数", TeamInfo.AVE_FREE_THROW_SHOTS);
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
