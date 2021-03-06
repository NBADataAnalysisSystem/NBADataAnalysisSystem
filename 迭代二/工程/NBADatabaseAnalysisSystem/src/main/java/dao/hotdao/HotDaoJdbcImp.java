package dao.hotdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HotDaoJdbcImp implements HotDao {
	
	private Connection connection;
	
	public HotDaoJdbcImp() {
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
	
	public  ArrayList<String[]> getCurrentKingPlayerInfo(String sift){
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
			rs = stat.executeQuery("select p.player_name,pmp."+sift+",t.full_name,pa.path||'players/portrait/'||p.player_name||'.png', "+
																"pa.path||'teams/'||t.abbreviation||'.png'"+
																" from player_match_performance pmp, "+
																"players p, "+
																"teams t , "+     
																"paths pa, "+
																"(select m.id mid,m.date_of_match "+
																	"from matches m, "+
																						"(select max(date_of_match) d "+
																									"from matches) as t1 "+    
																	"where m.date_of_match=t1.d) as t2 "+
														"where t2.mid=pmp.match_id and p.id = pmp.player_id and t.id = pmp.team_id "+
														"group by player_id "+
														"order by pmp." +sift+" desc");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("执行Statement 错误！");
		}
		int i = 0;
		try {
			while (rs.next() && i<5){
				String[] str = new String[5];
				for(int j = 0;j < 5;j ++){
					str[j] = rs.getString(j+1);
				}
				result.add(str);
				i ++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for( i = 0 ;i < result.size();i ++){
			for(int j = 0 ;j < 5;j ++){
				System.out.print(result.get(i)[j]+" ");
			}
			System.out.println();
			
		}
		return result;
	}
	
	public ArrayList<String[]> getSeasonHotPlayerInfo(String sift){
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
			rs = stat.executeQuery("select pmp.player_name,"+sift+",t.full_name,pa.path||'players/portrait/'||pmp.player_name||'.png', "+
																"pa.path||'teams/'||t.abbreviation||'.png' "+
													"from matches m, "+
																"teams t, " +    
																"paths pa, "+
																"player_match_performance pmp, "+     
																"(select max(season) ms "+
																"from matches) t1, "+
																"(select pmp.player_id pid ,pmp.team_id ptid "+
																"from player_match_performance pmp, "+
																"matches m "+    
																"where m.id =pmp.match_id and pmp.player_id<>-1 "+
																"group by pmp.player_id "+ 
																"having m.season =max(m.season) and m.date_of_match =max(m.date_of_match)) as t2 "+
													"where m.id=pmp.match_id and m.season = t1.ms and pmp.player_id<>-1 and t2.pid=pmp.player_id and t.id = t2.ptid "+
													"group by pmp.player_id "+
													"order by "+sift+" desc;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("执行Statement 错误！");
		}
		int i = 0;
		try {
			while (rs.next() && i<5){
				String[] str = new String[5];
				for(int j = 0;j < 5;j ++){
					str[j] = rs.getString(j+1);
				}
				result.add(str);
				i ++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for( i = 0 ;i < result.size();i ++){
			for(int j = 0 ;j < 5;j ++){
				System.out.print(result.get(i)[j]+" ");
			}
			System.out.println();
			
		}
		return result;
	}
	

	public ArrayList<String[]> getSeasonHotTeamInfo (String sift){
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
			rs = stat.executeQuery("select t.full_name,"+sift+",pa.path||'teams/'||t.abbreviation||'.png' "+
													"from teams t, "+
																"player_match_performance pmp, "+ 
																"paths pa "+   
													"where pmp.team_id = t.id "+
													"group by t.id	"+
													"order by "+sift+" desc");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("执行Statement 错误！");
		}
		int i = 0;
		try {
			while (rs.next() && i<5){
				String[] str = new String[3];
				for(int j = 0;j < 3;j ++){
					str[j] = rs.getString(j+1);
				}
				result.add(str);
				i ++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for( i = 0 ;i < result.size();i ++){
			for(int j = 0 ;j < 3;j ++){
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
		HotDaoJdbcImp t = new HotDaoJdbcImp();
		String[] strList = new String[2];
		strList[0] ="13-14";
		strList[1] = "round(1.0*sum(pmp.shootings)/count(distinct pmp.match_id),1)";
		t.getCurrentKingPlayerInfo("steals");
	}

	@Override
	public ArrayList<String[]> getSeasonHotPlayer(String sift) {
		// TODO Auto-generated method stub
		return null;
	}

}
