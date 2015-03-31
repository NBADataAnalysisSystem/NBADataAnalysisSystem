package dao.teamdao;

import java.util.ArrayList;
import java.util.Map;

import entity.SortType;
import entity.TeamInfo;

public interface TeamDao {

	public ArrayList<Map<TeamInfo, String>> getTeam(ArrayList<TeamInfo> columnList, SortType sortType, TeamInfo sortBy) throws Exception;
	public void close() throws Exception;
	
}