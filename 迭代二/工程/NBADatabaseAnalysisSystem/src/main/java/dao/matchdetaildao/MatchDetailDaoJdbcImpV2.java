package dao.matchdetaildao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MatchDetailDaoJdbcImpV2 implements MatchDetailDao {

	Connection connection = null;
	
	public MatchDetailDaoJdbcImpV2() {
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
	public ArrayList<String[]> getTeamMatchPerformance(String MatchID) {
		String path="";
		String season  =getSeasonFromMatchID(MatchID);
		ArrayList<String[]> result = new ArrayList<String[]>();
		Statement stat = null;
		ResultSet rs = null;
		try{
			stat=connection.createStatement();
			rs=stat.executeQuery("select AbsolutePath from Path where category='Team'");
			path=rs.getString(1);
			rs=stat.executeQuery("select PlayerName,Pos,PresenceTime,round(100.0*Shootings/Shots,1),Shootings,"
					+ "Shots,round(100.0*ThreePointShootings/ThreePointShots,1),ThreePointShootings,ThreePointShots,"
					+ "round(100.0*FreeThrowShootings/FreeThrowShots,1),FreeThrowShootings,FreeThrowShots,OffensiveRebounds,"
					+ "DefensiveRebounds,Rebounds,Assists,Fouls,Steals,TurnOvers,BlockShots,Score,TeamAbb  "
					+ "from PlayerMatch"+season+"Season where MatchID='"+MatchID+"' and TeamAbb in "
					+ "(select HomeCourtTeamAbb from Match"+season+"Season where MatchID='"+MatchID+"'); ");
			while(rs.next()){
				String[] tempList=new String[22];
				for(int i = 0;i<22;i++){
					tempList[i] = rs.getString(i+1);
				}
				tempList[21]=path+tempList[21]+".png";
				result.add(tempList);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	private String getSeasonFromMatchID(String MatchID){
		String season=MatchID.substring(3,5);
		season = "20"+season;
		season = season+((Integer.parseInt(season)+1)+"");
		return season;
	}
	
	@Override
	public ArrayList<String[]> getRivalTeamMatchPerformance(String MatchID) {
		String path="";
		String season  =getSeasonFromMatchID(MatchID);
		ArrayList<String[]> result = new ArrayList<String[]>();
		Statement stat = null;
		ResultSet rs = null;
		try{
			stat=connection.createStatement();
			rs=stat.executeQuery("select AbsolutePath from Path where category = 'Team'");
			path=rs.getString(1);
			rs=stat.executeQuery("select PlayerName,Pos,PresenceTime,round(100.0*Shootings/Shots,1),Shootings,"
					+ "Shots,round(100.0*ThreePointShootings/ThreePointShots,1),ThreePointShootings,ThreePointShots,"
					+ "round(100.0*FreeThrowShootings/FreeThrowShots,1),FreeThrowShootings,FreeThrowShots,OffensiveRebounds,"
					+ "DefensiveRebounds,Rebounds,Assists,Fouls,Steals,TurnOvers,BlockShots,Score,TeamAbb "
					+ "from PlayerMatch"+season+"Season where MatchID='"+MatchID+"' and TeamAbb in "
					+ "(select AwayTeamAbb from Match"+season+"Season where MatchID='"+MatchID+"'); ");
			while(rs.next()){
				String[] tempList=new String[22];
				for(int i = 0;i<22;i++){
					tempList[i] = rs.getString(i+1);
				}
				tempList[21]=path+tempList[21]+".png";
				result.add(tempList);
			}
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

}
