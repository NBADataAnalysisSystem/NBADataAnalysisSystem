package service.hotservice;

import java.util.ArrayList;

public interface GetHotInfoService {

	public  ArrayList<String[]> getCurrentHotPlayerInfo(String sift);
	public ArrayList<String[]> getSeasonHotPlayerInfo(String sift);
	public ArrayList<String[]> getSeasonHotTeamInfo (String sift);
	public ArrayList<String[]> getHotPlayer(String sift);
	public void close();
	
}
