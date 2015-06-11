package dao.teamdetaildao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.teamdao.TeamDao;

public class TeamDaoJdbcImpV2 implements TeamDao {
	Connection connection =null;
	
	public TeamDaoJdbcImpV2(){
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
	public ArrayList<String[]> getTeamSeasonTotalBasicInfo(String[] sift) {
		ArrayList<String[]> result = new ArrayList<String[]>();
		Statement stat = null;
		ResultSet rs = null;
		try{
			stat = connection.createStatement();
			rs = stat.executeQuery("select FullName,NumOfMatch,Shots,Shootings,ThreePointShots,ThreePointShootings,FreeThrowShootings,FreeThrowShots,OffensiveRebounds,"
					+ "DefensiveRebounds,Rebounds,Assists,Steals,BlockShots,TurnOvers,Fouls,Score from Team,         "
					+ "Team"+sift[0]+"Season       where Team.Abb = Team"+sift[0]+"Season.TeamAbb and (Team.Division like'"+sift[1]+"%' or Team.Sec like'"+sift[1]+"%')");
			while(rs.next()){
				String[] tempList = new String[17];
				for(int i=0;i<17;i++){
					tempList[i]=rs.getString(i+1);
				}
				result.add(tempList);
			}
			stat. close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<String[]> getTeamSeasonAvgBasicInfo(String[] sift) {
		ArrayList<String[]> result = new ArrayList<String[]>();
		Statement stat = null;
		ResultSet rs = null;
		try{
			stat = connection.createStatement();
			rs = stat.executeQuery("select FullName,NumOfMatch,round(1.0*Shots/NumOfMatch,1),round(1.0*Shootings/NumOfMatch,1),round(1.0*ThreePointShots/NumOfMatch,1),"
					+ "round(1.0*ThreePointShootings/NumOfMatch,1),round(1.0*FreeThrowShootings/NumOfMatch,1),round(1.0*FreeThrowShots/NumOfMatch,1),round(1.0*OffensiveRebounds/NumOfMatch,1),"
					+ "round(1.0*DefensiveRebounds/NumOfMatch,1),round(1.0*Rebounds/NumOfMatch,1),round(1.0*Assists/NumOfMatch,1),round(1.0*Steals/NumOfMatch,1),"
					+ "round(1.0*BlockShots/NumOfMatch,1),round(1.0*TurnOvers/NumOfMatch,1),round(1.0*Fouls/NumOfMatch,1),round(1.0*Score/NumOfMatch,1) from Team,         "
					+ "Team"+sift[0]+"Season       where Team.Abb = Team"+sift[0]+"Season.TeamAbb and (Team.Division like'"+sift[1]+"%' or Team.Sec like'"+sift[1]+"%')");
			while(rs.next()){
				String[] tempList = new String[17];
				for(int i=0;i<17;i++){
					tempList[i]=rs.getString(i+1);
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
	public ArrayList<String[]> getTeamSeasonRateInfo(String[] sift) {
		Statement stat = null;
		ResultSet rs = null;
		ArrayList<String[]> result = new ArrayList<String[]>();
		try{
			stat = connection.createStatement();
			rs = stat.executeQuery("select FullName,WinRate,ShootingPersentage,ThreePointPersentage,FreeThrowPersentage from Team,  "
					+ "Team"+sift[0]+"Season   where Team.Abb=Team"+sift[0]+"Season.TeamAbb and (Division like '"+sift[1]+"%' or Sec like '"+sift[1]+"%')   ");
			while(rs.next()){
				String[] tempList = new String[5];
				for(int i=0;i<5;i++){
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
	public ArrayList<String[]> getTeamSeasonEffInfo(String[] sift) {
		ArrayList<String[]> result = new ArrayList<String[]>();
		Statement stat = null;
		ResultSet rs = null;
		try{
			stat = connection.createStatement();
			rs = stat.executeQuery("select FullName,AttackRound,DefendRound,OffensiveEfficiency,DefensiveEfficiency,OffensiveReboundEfficiency,DefensiveReboundEfficiency,StealEfficiency,"
					+ "AssistEfficiency from Team,Team"+sift[0]+"Season where Team.Abb=Team"+sift[0]+"Season.TeamAbb and (Division like '"+sift[1]+"%' or Sec like '"+sift[1]+"%')");
			while (rs.next()){
				String[] tempList = new String[9];
				for(int i = 0;i< 9;i++){
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
	public ArrayList<String[]> getTeamList() {
		// TODO Auto-generated method stub
		ArrayList<String[]> result  = new ArrayList<String[]>();
		Statement stat = null;
		ResultSet rs =null;
		String path ="";
		try{
			stat = connection.createStatement();
			rs = stat.executeQuery("select AbsolutePath from Path where Category = 'Team'");
			path = rs.getString(1);
			rs = stat.executeQuery("select FullName,Abb from Team ");
			while (rs.next()){
				String[] tempList = new String[2];
				for(int i =0;i< 2;i++){
					tempList[i] = rs.getString(i+1);
				}
				tempList[1] =path+tempList[1]+".png";
				result.add(tempList);
			}
			stat.close();
		}catch (Exception e){
			e.printStackTrace();
		}
		show(result);
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

	public static void main(String[] args){
		TeamDaoJdbcImpV2 t = new TeamDaoJdbcImpV2();
		String[] sift = new String[2];
		sift[0] = "20132014";
		sift[1] = "Western";
		//t.getTeamSeasonTotalBasicInfo(sift);
		//t.getTeamSeasonAvgBasicInfo(sift);
		//t.getTeamSeasonEffInfo(sift);
		t.getTeamList();
	}
	
	
}
