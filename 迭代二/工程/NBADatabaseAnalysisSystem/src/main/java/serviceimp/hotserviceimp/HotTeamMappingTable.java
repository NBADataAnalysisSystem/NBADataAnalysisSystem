package serviceimp.hotserviceimp;

import serviceimp.MappingTable;

public class HotTeamMappingTable extends MappingTable {

	public HotTeamMappingTable() {
		super();
		
		addMap("得分", "sum(pmp.score)");
		addMap("篮板", "sum(pmp.rebounds)");
		addMap("助攻", "sum(pmp.assists)");
		addMap("盖帽", "sum(pmp.block_shots)");
		addMap("抢断", "sum(pmp.steals)");
		addMap("三分%", "round(100.0*sum(pmp.three_point_shootings)/sum(pmp.three_point_shots),1)");
		addMap("%", "round(100.0*sum(pmp.shootings)/sum(pmp.shots),1)");
		addMap("罚球%", "round(100.0*sum(pmp.free_throw_shootings)/sum(pmp.free_throw_shots),1)");
	}
	
}
