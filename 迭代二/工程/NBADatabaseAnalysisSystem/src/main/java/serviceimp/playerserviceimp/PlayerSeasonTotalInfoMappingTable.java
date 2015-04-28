package serviceimp.playerserviceimp;

public class PlayerSeasonTotalInfoMappingTable extends MappingTable {

	public PlayerSeasonTotalInfoMappingTable() {
		super();
		
		addMap("东部", "E");
		addMap("西部", "W");
		addMap("大西洋区", "Atlantic");
		addMap("中央区", "Central");
		addMap("东南区", "Southeast");
		addMap("西南区", "Southwest");
		addMap("西北区", "Northwest");
		addMap("太平洋区", "Pacific");
		
		addMap("前锋", "F");
		addMap("中锋", "C");
		addMap("后卫", "G");
		
		addMap("得分", "ssc");
		addMap("篮板", "sr");
		addMap("助攻", "sa");
		addMap("得分/篮板/助攻", "round(1.0 * (ssc + sr + sa) / 3, 1)");
		addMap("盖帽", "sbs");
		addMap("抢断", "sst");
		addMap("犯规", "sfo");
		addMap("失误", "sto");
		addMap("分钟", "spt");
		addMap("效率", "''");
		addMap("投篮", "sp");
		addMap("三分", "tpsp");
		addMap("罚球", "ftsp");
		addMap("两双", "1.0*t5.dd/dmi");
		
		addMap("2012-2013", "12-13");
		addMap("2013-2014", "13-14");
	}
	
}
