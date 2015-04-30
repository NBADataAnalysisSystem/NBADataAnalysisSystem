package serviceimp.hotserviceimp;

import serviceimp.MappingTable;

public class HotTeamMappingTable extends MappingTable {

	public HotTeamMappingTable() {
		super();
		
		addMap("得分", "");
		addMap("篮板", "");
		addMap("助攻", "");
		addMap("盖帽", "");
		addMap("抢断", "");
		addMap("三分%", "");
		addMap("%", "");
		addMap("罚球%", "");
	}
	
}
