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
		
		map.put("������", TeamInfo.REBOUNDS);
		map.put("������", TeamInfo.ASSISTS);
		map.put("�ڳ�ʱ�䣨�룩", TeamInfo.PRESENCE_TIME);
		map.put("������", TeamInfo.DEFENCES);
		map.put("������", TeamInfo.OFFENCES);
		map.put("������", TeamInfo.STEALS);
		map.put("��ñ��", TeamInfo.BLOCK_SHOTS);
		map.put("ʧ����", TeamInfo.TURN_OVERS);
		map.put("������", TeamInfo.FOULS);
		map.put("�÷�", TeamInfo.SCORE);
		map.put("Ͷ��������", TeamInfo.SHOOTINGS);
		map.put("Ͷ����", TeamInfo.SHOTS);
		map.put("��������", TeamInfo.THREE_POINT_SHOTS);
		map.put("������������", TeamInfo.THREE_POINT_SHOOTINGS);
		map.put("����������", TeamInfo.FREE_THROW_SHOOTINGS);
		map.put("������", TeamInfo.FREE_THROW_SHOTS);
		map.put("������", TeamInfo.NUM_OF_MATCH);
		
		map.put("����������", TeamInfo.AVE_REBOUNDS);
		map.put("����������", TeamInfo.AVE_ASSISTS);
		map.put("�����ڳ�ʱ�䣨�룩", TeamInfo.AVE_PRESENCE_TIME);
		map.put("����������", TeamInfo.AVE_DEFENCES);
		map.put("����������", TeamInfo.AVE_OFFENCES);
		map.put("����������", TeamInfo.AVE_STEALS);
		map.put("������ñ��", TeamInfo.AVE_BLOCK_SHOTS);
		map.put("����ʧ����", TeamInfo.AVE_TURN_OVERS);
		map.put("����������", TeamInfo.AVE_FOULS);
		map.put("�����÷�", TeamInfo.AVE_SCORE);
		map.put("����Ͷ��������", TeamInfo.AVE_SHOOTINGS);
		map.put("����Ͷ����", TeamInfo.AVE_SHOTS);
		map.put("������������", TeamInfo.AVE_THREE_POINT_SHOTS);
		map.put("����������������", TeamInfo.AVE_THREE_POINT_SHOOTINGS);
		map.put("��������������", TeamInfo.AVE_FREE_THROW_SHOOTINGS);
		map.put("����������", TeamInfo.AVE_FREE_THROW_SHOTS);
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
