package dao.playerdao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import entity.PlayerEntity;

public class PlayerEntityToField {

	private Map<PlayerEntity, String> map;
	
	public PlayerEntityToField() {
		map = new HashMap<PlayerEntity, String>();
	}
	
	public String translation(PlayerEntity playerEntity) {
		return map.get(playerEntity);
	}
	
	public PlayerEntity reverseTranslation(String string) {
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
