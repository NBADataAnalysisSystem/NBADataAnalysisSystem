package dao.matchdetaildao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class MatchDetailDaoJdbcImp implements MatchDetailDao {

	private Connection connection;
	
	public MatchDetailDaoJdbcImp() {
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
	
	public ArrayList<String[]> getTeamMatchPerformance(String matchID){
		ArrayList<String[]> result = new ArrayList<String[]>();
		
		Statement stat = null;
		try {
			stat = connection.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("创建Statement错误！");
		}
		ResultSet rs = null;
		try {
			rs = stat.executeQuery("select pmp.player_name,pmp.player_position,"
					+ "round(1.0*pmp.presence_time/60,1),round(1.0*pmp.shootings/pmp.shots,1),"
					+ "pmp.shootings,pmp.shots,round(1.0*pmp.three_point_shootings/pmp.three_point_shots),"
					+ "pmp.three_point_shootings,pmp.three_point_shots,round(1.0*pmp.free_throw_shootings/pmp.free_throw_shots,1),"
					+ "pmp.free_throw_shootings,pmp.free_throw_shots,pmp.offensive_rebounds,pmp.defensive_rebounds,pmp.rebounds,"
					+ "pmp.assists,pmp.fouls,pmp.steals,pmp.turn_overs,pmp.block_shots,pmp.score,pa.path||'teams/'||t.abbreviation||'.png' "
					+ "from player_match_performance pmp,matches m,teams t,paths pa "
					+ "where m.id=pmp.match_id and t.id=pmp.team_id and pmp.team_id =m.home_court_team_id and "
					+ "pmp.match_id='"+matchID+"' ");
			
			
			while(rs.next()){
				String[] strList = new String[22];
				for(int i = 0;i< 22;i++){
					strList[i]=rs.getString(i+1);
				}
				result.add(strList);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("执行Statement 错误！");
		}
		
		for(int  i = 0 ;i < result.size();i ++){
			for(int j = 0 ;j < 22;j ++){
				System.out.print(result.get(i)[j]+" ");
			}
			System.out.println();
			
		}
		return result;
	}

	public ArrayList<String[]> getTeamMatchPerformanceV2(String MatchID){
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
	
	public ArrayList<String[]> getRivalTeamMatchPerformance(String matchID){
		ArrayList<String[]> result = new ArrayList<String[]>();
		
		Statement stat = null;
		try {
			stat = connection.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("创建Statement错误！");
		}
		ResultSet rs = null;
		try {
			rs = stat.executeQuery("select pmp.player_name,pmp.player_position,"
					+ "round(1.0*pmp.presence_time/60,1),round(1.0*pmp.shootings/pmp.shots,1),"
					+ "pmp.shootings,pmp.shots,round(1.0*pmp.three_point_shootings/pmp.three_point_shots),"
					+ "pmp.three_point_shootings,pmp.three_point_shots,round(1.0*pmp.free_throw_shootings/pmp.free_throw_shots,1),"
					+ "pmp.free_throw_shootings,pmp.free_throw_shots,pmp.offensive_rebounds,pmp.defensive_rebounds,pmp.rebounds,"
					+ "pmp.assists,pmp.fouls,pmp.steals,pmp.turn_overs,pmp.block_shots,pmp.score,pa.path||'teams/'||t.abbreviation||'.png' "
					+ "from player_match_performance pmp,matches m,teams t,paths pa "
					+ "where m.id=pmp.match_id and t.id=pmp.team_id and pmp.team_id =m.away_team_id and "
					+ "pmp.match_id='"+matchID+"' ");
			
			
			while(rs.next()){
				String[] strList = new String[22];
				for(int i = 0;i< 22;i++){
					strList[i]=rs.getString(i+1);
				}
				result.add(strList);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("执行Statement 错误！");
		}
		
		for(int  i = 0 ;i < result.size();i ++){
			for(int j = 0 ;j < 22;j ++){
				System.out.print(result.get(i)[j]+" ");
			}
			System.out.println();
			
		}
		return result;
	}
	
	public ArrayList<String[]> getRivalTeamMatchPerformanceV2(String MatchID){
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
	
	private void show(ArrayList<String[]> list){
		if(list.size()==0){
			System.out.println("ArrayList为空");
		}else{
			int length =list.get(0).length;
			for(int i =0;i<list.size();i++){
				for(int j=0;j<length;j++){
					System.out.print(list.get(i)[j]+" ");
				}
				System.out.println();
			}
		}
	
	}
	
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("SQL错误");
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args){
		MatchDetailDaoJdbcImp t = new MatchDetailDaoJdbcImp();
		String[] strList = new String[2];
		t.getTeamMatchPerformanceV2("0011300001");
		//strList[0] ="13-14";
		//strList[1] = "round(1.0*sum(pmp.shootings)/count(distinct pmp.match_id),1)";
		//t.getRivalTeamMatchPerformance("17");
	}
}
