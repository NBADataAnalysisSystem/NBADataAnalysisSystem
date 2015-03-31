package service.playerservice;

import java.util.ArrayList;
import java.util.Map;

import entity.SortType;
import entity.player.PlayerInfo;

public interface GetPlayerService {

	public ArrayList<Map<PlayerInfo, String>> getPlayer(ArrayList<PlayerInfo> columnList, SortType sortType, PlayerInfo sortBy) throws Exception;
}
