package ui.frame;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import entity.PlayerEntity;

public class PlayerHeaderToEnum {

	private Map<String, PlayerEntity> map;
	
	public PlayerHeaderToEnum() {
		map = new HashMap<String, PlayerEntity>();
		//编号，唯一
		map.put("ID", PlayerEntity.ID);
		
		//基本信息
		//球员名称
		map.put("名字", PlayerEntity.PLAYER_NAME);
		//球衣号码
		map.put("号数", PlayerEntity.JERSEY_NUMBER);
		//球员位置
		map.put("位置", PlayerEntity.POSITION);
		//身高
		map.put("身高", PlayerEntity.HEIGHT);
		//体重
		map.put("体重", PlayerEntity.WEIGHT);
		//生日
		map.put("出生日期", PlayerEntity.BIRTH);
		//年龄
		map.put("年龄", PlayerEntity.AGE);
		//球龄
		map.put("球龄", PlayerEntity.EXP);
		//毕业学校
		map.put("学校", PlayerEntity.SCHOOL);
		//所属球队
		map.put("球队", PlayerEntity.TEAM);
		
		//赛季总数据
		map.put("场数", PlayerEntity.NUM_OF_MATCH);
		map.put("先发", PlayerEntity.NUM_OF_START);
		map.put("篮板", PlayerEntity.REBOUNDS);
		map.put("助攻", PlayerEntity.ASSISTS);
		map.put("分钟", PlayerEntity.PRESENCE_TIME);
		map.put("%", PlayerEntity.SHOOTING_PERSENTAGE);
		map.put("三分%", PlayerEntity.THREE_POINT_SHOOTING_PERSENTAGE);
		map.put("罚球%", PlayerEntity.FREE_THROW_SHOOTING_PERSENTAGE);
		map.put("进攻", PlayerEntity.OFFENCES);
		map.put("防守", PlayerEntity.DEFENCES);
		map.put("抢断", PlayerEntity.STEALS);
		map.put("盖帽", PlayerEntity.BLOCK_SHOTS);
		map.put("失误", PlayerEntity.TURN_OVERS);
		map.put("犯规", PlayerEntity.FOULS);
		map.put("得分", PlayerEntity.SCORE);
	}
	
	public PlayerEntity translate(String string) {
		return map.get(string);
	}
	
	public String reverseTranslate(PlayerEntity playerEntity) {
		Iterator<Entry<String, PlayerEntity>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, PlayerEntity> entry = iterator.next();
			if (entry.getValue().equals(playerEntity)) {
				return (String) entry.getKey();
			}
		}
		return null;
	}
	
}

