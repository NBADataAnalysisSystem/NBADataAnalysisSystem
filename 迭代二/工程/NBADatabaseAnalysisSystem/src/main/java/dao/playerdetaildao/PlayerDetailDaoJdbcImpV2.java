package dao.playerdetaildao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PlayerDetailDaoJdbcImpV2 implements PlayerDetailDao{
	
	private Connection connection = null;
	private String[] SEASON = {"20122013","20132014","20142015"};

	public PlayerDetailDaoJdbcImpV2() {
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/cross/Documents/GitHub/NBADataCollector/Database.db");
		} catch (ClassNotFoundException e) {
			System.out.println("没有找到sqlite jdbc");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL错误");
			e.printStackTrace();
		}
	}

	@Override
	public String[][] getPlayerSeasonInfo(String playerName) {
		// TODO Auto-generated method stub
		String[][] result = new String[2][17];
		Statement stat = null;
		ResultSet rs = null;
		String currentSeason = SEASON[SEASON.length-1];
		result[0][0] = currentSeason;
		result[1][0] = currentSeason;
		
		try{
			stat  = connection.createStatement();
			rs = stat.executeQuery("select TeamAbb,NumOfMatch,NumOfStart,PresenceTime,ShootingPersentage,ThreePointPersentage,FreeThrowPersentage,OffensiveRebounds,"
					+ "DefensiveRebounds,Rebounds,Assists,Steals,BlockShots,TurnOvers,Fouls,Score "
					+ "from Player"+currentSeason+"Season,"
					+ "     Player "
					+ "where Player"+currentSeason+"Season.PlayerName = Player.Name and Player.Name='"+playerName+"';");
			for(int i =1;i<17;i++){
				result[0][i] = rs.getString(i);
			}
			rs =stat.executeQuery("select TeamAbb,NumOfMatch,NumOfStart,round(1.0*PresenceTime/NumOfMatch,1),round(1.0*ShootingPersentage/NumOfMatch,1),"
					+ "round(1.0*ThreePointPersentage/NumOfMatch,1),round(1.0*FreeThrowPersentage/NumOfMatch,1),round(1.0*OffensiveRebounds/NumOfMatch,1),"
					+ "round(1.0*DefensiveRebounds/NumOfMatch,1),round(1.0*Rebounds/NumOfMatch,1),round(1.0*Assists/NumOfMatch,1),round(1.0*Steals/NumOfMatch,1),"
					+ "round(1.0*BlockShots/NumOfMatch,1),round(1.0*TurnOvers/NumOfMatch,1),round(1.0*Fouls/NumOfMatch,1),round(1.0*Score/NumOfMatch,1) "
					+ "from Player"+currentSeason+"Season,"
					+ "     Player "
					+ "where Player"+currentSeason+"Season.PlayerName = Player.Name and Player.Name='"+playerName+"';");
			for(int i =1;i<17;i++){
				result[1][i] = rs.getString(i);
			}
			stat.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String[][] getPlayerLatestFiveMatchInfo(String playerName) {
		String [][] result = new String[5][21];
		Statement stat = null;
		ResultSet rs = null;
		String currentSeason = SEASON[SEASON.length-1];
		try{
			stat = connection.createStatement();
			rs = stat.executeQuery("select DateOfMatch,TeamAbb,PresenceTime,round(1.0*Shootings/Shots,1),Shootings,Shots,"
					+ "round(1.0*ThreePointShootings/ThreePointShots,1),ThreePointShootings,ThreePointShots,round(1.0*FreeThrowShootings/FreeThrowShots,1),"
					+ "FreeThrowShootings,FreeThrowShots,OffensiveRebounds,DefensiveRebounds,Rebounds,Assists,Fouls,Steals,TurnOvers,BlockShots,Score "
					+ "from PlayerMatch"+currentSeason+"Season,"
					+ "     Match"+currentSeason+"Season        "
					+ "where  PlayerMatch"+currentSeason+"Season.MatchID = Match"+currentSeason+"Season.MatchID and PlayerName='"+playerName+"' "
					+ "order by DateOfMatch desc "
					+ "limit 5;");
			int col=0;
			while(rs.next()){
				for(int i =0;i<21;i++){
					result[col][i] = rs.getString(i+1);
				}
				col++;
			}
			stat.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String[] getPlayerBasicInfo(String playerName) {
		String[] result = new String[11];
		Statement stat = null;
		ResultSet rs = null;
		String teamPath = "";
		String playerPath = "";
		try{
			stat = connection.createStatement();
			rs = stat.executeQuery("select AbsolutePath from Path where category = 'Team'");
			teamPath = rs.getString(1);
			rs = stat.executeQuery("select AbsolutePath from Path where category = 'Player'");
			playerPath = rs.getString(1);
			rs = stat.executeQuery("select Number,Name,TeamAbb,Pos,Height,Weight,Birthday,Exp,School,Name,TeamAbb "
					+ "from Player "
					+ "where Name = '"+playerName+"'");
			while(rs.next()){
				for(int i = 0;i < 11;i++){
					result[i]=rs.getString(i+1);				}
			}
			result[9] = playerPath+result[9]+".png";
			result[10] = teamPath+result[10]+".png";
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

	public static void main(String [] args){
		PlayerDetailDaoJdbcImpV2 p = new PlayerDetailDaoJdbcImpV2();
		//p.getPlayerBasicInfo("Lavoy Allen");
		//p.getPlayerLatestFiveMatchInfo("Quincy Acy");
		p.getPlayerSeasonInfo("Quincy Acy");
	}
	
}
