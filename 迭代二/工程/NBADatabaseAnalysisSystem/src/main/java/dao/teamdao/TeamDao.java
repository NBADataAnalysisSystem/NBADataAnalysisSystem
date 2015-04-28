package dao.teamdao;

import java.util.ArrayList;

public interface TeamDao {

	public ArrayList<String[]> getTeamSeasonTotalBasicInfo(String[] sift);
	public ArrayList<String[]> getTeamSeasonAvgBasicInfo(String[] sift);
	public ArrayList<String[]> getTeamSeasonRateInfo(String[] sift);
	public ArrayList<String[]> getTeamSeasonEffInfo(String[] sift);
	public ArrayList<String> getTeamList();
	public void close();
	
}
