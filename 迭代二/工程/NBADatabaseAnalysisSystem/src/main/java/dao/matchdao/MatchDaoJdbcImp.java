package dao.matchdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.teamdao.TeamDaoJdbcImp;

public class MatchDaoJdbcImp {
	
	private Connection connection;
	
	public MatchDaoJdbcImp() {
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
	
	public ArrayList<String[]>getMatchSectionInfo(String[] sift){
		String condition="";
		ArrayList<String[]> result = new ArrayList<String[]>();
		if(sift[0] != null){
			condition +=" and m.season='"+sift[0]+"' ";
		}
		if(sift[1] != null){
			condition+="and m.date_of_match='"+sift[1]+"' ";
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
			rs = stat.executeQuery("select t1.abbreviation,t2.abbreviation,m.hscore_of_first_section,m.ascore_of_first_section, "+
																"m.hscore_of_second_section,m.ascore_of_second_section,m.hscore_of_third_section,m.ascore_of_third_section, "+
																"m.hscore_of_fourth_section,m.ascore_of_fourth_section,m.hscore,m.ascore "+
													"from matches m,teams t1,teams t2 "+
													"where t1.id = m.home_court_team_id and t2.id=m.away_team_id "+condition);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("执行Statement 错误！");
		}
		
		try {
			while(rs.next()){
				String[] strList = new String[12];
				for(int i = 0 ;i < 12;i ++){
					strList[i] = rs.getString(i+1);
				}
				result.add(strList);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i = 0 ;i < result.size();i ++){
			for(int j = 0 ;j < 12;j ++){
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
		MatchDaoJdbcImp t = new MatchDaoJdbcImp();
		String[] strList = new String[2];
		strList[0] ="13-14";
		strList[1] = "01-02";
		t.getMatchSectionInfo(strList);
	}

}
