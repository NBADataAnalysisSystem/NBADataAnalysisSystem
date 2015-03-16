package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;





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
	
	public boolean fileToDatabase(String path) throws Exception {
		File[] fileList = new File(path).listFiles();
		Pattern pattern = Pattern.compile("©¦\\w+ *\\w*,* *\\w*-*\\w*");
		for(File file : fileList){
			System.out.println(findPlayerMatcher(file,pattern));
		}
		return true;
	}
	
	private String findPlayerMatcher(File file,Pattern pattern) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
		String strTemp = br.readLine();
        String result = "";
		
		while(strTemp != null){
		    Matcher matcher = pattern.matcher(strTemp);
			if(matcher.find()){
				result += ("'"+matcher.group(0).split("©¦")[1] + "',");
			}
			strTemp = br.readLine();
		}
		br.close();	      
		result = result.substring(0,result.length()-1);
		return result;
	}
	

}
