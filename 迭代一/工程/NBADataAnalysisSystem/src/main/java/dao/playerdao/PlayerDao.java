package dao.playerdao;

import java.sql.SQLException;

import entity.player.Player;

public interface PlayerDao {

	Player getPlayerById(String id) throws SQLException;
	
}
