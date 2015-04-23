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

