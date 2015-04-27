package serviceimp.playerserviceimp;

import java.util.HashMap;
import java.util.Map;

public class MappingTable {

	private Map<String, String> map;
	
	public MappingTable() {
		map = new HashMap<String, String>();
	}
	
	public void addMap(String from, String to) {
		map.put(from, to);
	}
	
	public String get(String from) {
		return map.get(from);
	}
	
}
