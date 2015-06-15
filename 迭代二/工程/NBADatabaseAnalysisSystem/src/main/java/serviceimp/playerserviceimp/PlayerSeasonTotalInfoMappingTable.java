package serviceimp.playerserviceimp;

import serviceimp.MappingTable;

public class PlayerSeasonTotalInfoMappingTable extends MappingTable {

	public PlayerSeasonTotalInfoMappingTable() {
		super();
		addMap("", "");
		
		addMap("根据球队查找", "");
		addMap("根据位置查找", "");
		
		addMap("全部联盟", "");
		addMap("全部位置", "");
		
		addMap("东部", "E");
		addMap("西部", "W");
		addMap("大西洋区", "大西洋");
		addMap("中央区", "中央");
		addMap("东南区", "东南");
		addMap("西南区", "西南");
		addMap("西北区", "西北");
		addMap("太平洋区", "太平洋");
		
		addMap("前锋", "前锋");
		addMap("中锋", "中锋");
		addMap("后卫", "后卫");
		
		addMap("得分", "Score");
		addMap("篮板", "Rebounds");
		addMap("助攻", "Assists");
		addMap("得分/篮板/助攻", "round(1.0 * (Score + Rebounds + Assists) / 3, 1)");
		addMap("盖帽", "BlockShots");
		addMap("抢断", "Steals");
		addMap("犯规", "Fouls");
		addMap("失误", "TurnOvers");
		addMap("分钟", "PresenceTime");
		addMap("效率", "Efficiency");
		addMap("投篮", "ShootingPersentage");
		addMap("三分", "ThreePointPersentage");
		addMap("罚球", "FreeThrowPersentage");
		addMap("两双", "''");
		
		addMap("2012-2013", "20122013");
		addMap("2013-2014", "20132014");
		addMap("2014-2015", "20142015");
	}
	
}
