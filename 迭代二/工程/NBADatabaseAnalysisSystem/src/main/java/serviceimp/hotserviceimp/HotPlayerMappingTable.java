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
		
		addMap("场均得分", "round(1.0*sum(pmp.shootings)/count(distinct pmp.match_id),1)");
		addMap("场均助攻", "round(1.0*sum(pmp.assists)/count(distinct pmp.match_id),1)");
		addMap("场均篮板", "round(1.0*sum(pmp.rebounds)/count(distinct pmp.match_id),1)");
		addMap("场均盖帽", "round(1.0*sum(pmp.block_shots)/count(distinct pmp.match_id),1)");
		addMap("三分%", "round(1.0*sum(pmp.three_point_shootings/sum(pmp.three_point_shots),1)");
		addMap("%", "round(1.0*sum(pmp.shootings)/sum(pmp.shots),1)");
		addMap("罚球%", "round(1.0*sum(pmp.free_throw_shootings)/sum(pmp.free_throw_shots),1)");
	}
	
}
