package dao.playerdao;

import java.util.ArrayList;
import java.util.Map;

import entity.PlayerInfo;
import entity.SiftingOfOth;
import entity.SiftingOfPosition;
import entity.SiftingOfUnion;
import entity.SortType;

public interface PlayerDao {

	public ArrayList<Map<PlayerInfo, String>> getPlayer(ArrayList<PlayerInfo> columnList, SortType sortType, PlayerInfo sortBy) throws Exception;
	public ArrayList<Map<PlayerInfo, String>> siftPlayer(ArrayList<PlayerInfo> columnList, SiftingOfPosition position, SiftingOfUnion union, SiftingOfOth sortBy) throws Exception;
	public void close() throws Exception;
	
}
