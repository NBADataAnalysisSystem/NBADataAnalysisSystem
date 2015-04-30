package service.matchdetailservice;

import java.util.ArrayList;

public interface MatchDetailService {

	public ArrayList<String[]> getTeamMatchPerformance(String matchID);
	public ArrayList<String[]> getRivalTeamMatchPerformance(String matchID);
	public void close();
	
}
