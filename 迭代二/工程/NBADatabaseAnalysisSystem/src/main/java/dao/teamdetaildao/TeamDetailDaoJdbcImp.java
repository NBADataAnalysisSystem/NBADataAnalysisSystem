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
		t.getTeamBasicInfo("Nets");
	}

}
