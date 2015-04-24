package dao.playerdao;

import java.util.ArrayList;
import java.util.Map;

import entity.PlayerEntity;

public interface PlayerDao {

	public ArrayList<Map<PlayerEntity, String>> getPlayerBasicInfo();
	public ArrayList<Map<PlayerEntity, String>> getPlayerSeasonTotalInfo();
	public ArrayList<Map<PlayerEntity, String>> getPlayerSeasonAvgInfo();
	public void close();
	
}
