package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dao implements DaoInterface {
	
	Connection connection;
	
	//创建新数据库，运行耗时3秒
	public void newDatabase() throws Exception{
		
		//连接到数据库
		Class.forName("org.sqlite.JDBC");
    	connection = DriverManager.getConnection("jdbc:sqlite:NBADatabase.db");
    	
    	//创建表格
		Statement stat = connection.createStatement();
    	stat.executeUpdate("drop table if exists players");
    	stat.executeUpdate("drop table if exists matches");
    	stat.executeUpdate("drop table if exists overtime_matches");
    	stat.executeUpdate("drop table if exists player_match_performance");
    	stat.executeUpdate("drop table if exists teams");
    	stat.executeUpdate("drop table if exists paths");
    	
    	BufferedReader reader = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(
								new File("./src/main/java/dao/database.sql"))));
		String sql = "";
		String strTemp = "";
		while((strTemp = reader.readLine()) != null){
			sql += strTemp;
		}
		stat.executeUpdate(sql);
		reader.close();
	}

	public void readFiles(String path)throws Exception {
		//连接到数据库
		Class.forName("org.sqlite.JDBC");
    	connection = DriverManager.getConnection("jdbc:sqlite:NBADatabase.db");
    	
    	//从文件中读取
    	readPlayerFiles(path+"players/info/");
    	readTeamFiles(path+"teams/teams");
    	readMatchFiles(path+"matches/");
	};
	
	//读取制定路径下的players文件，并将结果写入数据库中，运行耗时1s
	private void readPlayerFiles(String path)throws Exception{
		File[] fileList = new File(path).listFiles();
		PreparedStatement prep = connection.prepareStatement(""
				+ "insert into players values("
				+ "?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,"
				+ "?)");
		for(File file : fileList){
			Pattern pattern = Pattern.compile("│([\\w', \\(\\)-\\.]*)");
			String[] player = findMatcher(file,pattern);
			
			//player数组的长度固定为9
			for(int i = 0 ;i < player.length ;i ++){
				prep.setString(i+2,player[i]);
			}
			prep.addBatch();
		}
		
		connection.setAutoCommit(false);
		prep.executeBatch();
		connection.setAutoCommit(true);
		
	};
		
	//返回指定文件的每一行中符合pattern中group（1）的字符串，每一行的结果放入数组中的一项
	private String[] findMatcher(File file,Pattern pattern)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
		String strTemp = br.readLine();
		String resultString = "";
		
		while(strTemp != null){
			Matcher matcher = pattern.matcher(strTemp);
			if(matcher.find()){
				resultString +=matcher.group(1)+";";
			}
			strTemp = br.readLine();
		}
		br.close();
		return resultString.split(";");
	}
	
	//读取指定路径下的teams文件，并将结果写入数据库中，耗时0.1s
	private void readTeamFiles(String path) throws Exception{
		File file = new File(path);
		PreparedStatement prep = connection.prepareStatement(""
				+ "insert into teams values("
				+ "?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?)");
		
		Pattern pattern = Pattern.compile("║([\\w\\t\\(\\)\\& │]*)║");
		String[] teamList = findMatcher(file,pattern);
		for(int i = 0;i < teamList.length;i++){
			String[] team = teamList[i].split("│");
			for(int j = 0;j < team.length;j ++){
				prep.setString(j+2,team[j].trim());
			}
			prep.addBatch();
		}
		connection.setAutoCommit(false);
		prep.executeBatch();
		connection.setAutoCommit(true);
	};
	
	private void readMatchFiles(String path){
		
	};
	
	private int getPlayerId(String n)throws Exception{
		int playerId;
		Statement stat = connection.createStatement();
		String name = checkPlayerName(n);
		ResultSet rs = stat.executeQuery("select id from players where player_name='"+name+"';");
		playerId = rs.getInt(1);
		return playerId;
	}
	
	//检查球员姓名中是否含有',将其改成\'
	private String checkPlayerName(String name){
		String result="";
		for(int i = 0 ; i < name.length();i ++){
			if(name.charAt(i)=='\''){
				result+="\\\'";
			}else{
				result+=name.charAt(i);
			}
		}
		return result;
	}
	
	//根据队伍缩写名查找队伍Id，结果返回int类型的Id值
	private int getTeamId(String abb)throws Exception{
		int teamId;
		Statement stat = connection.createStatement();
		ResultSet rs = stat.executeQuery("select id from teams where abbreviation='"+abb+"';");
		teamId = rs.getInt(1);
		return teamId;
	}
	
	//根据赛季，比赛日期和主场队伍查找比赛Id，结果返回int类型的Id
	private int getMatchId(String season,String date,int home_court_team_id)throws Exception{
		int matchId;
		Statement stat = connection.createStatement();
		ResultSet rs = stat.executeQuery("select id from matches where data_of_match='"+
		date+"',home_court_team_id='"+home_court_team_id+"',season='"+season+"';");
		matchId = rs.getInt(1);
		return matchId;
	};
	
	public void refreshFiles() throws Exception{};
	
	public static void main(String[] args) throws Exception{
		Dao dao = new Dao();
		//dao.newDatabase();//3秒
		//dao.readFiles("C:/Users/cross/Documents/CSE/CSEIII data/迭代一数据/");
		Class.forName("org.sqlite.JDBC");
    	dao.connection = DriverManager.getConnection("jdbc:sqlite:NBADatabase.db");
		System.out.println(dao.getTeamId("LAC"));
	}

}
