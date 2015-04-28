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
    
	public ArrayList<String[]> getPlayerBasicInfo(String[] sift) {
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
		String columnsToSearch = "player_name,jersey_number,position,height,weight,birth,age,exp,school,fn";
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<String[]> result = new ArrayList<String[]>();
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
				int j = 0;
				String[] temp = new String[10];
				while (j < 10) {
					temp[j] = resultSet.getString(j+1);
					j++;
				}
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
	public ArrayList<String[]> getPlayerSeasonTotalInfo(String[] sift) {
		//sift[0] 联盟
		//sift[1] 位置
		//sift[2] 排序依据
		//sift[3] 赛季
		String condition1 = "";
		String condition2 = "";
		String condition3 = "";
		String condition4 = "";
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
		if (sift[3]!=null) {
			condition4 = "and m.season='" + sift[3] + "' ";
		}
		String columnsToSearch = "p.player_name,t4.fn,t1.dmi,t1.sis,t1.sr,t1.sa,"
				+ "t1.spt,round(100.0*t1.ssing/t1.ss,1) as sp,round(100.0*stpsing/stps,1) as tpsp,"
				+ "round(100.0*sftsing/sfts,1) as ftsp,t1.sor,t1.sdr,t1.sst,t1.sbs,t1.sto,t1.sfo,t1.ssc";
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<String[]> result = new ArrayList<String[]>();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(
					"SELECT " + columnsToSearch + " FROM players as p ,"
							+ "(select match_id,player_id pi,count(distinct match_id) as dmi, "
							+ "sum(is_start) as sis,sum(rebounds) as sr,sum(assists) as sa, "
							+ "sum(presence_time)/60 as spt,sum(shootings) as ssing, "
							+ "sum(shots) as ss,sum(three_point_shootings) as stpsing, "
							+ "sum(three_point_shots) as stps,sum(free_throw_shootings) as sftsing, "
							+ "sum(free_throw_shots) as sfts, sum(offensive_rebounds) as sor, "
							+ "sum(defensive_rebounds) as sdr, sum(steals) as sst, "
							+ "sum(block_shots) as sbs,sum(turn_overs) as sto,sum(fouls) as sfo, "
							+ "sum(score) as ssc "
							+ "from player_match_performance pmp,matches m "
							+ "where m.id= pmp.match_id " + condition4
							+ "group by pi) as t1, "
							+ "(select pi,fn "
							+ "from (select player_id pi,full_name fn,date_of_match dom "
							+ "from player_match_performance p,teams t,matches m "
							+ "where t.id = p.team_id and p.match_id = m.id "
							+ condition4 + ") as t3 "
							+ "group by pi "
							+ "having dom=max(dom)) as t4, "
							+ "(select player_id as id,sum(double_double) as dd "
							+ "from player_match_performance "
							+ "group by player_id) as t5 "
							+ "where t1.pi = p.id and t4.pi=p.id and "
							+ "t1.pi=t5.id "
							+ condition1 + condition2 + condition3 + ";");
			while (resultSet.next()) {
				int j = 0;
				String[] temp = new String[17];
				while (j < 17) {
					temp[j] = resultSet.getString(j+1);
					j++;
				}
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
	public ArrayList<String[]> getPlayerSeasonAvgInfo(String[] sift) {
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
		String columnsToSearch = "p.player_name,t4.fn,t1.dmi,t1.sis,round(1.0*t1.sr/t1.dmi,1) as cjlb,"
				+ "round(1.0*t1.sa/t1.dmi,1) as cjzg,round(1.0*t1.spt/t1.dmi,1) as cjfz,"
				+ "round(1.0*(t1.ssc+t1.sr+t1.sa+t1.sst+t1.sbs-ss+ssing-sfts+sftsing-sto)/t1.dmi,1) as eff,"
				+ "round(100.0*t1.ssing/t1.ss,1) as tlmzl,round(100.0*stpsing/stps,1) as sfqmzl,"
				+ "round(100.0*sftsing/sfts,1) as fqmzl,round(1.0*t1.sor/t1.dmi,1) as cjjg,"
				+ "round(1.0*t1.sdr/t1.dmi) as cjfs,round(1.0*t1.sst/t1.dmi,1) as cjqd,"
				+ "round(1.0*t1.sbs/t1.dmi,1) as cjgm,round(1.0*t1.sto/t1.dmi) as cjsw,"
				+ "round(1.0*t1.sfo/t1.dmi,1) as cjfg,round(1.0*t1.ssc/t1.dmi,1) as cjdf";
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<String[]> result = new ArrayList<String[]>();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(
					"SELECT " + columnsToSearch + " FROM players as p ,"
							+ "(select player_id pi,count(distinct match_id) as dmi,"
							+ "sum(is_start) as sis,sum(rebounds) as sr,sum(assists) as sa,"
							+ "sum(presence_time)/60 as spt,sum(shootings) as ssing,"
							+ "sum(shots) as ss,sum(three_point_shootings) as stpsing,"
							+ "sum(three_point_shots) as stps,sum(free_throw_shootings) as sftsing,"
							+ "sum(free_throw_shots) as sfts, sum(offensive_rebounds) as sor,"
							+ "sum(defensive_rebounds) as sdr, sum(steals) as sst,"
							+ "sum(block_shots) as sbs,sum(turn_overs) as sto,sum(fouls) as sfo,"
							+ "sum(score) as ssc "
							+ "from player_match_performance "
							+ "group by pi) as t1,"
							+ "(select pi,fn "
							+ "from (select player_id pi,full_name fn,date_of_match dom "
							+ "from player_match_performance p,teams t,matches m "
							+ "where t.id = p.team_id and p.match_id = m.id) as t3 "
							+ "group by pi "
							+ "having dom=max(dom)) as t4 "
							+ "where t1.pi = p.id and t4.pi=p.id "
							+ condition1 + condition2 + condition3 + ";");
			while (resultSet.next()) {
				int j = 0;
				String[] temp = new String[18];
				while (j < 18) {
					temp[j] = resultSet.getString(j+1);
					j++;
				}
				result.add(temp);
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
