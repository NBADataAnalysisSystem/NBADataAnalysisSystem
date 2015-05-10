package dao.testdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import test.data.PlayerNormalInfo;

public class TestDaoJdbcImp {
	private Connection connection;
	  public TestDaoJdbcImp() {
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
	  
	  public ArrayList<PlayerNormalInfo> getPlayerTotalNormalInfo(String[] sift){
		  ArrayList<PlayerNormalInfo> result= new ArrayList<PlayerNormalInfo>();
		  Statement statement = null;
			ResultSet resultSet = null;
			String condition ="";
			if(!sift[1].equals("A")){
				condition+=" and p.position like '%"+sift[1]+"%' ";
			}
			if(!sift[2].equals("A")){
				condition+=" and t.division like '%"+sift[2]+"%' ";
			}
			if(sift[3].equals("1")){
				condition += " and p.age<=22 ";
			}else if(sift[3].equals("2")){
				condition+=" and p.age>22 and p.age<=25 ";
			}else if(sift[3].equals("3")){
				condition+=" and p.age>25 and p.age<=30 ";
			}else if(sift[3].equals("4")){
				condition+= " and p.age>30 ";
			}
			
			try {
				statement = connection.createStatement();
				resultSet = statement.executeQuery("select * from(select  p.player_name name,t.abbreviation teamName,p.age age,sum(pmp.assists) assist,sum(pmp.block_shots) blockShot,sum(pmp.defensive_rebounds) defend,"+
"sum(pmp.score)+sum(pmp.rebounds)+sum(pmp.assists)+sum(pmp.steals)+sum(pmp.block_shots)-(sum(pmp.shots)-sum(pmp.shootings))-"+
"(sum(pmp.free_throw_shots)-sum(pmp.free_throw_shootings))-sum(pmp.turn_overs) efficiency,sum(pmp.turn_overs) fault,"+
"sum(pmp.fouls) foul,round(1.0*sum(pmp.presence_time)/60,1) minute,count(distinct pmp.match_id) numOfGame,sum(pmp.offensive_rebounds) offend,"+
"round(100.0*sum(pmp.shootings)/sum(pmp.shots),1) penalty,sum(pmp.score) point,sum(pmp.rebounds) rebound,sum(pmp.shots) shot,sum(pmp.is_start) start,"+
"sum(pmp.steals) steal,round(100.0*sum(pmp.three_point_shootings)/sum(pmp.three_point_shots),1) three "+
" from players p, "+
" player_match_performance pmp, "+
" (select pmp.player_id pid,pmp.team_id tid "+
" from player_match_performance pmp, "+
" matches m "    +
" where pmp.match_id =m.id and pmp.player_id<>-1 "+
" group by pmp.player_id "+
" having m.date_of_match=max(m.date_of_match)) as t1, "+
" teams t "+
" where p.id = pmp.player_id and t1.pid =p.id and t.id=t1.tid "+condition+
" group by p.id) "+
" order by "+sift[4].split("\\.")[0]+" "+sift[4].split("\\.")[1]+" limit "+sift[0]);
				while (resultSet.next()) {
					PlayerNormalInfo pni = new PlayerNormalInfo();
					pni.setName(resultSet.getString(1));
					pni.setTeamName(resultSet.getString(2));
					pni.setAge(resultSet.getInt(3));
					pni.setAssist(resultSet.getDouble(4));
					pni.setBlockShot(resultSet.getDouble(5));
					pni.setDefend(resultSet.getDouble(6));
					pni.setEfficiency(resultSet.getDouble(7));
					pni.setFault(resultSet.getDouble(8));
					pni.setFoul(resultSet.getDouble(9));
					pni.setMinute(resultSet.getDouble(10));
					pni.setNumOfGame(resultSet.getInt(11));
					pni.setOffend(resultSet.getDouble(12));
					pni.setPenalty(resultSet.getDouble(13));
					pni.setPoint(resultSet.getDouble(14));
					pni.setRebound(resultSet.getDouble(15));
					pni.setShot(resultSet.getDouble(16));
					pni.setStart(resultSet.getInt(17));
					pni.setSteal(resultSet.getDouble(18));
					pni.setThree(resultSet.getDouble(19));
					result.add(pni);
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
