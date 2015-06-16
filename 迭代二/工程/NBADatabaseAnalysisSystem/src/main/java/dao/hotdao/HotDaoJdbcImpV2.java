package dao.hotdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class HotDaoJdbcImpV2 implements HotDao {

	Connection connection = null;
	
	public HotDaoJdbcImpV2(){
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:Database.db");
		} catch (ClassNotFoundException e) {
			System.out.println("没有找到sqlite jdbc");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL错误");
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<String[]> getCurrentKingPlayerInfo(String sift) {
		Statement stat = null;
		ResultSet rs = null;
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		String date = s.format(c.getTime());
		String currentSeason = "20142015";
		ArrayList<String[]> result = new ArrayList<String[]>();
		String playerPath = "";
		String teamPath = "";
		try{
			stat = connection.createStatement();
			
			rs = stat.executeQuery("select AbsolutePath from Path where category ='Player'");
			playerPath = rs.getString(1);
			rs = stat.executeQuery("select AbsolutePath from Path where category ='Team'");
			teamPath = rs.getString(1);
			
			do{
				rs = stat.executeQuery("select PlayerName,"+sift+",TeamAbb,PlayerName,TeamAbb from PlayerMatch"+currentSeason+"Season T1,Match"+currentSeason+"Season T2 where "
						+ "T1.MatchID=T2.MatchID and "
						+ "DateOfMatch = '"+date+"' order by "+sift+" desc limit 5;");
				c.add(Calendar.DAY_OF_MONTH, -1);
				date = s.format(c.getTime());
			}while (!rs.next());
			
			do{
				String[] tempList = new String[5];
				for(int i = 0;i<5;i++){
					tempList[i] = rs.getString(i+1);
				}
				tempList[3] = playerPath + tempList[3] + ".png";
				tempList[4] = teamPath + tempList[4] + ".png";
				result.add(tempList);
			}while(rs.next());
			
		}catch(Exception e){
			e.printStackTrace();
		}
		for(int i=0;i<result.size();i++){
			System.out.println(Arrays.asList(result.get(i)));
		}
		return result;
	}

	@Override
	public ArrayList<String[]> getSeasonHotPlayerInfo(String sift) {
		Statement stat = null;
		ResultSet rs = null;
		String currentSeason = "20142015";
		ArrayList<String[]> result = new ArrayList<String[]>();
		String playerPath = "";
		String teamPath = "";
		try{
			stat = connection.createStatement();
			rs = stat.executeQuery("select AbsolutePath from Path where category ='Player'");
			playerPath = rs.getString(1);
			rs = stat.executeQuery("select AbsolutePath from Path where category ='Team'");
			teamPath = rs.getString(1);
			rs = stat.executeQuery("select PlayerName,"+sift+",TeamAbb,PlayerName,TeamAbb from Player"+currentSeason+"Season T1,Player T2 where T1.PlayerName=T2.Name  order by "+sift+" desc limit 5");
			while(rs.next()){
				String[] tempList = new String[5];
				for(int i =0;i<5;i++){
					tempList[i] = rs.getString(i+1);
				}
				tempList[3] = playerPath + tempList[3] + ".png";
				tempList[4] = teamPath + tempList[4] + ".png";
				result.add(tempList);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		for(int i=0;i<result.size();i++){
			System.out.println(Arrays.asList(result.get(i)));
		}
		return result;
	}

	@Override
	public ArrayList<String[]> getSeasonHotTeamInfo(String sift) {
		Statement stat = null;
		ResultSet rs = null;
		String currentSeason = "20142015";
		ArrayList<String[]> result = new ArrayList<String[]>();
		String teamPath = "";
		try{
			stat = connection.createStatement();
			rs = stat.executeQuery("select AbsolutePath from Path where category ='Team'");
			teamPath = rs.getString(1);
			rs = stat.executeQuery("select TeamAbb,"+sift+",TeamAbb from Team"+currentSeason+"Season order by "+sift+" desc limit 5");
			while(rs.next()){
				String[] tempList = new String[3];
				for(int i =0;i<3;i++){
					tempList[i] = rs.getString(i+1);
				}
				tempList[2] = teamPath + tempList[2] + ".png";
				result.add(tempList);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		for(int i=0;i<result.size();i++){
			System.out.println(Arrays.asList(result.get(i)));
		}
		return result;
	}

	@Override
	public ArrayList<String[]> getSeasonHotPlayer(String sift) {
		// TODO Auto-generated method stub
		Statement stat = null;
		ResultSet rs = null;
		String currentSeason = "20142015";
		ArrayList<String[]> result = new ArrayList<String[]>();
		String playerPath = "";
		String teamPath = "";
		try{
			stat = connection.createStatement();
			rs = stat.executeQuery("select AbsolutePath from Path where category ='Player'");
			playerPath = rs.getString(1);
			rs = stat.executeQuery("select AbsolutePath from Path where category ='Team'");
			teamPath = rs.getString(1);
			rs = stat.executeQuery("select PlayerName,"+sift+",TeamAbb,PlayerName,TeamAbb from LiftRate T1,Player T2 where T1.PlayerName=T2.Name  order by "+sift+" desc limit 5");
			while(rs.next()){
				String[] tempList = new String[5];
				for(int i =0;i<5;i++){
					tempList[i] = rs.getString(i+1);
				}
				tempList[3] = playerPath + tempList[3] + ".png";
				tempList[4] = teamPath + tempList[4] + ".png";
				result.add(tempList);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		for(int i=0;i<result.size();i++){
			System.out.println(Arrays.asList(result.get(i)));
		}
		return result;
	}

	
	@Override

	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("SQL错误");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		HotDaoJdbcImpV2 h = new HotDaoJdbcImpV2();
		//h.getCurrentKingPlayerInfo(null);
		//h.getCurrentKingPlayerInfo("PresenceTime");
		//h.getSeasonHotPlayerInfo("Score");
		//h.getSeasonHotTeamInfo("Shootings");
		h.getSeasonHotPlayer("Score");
	}

	
}
