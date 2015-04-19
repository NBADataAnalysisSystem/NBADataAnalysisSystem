package dao.playerdao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import entity.PlayerEntity;

public class PlayerEnumToField {

	private Map<PlayerEntity, String> map;
	
	public PlayerEnumToField() {
		map = new HashMap<PlayerEntity, String>();
		//编号，唯一
		map.put(PlayerEntity.ID, "id");
		
		//基本信息
		//球员名称
		map.put(PlayerEntity.PLAYER_NAME, "player_name");
	}
	
	public String translate(PlayerEntity playerEntity) {
		return map.get(playerEntity);
	}
	
	public PlayerEntity reverseTranslate(String string) {
		Iterator<Entry<PlayerEntity, String>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<PlayerEntity, String> entry = iterator.next();
			if (entry.getValue().equals(string)) {
				return (PlayerEntity) entry.getKey();
			}
		}
		return null;
	}
	
}
