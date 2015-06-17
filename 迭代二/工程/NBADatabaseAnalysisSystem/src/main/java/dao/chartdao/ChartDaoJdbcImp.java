package dao.chartdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

public class ChartDaoJdbcImp  implements ChartDao{

	Connection connection = null;
	String[] SEASON ={"20122013","20132014","20142015"};
	
	public ChartDaoJdbcImp(){
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:Database.db");
		} catch (ClassNotFoundException e) {
			System.out.println("没有找到sqlite jdbc");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL错误");
			e.printStackTrace();
		}
	}
	
	@Override
	public String[][] getPlayerEfficiency(String playerName) {
		String[] SEASON ={"19961997","19971998","19981999","19992000","20002001","20012002","20022003","20032004","20042005","20052006"
				,"20062007","20072008","20082009","20092010","20102011","20112012","20122013","20132014","20142015"};
		Statement stat = null;
		ResultSet rs = null;
		ArrayList<String[]> list = new ArrayList<String[]>();
		try{
			stat = connection.createStatement();
			for(int i = 0;i< SEASON.length;i++){
				rs = stat.executeQuery("select round(1.0*Efficiency/NumOfMatch,2) from Player"+SEASON[i]+"Season where PlayerName = '"+playerName+"'");
				if(rs.next()){
					String[] tempList = new String[2];
					tempList[0] = SEASON[i];
					tempList[1] = rs.getString(1);
					list.add(tempList);
				}
			}
			stat.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		String[][] result = new String[list.size()][2];
		for(int i = 0;i<list.size();i++){
			System.out.println(Arrays.asList(list.get(i)));
			for(int j =0;j<2;j++){
				result[i][j] = list.get(i)[j];
			}
		}
		return result;
	}

	@Override
	public String[] getLeagueInfo() {
		String[] result = new String[5];
		Statement stat = null;
		ResultSet rs = null;
		String currentSeason = SEASON[SEASON.length-1];
		
		try{
			stat = connection.createStatement();
			rs = stat.executeQuery("select round(1.0*sum(Score)/sum(NumOfMatch),1),"
					+ "round(1.0*sum(Rebounds)/sum(NumOfMatch),1),round(1.0*sum(Assists)/sum(NumOfMatch),1),"
					+ "FreeThrowPersentage,ThreePointPersentage "
					+ "from Team"+currentSeason+"Season");
			for(int i = 0;i< 5;i++){
				result[i] = rs.getString(i+1);
			}
			stat.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(Arrays.asList(result));
		return result;
	}

	@Override
	public String[][] getTeamPlayerEfficiency(String teamAbb) {
		ArrayList<String[]> list = new ArrayList<String[]>();
		Statement stat = null;
		ResultSet rs = null;
		String currentSeason = SEASON[SEASON.length-1];
		
		try{
			stat = connection.createStatement();
			rs = stat.executeQuery("select Name,Efficiency "
					+ "from Player T1,Player"+currentSeason+"Season T2 "
					+ "where T1.Name=T2.PlayerName and T1.TeamAbb = 'LAL' and Efficiency>0; ");
			while(rs.next()){
				String[] tempList = new String[2];
				for(int i =0;i<2;i++){
					tempList[i] = rs.getString(i+1);
				}
				list.add(tempList);
			}
			stat.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		String[][] result  = new String[list.size()][2];
		for(int i =0;i<list.size();i++){
			System.out.println(Arrays.asList(list.get(i)));
			for(int j=0;j<2;j++){
				result[i][j] = list.get(i)[j];
			}
		}
		return result;
	}

	@Override
	public String[][] getPlayerScoreAtPosition() {
		String currentSeason = SEASON[SEASON.length-1];
		ArrayList<String[]> resultArrayList = new ArrayList<String[]>();
		Statement stat = null;
		ResultSet rs = null;
		try{
			stat = connection.createStatement();
			rs = stat.executeQuery("select round(1.0*Score/NumOfMatch,2)"
					+ " from Player"+currentSeason+"Season,Player  where Name = PlayerName and Pos like '%前锋%' and NumOfMatch<>'0' limit 30");
			String[] tempList = new String[30];
			for(int i =0;i<30;i++){
				rs.next();
				tempList[i] =rs.getString(1);
			}
			resultArrayList.add(tempList);
			
			rs = stat.executeQuery("select round(1.0*Score/NumOfMatch,2)"
					+ " from Player"+currentSeason+"Season,Player where Name = PlayerName and  Pos like '%中锋%' and NumOfMatch<>'0' limit 30");
			tempList = new String[30];
			for(int i =0;i<30;i++){
				rs.next();
				tempList[i] =rs.getString(1);
			}
			resultArrayList.add(tempList);
			
			rs = stat.executeQuery("select round(1.0*Score/NumOfMatch,2)"
					+ " from Player"+currentSeason+"Season,Player where Name = PlayerName and  Pos like '%后卫%' and NumOfMatch<>'0' limit 30");
			tempList = new String[30];
			for(int i =0;i<30;i++){
				rs.next();
				tempList[i] =rs.getString(1);
			}
			resultArrayList.add(tempList);
			
			stat.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		String[][] result = new String[30][3];
		for(int i=0;i<resultArrayList.size();i++){
			System.out.println(Arrays.asList(resultArrayList.get(i)));
		}
		for(int i =0;i<30;i++){
			for(int j=0;j<3;j++){
				result[i][j] = resultArrayList.get(j)[i];
				}
		}
		return result;
	}

	@Override
	public String[][] getTeamRate() {
		String currentSeason = SEASON[SEASON.length-1];
		ArrayList<String[]> resultArrayList = new ArrayList<String[]>();
		Statement stat = null;
		ResultSet rs = null;
		try{
			stat = connection.createStatement();
			rs = stat.executeQuery("select TeamAbb,ShootingPersentage,FreeThrowPersentage,round(1.0*Rebounds/NumOfMatch,2),WinRate"
					+ " from Team"+currentSeason+"Season");
			while(rs.next()){
				String[] tempList = new String[5];
				for(int i =0;i<5;i++){
					tempList[i] = rs.getString(i+1);
				}
				resultArrayList.add(tempList);
			}
			stat.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		String[][] result = new String[resultArrayList.size()][5];
		for(int i =0;i<resultArrayList.size();i++){
			System.out.println(Arrays.asList(resultArrayList.get(i)));
			for(int j=0;j<5;j++){
				result[i][j] = resultArrayList.get(i)[j];
				}
		}
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

	public static void main(String[] args){
		ChartDaoJdbcImp c = new ChartDaoJdbcImp();
		//c.getTeamRate();
		//c.getPlayerScoreAtPosition();
		//c.getLeagueInfo();
		//c.getTeamPlayerEfficiency("LAC");
		c.getPlayerEfficiency("Kobe Bryant");
		//c.getPlayerLeagueInfo();
	}

	@Override
	public String[] getPlayerLeagueInfo() {
		// TODO Auto-generated method stub
		String[] result = new String[5];
		Statement stat = null;
		ResultSet rs = null;
		String currentSeason = SEASON[SEASON.length-1];
		
		try{
			stat = connection.createStatement();
			rs = stat.executeQuery("select round(1.0*sum(Score)/sum(NumOfMatch)/15,1),"
					+ "round(1.0*sum(Rebounds)/sum(NumOfMatch)/15,1),round(1.0*sum(Assists)/sum(NumOfMatch)/15,1),"
					+ "FreeThrowPersentage/10,ThreePointPersentage/10 "
					+ "from Team"+currentSeason+"Season");
			for(int i = 0;i< 5;i++){
				result[i] = rs.getString(i+1);
			}
			stat.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(Arrays.asList(result));
		return result;
	}
	
	public String[][] getPlayerCareerInfo(){
		String[] SEASON ={"19961997","19971998","19981999","19992000","20002001","20012002","20022003","20032004","20042005","20052006"
				,"20062007","20072008","20082009","20092010","20102011","20112012","20122013","20132014","20142015"};
		Statement stat = null;
		ResultSet rs = null;
		ArrayList<String[]> list = new ArrayList<String[]>();
		try{
			stat = connection.createStatement();
			for(int i = 0;i< SEASON.length;i++){
				rs = stat.executeQuery("select Efficiency from Player"+SEASON[i]+"Season where PlayerName = '"+"'");
				if(rs.next()){
					String[] tempList = new String[2];
					tempList[0] = SEASON[i];
					tempList[1] = rs.getString(1);
					list.add(tempList);
				}
			}
			stat.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		String[][] result = new String[list.size()][2];
		for(int i = 0;i<list.size();i++){
			System.out.println(Arrays.asList(list.get(i)));
			for(int j =0;j<2;j++){
				result[i][j] = list.get(i)[j];
			}
		}
		return result;
	}
	
}
