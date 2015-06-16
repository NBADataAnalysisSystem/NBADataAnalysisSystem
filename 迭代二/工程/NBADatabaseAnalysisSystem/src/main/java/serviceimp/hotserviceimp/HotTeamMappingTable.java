package serviceimp.hotserviceimp;

import serviceimp.MappingTable;

public class HotTeamMappingTable extends MappingTable {

	public HotTeamMappingTable() {
		super();
		
		addMap("得分", "Score");
		addMap("篮板", "Rebounds");
		addMap("助攻", "Assists");
		addMap("盖帽", "BlockShots");
		addMap("抢断", "Steals");
		addMap("三分%", "ThreePointPersentage");
		addMap("%", "ShootingPersentage");
		addMap("罚球%", "FreeThrowPersentage");
	}
	
}
