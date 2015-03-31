package dao.teamdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import entity.SortType;
import entity.TeamInfo;

public class TeamDaoJdbcImp implements TeamDao {

	private Connection connection;
	
    public TeamDaoJdbcImp() throws Exception {
    	Class.forName("org.sqlite.JDBC");
    	connection = DriverManager.getConnection("jdbc:sqlite:NBADatabase.db");    
    }
    
	public ArrayList<Map<TeamInfo, String>> getTeam(ArrayList<TeamInfo> columnList, SortType sortType, TeamInfo sortBy)
			throws Exception {
		String columnsToSearch = "";
		TeamTranslation translation = new TeamTranslation();
		ArrayList<String> columnStrList = new ArrayList<String>();
		for (TeamInfo playerInfo:columnList) {
			String temp = translation.translation(playerInfo);
			columnsToSearch = columnsToSearch + temp + ",";
			columnStrList.add(temp);
		}
		columnsToSearch = columnsToSearch.substring(0, columnsToSearch.length()-1);
		Statement statement = connection.createStatement();
		ResultSet resultSet;
		if (sortType.equals(SortType.SORT)) {
			String temp = translation.translation(sortBy);
			resultSet = statement.executeQuery("SELECT " + columnsToSearch + " FROM teams ORDER BY " + temp + " ASC");
		} else if (sortType.equals(SortType.REVERSE_SORT)) {
			String temp = translation.translation(sortBy);
			resultSet = statement.executeQuery("SELECT " + columnsToSearch + " FROM teams ORDER BY " + temp + " DESC");
		} else {
			resultSet = statement.executeQuery("SELECT " + columnsToSearch + " FROM teams");
		}
		ArrayList<Map<TeamInfo, String>> result = new ArrayList<Map<TeamInfo, String>>();
		while (resultSet.next()) {
			Map<TeamInfo, String> map = new HashMap<TeamInfo, String>();
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

