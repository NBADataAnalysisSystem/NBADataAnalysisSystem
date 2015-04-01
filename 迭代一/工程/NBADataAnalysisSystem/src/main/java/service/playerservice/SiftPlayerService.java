package service.playerservice;

import java.util.ArrayList;
import java.util.Map;

import entity.PlayerInfo;
import entity.SiftingOfOth;
import entity.SiftingOfPosition;
import entity.SiftingOfUnion;

public interface SiftPlayerService {

	public ArrayList<Map<PlayerInfo, String>> siftPlayer(ArrayList<PlayerInfo> columnList, SiftingOfPosition position, SiftingOfUnion union, SiftingOfOth sortBy) throws Exception;
	
}
