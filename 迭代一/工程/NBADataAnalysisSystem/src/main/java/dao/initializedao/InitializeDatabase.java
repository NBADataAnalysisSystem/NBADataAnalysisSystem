package dao.initializedao;

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
    	stat.executeUpdate("drop table if exists teams");
    	stat.executeUpdate("drop table if exists paths");
    	
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(
								new File("./src/main/java/dao/initializedao/database.sql"))));
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
		
		pathToDatabase(path);
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
	private void matchFileToDatabase(String path) throws Exception{
		File[] fileList = new File(path).listFiles();
		PreparedStatement matchPrep = connection.prepareStatement(""
				+ "insert into matches values ("
				+ "?,?,?,?,?,?,?,?,?,?,"
				+ "?)");
		PreparedStatement overtimeMatchPrep = connection.prepareStatement(""
				+ "insert into overtime_matches values("
				+ "?,?,?)");
		PreparedStatement playerMatchPerformancePrep = 
				connection.prepareStatement(""
				+ "insert into player_match_performance values ("
				+ "?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?)");
		for(File file : fileList ){
			String matchID = file.getName();
			String matchInformation = matchID.split("_")[0]+";";
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));

		
			String strTemp = br.readLine();
			while(!isTeam(strTemp)){
				matchInformation += strTemp;
				strTemp = br.readLine();
			}
			insertMatchIntoDatabase(matchInformation,matchPrep,overtimeMatchPrep);
			String team = strTemp;
			strTemp = br.readLine();
			while(!isTeam(strTemp)){
				playerMatchPerformancePrep.setString(1,matchID);
				playerMatchPerformancePrep.setString(2,team);
				insertPlayerMatchPerformanceIntoDatabase(strTemp,playerMatchPerformancePrep);
				strTemp = br.readLine();
			}
		
			team = strTemp;
			strTemp = br.readLine();
			while(strTemp!=null && !isTeam(strTemp)){
				playerMatchPerformancePrep.setString(1,matchID);
				playerMatchPerformancePrep.setString(2,team);
				insertPlayerMatchPerformanceIntoDatabase(strTemp,playerMatchPerformancePrep);
				strTemp = br.readLine();
			}
			br.close();
		}
		
    	connection.setAutoCommit(false);
    	matchPrep.executeBatch();
    	overtimeMatchPrep.executeBatch();
    	playerMatchPerformancePrep.executeBatch();
    	connection.setAutoCommit(true);	
		
	};

	//����·����Ϣ�����ݿ�
	private void pathToDatabase(String path) throws Exception{
		PreparedStatement prep = connection.prepareStatement("insert into paths values ("
				+ "?,?)");
		prep.setString(2,path);
		prep.addBatch();
		
    	connection.setAutoCommit(false);
    	prep.executeBatch();
    	connection.setAutoCommit(true);	
	}
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
	
	//�ж�match�ļ��ķָ������������
	 private boolean isTeam(String str){
		for(int i = 0 ;i < str.length();i ++){
			if(str.charAt(i)==';'){
				return false;
			}
		}
		return true;
	}

	//��һ��match��¼��ӵ�matches��overtime_matches��PrepareedStatement��
	private void insertMatchIntoDatabase(String match,PreparedStatement matchPrep
			,PreparedStatement overtimeMatchPrep) throws Exception{
		String[] data = match.split(";");
		matchPrep.setString(2, data[0]);
		matchPrep.setString(3, data[1]);
		matchPrep.setString(4, data[2].split("-")[0]);
		matchPrep.setString(5, data[2].split("-")[1]);
		matchPrep.setString(6, data[3]);
		matchPrep.setString(7, data[4]);
		matchPrep.setString(8, data[5]);
		matchPrep.setString(9, data[6]);
		matchPrep.setString(10, data[7]);
		if(data.length >8 ){
			matchPrep.setString(11, "true");
			for(int i = 8 ;i < data.length;i++){
				overtimeMatchPrep.setString(1,data[0]
						+";"+data[1]+";"+data[2]);
				overtimeMatchPrep.setString(2,(i-7)+"");
				overtimeMatchPrep.setString(3,data[i]);
				overtimeMatchPrep.addBatch();
			}
		}else{
			matchPrep.setString(11,"false");
		}
		matchPrep.addBatch();
	}

	//��һ����Ա������������ӵ�PreparedStatement��
	private void insertPlayerMatchPerformanceIntoDatabase(String str,PreparedStatement prep) throws Exception{
		String[] data = str.split(";");
		for(int i = 0 ;i < 18; i ++ ){
			prep.setString(3+i,data[i]);
		}
		prep.addBatch();
	}
}
