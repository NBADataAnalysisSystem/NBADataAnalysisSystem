package dao.playerdao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PlayerDaoJdbcImp implements PlayerDao {

	private Connection connection;
	
    public PlayerDaoJdbcImp() {
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
    
	public ArrayList<String> getPlayerBasicInfo(String[] sift) {
		//sift[0] 姓名首字母筛选
		//sift[1] 球队筛选
		//sift[2] 位置筛选
		String condition = "";
		if (sift[1]!=null) {
			condition = " fn = '" + sift[1] + "' ";
		} else if (sift[2]!=null) {
			condition = " position like '%" + sift[2] + "%' ";
		} else if (sift[0]!=null) {
			condition = " player_name like '" + sift[0] + "%' ";
		}
		String columnsToSearch = "player_name,jersey_number,position,height,weight,birth,age,exp,fn";
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<String> result = new ArrayList<String>();
		try {
			statement = connection.createStatement();
			if (condition.equals("")) {
				resultSet = statement.executeQuery(
						"SELECT " + columnsToSearch + " "
								+ "FROM (select player_id pi,full_name fn,date_of_match dom "
								+ "from player_match_performance p,teams t,matches m "
								+ "where t.id = p.team_id and p.match_id = m.id) as t3 "
								+ "join players on players.id=pi "
								+ "group by pi "
								+ "having dom=max(dom)");
			} else {
				resultSet = statement.executeQuery(
						"SELECT " + columnsToSearch + " "
								+ "FROM (select player_id pi,full_name fn,date_of_match dom "
								+ "from player_match_performance p,teams t,matches m "
								+ "where t.id = p.team_id and p.match_id = m.id) as t3 "
								+ "join players on players.id=pi "
								+ " where" + condition + " "
								+ "group by pi "
								+ "having dom=max(dom)");
			}
			while (resultSet.next()) {
				String temp = "";
				int i = 1;
				for (i = 1; i < 9; i++) {
					if (resultSet.getString(i) != null) {
						temp = temp + resultSet.getString(i) + ",";
					} else {
						temp = temp + ",";
					}
				}
				temp = temp + resultSet.getString(i);
				result.add(temp);
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("SQL错误");
			e.printStackTrace();
		}
		return result;
	}

	//获取球员赛季数据-总数
	public ArrayList<String> getPlayerSeasonTotalInfo(String[] sift) {
		//sift[0] 联盟
		//sift[1] 位置
		//sift[2] 排序依据
		String condition1 = "";
		String condition2 = "";
		String condition3 = "";
		if (sift[0]!=null) {
			if (sift[0].equals("E") || sift[0].equals("W")) {
				condition1 = " and fn in (select full_name from teams where division='" + sift[0] + "') ";
			} else {
				condition1 = " and fn in (select full_name from teams where section='" + sift[0] + "') ";
			}
		}
		if (sift[1]!=null) {
			condition2 = " and position like '%" + sift[1] + "%' ";
		}
		if (sift[2]!=null) {
			condition3 = " order by " + sift[2] + " desc";
		}
		String columnsToSearch = "p.player_name,t4.fn,t1.dmi,t1.sis,t1.sr,t1.sa,"
				+ "t1.spt,round(100.0*t1.ssing/t1.ss,1) as sp,round(100.0*stpsing/stps,1) as tpsp,"
				+ "round(100.0*sftsing/sfts,1) as ftsp,t1.sor,t1.sdr,t1.sst,t1.sbs,t1.sto,t1.sfo,t1.ssc";
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<String> result = new ArrayList<String>();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(
					"SELECT " + columnsToSearch + " FROM players as p ,(select player_id pi,count(distinct match_id) as dmi, "
							+ "sum(is_start) as sis,sum(rebounds) as sr,sum(assists) as sa, "
							+ "sum(presence_time)/60 as spt,sum(shootings) as ssing, "
							+ "sum(shots) as ss,sum(three_point_shootings) as stpsing, "
							+ "sum(three_point_shots) as stps,sum(free_throw_shootings) as sftsing, "
							+ "sum(free_throw_shots) as sfts, sum(offensive_rebounds) as sor, "
							+ "sum(defensive_rebounds) as sdr, sum(steals) as sst, "
							+ "sum(block_shots) as sbs,sum(turn_overs) as sto,sum(fouls) as sfo, "
							+ "sum(score) as ssc "
							+ "from player_match_performance "
							+ "group by pi) as t1, "
							+ "(select pi,fn "
							+ "from (select player_id pi,full_name fn,date_of_match dom "
							+ "from player_match_performance p,teams t,matches m "
							+ "where t.id = p.team_id and p.match_id = m.id) as t3 "
							+ "group by pi "
							+ "having dom=max(dom)) as t4, "
							+ "(select player_id as id,sum(double_double) as dd from player_match_performance "
							+ "group by player_id) as t5 "
							+ "where t1.pi = p.id and t4.pi=p.id and t1.pi=t5.id "
							+ condition1 + condition2 + condition3 + ";");
			while (resultSet.next()) {
				String temp = "";
				int i = 1;
				for (i = 1; i < 17; i++) {
					if (resultSet.getString(i) != null) {
						temp = temp + resultSet.getString(i) + ",";
					} else {
						temp = temp + ",";
					}
				}
				temp = temp + resultSet.getString(i);
				result.add(temp);
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("SQL错误");
			e.printStackTrace();
		}
		return result;
	}
	
	//获取球员赛季数据-场均
	public ArrayList<String> getPlayerSeasonAvgInfo(String[] sift) {
		
		String columnsToSearch = "";
		//ArrayList<String> columnStrList = new ArrayList<String>();
		columnsToSearch = columnsToSearch.substring(0, columnsToSearch.length()-1);
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<String> result = new ArrayList<String>();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(
					"SELECT " + columnsToSearch + " FROM players");
			while (resultSet.next()) {
				String map = "";
				result.add(map);
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("SQL错误");
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<String> getTeamList() {
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<String> result = new ArrayList<String>();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(
					"select fn "
					+ "from (select player_id pi,full_name fn,date_of_match dom "
					+ "from player_match_performance p,teams t,matches m "
					+ "where t.id = p.team_id and p.match_id = m.id) as t3 "
					+ "group by fn "
					+ "having dom=max(dom)");
			while (resultSet.next()) {
				result.add(resultSet.getString("fn"));
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
    
}
