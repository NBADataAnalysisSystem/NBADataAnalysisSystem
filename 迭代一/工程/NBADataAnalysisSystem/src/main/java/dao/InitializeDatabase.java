package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.PreparedStatement;

//���Ӳ��������ݿ⣬���ļ����ж�������
public class InitializeDatabase {
	Connection connection;
	
	//�����µģ�û���κμ�¼�����ݿ�
	public void createDatabase() throws Exception{
		connectToDatabase();
		Statement stat = connection.createStatement();
    	stat.executeUpdate("drop table if exists players");
    	stat.executeUpdate("drop table if exists matches");
    	stat.executeUpdate("drop table if exists overtime_matches");
    	stat.executeUpdate("drop table if exists player_match_performance");
    	stat.executeUpdate("drop table if exists team_season_performance");
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
	
	//��ȡ�ļ����ݵ����ݿ�
	public void fileToDatabase(String path) throws Exception{
		connectToDatabase();
		
		playerFileToDatabase(path+"/players/info/");
		
		teamFileToDatabase(path+"/teams/teams");
		
		matchFileToDatabase(path+"/matches");
	}
	
	//���ӵ����ݿ�
	private void connectToDatabase() throws Exception{
		Class.forName("org.sqlite.JDBC");
    	connection = DriverManager.getConnection("jdbc:sqlite:NBADatabase.db");
	}
	
	//������Ա���ݵ����ݿ�
	private void playerFileToDatabase(String path) throws Exception{
		PreparedStatement prep = connection.prepareStatement(""
				+ "insert into players values("
				+ "?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?)");
		File[] fileList = new File(path).listFiles();	
		String[] strList = new String[9];
		for(File file : fileList){
			strList = findPlayerMatcher(file);
	    	for(int i = 0 ;i < 9;i ++ ){
	    		prep.setString(i+2,strList[i]);
	    	}
	    	prep.addBatch();
		}
		
    	connection.setAutoCommit(false);
    	prep.executeBatch();
    	connection.setAutoCommit(true);
	}
	
	//����������ݵ����ݿ�
	private void teamFileToDatabase(String path) throws Exception{
		PreparedStatement prep = connection.prepareStatement(""
				+ "insert into teams values("
				+ "?,?,?,?,?,?,?,?)");
		Pattern pattern = Pattern.compile("�U([\\w\\t\\(\\)\\& ��]*)�U");
		
		File file = new File(path);
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
		String strTemp = br.readLine();
		
		strTemp=br.readLine();
		
		String data[] = new String[7];
		while(strTemp != null){
			Matcher matcher = pattern.matcher(strTemp);
			if(matcher.find()){
				data = matcher.group(1).split("��");
				for(int i = 0;i < 7;i++){
					prep.setString(i+2,data[i].trim());
				}
				prep.addBatch();
			}
			
			strTemp = br.readLine();
		}
		
		br.close();
    	connection.setAutoCommit(false);
    	prep.executeBatch();
    	connection.setAutoCommit(true);		
	}
	
	//����������ݵ����ݿ�
	private void matchFileToDatabase(String path){};

	//ɸѡָ���ļ��е���Ա��Ϣ
	private String[] findPlayerMatcher(File file) throws Exception{
		Pattern pattern = Pattern.compile("��([\\w', \\(\\)-\\.]*)");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
		String strTemp = br.readLine();
        String[]  result = new String[9];
		
        int i = 0;
		while(strTemp != null){
		    Matcher matcher = pattern.matcher(strTemp);
			if(matcher.find()){
				result[i] = matcher.group(0).split("��")[1] ;
				i++;
			}
			strTemp = br.readLine();
		}
		br.close();	      
		return result;
	}
}
