package dao.playerdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import entity.SortType;
import entity.player.PlayerInfo;

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
	
	public void close() throws Exception {
		connection.close();
	}
    
}
