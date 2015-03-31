package service.teamservice;

import java.util.ArrayList;
import java.util.Map;

import entity.SortType;
import entity.TeamInfo;

public interface GetTeamService {

	public ArrayList<Map<TeamInfo, String>> getTeam(ArrayList<TeamInfo> columnList, SortType sortType, TeamInfo sortBy) throws Exception;
	
}
