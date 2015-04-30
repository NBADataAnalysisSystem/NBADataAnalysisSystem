package dao.matchdetaildao;

import java.util.ArrayList;

public interface MatchDetailDao {

	public ArrayList<String[]> getTeamMatchPerformance(String matchID);
	public ArrayList<String[]> getRivalTeamMatchPerformance(String matchID);
	public void close();
	
}
