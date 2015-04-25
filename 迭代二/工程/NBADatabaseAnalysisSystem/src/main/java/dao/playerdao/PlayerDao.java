package dao.playerdao;

import java.util.ArrayList;
import java.util.Map;

import entity.PlayerEntity;

public interface PlayerDao {

	public ArrayList<Map<PlayerEntity, String>> getPlayerBasicInfo(String[] sift);
	public ArrayList<Map<PlayerEntity, String>> getPlayerSeasonTotalInfo(String[] sift);
	public ArrayList<Map<PlayerEntity, String>> getPlayerSeasonAvgInfo(String[] sift);
	public ArrayList<String> getTeamList();
	public void close();
	
}
