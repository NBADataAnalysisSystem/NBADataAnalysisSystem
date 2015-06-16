package serviceimp.hotserviceimp;

import serviceimp.MappingTable;

public class HotPlayerMappingTable extends MappingTable {

	public HotPlayerMappingTable() {
		super();
		
		addMap("场均得分", "Score");
		addMap("场均篮板", "Rebounds");
		addMap("场均助攻", "Assists");
	}
	
}
