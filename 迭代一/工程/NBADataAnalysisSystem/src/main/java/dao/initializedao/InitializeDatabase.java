package dao.initializedao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
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
		
		pathToDatabase(path);
		
		playerFileToDatabase(path+"/players/info/");
		
		teamFileToDatabase(path+"/teams/teams");
		
		matchFileToDatabase(path+"/matches");
		
		calculatePlayerInformation(path+"/matches/");
		
		calculateRivalInformation(path+"/matches/");
		
		calcualteAdvancedData();
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
				+ "?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,"
				+ "?)");
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
				+ "?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?)");
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

	//������Ա����������
	private void calculatePlayerInformation(String path) throws Exception{
		
		ArrayList<String[]> resultTemp = new ArrayList<String[]>();
		ArrayList<String> playerNameList = new ArrayList<String>();
		ArrayList<String> teamNameList = new ArrayList<String>();
		ArrayList<String[]> resultTeam = new ArrayList<String[]>();
		
		PreparedStatement prep = connection.prepareStatement("update players set offences = ?,defences = ?"
				+ ",rebounds = ? ,assists = ?,steals = ? ,block_shots = ? , turn_overs = ? ,fouls = ? ,"
				+ "score = ? ,num_of_match = ? , num_of_start = ? ,team = ? ,presence_time = ? ,"
				+ "shootings = ?, shots = ?,three_point_shootings = ?,three_point_shots = ?,free_throw_shootings = ?,"
				+ "free_throw_shots = ? where player_name = ? ;");
		
		PreparedStatement prepTeam = connection.prepareStatement("update teams set num_of_match = ?,presence_time = ?,"
				+ "shootings = ?,shots = ?,three_point_shootings = ?,three_point_shots = ?,free_throw_shootings = ?,"
				+ "free_throw_shots = ?, offences = ?,defences = ?, rebounds = ?,assists = ?,steals = ?,block_shots = ?,"
				+ "turn_overs = ?,fouls = ?,score = ? where abbreviation = ?; ");
		File[] fileList = new File(path).listFiles();
		BufferedReader br ;
		String strTemp;
		
		
		for(File file : fileList){
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));	
			strTemp = br.readLine();
			String[] teamScore = strTemp.split(";")[2].split("-");
			while(!isTeam(strTemp)){
				strTemp = br.readLine();
			}
			String team = strTemp;
			int numOfStartPlayer = 5;
			int teamIndex = 0;
			int numOfTeam = 0;
			while(strTemp != null){

				if(!isTeam(strTemp)){
					String[] oneRecord = strTemp.split(";");
					int index = playerNameList.indexOf(oneRecord[0]);
					//�������Ա�Ѿ�����
					if(index > 0 ){
						//�����ϳ�ʱ��
						String[] time = resultTemp.get(index)[2].split(":");
						
						if(oneRecord[2].equals("null") || oneRecord[2].equals("None")){
							oneRecord[2] = "0:0";
						}
						
						time[0] = "" + (Integer.parseInt(oneRecord[2].split(":")[0]) + Integer.parseInt(time[0])+
								 (Integer.parseInt(oneRecord[2].split(":")[1]) + Integer.parseInt(time[1]))/60);
						time[1] = "" + (Integer.parseInt(oneRecord[2].split(":")[1]) + Integer.parseInt(time[1]))%60;
						resultTemp.get(index)[2] = time[0] + ":" + time[1];
						
						//������ԱͶ����������Ͷ�������������������������ֳ������������������������������������������������������
						//����������������������������ñ����ʧ���������������ķ���
						for(int i = 3 ;i < oneRecord.length; i ++){
							if(resultTemp.get(index)[i].equals("null")){
								resultTemp.get(index)[i] = 0+"";
							}
							if(oneRecord[i].equals("null")){
								oneRecord[i] = 0 + "";
							}
							resultTemp.get(index)[i] = (Integer.parseInt(oneRecord[i])+
									Integer.parseInt(resultTemp.get(index)[i]))+"";
						}
						
						//�����ϳ������ȷ��������������
						resultTemp.get(index)[18] = (Integer.parseInt(resultTemp.get(index)[18])+1) + "";
						
						if(numOfStartPlayer > 0 ){
							resultTemp.get(index)[19] = (Integer.parseInt(resultTemp.get(index)[19])+1) + "";
							numOfStartPlayer--;
						}
						
					}
					//����Ա������
					else{
						
						playerNameList.add(oneRecord[0]);
						//resultTemp.add(oneRecord);
						String[] oneResult = new String[21];
						for(int i = 0 ;i < 18 ; i ++){
							oneResult[i] = oneRecord[i]; 
						}
						
						//������
						oneResult[18] = "1";
						//�ȷ�����
						if(numOfStartPlayer > 0){
							oneResult[19] = "1";
							numOfStartPlayer-- ;
						}
						else{
							oneResult[19] = "0";
						}
						
						//������ӵ���д
						oneResult[20] = team;
						resultTemp.add(oneResult);
					}
					
					//������Ա��Ϣ�������Ϣ
					if(oneRecord[2].equals("null") || oneRecord[2].equals("None")){
						
					}else{
						String[] teamPresenceTime = new String[2];
						teamPresenceTime[0] = (Integer.parseInt(resultTeam.get(teamIndex)[2].split(":")[0]) + 
								Integer.parseInt(oneRecord[2].split(":")[0])+(
								Integer.parseInt(resultTeam.get(teamIndex)[2].split(":")[1]) + 
								Integer.parseInt(oneRecord[2].split(":")[1]))/60) + "";
						teamPresenceTime[1] = (Integer.parseInt(resultTeam.get(teamIndex)[2].split(":")[1]) + 
								Integer.parseInt(oneRecord[2].split(":")[1]))%60 + "";
						resultTeam.get(teamIndex)[2] = teamPresenceTime[0] + ":" + teamPresenceTime[1];
					}
					
					
					for(int i = 3; i < 17;i ++){
						if(oneRecord[i].equals("null") || oneRecord[i].equals("None")){
							//do nothing
						}else{
							resultTeam.get(teamIndex)[i] = (Integer.parseInt(oneRecord[i])+Integer.parseInt(
									resultTeam.get(teamIndex)[i])) + "";
						}
					}
				}
				//��������
				else{
					teamIndex = teamNameList.indexOf(strTemp);
					//����в�����
					if(teamIndex < 0){
						teamNameList.add(strTemp);
						String[] oneTeamRecord = new String[18];
						oneTeamRecord[0] = strTemp;
						oneTeamRecord[1] = "1";
						oneTeamRecord[2] = "0:0";
						for(int i = 3 ;i < 17 ;i ++){
							oneTeamRecord[i] = "0";
						}
						oneTeamRecord[17] = teamScore[numOfTeam];
						numOfTeam ++;
						resultTeam.add(oneTeamRecord);
						teamIndex = teamNameList.indexOf(strTemp);
					}
					//����Ѿ�����
					else{
						resultTeam.get(teamIndex)[1] = (Integer.parseInt(resultTeam.get(teamIndex)[1]) +
								1) + "";
						resultTeam.get(teamIndex)[17] = (Integer.parseInt(resultTeam.get(teamIndex)[17]) +
								Integer.parseInt(teamScore[numOfTeam])) + "";
						numOfTeam ++;
					}
					team = strTemp;
					numOfStartPlayer = 5;
				}
				
				strTemp = br.readLine();
			}
			br.close();
		}
		
		
		for( int i = 0 ; i < resultTemp.size() ; i ++ ){
			prep.setString(1,resultTemp.get(i)[9]);
			prep.setString(2,resultTemp.get(i)[10]);
			prep.setString(3,resultTemp.get(i)[11]);
			prep.setString(4,resultTemp.get(i)[12]);
			prep.setString(5,resultTemp.get(i)[13]);
			prep.setString(6,resultTemp.get(i)[14]);
			prep.setString(7,resultTemp.get(i)[15]);
			prep.setString(8,resultTemp.get(i)[16]);
			prep.setString(9,resultTemp.get(i)[17]);
			prep.setString(10,resultTemp.get(i)[18]);
			prep.setString(11,resultTemp.get(i)[19]);
			prep.setString(12,resultTemp.get(i)[20]);
			resultTemp.get(i)[2] = (Integer.parseInt(resultTemp.get(i)[2].split(":")[0])*60 + 
					Integer.parseInt(resultTemp.get(i)[2].split(":")[1])) + "";
			prep.setString(13,resultTemp.get(i)[2]);
			prep.setString(14,resultTemp.get(i)[3]);
			prep.setString(15,resultTemp.get(i)[4]);
			prep.setString(16,resultTemp.get(i)[5]);
			prep.setString(17,resultTemp.get(i)[6]);
			prep.setString(18,resultTemp.get(i)[7]);
			prep.setString(19,resultTemp.get(i)[8]);
			prep.setString(20,resultTemp.get(i)[0]);
			prep.addBatch();
		}
		
		for(int i = 0 ;i < resultTeam.size(); i++ ){
			prepTeam.setString(1,resultTeam.get(i)[1]);
			resultTeam.get(i)[2] = (Integer.parseInt(resultTeam.get(i)[2].split(":")[0])*60 + 
					Integer.parseInt(resultTeam.get(i)[2].split(":")[1]))+"";
			prepTeam.setString(2,resultTeam.get(i)[2]);
			prepTeam.setString(3,resultTeam.get(i)[3]);
			prepTeam.setString(4,resultTeam.get(i)[4]);
			prepTeam.setString(5,resultTeam.get(i)[5]);
			prepTeam.setString(6,resultTeam.get(i)[6]);
			prepTeam.setString(7,resultTeam.get(i)[7]);
			prepTeam.setString(8,resultTeam.get(i)[8]);
			prepTeam.setString(9,resultTeam.get(i)[9]);
			prepTeam.setString(10,resultTeam.get(i)[10]);
			prepTeam.setString(11,resultTeam.get(i)[11]);
			prepTeam.setString(12,resultTeam.get(i)[12]);
			prepTeam.setString(13,resultTeam.get(i)[13]);
			prepTeam.setString(14,resultTeam.get(i)[14]);
			prepTeam.setString(15,resultTeam.get(i)[15]);
			prepTeam.setString(16,resultTeam.get(i)[16]);
			prepTeam.setString(17,resultTeam.get(i)[17]);
			prepTeam.setString(18,resultTeam.get(i)[0]);
			prepTeam.addBatch();
		}

		connection.setAutoCommit(false);
		prep.executeBatch();
		prepTeam.executeBatch();
		connection.setAutoCommit(true);
		
	}
	
	private void calculateRivalInformation(String path) throws Exception{
		ArrayList<String> rivalTeamList = new ArrayList<String>();
		ArrayList<String[]> rivalTeamInformation = new ArrayList<String[]>();
		File[] fileList = new File(path).listFiles();
		
		//ͳ�ƶ��ֵ��ڳ�ʱ�䣬Ͷ����������Ͷ�������������������������ֳ����������������������������������������������������������������������������������ñ����ʧ���������������÷�
		for(File file : fileList){
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
			String strTemp = br.readLine();
			String[] team = strTemp.split(";")[1].split("-");
			String[] score = strTemp.split(";")[2].split("-");
			int[] teamIndex = new int[2];
			for(int i = 0 ;i < 2;i ++ ){
				//������鲻����
				if(rivalTeamList.indexOf(team[i]) < 0){
					//����ǰ�������������ƺ�ʤ���������������ڳ�ʱ�䣬Ͷ����������������
					String [] originalRecord = new String[18];
					originalRecord[0] = team[i];
					originalRecord[1] = "0";
					if((Integer.parseInt(score[i])>(Integer.parseInt(score[1-i])))){
						originalRecord[1] = (Integer.parseInt(originalRecord[1])+1) + "";
					}
					originalRecord[2] = "0";
					for(int j = 3 ;j < 17 ;j++){
						originalRecord[j] = "0";
					}
					originalRecord[17] = score[1-i];
					rivalTeamList.add(team[i]);
					rivalTeamInformation.add(originalRecord);
					teamIndex[i] = rivalTeamList.indexOf(team[i]);
				}
				//�����Ӵ���
				else{
					teamIndex[i] = rivalTeamList.indexOf(team[i]);
					if((Integer.parseInt(score[i]) > (Integer.parseInt(score[1-i])))){
						rivalTeamInformation.get(teamIndex[i])[1] = (Integer.parseInt(rivalTeamInformation.get(teamIndex[i])[1]) + 1)
								+ "";
					}
					rivalTeamInformation.get(teamIndex[i])[17] = (Integer.parseInt(rivalTeamInformation.get(teamIndex[i])[17]) + 
							Integer.parseInt(score[1-i])) + "";

					}
			}
			br.readLine();
			
			while ((strTemp = br.readLine()) != null){
				//��ǰ���Ƕ������д
				int index = 0 ;
				if(isTeam(strTemp)){
					if(strTemp.equals(team[0]))
						index=0;
					else
						index=1;
				}
				//��ǰ������Ա����
				else{
					String[] oneRecord = strTemp.split(";");
					if(oneRecord[2].equals("None") ||
							(oneRecord[2].equals("null"))){
						//do nothing
					}else{
						
						rivalTeamInformation.get(teamIndex[1-index])[2] = 
								(Integer.parseInt(rivalTeamInformation.get(teamIndex[1-index])[2])+
								Integer.parseInt(oneRecord[2].split(":")[0])*60 + 
								Integer.parseInt(oneRecord[2].split(":")[1])) + "";
					}
					for(int i = 3 ;i < 17 ;i ++){
						if(oneRecord[i].equals("None") || 
								oneRecord[i].equals("null")){
							//do nothing
						}else{
							rivalTeamInformation.get(teamIndex[1-index])[i] = (
									Integer.parseInt(rivalTeamInformation.get(teamIndex[1-index])[i]) + 
									Integer.parseInt(oneRecord[i])) + "";
						}

					}
				}
			}//һ���ļ���ȡ���
			br.close();
		}//�����ļ���ȡ���
		
		PreparedStatement prep = connection.prepareStatement("update teams set "
				+ "num_of_win = ?,rival_presence_time =?,rival_shootings = ?,"
				+ "rival_shots = ?,rival_three_point_shootings = ?,rival_three_point_shots = ?,"
				+ "rival_free_throw_shootings = ?,rival_free_throw_shots = ?,rival_offences = ?,"
				+ "rival_defences = ?, rival_rebounds = ?,rival_assists =?,rival_steals =?,"
				+ "rival_block_shots = ?,rival_turn_overs = ?,rival_fouls = ?,rival_score =? "
				+ "where abbreviation = ?");
		
		for(int i = 0 ;i < rivalTeamInformation.size();i ++){
			for(int j = 1;j < 18;j ++){
				prep.setString(j,rivalTeamInformation.get(i)[j]);
			}
			prep.setString(18,rivalTeamInformation.get(i)[0]);
			prep.addBatch();
		}
		
		connection.setAutoCommit(false);
		prep.executeBatch();
		connection.setAutoCommit(true);

	}

    private void calcualteAdvancedData() throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("./src/main/java/dao/initializedao/advancedCalculate.txt")),"UTF-8"));
    	String sql="";
    	String str=br.readLine();
    	while(str != null){
    		sql+=str;
    		str=br.readLine();
    	}
    	
    	
    	Statement stat =connection.createStatement();
    	stat.executeUpdate(sql);
    	br.close();
    }
}
