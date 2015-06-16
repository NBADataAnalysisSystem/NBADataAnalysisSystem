package dao.hotdao;

import java.util.ArrayList;

public interface HotDao {
	
	public  ArrayList<String[]> getCurrentKingPlayerInfo(String sift);
	public ArrayList<String[]> getSeasonHotPlayerInfo(String sift);
	public ArrayList<String[]> getSeasonHotTeamInfo (String sift);
	public ArrayList<String[]> getSeasonHotPlayer(String sift);
	public void close();
	
}
