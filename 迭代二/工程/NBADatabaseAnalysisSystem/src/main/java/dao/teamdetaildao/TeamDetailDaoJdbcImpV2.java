package dao.teamdetaildao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeamDetailDaoJdbcImpV2 implements TeamDetailDao{

	Connection connection = null;
	
	public TeamDetailDaoJdbcImpV2() {
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/cross/Documents/GitHub/NBADataCollector/Database.db");
		} catch (ClassNotFoundException e) {
			System.out.println("没有找到sqlite jdbc");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL错误");
			e.printStackTrace();
		}
	}
	
	@Override
	public String[] getTeamBasicInfo(String teamFullName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String[]> getTeamSeasonAvgInfo(String teamFullName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String[]> getTeamSeasonTotalInfo(String teamFullName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String[]> getTeamPlayerInfo(String teamFullName) {
		// TODO Auto-generated method stub
		return null;
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
