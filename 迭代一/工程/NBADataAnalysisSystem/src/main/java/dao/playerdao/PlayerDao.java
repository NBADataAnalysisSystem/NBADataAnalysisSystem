package dao.playerdao;

import java.util.ArrayList;
import java.util.Map;

import entity.player.PlayerInfo;

public interface PlayerDao {

	public ArrayList<Map<PlayerInfo, String>> getPlayer(ArrayList<PlayerInfo> columnList) throws Exception;
	public void close() throws Exception;
	
}
