package serviceimp.teamserviceimp;

import serviceimp.MappingTable;

public class TeamSeasonTotalBasicInfoMappingTable extends MappingTable {

	public TeamSeasonTotalBasicInfoMappingTable() {
		super();
		
		addMap("东部", "E");
		addMap("西部", "W");
		addMap("大西洋区", "Atlantic");
		addMap("中央区", "Central");
		addMap("东南区", "Southeast");
		addMap("西南区", "Southwest");
		addMap("西北区", "Northwest");
		addMap("太平洋区", "Pacific");

		addMap("2012-2013", "12-13");
		addMap("2013-2014", "13-14");
	}
	
}
