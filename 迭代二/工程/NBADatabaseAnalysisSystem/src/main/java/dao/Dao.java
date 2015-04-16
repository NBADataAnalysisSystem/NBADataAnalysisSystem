package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Dao implements DaoInterface {
	
	Connection connection;
	
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

	public void readFiles(String path)throws Exception {};
	
	public void refreshFiles() throws Exception{};
	
	public static void main(String[] args) throws Exception{
		Dao dao = new Dao();
		dao.newDatabase();
	}
	
}
