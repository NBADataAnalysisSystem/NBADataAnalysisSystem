package dao.playerdao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import entity.PlayerEntity;
import entity.PlayerInfoType;

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

	public ArrayList<Map<PlayerEntity, String>> getPlayerInfo(PlayerInfoType type) {
		switch (type) {
		case PLAYER_BASIC_INFO:
			return getPlayerBasicInfo();
		case PLAYER_SEASON_TOTAL_INFO:
			return getPlayerSeasonTotalInfo();
		case PLAYER_SEASON_AVG_INFO:
			return getPlayerSeasonAvgInfo();
		default:
			return null;
		}
	}
    
	private ArrayList<Map<PlayerEntity, String>> getPlayerBasicInfo() {
		ArrayList<PlayerEntity> columnList = new ArrayList<PlayerEntity>();
		columnList.add(PlayerEntity.ID);
		columnList.add(PlayerEntity.PLAYER_NAME);
		columnList.add(PlayerEntity.JERSEY_NUMBER);
		columnList.add(PlayerEntity.POSITION);
		columnList.add(PlayerEntity.HEIGHT);
		columnList.add(PlayerEntity.WEIGHT);
		columnList.add(PlayerEntity.BIRTH);
		columnList.add(PlayerEntity.AGE);
		columnList.add(PlayerEntity.EXP);
		columnList.add(PlayerEntity.SCHOOL);
		columnList.add(PlayerEntity.TEAM);
		String columnsToSearch = "";
		PlayerEnumToField translation = new PlayerEnumToField();
		ArrayList<String> columnStrList = new ArrayList<String>();
		for (PlayerEntity playerEntity:columnList) {
			String temp = translation.translate(playerEntity);
			columnsToSearch = columnsToSearch + temp + ",";
			columnStrList.add(temp);
		}
		columnsToSearch = columnsToSearch.substring(0, columnsToSearch.length()-1);
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Map<PlayerEntity, String>> result = new ArrayList<Map<PlayerEntity, String>>();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(
					"SELECT " + columnsToSearch + " FROM players");
			while (resultSet.next()) {
				Map<PlayerEntity, String> map = new HashMap<PlayerEntity, String>();
				for (String string:columnStrList) {
					map.put(translation.reverseTranslate(string), resultSet.getString(string));
				}
				result.add(map);
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("SQL错误");
			e.printStackTrace();
		}
		return result;
	}

	//获取球员赛季数据-总数
	private ArrayList<Map<PlayerEntity, String>> getPlayerSeasonTotalInfo() {
		ArrayList<PlayerEntity> columnList = new ArrayList<PlayerEntity>();
		columnList.add(PlayerEntity.ID);
		columnList.add(PlayerEntity.PLAYER_NAME);
		columnList.add(PlayerEntity.TEAM);
		columnList.add(PlayerEntity.NUM_OF_MATCH);
		columnList.add(PlayerEntity.NUM_OF_START);
		columnList.add(PlayerEntity.REBOUNDS);
		columnList.add(PlayerEntity.ASSISTS);
		columnList.add(PlayerEntity.PRESENCE_TIME);
		columnList.add(PlayerEntity.SHOOTING_PERSENTAGE);
		columnList.add(PlayerEntity.THREE_POINT_SHOOTING_PERSENTAGE);
		columnList.add(PlayerEntity.FREE_THROW_SHOOTING_PERSENTAGE);
		columnList.add(PlayerEntity.OFFENCES);
		columnList.add(PlayerEntity.DEFENCES);
		columnList.add(PlayerEntity.STEALS);
		columnList.add(PlayerEntity.BLOCK_SHOTS);
		columnList.add(PlayerEntity.TURN_OVERS);
		columnList.add(PlayerEntity.FOULS);
		columnList.add(PlayerEntity.SCORE);
		//columnList是所有需要查找的属性构成的数组
		String columnsToSearch = "";
		PlayerEnumToField translation = new PlayerEnumToField();
		ArrayList<String> columnStrList = new ArrayList<String>();
		for (PlayerEntity playerEntity:columnList) {
			String temp = translation.translate(playerEntity);
			columnsToSearch = columnsToSearch + temp + ",";
			columnStrList.add(temp);
		}
		columnsToSearch = columnsToSearch.substring(0, columnsToSearch.length()-1);
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Map<PlayerEntity, String>> result = new ArrayList<Map<PlayerEntity, String>>();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(
					"SELECT " + columnsToSearch + " FROM players");
			while (resultSet.next()) {
				Map<PlayerEntity, String> map = new HashMap<PlayerEntity, String>();
				for (String string:columnStrList) {
					map.put(translation.reverseTranslate(string), resultSet.getString(string));
				}
				result.add(map);
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("SQL错误");
			e.printStackTrace();
		}
		return result;
	}
	
	//获取球员赛季数据-场均
	private ArrayList<Map<PlayerEntity, String>> getPlayerSeasonAvgInfo() {
		ArrayList<PlayerEntity> columnList = new ArrayList<PlayerEntity>();
		columnList.add(PlayerEntity.ID);
		columnList.add(PlayerEntity.PLAYER_NAME);
		columnList.add(PlayerEntity.TEAM);
		columnList.add(PlayerEntity.NUM_OF_MATCH);
		columnList.add(PlayerEntity.NUM_OF_START);
		columnList.add(PlayerEntity.AVE_REBOUNDS);
		columnList.add(PlayerEntity.AVE_ASSISTS);
		columnList.add(PlayerEntity.AVE_PRESENCE_TIME);
		columnList.add(PlayerEntity.EFFICIENCY);
		columnList.add(PlayerEntity.SHOOTING_PERSENTAGE);
		columnList.add(PlayerEntity.THREE_POINT_SHOOTING_PERSENTAGE);
		columnList.add(PlayerEntity.FREE_THROW_SHOOTING_PERSENTAGE);
		columnList.add(PlayerEntity.AVE_OFFENCES);
		columnList.add(PlayerEntity.AVE_DEFENCES);
		columnList.add(PlayerEntity.AVE_STEALS);
		columnList.add(PlayerEntity.AVE_BLOCK_SHOTS);
		columnList.add(PlayerEntity.AVE_TURN_OVERS);
		columnList.add(PlayerEntity.AVE_FOULS);
		columnList.add(PlayerEntity.AVE_SCORE);
		//columnList是所有需要查找的属性构成的数组
		String columnsToSearch = "";
		PlayerEnumToField translation = new PlayerEnumToField();
		ArrayList<String> columnStrList = new ArrayList<String>();
		for (PlayerEntity playerEntity:columnList) {
			String temp = translation.translate(playerEntity);
			columnsToSearch = columnsToSearch + temp + ",";
			columnStrList.add(temp);
		}
		columnsToSearch = columnsToSearch.substring(0, columnsToSearch.length()-1);
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Map<PlayerEntity, String>> result = new ArrayList<Map<PlayerEntity, String>>();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(
					"SELECT " + columnsToSearch + " FROM players");
			while (resultSet.next()) {
				Map<PlayerEntity, String> map = new HashMap<PlayerEntity, String>();
				for (String string:columnStrList) {
					map.put(translation.reverseTranslate(string), resultSet.getString(string));
				}
				result.add(map);
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
