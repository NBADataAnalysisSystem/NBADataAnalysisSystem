package dao.teamdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TeamDaoJdbcImp implements TeamDao {
	
	private Connection connection;
	
	public TeamDaoJdbcImp() {
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
	
	public ArrayList<String[]> getTeamSeasonTotalBasicInfo(String[] sift){
		String condition ="";
		ArrayList<String[]> result = new ArrayList<String[]>();
		if(sift[0] != null){
			condition += "and m.season = '"+sift[0]+"' ";
		}
		if(sift[1] != null){
			if(sift[1].equals("E")||sift[1].equals("W")){
				condition += "and t.division='"+sift[1]+"' ";
			}else{
				condition += "and t.section='"+sift[1]+"' ";
			}
			
		}
		
		Statement stat = null;
		try {
			stat = connection.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("创建Statement错误！");
		}
		ResultSet rs = null;
		try {
			rs = stat.executeQuery("select "+
									"t.full_name,t1.cdmi,t1.ss,t1.ssing,t1.stps,t1.stpsing,t1.sfts,t1.sftsing,t1.sor,t1.sdr,t1.sr,t1.sas,t1.sst,t1.sbs,t1.sto,t1.sfo,t1.ssc "+
									"from teams as t, "+
									"(select match_id,team_id,count(distinct match_id) as cdmi,sum(shots) as ss, "+
											"sum(shootings) as ssing,sum(three_point_shots) as stps,sum(three_point_shootings) as stpsing, "+             
											"sum(free_throw_shots) as sfts,sum(free_throw_shootings) as sftsing,sum(offensive_rebounds) as sor, "+             
											"sum(defensive_rebounds) as sdr,sum(rebounds) as sr,sum(assists) as sas,sum(steals) as sst,sum(block_shots) as sbs, "+             
											"sum(turn_overs) as sto,sum(fouls) as sfo,sum(score) as ssc "+             
											"from player_match_performance "+     
											"group by team_id "+
											") as t1,matches as m "+
									"where t.id=t1.team_id and m.id=t1.match_id"+condition);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("执行Statement 错误！");
		}
		
		try {
			while(rs.next()){
				String[] strList = new String[17];
				for(int i = 0 ;i < 17;i ++){
					strList[i] = rs.getString(i+1);
				}
				result.add(strList);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i = 0 ;i < result.size();i ++){
			for(int j = 0 ;j < 17;j ++){
				System.out.print(result.get(i)[j]+" ");
			}
			System.out.println();
			
		}
		return result;
	}
	
	public ArrayList<String[]> getTeamSeasonAvgBasicInfo(String[] sift){
		String condition ="";
		ArrayList<String[]> result = new ArrayList<String[]>();
		if(sift[0] != null){
			condition += "and m.season = '"+sift[0]+"' ";
		}
		if(sift[1] != null){
			if(sift[1].equals("E")||sift[1].equals("W")){
				condition += "and t.division='"+sift[1]+"' ";
			}else{
				condition += "and t.section='"+sift[1]+"' ";
			}
			
		}
		
		Statement stat = null;
		try {
			stat = connection.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("创建Statement错误！");
		}
		ResultSet rs = null;
		try {
			rs = stat.executeQuery("select "+
									"t.full_name,t1.cdmi,round(1.0*t1.ss/t1.cdmi,1),round(1.0*t1.ssing/t1.cdmi,1),"
									+ "round(1.0*t1.stps/t1.cdmi,1),round(1.0*t1.stpsing/t1.cdmi,1),"+
									"round(1.0*t1.sfts/t1.cdmi,1),round(1.0*t1.sftsing/t1.cdmi,1),"
									+ "round(1.0*t1.sor/t1.cdmi,1),round(1.0*t1.sdr/t1.cdmi,1), "+
									"round(1.0*t1.sr/t1.cdmi,1),round(1.0*t1.sas/t1.cdmi,1),round(1.0*t1.sst/t1.cdmi,1), "+
									"round(1.0*t1.sbs/t1.cdmi,1),round(1.0*t1.sto/t1.cdmi,1),"
									+ "round(1.0*t1.sfo/t1.cdmi,1),round(1.0*t1.ssc/t1.cdmi,1) "+
									"from teams as t, "+
									"(select match_id,team_id,count(distinct match_id) as cdmi,sum(shots) as ss, "+
											"sum(shootings) as ssing,sum(three_point_shots) as stps,sum(three_point_shootings) as stpsing, "+             
											"sum(free_throw_shots) as sfts,sum(free_throw_shootings) as sftsing,sum(offensive_rebounds) as sor, "+             
											"sum(defensive_rebounds) as sdr,sum(rebounds) as sr,sum(assists) as sas,sum(steals) as sst,sum(block_shots) as sbs, "+             
											"sum(turn_overs) as sto,sum(fouls) as sfo,sum(score) as ssc "+             
											"from player_match_performance "+     
											"group by team_id "+
											") as t1,matches as m "+
									"where t.id=t1.team_id and m.id=t1.match_id"+condition);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("执行Statement 错误！");
		}
		
		try {
			while(rs.next()){
				String[] strList = new String[17];
				for(int i = 0 ;i < 17;i ++){
					strList[i] = rs.getString(i+1);
				}
				result.add(strList);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i = 0 ;i < result.size();i ++){
			for(int j = 0 ;j < 17;j ++){
				System.out.print(result.get(i)[j]+" ");
			}
			System.out.println();
			
		}
		return result;
	}
	
	public ArrayList<String[]> getTeamSeasonRateInfo(String[] sift){
		String condition = "";
		ArrayList<String[]> result = new ArrayList<String[]>();
		if(sift[0] != null){
			condition += "and m.season = '"+sift[0]+"' ";
		}
		if(sift[1] != null){
			if(sift[1].equals("E")||sift[1].equals("W")){
				condition += "and t.division='"+sift[1]+"' ";
			}else{
				condition += "and t.section='"+sift[1]+"' ";
			}
			
		}
		
		Statement stat = null;
		try {
			stat = connection.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("创建Statement错误！");
		}
		ResultSet rs = null;
		try {
			rs = stat.executeQuery("select "+
									"t.full_name,round(100.0*t2.cdmi/t1.cdmi,1),round(100.0*t1.ssing/t1.ss,1),"+
									"round(100.0*t1.stpsing/t1.stps,1),round(100.0*t1.sftsing/t1.sfts,1)"+
									"from teams as t,"+
										"(select match_id,team_id,count(distinct match_id) as cdmi,sum(shots) as ss,"+
												"sum(shootings) as ssing,sum(three_point_shots) as stps,sum(three_point_shootings) as stpsing, "+             
												"sum(free_throw_shots) as sfts,sum(free_throw_shootings) as sftsing "+            
										"from player_match_performance "+     
										"group by team_id "+
										") as t1, "+
										"matches as m, "+     
										"(select tid,count(distinct mid) as cdmi "+
												"from "+
												"(select t.id as tid,m.id as mid "+
														"from matches m,teams t "+
														"where (t.id = m.home_court_team_id and m.hscore>m.ascore) or (t.id = m.away_team_id and m.ascore>m.hscore)) "+                        
														"group by tid) as t2 "+   
									"where t.id=t1.team_id and m.id=t1.match_id and t2.tid = t.id"+condition);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("执行Statement 错误！");
		}
		
		try {
			while(rs.next()){
				String[] strList = new String[5];
				for(int i = 0 ;i < 5;i ++){
					strList[i] = rs.getString(i+1);
				}
				result.add(strList);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i = 0 ;i < result.size();i ++){
			for(int j = 0 ;j < 5;j ++){
				System.out.print(result.get(i)[j]+" ");
			}
			System.out.println();
			
		}
		
		return result;
	}

	public ArrayList<String[]> getTeamSeasonEffInfo(String[] sift){
		String condition = "";
		ArrayList<String[]> result = new ArrayList<String[]>();
		if(sift[1] != null){
			if(sift[1].equals("E")||sift[1].equals("W")){
				condition += "and t.division='"+sift[1]+"' ";
			}else{
				condition += "and t.section='"+sift[1]+"' ";
			}
			
		}
		
		Statement stat = null;
		try {
			stat = connection.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("创建Statement错误！");
		}
		ResultSet rs = null;
		try {
			rs = stat.executeQuery("select t.full_name,round(ss+0.7*sfts-1.07*(1.0*sor/(sor+r_sdr)*(ss-ssing))+1.07*sfo,1), "+
											"round(ss+0.7*sfts-1.07*(1.0*sdr/(sdr+r_sor)*(ss-ssing))+1.07*sfo,1), "+
											"round(100.0*ssc/(ss+0.7*sfts-1.07*(1.0*sor/(sor+r_sdr)*(ss-ssing))+1.07*sfo),1), "+
											"round(100.0*r_ssc/(ss+0.7*sfts-1.07*(1.0*sdr/(sdr+r_sor)*(ss-ssing))+1.07*sfo),1), "+
											"round(1.0*sor/(sor+r_sdr),1),round(1.0*sdr/(sdr+r_sor),1), "+
											"round(100.0*sst/ss+0.7*sfts-1.07*(1.0*sdr/(sdr+r_sor)*(ss-ssing))+1.07*sfo,1), "+
											"round(100.0*sas/ss+0.7*sfts-1.07*(1.0*sor/(sor+r_sdr)*(ss-ssing))+1.07*sfo,1) "+
									"from teams t, "+
											"(select t.id tid,sum(pmp.score) ssc,sum(pmp.shots) ss,sum(pmp.shootings) ssing,sum(pmp.free_throw_shots) sfts,sum(pmp.offensive_rebounds) sor, "+
													"sum(pmp.defensive_rebounds) sdr,sum(pmp.fouls) sfo,sum(pmp.steals) sst,sum(pmp.assists) sas "+
											"from player_match_performance as pmp, "+
													"matches m, "+     
													"teams as t "+    
											"where (t.id = m.home_court_team_id or t.id = m.away_team_id) and pmp.match_id = m.id and pmp.team_id = t.id and m.season = '"+sift[0]+"' "+
											"group by t.id) t1, "+     
											"(select t.id tid,sum(pmp.score) r_ssc,sum(pmp.offensive_rebounds) r_sor, "+
													"sum(pmp.defensive_rebounds) r_sdr "+
											"from player_match_performance as pmp, "+
													"matches m, "+     
													"teams as t "+     
											"where (t.id = m.home_court_team_id or t.id = m.away_team_id) and pmp.match_id = m.id and pmp.team_id <> t.id and m.season='"+sift[0]+"' "+
											"group by t.id) t2 "+     
									"where t1.tid=t2.tid and t1.tid=t.id "+condition);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("执行Statement 错误！");
		}
		
		try {
			while(rs.next()){
				String[] strList = new String[9];
				for(int i = 0 ;i < 9;i ++){
					strList[i] = rs.getString(i+1);
				}
				result.add(strList);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i = 0 ;i < result.size();i ++){
			for(int j = 0 ;j < 9;j ++){
				System.out.print(result.get(i)[j]+" ");
			}
			System.out.println();
			
		}
		return result;
	}
	
	public ArrayList<String> getTeamList() {
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<String> result = new ArrayList<String>();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("");
			while (resultSet.next()) {
				String temp = resultSet.getString(1);
				result.add(temp);
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("SQL错误");
			e.printStackTrace();
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
		TeamDaoJdbcImp t = new TeamDaoJdbcImp();
		String[] strList = new String[4];
		strList[0] ="13-14";
		t.getTeamSeasonEffInfo(strList);
	}

}
