package serviceimp.playerserviceimp;

public class PlayerSeasonAvgInfoMappingTable extends MappingTable {

	public PlayerSeasonAvgInfoMappingTable() {
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
		
		addMap("得分", "cjdf");
		addMap("篮板", "cjlb");
		addMap("助攻", "cjzg");
		addMap("得分/篮板/助攻", "round(1.0 * (cjdf + cjlb + cjzg) / 3, 1)");
		addMap("盖帽", "cjgm");
		addMap("抢断", "cjqd");
		addMap("犯规", "cjfg");
		addMap("失误", "cjsw");
		addMap("分钟", "cjfz");
		addMap("效率", "eff");
		addMap("投篮", "tlmzl");
		addMap("三分", "sfqmzl");
		addMap("罚球", "fqmzl");
		addMap("两双", "1.0*t1.dd/dmi");
		
		addMap("2012-2013", "12-13");
		addMap("2013-2014", "13-14");
	}
	
}
