package dao.teamdetaildao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TeamDetailDaoJdbcImpV2 implements TeamDetailDao{

	Connection connection = null;
	String SEASON[] = {"20122013","20132014","20142015"};
	
	public TeamDetailDaoJdbcImpV2() {
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
	public String[] getTeamBasicInfo(String teamFullName) {
		String[] result = new String[9];
		Statement stat = null;
		ResultSet rs = null;
		String path = "";
		String currentSeason = SEASON[SEASON.length-1];
		try{
			stat = connection.createStatement();
			rs = stat.executeQuery("select AbsolutePath from Path where Category='Team'");
			path = rs.getString(1);
			rs = stat.executeQuery("select FullName,Sec,round(NumOfMatch*WinRate,0),round(NumOfMatch*(1-WinRate),0),round(1.0*Score/NumOfMatch,1),"
					+ "round(1.0*Rebounds/NumOfMatch,1),round(1.0*Assists/NumOfMatch,1),RivalScore,Abb"
					+ " from Team,    Team"+currentSeason+"Season     where Team.Abb = Team"+currentSeason+"Season.TeamAbb and FullName='"+teamFullName+"' ");
			for(int i = 0;i< 9;i++){
				result[i] = rs.getString(i+1);
			}
			result[8] = path+result[8]+".png";
			stat.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<String[]> getTeamSeasonAvgInfo(String teamFullName) {
		// TODO Auto-generated method stub
		Statement stat = null;
		ResultSet rs = null;
		ArrayList<String[]> result = new ArrayList<String[]>();
		try{
			stat = connection.createStatement();
			for(int i =0;i<SEASON.length;i++){
				rs = stat.executeQuery("select NumOfMatch,round(100.0*Shootings/Shots,1),"
						+ "round(100.0*ThreePointShootings/ThreePointShots,1),"
						+ "round(100.0*FreeThrowShootings/FreeThrowShots,1),"
						+ "round(1.0*OffensiveRebounds/NumOfMatch,1),"
						+ "round(1.0*DefensiveRebounds/NumOfMatch,1),round(1.0*Rebounds/NumOfMatch,1),round(1.0*Assists/NumOfMatch,1),"
						+ "round(1.0*Steals/NumOfMatch,1),round(1.0*BlockShots/NumOfMatch,1),round(1.0*TurnOvers/NumOfMatch,1),round(1.0*Fouls/NumOfMatch,1),round(1.0*Score/NumOfMatch,1) "
						+ "from Team,Team"+SEASON[i]+"Season "
						+ "where Team.Abb = Team"+SEASON[i]+"Season.TeamAbb and Team.FullName = '"+teamFullName+"'");
				if(rs.next()){
					String[] tempList = new String[14];
					tempList[0] = SEASON[i];
					for(int j = 1 ;j<14;j++){
						tempList[j] = rs.getString(j);
					}
					result.add(tempList);
				}
				stat.close();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<String[]> getTeamSeasonTotalInfo(String teamFullName) {
		Statement stat = null;
		ResultSet rs = null;
		ArrayList<String[]> result = new ArrayList<String[]>();
		try{
			stat = connection.createStatement();
			for(int i =0;i<SEASON.length;i++){
				rs = stat.executeQuery("select NumOfMatch,Shootings,Shots,ThreePointShootings,ThreePointShots,FreeThrowShootings,FreeThrowShots,"
						+ "OffensiveRebounds,DefensiveRebounds,Rebounds,Assists,Steals,BlockShots,TurnOvers,Fouls,Score "
						+ "from Team,Team"+SEASON[i]+"Season "
						+ "where Team.Abb = Team"+SEASON[i]+"Season.TeamAbb and Team.FullName = '"+teamFullName+"'");
				if(rs.next()){
					String[] tempList = new String[17];
					tempList[0] = SEASON[i];
					for(int j = 1 ;j<17;j++){
						tempList[j] = rs.getString(j);
					}
					result.add(tempList);
				}
				stat.close();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<String[]> getTeamPlayerInfo(String teamFullName) {
		// TODO Auto-generated method stub
		ArrayList<String[]> result = new ArrayList<String[]>();
		Statement stat = null;
		ResultSet rs = null;
		String currentSeason = SEASON[SEASON.length-1];
		try{
			stat = connection.createStatement();
			rs = stat.executeQuery("select PlayerName,NumOfMatch,NumOfStart,PresenceTime,ShootingPersentage,ThreePointPersentage,FreeThrowPersentage,"
					+ "OffensiveRebounds,DefensiveRebounds,round(1.0*Rebounds/NumOfMatch,1),round(1.0*Steals/NumOfMatch,1),"
					+ "round(1.0*BlockShots/NumOfMatch,1),round(1.0*Assists/NumOfMatch,1),Fouls,TurnOvers,round(1.0*Score/NumOfMatch,1) "
					+ "from Team,"
					+ "     Player"+currentSeason+"Season,"
					+ "     Player where Player.TeamAbb = Team.Abb and Player.Name = Player"+currentSeason+"Season.PlayerName and Team.FullName='"+teamFullName+"'");
			while(rs.next()){
				String[] tempList = new String[16];
				for(int i = 0 ;i<16;i++){
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
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("SQL错误");
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		TeamDetailDaoJdbcImpV2 t = new TeamDetailDaoJdbcImpV2();
		//t.getTeamSeasonAvgInfo("Sixers");
		t.getTeamPlayerInfo("Hawks");
	}
	
}
