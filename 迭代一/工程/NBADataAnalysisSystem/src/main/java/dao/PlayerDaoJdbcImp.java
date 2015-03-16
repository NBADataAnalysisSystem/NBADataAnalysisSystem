package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import entity.Player;
import entity.PlayerInfo;

public class PlayerDaoJdbcImp implements PlayerDao {

	private Connection connection;

	public Player getPlayerById(String id) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM players WHERE id=" + id);
		Map<PlayerInfo, String> map = new HashMap<PlayerInfo, String>();
		map.put(PlayerInfo.PLAYER_ID, resultSet.getString("id"));
		map.put(PlayerInfo.NAME, resultSet.getString("name"));
		map.put(PlayerInfo.NUMBER, resultSet.getString("number"));
		map.put(PlayerInfo.POSITION, resultSet.getString("position"));
		map.put(PlayerInfo.HEIGHT, resultSet.getString("height"));
		map.put(PlayerInfo.WEIGHT, resultSet.getString("weight"));
		map.put(PlayerInfo.BIRTH, resultSet.getString("birth"));
		map.put(PlayerInfo.AGE, resultSet.getString("age"));
		map.put(PlayerInfo.EXP, resultSet.getString("exp"));
		map.put(PlayerInfo.SCHOOL, resultSet.getString("school"));
		map.put(PlayerInfo.FILE_PATH, resultSet.getString("filepath"));
		map.put(PlayerInfo.TEAM, resultSet.getString("team"));
		map.put(PlayerInfo.NUM_OF_ENTRY_FIELD, resultSet.getString("num_of_entry_field"));
		map.put(PlayerInfo.NUM_OF_STARTING_FIELD, resultSet.getString("num_of_starting_field"));
		map.put(PlayerInfo.NUM_OF_REBOUND, resultSet.getString("num_of_rebound"));
		map.put(PlayerInfo.NUM_OF_ASSIST, resultSet.getString("num_of_assist"));
		map.put(PlayerInfo.TIME_OF_PRESENCE, resultSet.getString("time_of_presence"));
		map.put(PlayerInfo.NUM_OF_OFFENSE, resultSet.getString("num_of_offense"));
		map.put(PlayerInfo.NUM_OF_DEFENSE, resultSet.getString("num_of_defense"));
		map.put(PlayerInfo.NUM_OF_STEAL, resultSet.getString("num_of_steal"));
		map.put(PlayerInfo.NUM_OF_BLOCK_SHOT, resultSet.getString("num_of_block_shot"));
		map.put(PlayerInfo.NUM_OF_TURN_OVER, resultSet.getString("num_of_turn_over"));
		map.put(PlayerInfo.NUM_OF_FOUL, resultSet.getString("num_of_foul"));
		map.put(PlayerInfo.SCORING, resultSet.getString("scoring"));
		return new Player(map);
	}
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public void createTables() throws Exception {
		Statement statement = connection.createStatement();
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(
								new File("./src/test/java/player.sql"))));
		statement.executeUpdate(reader.readLine());
		reader.close();
	}

}
