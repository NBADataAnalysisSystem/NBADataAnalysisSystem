package dao.playerdetaildao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;   

import dao.hotdao.HotDaoJdbcImp;

public class PlayerDetailDaoJdbcImp {
private Connection connection;
	
	public PlayerDetailDaoJdbcImp() {
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
	
	public String[][] getPlayerSeasonInfo(String playerName){
		String [] []result = new String[2][17];
		Statement stat = null;
		DecimalFormat    df   = new DecimalFormat("######0.0");
		try {
			stat = connection.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("创建Statement错误！");
		}
		ResultSet rs = null;
		try {
			rs = stat.executeQuery("select max(season) from matches");
			result[0][0] = rs.getString(1);
			result[1][0] = rs.getString(1);
			rs = stat.executeQuery("select full_name from players p,teams t,matches m,"
					+ "player_match_performance pmp where m.season='"+result[0][0]+"' "
					+ "and p.player_name ='"+playerName+"' and p.id = pmp.player_id and m.id =pmp.match_id "
					+ "and pmp.team_id = t.id "
					+ "group by pmp.player_id having m.date_of_match = max(m.date_of_match) ");
			result[0][1] = rs.getString(1);
			result[1][1] = rs.getString(1);
			rs=stat.executeQuery("select count(p.id),sum(is_start) from player_match_performance pmp,"
					+ "players p,matches m where m.id= pmp.match_id and p.id= pmp.player_id and"
					+ " p.player_name ='"+playerName+"' and m.season ='"+result[0][0]+"' group by p.id");
			result[0][2] =rs.getString(1);
			result[1][2] = rs.getString(1);
			result[0][3] = rs.getString(2);
			result[1][3] = rs.getString(2);
			rs= stat.executeQuery("select round(1.0*sum(pmp.presence_time)/60,1) "
					+ "from player_match_performance pmp,players p,matches m "
					+ "where pmp.match_id = m.id and p.id = pmp.player_id and "
					+ "m.season='"+result[0][0]+"' and p.player_name='"+playerName+"' group by p.id");
			result[0][4] = rs.getString(1);
			result[1][4] = df.format(Double.parseDouble(result[0][4])/Double.parseDouble(result[0][2]));
			rs=stat.executeQuery("select round(1.0*sum(pmp.shootings)/sum(pmp.shots),1),"
					+ "round(1.0*sum(pmp.three_point_shootings)/sum(pmp.three_point_shots),1),"
					+ "round(1.0*sum(pmp.free_throw_shootings)/sum(pmp.free_throw_shots),1)"
					+ " from player_match_performance pmp,players p,matches m where pmp.match_id = m.id and "
					+ "p.id = pmp.player_id and "
					+ "m.season='"+result[0][0]+"' and p.player_name='"+playerName+"' group by p.id");
			for(int i=0;i<3;i++){
				result[0][i+5]=rs.getString(i+1);
				result[1][i+5]=rs.getString(i+1);
			}
			rs=stat.executeQuery("select sum(pmp.offensive_rebounds),sum(pmp.defensive_rebounds),"
					+ "sum(pmp.rebounds),sum(pmp.assists),sum(pmp.steals),sum(pmp.block_shots),"
					+ "sum(pmp.turn_overs),sum(pmp.fouls),sum(pmp.score) "
					+ "from player_match_performance pmp,players p,matches m "
					+ "where pmp.match_id = m.id and p.id = pmp.player_id and "
					+ "m.season='"+result[0][0]+"' and p.player_name='"+playerName+"' group by p.id");
			for(int i = 0 ;i<9;i++){
				result[0][i+8]=rs.getString(i+1);
				result[1][i+8]=df.format(Double.parseDouble(result[0][i+8])/Double.parseDouble(result[0][2]));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("执行Statement 错误！");
		}
		
		for(int i=0;i<2;i++){
			for(int j=0;j<17;j++){
				System.out.print(result[i][j]+" ");
			}
			System.out.println("");
		}
		return result;
	}
	
	public String[][] getPlayerLatestFiveMatchInfo(String playerName){
		String[][] result = new String[5][21];
		Statement stat = null;
		try {
			stat = connection.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("创建Statement错误！");
		}
		ResultSet rs = null;
		try {
			rs = stat.executeQuery("select t.abbreviation,t1.abbreviation,t2.abbreviation,"
					+ "m.date_of_match,round(1.0*pmp.presence_time/60,1),round(1.0*pmp.shootings/pmp.shots,1),"
					+ "pmp.shootings,pmp.shots,round(1.0*pmp.three_point_shootings/pmp.three_point_shots,1),"
					+ "pmp.three_point_shootings,pmp.three_point_shots"
					+ ",round(1.0*pmp.free_throw_shootings/pmp.free_throw_shots,1),pmp.free_throw_shootings,"
					+ "pmp.free_throw_shots,pmp.offensive_rebounds,pmp.defensive_rebounds,"
					+ "pmp.rebounds,pmp.assists,pmp.fouls,pmp.steals,pmp.turn_overs,pmp.block_shots,"
					+ "pmp.score from matches m,teams t1,teams t2,teams t,player_match_performance pmp,players p "
					+ "where m.season in (select max(season) from matches) and m.id = pmp.match_id and"
					+ " t1.id=m.home_court_team_id and t2.id=m.away_team_id and t.id=pmp.team_id and"
					+ " pmp.player_id = p.id and "
					+ "p.player_name ='"+playerName+"' order by m.date_of_match desc limit 5");
			int i=0;
			while(rs.next()){
				if(rs.getString(1).equals(rs.getString(2))){
					result[i][0]=rs.getString(3);
				}else{
					result[i][0]=rs.getString(2);
				}
				for(int j=1;j<21;j++){
					result[i][j]=rs.getString(j+3);
				}
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("执行Statement 错误！");
		}
		for( int i=0;i<5;i++){
			for(int j=0;j<21;j++){
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
		return result;
		
	}
	
	public String[] getPlayerBasicInfo(String playerName){
		String[] result = new String[11];
		Statement stat = null;
		try {
			stat = connection.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("创建Statement错误！");
		}
		ResultSet rs = null;
		try {
			rs = stat.executeQuery("select p.jersey_number,p.player_name,t.abbreviation,"
					+ "p.position,p.height,p.weight,p.birth,p.exp,p.school,"
					+ "pa.path||'players\\portrait\\'||p.player_name||'.png',pa.path||'teams\\'||t.abbreviation||'.png' "
					+ "from players p,player_match_performance pmp,matches m,teams t,paths pa "
					+ "where pmp.player_id =p.id and pmp.match_id=m.id and pmp.team_id =t.id and"
					+ " p.player_name='"+playerName+"' order by m.date_of_match desc limit 1 ");
			for(int i =0;i<11;i++){
				result[i] = rs.getString(i+1);
				System.out.print(result[i]+" ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("执行Statement 错误！");
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
		PlayerDetailDaoJdbcImp t = new PlayerDetailDaoJdbcImp();
		String[] strList = new String[2];
		strList[0] ="13-14";
		strList[1] = "round(1.0*sum(pmp.shootings)/count(distinct pmp.match_id),1)";
		t.getPlayerBasicInfo("Aaron Brooks");
	}
}
