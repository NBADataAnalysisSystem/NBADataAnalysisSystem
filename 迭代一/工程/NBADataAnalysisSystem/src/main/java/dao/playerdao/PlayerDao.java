package dao.playerdao;

import java.util.ArrayList;
import java.util.Map;

import entity.SortType;
import entity.player.PlayerInfo;

public interface PlayerDao {

	public ArrayList<Map<PlayerInfo, String>> getPlayer(ArrayList<PlayerInfo> columnList, SortType sortType, PlayerInfo sortBy) throws Exception;
	public void close() throws Exception;
	
}
