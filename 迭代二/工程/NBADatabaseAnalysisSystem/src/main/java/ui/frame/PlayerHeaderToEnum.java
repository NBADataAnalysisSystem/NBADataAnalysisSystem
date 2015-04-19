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

