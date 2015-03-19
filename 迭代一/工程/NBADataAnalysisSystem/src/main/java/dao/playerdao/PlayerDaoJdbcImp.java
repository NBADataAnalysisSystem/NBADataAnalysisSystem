package dao.playerdao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;










import entity.player.Player;
import entity.player.PlayerInfo;

public class PlayerDaoJdbcImp implements PlayerDao {

	private Connection connection;
	private PreparedStatement prep ;
	//从数据库中读取球员数据，创建并返回球员对象
	public Player getPlayerById(String id) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM players WHERE id=" + id);
		Map<PlayerInfo, String> map = new HashMap<PlayerInfo, String>();
		map.put(PlayerInfo.PLAYER_ID, resultSet.getString("id"));
		map.put(PlayerInfo.NAME, resultSet.getString("name"));
		/*map.put(PlayerInfo.NUMBER, resultSet.getString("number"));
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
		map.put(PlayerInfo.SCORING, resultSet.getString("scoring"));*/
		return new Player(map);
	}
	
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	//创建数据库及相关表格
	public void createTables() throws Exception {
		Statement statement = connection.createStatement();
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(
								new File("./src/test/java/player.sql"))));
		String sql = "";
		String strTemp = "";
		while((strTemp = reader.readLine()) != null){
			sql += strTemp;
		}
        System.out.println(sql);
		statement.executeUpdate(sql);
		reader.close();
	}
	
	//连接并创建数据库
    public void createDatabase() throws Exception{
    	Class.forName("org.sqlite.JDBC");
    	connection = DriverManager.getConnection("jdbc:sqlite:NBADatabase.db");
    	Statement stat = connection.createStatement();
    	stat.executeUpdate("drop table if exists players");
    	stat.executeUpdate("create table players ("
    			+ "id integer primary key autoincrement,"
    			+ "player_name varchar(30),"
    			+ "jersey_number varchar(10),"
    			+ "position varchar(10),"
    			+ "height varchar(10),"
    			+ "weight varchar(10),"
    			+ "birth varchar(10),"
    			+ "age varchar(10),"
    			+ "exp varchar(10),"
    			+ "school varchar(10),"
    			+ "unique(id,player_name) );");
    	 prep = connection.prepareStatement("insert into players values(?,?,?,?,?,?,?,?,?,?);");
    	 PreparedStatement prepa = connection.prepareStatement("insert into paths values(?,?)");
    	 prepa.setString(1,"2");
    	 prepa.setString(2,"sig");
    	 prepa.addBatch();
    	   	connection.setAutoCommit(false);
        	prepa.executeBatch();
        	connection.setAutoCommit(true);
    		
    	
    }
	
	//读取文本文件，保存到数据库
	public void fileToDatabase(String path) throws Exception {
		File[] fileList = new File(path+"players/info/").listFiles();
		
		//存储球员数据到数据库
		//Pattern pattern = Pattern.compile("│\\w+ *\\w*,* *\\w*-*\\w*");
		Pattern pattern = Pattern.compile("│([\\w', \\(\\)-\\.]*)");
		for(File file : fileList){
			insertPlayersIntoDatabase("players",findPlayerMatcher(file,pattern));
		}
		
    	
    	connection.setAutoCommit(false);
    	prep.executeBatch();
    	connection.setAutoCommit(true);
		
	}
	
	//读取player文件，格式化输出球员信息
	private String[] findPlayerMatcher(File file,Pattern pattern) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
		String strTemp = br.readLine();
        String[]  result = new String[9];
		
        int i = 0;
		while(strTemp != null){
		    Matcher matcher = pattern.matcher(strTemp);
			if(matcher.find()){
				result[i] = matcher.group(0).split("│")[1] ;
				i++;
			}
			strTemp = br.readLine();
		}
		br.close();	      
		return result;
	}
	
	//将球员数据保存到数据库
	private void insertPlayersIntoDatabase(String table,String[] value) throws Exception{

		//PreparedStatement prep = connection.prepareStatement("insert into players values(?,?,?,?,?,?,?,?,?);");
		
    	for(int i = 0 ;i < 9;i ++ ){
    		prep.setString(i+2,value[i]);
    	}
    	prep.addBatch();
    	
    	Statement stat = connection.createStatement();
    	ResultSet rs = stat.executeQuery("select * from players;");
    	while (rs.next()){
    		System.out.println("name = "+rs.getString("player_name"));
    		System.out.println("number= "+rs.getString("jersey_number"));
    		rs.close();
    		connection.close();
    	}
	}
	

}
