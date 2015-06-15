package dao.matchdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MatchDaoJdbcImpV2 implements MatchDao{
	Connection connection =null;
	
	public MatchDaoJdbcImpV2() {
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
	public ArrayList<String[]> getMatchSectionInfo(String[] sift) {
		ResultSet rs =null;
		ArrayList<String[]> result = new ArrayList<String[]>();
		Statement stat = null;
		String path ="";
		try{
			stat = connection.createStatement();
			rs=stat.executeQuery("select AbsolutePath from Path where Category='Team'");
			rs.next();
			path=rs.getString(1);
			rs = stat.executeQuery("select HomeCourtTeamAbb,HomeScore1,HomeScore2,HomeScore3,HomeScore4,HomeScore,HomeCourtTeamAbb,Overtime,"
					+ "AwayTeamAbb,AwayScore1,AwayScore2,AwayScore3,AwayScore4,AwayScore,AwayTeamAbb,Overtime from Match"+sift[0]+"Season where DateOfMatch='"+sift[1]+"'");
			while (rs.next()){
				String[] strList = new String[16];
				for(int i =0 ;i <16;i++){
					strList[i]=rs.getString(i+1);
				}
				strList[6]=path+strList[6]+".png";
				strList[14]=path+strList[14]+".png";
				result.add(strList);
			}
			stat.close();
		}catch (Exception e){
			e.printStackTrace();
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
	

}
