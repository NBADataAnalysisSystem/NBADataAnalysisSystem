package dao.playerdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

public class PlayerDaoJdbcImpV2 implements PlayerDao {

	Connection connection = null;
	
	public PlayerDaoJdbcImpV2(){
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
	public ArrayList<String[]> getPlayerBasicInfo(String[] sift) {
		ArrayList<String[]> result = new ArrayList<String[]>();
		Statement stat = null;
		ResultSet rs = null;
		Calendar c = Calendar.getInstance();
		int currentYear = c.get(Calendar.YEAR);
		try{
			stat = connection.createStatement();
			rs = stat.executeQuery("select Name,Number,Pos,Height,Weight,Birthday,Birthday,Exp,School,TeamAbb "
					+ "from Player  "
					+ "where Name like '"+sift[0]+"%' and TeamAbb like '"+sift[1]+"%' and Pos like '"+sift[2]+"%'");
			while(rs.next()){
				String[] tempList = new String[10];
				for(int i =0;i<10;i++){
					tempList[i] = rs.getString(i+1);
				}
				tempList[6] = (currentYear - Integer.parseInt(tempList[6].split("-")[0]))+"";
				result.add(tempList);
			}
			stat.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<String[]> getPlayerSeasonTotalInfo(String[] sift) {
		ArrayList<String[]> result = new ArrayList<String[]> ();
		Statement stat = null;
		ResultSet rs = null;
		try{
			stat = connection.createStatement();
			rs = stat.executeQuery("select Name,TeamAbb,NumOfMatch,NumOfStart,Rebounds,Assists,PresenceTime,ShootingPersentage,ThreePointPersentage,"
					+ "FreeThrowPersentage,OffensiveRebounds,DefensiveRebounds,Steals,BlockShots,TurnOvers,Fouls,Score "
					+ "from Player"+sift[3]+"Season,"
					+ "     Player,     "
					+ "     Team "
					+ "where Player.Name=Player"+sift[3]+"Season.PlayerName and Team.Abb=Player.TeamAbb and (Division like '"+sift[0]+"%' or Sec like '"+sift[0]+"%') and Pos like '"+sift[1]+"%' "
					+ "order by "+sift[2]+" desc limit 50");
			while(rs.next()){
				String[] tempList = new String[17];
				for(int i = 0 ;i<17;i++){
					tempList[i] = rs.getString(i+1);
				}
				result.add(tempList);
			}
			stat.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<String[]> getPlayerSeasonAvgInfo(String[] sift) {
		Statement stat = null;
		ResultSet rs = null;
		ArrayList<String[]> result = new ArrayList<String[]>();
		try{
			stat = connection.createStatement();
			rs = stat.executeQuery("select Name,TeamAbb,NumOfMatch,NumOfStart,round(1.0*Rebounds/NumOfMatch,1),round(1.0*Assists/NumOfMatch,1),"
					+ "round(1.0*PresenceTime/NumOfMatch,1),Efficiency,ShootingPersentage,ThreePointPersentage,"
					+ "FreeThrowPersentage,round(1.0*OffensiveRebounds/NumOfMatch,1),round(1.0*DefensiveRebounds/NumOfMatch,1),"
					+ "round(1.0*Steals/NumOfMatch,1),round(1.0*BlockShots/NumOfMatch,1),round(1.0*TurnOvers/NumOfMatch,1),round(1.0*Fouls/NumOfMatch,1),"
					+ "round(1.0*Score/NumOfMatch,1) "
					+ "from Player"+sift[3]+"Season,"
					+ "     Player,     "
					+ "     Team "
					+ "where Player.Name=Player"+sift[3]+"Season.PlayerName and Team.Abb=Player.TeamAbb and (Division like '"+sift[0]+"%' or Sec like '"+sift[0]+"%') and Pos like '"+sift[1]+"%' "
					+ "order by "+sift[2]+" desc limit 50");
			while(rs.next()){
				String[] tempList = new String[18];
				for(int i = 0 ;i< 18;i++){
					tempList[i] = rs.getString(i+1);
				}
				result.add(tempList);
			}
			stat.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<String> getTeamList() {
		ArrayList<String> result = new ArrayList<String>();
		Statement stat = null;
		ResultSet rs = null;
		try{
			stat = connection.createStatement();
			rs = stat.executeQuery("select Abb from Team");
			while(rs.next()){
				result.add(rs.getString(1));
			}
			stat.close();
		}catch (Exception e){
			e.printStackTrace();
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
	
	public static void  main(String[] args) {
		//PlayerDaoJdbcImpV2 p = new PlayerDaoJdbcImpV2();
		//String[] sift = {"A","B",""};
		//p.getPlayerBasicInfo(sift);
		//String[] sift1 = {"","","Name","20142015"};
		//p.getPlayerSeasonTotalInfo(sift1);
		//String[] sift = {"","","Name","20142015"};
		//p.getPlayerSeasonAvgInfo(sift);
		//p.getTeamList();
	}
	
}
