package dao.playerdao;

import java.util.ArrayList;

public interface PlayerDao {

	public ArrayList<String[]> getPlayerBasicInfo(String[] sift);
	public ArrayList<String[]> getPlayerSeasonTotalInfo(String[] sift);
	public ArrayList<String[]> getPlayerSeasonAvgInfo(String[] sift);
	public ArrayList<String> getTeamList();
	public void close();
	
}
