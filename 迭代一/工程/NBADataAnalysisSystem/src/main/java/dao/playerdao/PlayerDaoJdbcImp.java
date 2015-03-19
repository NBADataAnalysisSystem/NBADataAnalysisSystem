package dao.playerdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import entity.player.PlayerInfo;

public class PlayerDaoJdbcImp implements PlayerDao {

	private Connection connection;
	
    public PlayerDaoJdbcImp() throws Exception {
    	Class.forName("org.sqlite.JDBC");
    	connection = DriverManager.getConnection("jdbc:sqlite:NBADatabase.db");    
    }
    
	public Map<PlayerInfo, String> getPlayer(ArrayList<PlayerInfo> columnList)
			throws Exception {
		String columnsToSearch = "";
		PlayerTranslation translation = new PlayerTranslation();
		for (PlayerInfo playerInfo:columnList) {
			columnsToSearch = columnsToSearch + (translation.translation(playerInfo)) + ",";
		}
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT " + columnsToSearch + "FROM players");
		Map<PlayerInfo, String> map = new HashMap<PlayerInfo, String>();
		map.put(PlayerInfo.PLAYER_ID, resultSet.getString("id"));
		map.put(PlayerInfo.NAME, resultSet.getString("name"));
		return map;
	}
    
}
