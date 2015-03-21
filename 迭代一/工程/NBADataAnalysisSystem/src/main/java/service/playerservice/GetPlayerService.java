package service.playerservice;

import java.util.ArrayList;
import java.util.Map;

import entity.player.PlayerInfo;

public interface GetPlayerService {

	public ArrayList<Map<PlayerInfo, String>> getPlayer(ArrayList<PlayerInfo> columnList) throws Exception;
	
}
