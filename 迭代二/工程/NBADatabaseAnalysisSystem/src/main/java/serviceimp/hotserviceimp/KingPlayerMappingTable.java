package serviceimp.hotserviceimp;

import serviceimp.MappingTable;

public class KingPlayerMappingTable extends MappingTable {

	public KingPlayerMappingTable() {
		super();
		
		addMap("得分", "Score");
		addMap("篮板", "Rebounds");
		addMap("助攻", "Assists");
		addMap("盖帽", "BlockShots");
		addMap("抢断", "Steals");
		
		addMap("场均得分", "round((Score/NumOfMatch),1)");
		addMap("场均助攻", "round((Assists/NumOfMatch),1)");
		addMap("场均篮板", "round((Rebounds/NumOfMatch),1)");
		addMap("场均盖帽", "round((BlockShots/NumOfMatch),1)");
		addMap("三分%", "ThreePointPersentage");
		addMap("%", "ShootingPersentage");
		addMap("罚球%", "FreeThrowPersentage");
	}
	
}
