package service.teamdetailservice;

import java.util.ArrayList;

public interface GetTeamDetailInfoService {

	public String[] getTeamBasicInfo(String teamFullName);
	public ArrayList<String[]> getTeamSeasonAvgInfo(String teamFullName);
	public ArrayList<String[]> getTeamSeasonTotalInfo(String teamFullName);
	public ArrayList<String[]> getTeamPlayerInfo(String teamFullName);
	public void close();
	
}
