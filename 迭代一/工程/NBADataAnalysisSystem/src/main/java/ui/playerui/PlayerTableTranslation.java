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
		//基本信息
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
		//赛季数据
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
		
		map.put("效率", PlayerInfo.EFFICIENCY);
		map.put("GmSc效率", PlayerInfo.GMSC_EFF);
		map.put("真实投篮命中率", PlayerInfo.TRUE_SHOOTING_PERCENTAGE);
		map.put("投篮效率", PlayerInfo.SHOOTING_EFF);
		map.put("篮板率", PlayerInfo.REBOUND_RATE);
		map.put("进攻篮板率", PlayerInfo.OFFENSIVE_REBOUND_RATE);
		map.put("防守篮板率", PlayerInfo.DEFENSIVE_REBOUND_RATE);
		map.put("助攻率", PlayerInfo.ASSIST_RATE);
		map.put("抢断率", PlayerInfo.STEAL_RATE);
		map.put("盖帽率", PlayerInfo.BLOCK_SHOT_RATE);
		map.put("失误率", PlayerInfo.TURN_OVER_RATE);
		map.put("使用率", PlayerInfo.USE_RATE);
		//场均数据
		map.put("场均篮板数", PlayerInfo.AVE_NUM_OF_REBOUND);
		map.put("场均助攻数", PlayerInfo.AVE_NUM_OF_ASSIST);
		map.put("场均在场时间（秒）", PlayerInfo.AVE_TIME_OF_PRESENCE);
		map.put("场均进攻数", PlayerInfo.AVE_NUM_OF_OFFENSE);
		map.put("场均防守数", PlayerInfo.AVE_NUM_OF_DEFENSE);
		map.put("场均抢断数", PlayerInfo.AVE_NUM_OF_STEAL);
		map.put("场均盖帽数", PlayerInfo.AVE_NUM_OF_BLOCK_SHOT);
		map.put("场均失误数", PlayerInfo.AVE_NUM_OF_FOUL);
		map.put("场均犯规数", PlayerInfo.AVE_NUM_OF_TURN_OVER);
		map.put("场均得分", PlayerInfo.AVE_SCORING);
		map.put("场均投篮命中数", PlayerInfo.AVE_NUM_OF_SHOOTING);
		map.put("场均投篮数", PlayerInfo.AVE_NUM_OF_SHOT);
		map.put("场均三分球命中数", PlayerInfo.AVE_NUM_OF_THREE_POINT_SHOOTING);
		map.put("场均三分球总数", PlayerInfo.AVE_NUM_OF_THREE_POINT_SHOT);
		map.put("场均罚球命中数", PlayerInfo.AVE_NUM_OF_FREE_THROW_SHOOTING);
		map.put("场均罚球总数", PlayerInfo.AVE_NUM_OF_FREE_THROW_SHOT);
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
