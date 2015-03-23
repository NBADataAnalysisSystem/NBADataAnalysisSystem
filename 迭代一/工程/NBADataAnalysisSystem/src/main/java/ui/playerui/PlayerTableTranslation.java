package ui.playerui;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import entity.player.PlayerInfo;

public class PlayerTableTranslation {

	private Map<String, PlayerInfo> map;
	
	public PlayerTableTranslation() {
		map = new HashMap<String, PlayerInfo>();
		map.put("ID", PlayerInfo.PLAYER_ID);
		map.put("����", PlayerInfo.NAME);
		map.put("����", PlayerInfo.NUMBER);
		map.put("λ��", PlayerInfo.POSITION);
		map.put("���", PlayerInfo.HEIGHT);
		map.put("����", PlayerInfo.WEIGHT);
		map.put("��������", PlayerInfo.BIRTH);
		map.put("����", PlayerInfo.AGE);
		map.put("����", PlayerInfo.EXP);
		map.put("ѧУ", PlayerInfo.SCHOOL);
		map.put("�������", PlayerInfo.TEAM);
		map.put("��������", PlayerInfo.NUM_OF_ENTRY_FIELD);
		map.put("�ȷ�����", PlayerInfo.NUM_OF_STARTING_FIELD);
		map.put("������", PlayerInfo.NUM_OF_REBOUND);
		map.put("������", PlayerInfo.NUM_OF_ASSIST);
		map.put("�ڳ�ʱ��", PlayerInfo.TIME_OF_PRESENCE);
		map.put("������", PlayerInfo.NUM_OF_DEFENSE);
		map.put("������", PlayerInfo.NUM_OF_STEAL);
		map.put("��ñ��", PlayerInfo.NUM_OF_BLOCK_SHOT);
		map.put("ʧ����", PlayerInfo.NUM_OF_FOUL);
		map.put("������", PlayerInfo.NUM_OF_TURN_OVER);
		map.put("�÷�", PlayerInfo.SCORING);
	}
	
	public PlayerInfo translation(String string) {
		return map.get(string);
	}
	
	public String reverseTranslation(PlayerInfo playerInfo) {
		Iterator<Entry<String, PlayerInfo>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, PlayerInfo> entry = iterator.next();
			if (entry.getValue().equals(playerInfo)) {
				return (String) entry.getKey();
			}
		}
		return null;
	}
	
}
