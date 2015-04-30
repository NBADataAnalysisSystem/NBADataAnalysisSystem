package serviceimp.hotserviceimp;

import serviceimp.MappingTable;

public class HotPlayerMappingTable extends MappingTable {

	public HotPlayerMappingTable() {
		super();
		
		addMap("得分", "score");
		addMap("篮板", "rebounds");
		addMap("助攻", "assists");
		addMap("盖帽", "block_shots");
		addMap("抢断", "steals");
		
		addMap("场均得分", "");
		addMap("场均助攻", "");
		addMap("场均篮板", "");
		addMap("场均盖帽", "");
		addMap("三分%", "");
		addMap("%", "");
		addMap("罚球%", "");
	}
	
}
