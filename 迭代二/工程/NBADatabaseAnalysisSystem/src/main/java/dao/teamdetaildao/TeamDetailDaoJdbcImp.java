package dao.teamdetaildao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.matchdetaildao.MatchDetailDaoJdbcImp;

public class TeamDetailDaoJdbcImp {
	
	private Connection connection;
	
	public TeamDetailDaoJdbcImp() {
    	try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:NBADatabase.db");
		} catch (ClassNotFoundException e) {
			System.out.println("没有找到sqlite jdbc");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL错误");
			e.printStackTrace();
		}
    }
	
	public String[] getTeamBasicInfo(String teamFullName){
		String[] result = new String[9];
		
		Statement stat = null;
		try {
			stat = connection.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("创建Statement错误！");
		}
		ResultSet rs = null;
		try {
			result[0] = teamFullName;
			rs = stat.executeQuery("select t.section,sum(pmp.score) "
					+ "from   teams t,player_match_performance pmp, matches m "
					+ "where t.id<>pmp.team_id and (t.id=m.home_court_team_id or t.id = m.away_team_id) and m.id = pmp.match_id  and "
					+ "t.full_name='"+teamFullName+"'");
			result[1] = rs.getString(1);
			result[7] = rs.getString(2);
			
			rs = stat.executeQuery("select count(m.id) "
					+ "from matches m,teams t where t.id=m.home_court_team_id and m.hscore>m.ascore and "
					+ "t.full_name='"+teamFullName+"'");
			result[2] = rs.getString(1);
			rs = stat.executeQuery("select count(m.id) "
					+ "from matches m,teams t where t.id=m.away_team_id and m.hscore<m.ascore and "
					+ "t.full_name='"+teamFullName+"'");
			result[2]=Integer.parseInt(result[2])+rs.getInt(1)+"";
			rs = stat.executeQuery("select count(distinct m.id) from teams t,matches m "
					+ "where (t.id=m.home_court_team_id or t.id=m.away_team_id) and "
					+ "t.full_name='"+teamFullName+"'");
			result[3] = rs.getInt(1)-Integer.parseInt(result[2])+"";
			rs = stat.executeQuery("select round(1.0*sum(pmp.score)/count(distinct m.id),1),"
					+ "round(1.0*sum(pmp.rebounds)/count(distinct m.id),1),round(1.0*sum(pmp.assists)/count(distinct m.id),1) "
					+ "from   teams t,player_match_performance pmp, matches m "
					+ "where t.id=pmp.team_id and (t.id=m.home_court_team_id or t.id = m.away_team_id) and m.id = pmp.match_id and "
					+ "t.full_name='"+teamFullName+"'");
			for(int i = 0 ;i< 3;i++){
				result[i+4]=rs.getString(i+1);
			}
			rs = stat.executeQuery("select pa.path from paths pa");
			result[8]=rs.getString(1);
			result[8]=result[8]+"teams/"+teamFullName+".png";
		}catch (Exception e){
			e.printStackTrace();
		}
		

			for(int j = 0 ;j < 9;j ++){
				System.out.print(result[j]+" ");
			}
	
		return result;
	}
	
	public ArrayList<String[]> getTeamSeasonAvgInfo(String teamFullName){
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
			rs = stat.executeQuery("select distinct m.season from matches m");
			while (rs.next()){
				String[] strList = new String[14];
				strList[0] = rs.getString(1);
				result.add(strList);
			}
			for(int i =0;i<result.size();i++){
			rs = stat.executeQuery("select count(distinct match_id),"
					+ "round(1.0*sum(pmp.shootings)/sum(pmp.shots),1),"
					+ "round(1.0*sum(pmp.three_point_shootings)/sum(pmp.three_point_shots),1),"
					+ "round(1.0*sum(pmp.free_throw_shootings)/sum(pmp.free_throw_shots),1),"
					+ "round(1.0*sum(pmp.offensive_rebounds)/count(distinct match_id),1),"
					+ "round(1.0*sum(pmp.defensive_rebounds)/count(distinct match_id),1)"
					+ ",round(1.0*sum(pmp.rebounds)/count(distinct match_id),1),"
					+ "round(1.0*sum(pmp.assists)/count(distinct match_id),1),round(1.0*sum(pmp.steals)/count(distinct match_id),1),"
					+ "round(1.0*sum(pmp.block_shots)/count(distinct match_id),1),round(1.0*sum(pmp.turn_overs)/count(distinct match_id),1),"
					+ "round(1.0*sum(pmp.fouls)/count(distinct match_id),1),round(1.0*sum(pmp.score)/count(distinct match_id),1) "
					+ "from matches m,player_match_performance pmp,teams t where m.id=pmp.match_id and "
					+ "pmp.team_id =t.id and "
					+ "t.full_name='"+teamFullName+"' and  m.season ='"+result.get(i)[0]+"'");
			for(int j=1;j<14;j++){
				result.get(i)[j]=rs.getString(j);
			}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<result.size();i++){
			for(int j=0;j<14;j++){
				System.out.print(result.get(i)[j]+" ");
			}
			System.out.println();
		}
		return result;
	}

	
	public ArrayList<String[]> getTeamSeasonTotalInfo(String teamFullName){
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
			rs = stat.executeQuery("select distinct m.season from matches m");
			while (rs.next()){
				String[] strList = new String[17];
				strList[0] = rs.getString(1);
				result.add(strList);
			}
			for(int i =0;i<result.size();i++){
			rs = stat.executeQuery("select count(distinct match_id),sum(pmp.shootings),"
					+ "sum(pmp.shots),sum(pmp.three_point_shootings),sum(pmp.three_point_shots),"
					+ "sum(pmp.free_throw_shootings),sum(pmp.free_throw_shots),sum(pmp.offensive_rebounds),"
					+ "sum(pmp.defensive_rebounds),sum(pmp.rebounds),sum(pmp.assists),sum(pmp.steals),"
					+ "sum(pmp.block_shots),sum(pmp.turn_overs),sum(pmp.fouls),sum(pmp.score) from matches m,player_match_performance pmp,"
					+ "teams t where m.id=pmp.match_id and pmp.team_id =t.id and "
					+ "t.full_name='"+teamFullName+"' and  m.season ='"+result.get(i)[0]+"'");
			for(int j=1;j<17;j++){
				result.get(i)[j]=rs.getString(j);
			}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<result.size();i++){
			for(int j=0;j<17;j++){
				System.out.print(result.get(i)[j]+" ");
			}
			System.out.println();
		}
		
		return result;
	}

	public ArrayList<String[]> getTeamPlayerInfo(String teamFullName){
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
			rs = stat.executeQuery("select p.player_name,count(distinct pmp.match_id),sum(pmp.is_start),"
					+ "round(1.0*sum(pmp.presence_time)/60,1),round(1.0*sum(pmp.shootings)/sum(pmp.shots),1),"
					+ "round(1.0*sum(pmp.three_point_shootings)/sum(pmp.three_point_shots),1),round(1.0*sum(pmp.free_throw_shootings)/sum(pmp.free_throw_shots),1)"
					+ ",sum(pmp.offensive_rebounds),sum(pmp.defensive_rebounds),sum(pmp.rebounds),round(1.0*sum(pmp.steals)/count(distinct pmp.match_id),1),"
					+ "round(1.0*sum(pmp.block_shots)/count(distinct pmp.match_id),1),sum(pmp.assists),sum(pmp.fouls),sum(pmp.turn_overs),"
					+ "round(1.0*sum(pmp.score)/count(distinct pmp.match_id),1) from player_match_performance pmp,teams t,players p "
					+ "where pmp.player_id=p.id and pmp.team_id =t.id and "
					+ "t.full_name='"+teamFullName+"' group by p.id");
			
			while(rs.next()){
				String[] strList = new String[16];
				for(int i = 0 ;i< 16;i++){
					strList[i]=rs.getString(i+1);
				}
				result.add(strList);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<result.size();i++){
			for(int j=0;j<16;j++){
				System.out.print(result.get(i)[j]+" ");
			}
			System.out.println();
		}
		
		return result;
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
		TeamDetailDaoJdbcImp t = new TeamDetailDaoJdbcImp();
		String[] strList = new String[2];
		strList[0] ="13-14";
		strList[1] = "round(1.0*sum(pmp.shootings)/count(distinct pmp.match_id),1)";
		t.getTeamPlayerInfo("Nets");
	}

}
