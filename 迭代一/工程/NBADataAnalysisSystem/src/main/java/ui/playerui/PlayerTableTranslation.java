package ui.playerui;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import entity.PlayerInfo;

public class PlayerTableTranslation {

	private Map<String, PlayerInfo> map;
	
	public PlayerTableTranslation() {
		map = new HashMap<String, PlayerInfo>();
		//������Ϣ
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
		//��������
		map.put("������", PlayerInfo.NUM_OF_REBOUND);
		map.put("������", PlayerInfo.NUM_OF_ASSIST);
		map.put("�ڳ�ʱ�䣨�룩", PlayerInfo.TIME_OF_PRESENCE);
		map.put("������", PlayerInfo.NUM_OF_OFFENSE);
		map.put("������", PlayerInfo.NUM_OF_DEFENSE);
		map.put("������", PlayerInfo.NUM_OF_STEAL);
		map.put("��ñ��", PlayerInfo.NUM_OF_BLOCK_SHOT);
		map.put("ʧ����", PlayerInfo.NUM_OF_FOUL);
		map.put("������", PlayerInfo.NUM_OF_TURN_OVER);
		map.put("�÷�", PlayerInfo.SCORING);
		map.put("Ͷ��������", PlayerInfo.NUM_OF_SHOOTING);
		map.put("Ͷ����", PlayerInfo.NUM_OF_SHOT);
		map.put("������������", PlayerInfo.NUM_OF_THREE_POINT_SHOOTING);
		map.put("����������", PlayerInfo.NUM_OF_THREE_POINT_SHOT);
		map.put("����������", PlayerInfo.NUM_OF_FREE_THROW_SHOOTING);
		map.put("��������", PlayerInfo.NUM_OF_FREE_THROW_SHOT);
		
		map.put("Ч��", PlayerInfo.EFFICIENCY);
		map.put("GmScЧ��", PlayerInfo.GMSC_EFF);
		map.put("��ʵͶ��������", PlayerInfo.TRUE_SHOOTING_PERCENTAGE);
		map.put("Ͷ��Ч��", PlayerInfo.SHOOTING_EFF);
		map.put("������", PlayerInfo.REBOUND_RATE);
		map.put("����������", PlayerInfo.OFFENSIVE_REBOUND_RATE);
		map.put("����������", PlayerInfo.DEFENSIVE_REBOUND_RATE);
		map.put("������", PlayerInfo.ASSIST_RATE);
		map.put("������", PlayerInfo.STEAL_RATE);
		map.put("��ñ��", PlayerInfo.BLOCK_SHOT_RATE);
		map.put("ʧ����", PlayerInfo.TURN_OVER_RATE);
		map.put("ʹ����", PlayerInfo.USE_RATE);
		//��������
		map.put("����������", PlayerInfo.AVE_NUM_OF_REBOUND);
		map.put("����������", PlayerInfo.AVE_NUM_OF_ASSIST);
		map.put("�����ڳ�ʱ�䣨�룩", PlayerInfo.AVE_TIME_OF_PRESENCE);
		map.put("����������", PlayerInfo.AVE_NUM_OF_OFFENSE);
		map.put("����������", PlayerInfo.AVE_NUM_OF_DEFENSE);
		map.put("����������", PlayerInfo.AVE_NUM_OF_STEAL);
		map.put("������ñ��", PlayerInfo.AVE_NUM_OF_BLOCK_SHOT);
		map.put("����ʧ����", PlayerInfo.AVE_NUM_OF_FOUL);
		map.put("����������", PlayerInfo.AVE_NUM_OF_TURN_OVER);
		map.put("�����÷�", PlayerInfo.AVE_SCORING);
		map.put("����Ͷ��������", PlayerInfo.AVE_NUM_OF_SHOOTING);
		map.put("����Ͷ����", PlayerInfo.AVE_NUM_OF_SHOT);
		map.put("����������������", PlayerInfo.AVE_NUM_OF_THREE_POINT_SHOOTING);
		map.put("��������������", PlayerInfo.AVE_NUM_OF_THREE_POINT_SHOT);
		map.put("��������������", PlayerInfo.AVE_NUM_OF_FREE_THROW_SHOOTING);
		map.put("������������", PlayerInfo.AVE_NUM_OF_FREE_THROW_SHOT);
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
