package dao.testdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import test.data.PlayerNormalInfo;
import test.data.TeamHighInfo;
import test.data.TeamHotInfo;
import test.data.TeamNormalInfo;

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
			String condition2="";
			String[] str = sift[4].split(",");
			for(int i=0;i<str.length;i++){
				condition2= condition2+str[i].split("\\.")[0]+" "+ str[i].split("\\.")[1]+" ";
			}
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
"round(100.0*sum(pmp.shootings)/sum(pmp.shots),1) penalty,sum(pmp.score) score,sum(pmp.rebounds) rebound,sum(pmp.shots) shot,sum(pmp.is_start) start,"+
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
" order by "+condition2+" limit "+sift[0]);
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

	  public ArrayList<TeamHotInfo> getTeamHotInfo(String[] sift){
		  ArrayList<TeamHotInfo> result= new ArrayList<TeamHotInfo>();
		  Statement statement = null;
			ResultSet resultSet = null;
			String condition = "";
			condition = condition+" limit "+sift[1];
			try {
				statement = connection.createStatement();
				resultSet = statement.executeQuery("select teamName,league,"+sift[0]+" "
						+ "from(select teamName,league,round(1.0*score/numOfGame,1) score,round(1.0*rebound/numOfGame,1) rebound, "
						+ "round(1.0*assist/numOfGame,1) assist,round(1.0*blockShot/numOfGame,1) blockShot, "
						+ "round(1.0*steal/numOfGame,1)steal ,round(1.0*foul/numOfGame,1) foul, "
						+ "round(1.0*fault/numOfGame,1) fault,round(1.0*shot/numOfGame,1) shot, "
						+ "three,penalty,round(1.0*defendRebound/numOfGame,1) defendRebound, "
						+ "round(1.0*offendRebound/numOfGame,1) offendRebound "
						+ "from "
						+ "(select t.abbreviation teamName,t.division league,sum(pmp.score) score,sum(pmp.rebounds) rebound, "
						+ "sum(pmp.assists) assist,sum(pmp.block_shots) blockShot, "
						+ "sum(pmp.steals) steal,sum(pmp.fouls) foul, "
						+"sum(pmp.turn_overs) fault,sum(pmp.shots) shot,"
						+ "round(100.0*sum(pmp.three_point_shootings)/sum(pmp.three_point_shots),1) three, "
						+ "round(100.0*sum(pmp.free_throw_shootings)/sum(pmp.free_throw_shots),1) penalty, "
						+ "sum(pmp.defensive_rebounds) defendRebound, "
						+ "sum(pmp.offensive_rebounds) offendRebound, "
						+ "count(distinct match_id) numOfGame "
						+ "from teams t, "
						+ "player_match_performance pmp where t.id=pmp.team_id group by t.id)) "
						+ "order by "+sift[0]+" desc "
						+ "limit "+sift[1]);
				while (resultSet.next()) {
					TeamHotInfo thi = new TeamHotInfo();
					thi.setTeamName(resultSet.getString(1));
					if(resultSet.getString(2).equals("E")){
						thi.setLeague("East");	
					}else{
						thi.setLeague("West");
					}
					
					thi.setField(sift[0]);
					thi.setValue(resultSet.getDouble(3));
					result.add(thi);
				}
			
				statement.close();
			} catch (SQLException e) {
				System.out.println("SQL错误");
				e.printStackTrace();
			}
			
			return result;
	  }

	  
	 public ArrayList<TeamNormalInfo> getTeamTotalNormalInfo(String[] sift){
		 ArrayList<TeamNormalInfo> result= new ArrayList<TeamNormalInfo>();
		  Statement statement = null;
			ResultSet resultSet = null;
			String sort =" "+sift[1].split("\\.")[0]+" "+sift[1].split("\\.")[1];
			String limit =" limit "+sift[0];
			
			try {
				statement = connection.createStatement();
				resultSet = statement.executeQuery("select * from (select t.abbreviation teamName,sum(pmp.assists) assist,sum(pmp.block_shots) blockShot,sum(pmp.defensive_rebounds) defendRebound,sum(pmp.turn_overs) fault,"+
"sum(pmp.fouls) foul,"+
"count(distinct match_id) numOfGame,sum(pmp.offensive_rebounds) offendRebound,round(100.0*sum(pmp.free_throw_shootings)/sum(pmp.free_throw_shots),1) penalty,"+
"sum(pmp.score) score,sum(pmp.rebounds) rebound,"+
"round(100.0*sum(pmp.shootings)/sum(pmp.shots),1) shot,sum(pmp.steals) steal,"+
"round(100.0*sum(pmp.three_point_shootings)/sum(pmp.three_point_shots),1) three "+
"from teams t,"+
"     player_match_performance pmp where t.id=pmp.team_id group by t.id) "+
"order by "+sort+" "+limit);
				while (resultSet.next()) {
					TeamNormalInfo tni = new TeamNormalInfo();
					tni.setTeamName(resultSet.getString(1));
					tni.setAssist(resultSet.getDouble(2));
					tni.setBlockShot(resultSet.getDouble(3));
					tni.setDefendRebound(resultSet.getDouble(4));
					tni.setFault(resultSet.getDouble(5));
					tni.setFoul(resultSet.getDouble(6));
					tni.setNumOfGame(resultSet.getInt(7));
					tni.setOffendRebound(resultSet.getDouble(8));
					tni.setPenalty(resultSet.getDouble(9));
					tni.setPoint(resultSet.getDouble(10));
					tni.setRebound(resultSet.getDouble(11));
					tni.setShot(resultSet.getDouble(12));
					tni.setSteal(resultSet.getDouble(13));
					tni.setThree(resultSet.getDouble(14));
					result.add(tni);
				}
			
				statement.close();
			} catch (SQLException e) {
				System.out.println("SQL错误");
				e.printStackTrace();
			}
			
			return result;
	 } 

	 
	 public ArrayList<TeamNormalInfo> getTeamAvgNormalInfo(String [] sift){
		 ArrayList<TeamNormalInfo> result= new ArrayList<TeamNormalInfo>();
		  Statement statement = null;
			ResultSet resultSet = null;
			String sort =" "+sift[1].split("\\.")[0]+" "+sift[1].split("\\.")[1];
			String limit =" limit "+sift[0];
			
			try {
				statement = connection.createStatement();
				resultSet = statement.executeQuery("select * from (select t.abbreviation teamName,round(1.0*sum(pmp.assists)/count(distinct match_id),1) assist,round(1.0*sum(pmp.block_shots)/count(distinct match_id),1) blockShot,"
						+ "round(1.0*sum(pmp.defensive_rebounds)/count(distinct match_id),1) defendRebound,round(1.0*sum(pmp.turn_overs)/count(distinct match_id),1) fault,"+
"round(1.0*sum(pmp.fouls)/count(distinct match_id),1) foul,"+
"count(distinct match_id) numOfGame,round(1.0*sum(pmp.offensive_rebounds)/count(distinct match_id)) offendRebound,"
+ "round(100.0*sum(pmp.free_throw_shootings)/sum(pmp.free_throw_shots),1) penalty,"+
"round(1.0*sum(pmp.score)/count(distinct match_id),1) score,round(1.0*sum(pmp.rebounds)/count(distinct match_id),1) rebound,"+
"round(100.0*sum(pmp.shootings)/sum(pmp.shots),1) shot,sum(pmp.steals) steal,"+
"round(100.0*sum(pmp.three_point_shootings)/sum(pmp.three_point_shots),1) three "+
"from teams t,"+
"     player_match_performance pmp where t.id=pmp.team_id group by t.id) "+
"order by "+sort+" "+limit);
				while (resultSet.next()) {
					TeamNormalInfo tni = new TeamNormalInfo();
					tni.setTeamName(resultSet.getString(1));
					tni.setAssist(resultSet.getDouble(2));
					tni.setBlockShot(resultSet.getDouble(3));
					tni.setDefendRebound(resultSet.getDouble(4));
					tni.setFault(resultSet.getDouble(5));
					tni.setFoul(resultSet.getDouble(6));
					tni.setNumOfGame(resultSet.getInt(7));
					tni.setOffendRebound(resultSet.getDouble(8));
					tni.setPenalty(resultSet.getDouble(9));
					tni.setPoint(resultSet.getDouble(10));
					tni.setRebound(resultSet.getDouble(11));
					tni.setShot(resultSet.getDouble(12));
					tni.setSteal(resultSet.getDouble(13));
					tni.setThree(resultSet.getDouble(14));
					result.add(tni);
				}
			
				statement.close();
			} catch (SQLException e) {
				System.out.println("SQL错误");
				e.printStackTrace();
			}
			
			return result;
	 } 

	 public ArrayList<TeamHighInfo> getTeamTotalHighInfo(String[] sift){
		 ArrayList<TeamHighInfo> result= new ArrayList<TeamHighInfo>();
		  Statement statement = null;
			ResultSet resultSet = null;
			String sort =" "+sift[1].split("\\.")[0]+" "+sift[1].split("\\.")[1]+" ";
			try {
				statement = connection.createStatement();
				resultSet = statement.executeQuery("select * "+
"from(select teamName,round(100.0*assists/offendRound,1) assistEfficient,round(100.0*rscore/defendRound,1) defendEfficient,"+
"round(defendReboundEfficient,1) defendReboundEfficient,round(100.0*tscore/offendRound,1) offendEfficient,"+
"round(offendReboundEfficient,1) offendReboundEfficient,"+
"round(offendRound,1) offendRound,round(100.0*steals/defendRound) stealEfficient,"+
"winRate "+
"from"+
"  (select t2.teamName,round(100.0*t1.win/t2.numOfGame,1) winRate,"+
" this.shots+0.4*this.free_throw_shots-1.07*(1.0*this.offensive_rebounds/"+
"(this.offensive_rebounds+rival.defensive_rebounds)*(this.shots-this.shootings))+1.07*this.turn_overs offendRound,"+
"this.shots+0.4*this.free_throw_shots-1.07*(1.0*this.defensive_rebounds/"+
"(this.defensive_rebounds+rival.offensive_rebounds)*(this.shots-this.shootings))+1.07*this.turn_overs defendRound,"+
"1.0*this.offensive_rebounds/(this.offensive_rebounds+rival.defensive_rebounds) offendReboundEfficient,"+
"1.0*this.defensive_rebounds/(this.defensive_rebounds+rival.offensive_rebounds) defendReboundEfficient,"+
"this.score tscore,rival.score rscore,this.steals steals,this.assists assists "+
"from "+
"(select t.id tid,count(distinct m.id) win "+
"from matches m,"+
"     teams t     "+
"where (t.id=m.home_court_team_id and m.hscore>m.ascore)||(t.id=m.away_team_id and m.hscore<m.ascore)"+
" group by t.id) t1,"+
"(select t.id tid,sum(pmp.shootings) shootings,sum(pmp.shots) shots,sum(pmp.three_point_shootings) three_point_shootings,sum(pmp.three_point_shots) three_poiint_shots,"+
"sum(pmp.free_throw_shootings) free_throw_shootings,sum(pmp.free_throw_shots) free_throw_shots,sum(pmp.offensive_rebounds) offensive_rebounds,"+
"sum(pmp.defensive_rebounds) defensive_rebounds,sum(pmp.rebounds) rebounds,sum(pmp.assists) assists ,sum(pmp.steals) steals,sum(pmp.block_shots) block_shots,"+
"sum(pmp.turn_overs) turn_overs,sum(pmp.fouls) fouls ,sum(pmp.score) score "+
"from player_match_performance pmp,"+
"     teams t       "+
"where t.id =pmp.team_id"+
" group by t.id) this,"+
"(select t.id tid,sum(pmp.shootings) shootings,sum(pmp.shots) shots,sum(pmp.three_point_shootings) three_point_shootings,sum(pmp.three_point_shots) three_poiint_shots,"+
"sum(pmp.free_throw_shootings) free_throw_shootings,sum(pmp.free_throw_shots) free_throw_shots,sum(pmp.offensive_rebounds) offensive_rebounds,"+
"sum(pmp.defensive_rebounds) defensive_rebounds,sum(pmp.rebounds) rebounds,sum(pmp.assists) assists ,sum(pmp.steals) steals,sum(pmp.block_shots) block_shots,"+
"sum(pmp.turn_overs) turn_overs,sum(pmp.fouls) fouls ,sum(pmp.score) score"+
" from player_match_performance pmp,"+
"     teams t,"+
"     matches m       "+
"where (t.id=m.away_team_id or t.id=m.home_court_team_id ) and pmp.match_id=m.id and pmp.team_id<>t.id"+
" group by t.id) rival,"+
"(select t.id tid,t.abbreviation teamName,count(distinct m.id) numOfGame "+
" from matches m,"+
"     teams t    "+ 
"where t.id=m.home_court_team_id or t.id= m.away_team_id "+
"group by t.id) t2 "+
"where t1.tid=t2.tid and t2.tid=this.tid and this.tid=rival.tid)) "+
"order by "+sort+" "+"limit "+sift[0]);
				while (resultSet.next()) {
					TeamHighInfo thi = new TeamHighInfo();
					thi.setTeamName(resultSet.getString(1));
					thi.setAssistEfficient(resultSet.getDouble(2));
					thi.setDefendEfficient(resultSet.getDouble(3));
					thi.setDefendReboundEfficient(resultSet.getDouble(4));
					thi.setOffendEfficient(resultSet.getDouble(5));
					thi.setOffendReboundEfficient(resultSet.getDouble(6));
					thi.setOffendRound(resultSet.getDouble(7));
					thi.setStealEfficient(resultSet.getDouble(8));
					thi.setWinRate(resultSet.getDouble(9));
					result.add(thi);
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
