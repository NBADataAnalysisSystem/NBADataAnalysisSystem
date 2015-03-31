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
		map.put("ID", PlayerInfo.PLAYER_ID);
		map.put("名字", PlayerInfo.NAME);
		map.put("号数", PlayerInfo.NUMBER);
		map.put("位置", PlayerInfo.POSITION);
		map.put("身高", PlayerInfo.HEIGHT);
		map.put("体重", PlayerInfo.WEIGHT);
		map.put("出生日期", PlayerInfo.BIRTH);
		map.put("年龄", PlayerInfo.AGE);
		map.put("球龄", PlayerInfo.EXP);
		map.put("学校", PlayerInfo.SCHOOL);
		map.put("所在球队", PlayerInfo.TEAM);
		map.put("参赛场数", PlayerInfo.NUM_OF_ENTRY_FIELD);
		map.put("先发场数", PlayerInfo.NUM_OF_STARTING_FIELD);
		map.put("篮板数", PlayerInfo.NUM_OF_REBOUND);
		map.put("助攻数", PlayerInfo.NUM_OF_ASSIST);
		map.put("在场时间（秒）", PlayerInfo.TIME_OF_PRESENCE);
		map.put("进攻数", PlayerInfo.NUM_OF_OFFENSE);
		map.put("防守数", PlayerInfo.NUM_OF_DEFENSE);
		map.put("抢断数", PlayerInfo.NUM_OF_STEAL);
		map.put("盖帽数", PlayerInfo.NUM_OF_BLOCK_SHOT);
		map.put("失误数", PlayerInfo.NUM_OF_FOUL);
		map.put("犯规数", PlayerInfo.NUM_OF_TURN_OVER);
		map.put("得分", PlayerInfo.SCORING);
		map.put("投篮命中数", PlayerInfo.NUM_OF_SHOOTING);
		map.put("投篮数", PlayerInfo.NUM_OF_SHOT);
		map.put("三分球命中数", PlayerInfo.NUM_OF_THREE_POINT_SHOOTING);
		map.put("三分球总数", PlayerInfo.NUM_OF_THREE_POINT_SHOT);
		map.put("罚球命中数", PlayerInfo.NUM_OF_FREE_THROW_SHOOTING);
		map.put("罚球总数", PlayerInfo.NUM_OF_FREE_THROW_SHOT);
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
