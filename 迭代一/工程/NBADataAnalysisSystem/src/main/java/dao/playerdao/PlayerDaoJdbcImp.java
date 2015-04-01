package dao.playerdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import entity.PlayerInfo;
import entity.SiftingOfOth;
import entity.SiftingOfPosition;
import entity.SiftingOfUnion;
import entity.SortType;

public class PlayerDaoJdbcImp implements PlayerDao {

	private Connection connection;
	
    public PlayerDaoJdbcImp() throws Exception {
    	Class.forName("org.sqlite.JDBC");
    	connection = DriverManager.getConnection("jdbc:sqlite:NBADatabase.db");    
    }
    
	public ArrayList<Map<PlayerInfo, String>> getPlayer(ArrayList<PlayerInfo> columnList, SortType sortType, PlayerInfo sortBy)
			throws Exception {
		String columnsToSearch = "";
		PlayerTranslation translation = new PlayerTranslation();
		ArrayList<String> columnStrList = new ArrayList<String>();
		for (PlayerInfo playerInfo:columnList) {
			String temp = translation.translation(playerInfo);
			columnsToSearch = columnsToSearch + temp + ",";
			columnStrList.add(temp);
		}
		columnsToSearch = columnsToSearch.substring(0, columnsToSearch.length()-1);
		Statement statement = connection.createStatement();
		ResultSet resultSet;
		if (sortType.equals(SortType.SORT)) {
			String temp = translation.translation(sortBy);
			resultSet = statement.executeQuery("SELECT " + columnsToSearch + " FROM players ORDER BY " + temp + " ASC");
		} else if (sortType.equals(SortType.REVERSE_SORT)) {
			String temp = translation.translation(sortBy);
			resultSet = statement.executeQuery("SELECT " + columnsToSearch + " FROM players ORDER BY " + temp + " DESC");
		} else {
			resultSet = statement.executeQuery("SELECT " + columnsToSearch + " FROM players");
		}
		ArrayList<Map<PlayerInfo, String>> result = new ArrayList<Map<PlayerInfo, String>>();
		while (resultSet.next()) {
			Map<PlayerInfo, String> map = new HashMap<PlayerInfo, String>();
			for (String string:columnStrList) {
				map.put(translation.reverseTranslation(string), resultSet.getString(string));
			}
			result.add(map);
		}
		statement.close();
		return result;
	}
	
	public ArrayList<Map<PlayerInfo, String>> siftPlayer(ArrayList<PlayerInfo> columnList, SiftingOfPosition position, SiftingOfUnion union, SiftingOfOth sortBy) throws Exception {
		String columnsToSearch = "";
		PlayerTranslation translation = new PlayerTranslation();
		ArrayList<String> columnStrList = new ArrayList<String>();
		for (PlayerInfo playerInfo:columnList) {
			String temp = translation.translation(playerInfo);
			columnsToSearch = columnsToSearch + temp + ",";
			columnStrList.add(temp);
		}
		columnsToSearch = columnsToSearch.substring(0, columnsToSearch.length()-1);
		Statement statement = connection.createStatement();
		ResultSet resultSet;
		String positionString="";
		switch (position) {
		case FORWARD:
			positionString = " position like \"%F%\" ";
			break;
		case CENTER:
			positionString = " position like \"%C%\" ";
			break;
		case GUARD:
			positionString = " position like \"%G%\" ";
			break;
		default:
			break;
		}
		Map<SiftingOfUnion, String> siftingOfUnionToStringMap = new HashMap<SiftingOfUnion, String>();
		siftingOfUnionToStringMap.put(SiftingOfUnion.ATLANTICDIVISION,
				" team in (select abbreviation from teams where section=\"Atlantic\")");
		siftingOfUnionToStringMap.put(SiftingOfUnion.CENTRALDIVISION, 
				" team in (select abbreviation from teams where section=\"Central\")");
		siftingOfUnionToStringMap.put(SiftingOfUnion.EASTDIVITION, 
				" team in (select abbreviation from teams where division=\"E\")");
		siftingOfUnionToStringMap.put(SiftingOfUnion.NORTHWESTDIVISION, 
				" team in (select abbreviation from teams where section=\"Northwest\")");
		siftingOfUnionToStringMap.put(SiftingOfUnion.PACIFICDIVISION, 
				" team in (select abbreviation from teams where section=\"Parcific\")");
		siftingOfUnionToStringMap.put(SiftingOfUnion.SOUTHEASTDIVISION, 
				" team in (select abbreviation from teams where section=\"Southeast\")");
		siftingOfUnionToStringMap.put(SiftingOfUnion.SOUTHWESTDIVISION, 
				" team in (select abbreviation from teams where section=\"Southwest\")");
		siftingOfUnionToStringMap.put(SiftingOfUnion.WESTDIVITION, 
				" team in (select abbreviation from teams where division=\"W\")");
		String unionString = siftingOfUnionToStringMap.get(union);
		if (!positionString.equals("")) {
			positionString = " where"+positionString;
			if (unionString!=null) {
				unionString = "and"+unionString;
			} else {
				unionString = "";
			}
		} else {
			positionString = "";
			if (unionString!=null) {
				unionString = " where"+unionString;
			} else {
				unionString = "";
			}
		}
		resultSet = statement.executeQuery("SELECT " + columnsToSearch + " FROM players"+positionString+unionString);
		ArrayList<Map<PlayerInfo, String>> result = new ArrayList<Map<PlayerInfo, String>>();
		while (resultSet.next()) {
			Map<PlayerInfo, String> map = new HashMap<PlayerInfo, String>();
			for (String string:columnStrList) {
				map.put(translation.reverseTranslation(string), resultSet.getString(string));
			}
			result.add(map);
		}
		statement.close();
		return result;
	}
	
	public void close() throws Exception {
		connection.close();
	}
    
}
