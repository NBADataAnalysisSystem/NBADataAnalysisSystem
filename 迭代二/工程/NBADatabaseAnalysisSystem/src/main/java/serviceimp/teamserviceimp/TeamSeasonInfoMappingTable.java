package serviceimp.teamserviceimp;

import serviceimp.MappingTable;

public class TeamSeasonInfoMappingTable extends MappingTable {

	public TeamSeasonInfoMappingTable() {
		super();
		
		addMap("东部", "E");
		addMap("西部", "W");
		addMap("大西洋区", "大西洋");
		addMap("中央区", "中央");
		addMap("东南区", "东南");
		addMap("西南区", "西南");
		addMap("西北区", "西北");
		addMap("太平洋区", "太平洋");
		addMap("全部联盟", "");

		addMap("2012-2013", "20122013");
		addMap("2013-2014", "20132014");
		addMap("2014-2015", "20142015");
	}
	
}
