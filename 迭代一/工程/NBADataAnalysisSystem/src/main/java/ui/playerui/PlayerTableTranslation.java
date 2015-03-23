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
		map.put("Ãû×Ö", PlayerInfo.NAME);
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
