package dao;

import java.sql.SQLException;

import entity.Player;

public interface PlayerDao {

	Player getPlayerById(String id) throws SQLException;
	
}
