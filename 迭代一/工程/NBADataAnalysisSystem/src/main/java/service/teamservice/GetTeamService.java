package service.teamservice;

import java.util.ArrayList;
import java.util.Map;

import entity.team.TeamInfo;

public interface GetTeamService {

	public ArrayList<Map<TeamInfo, String>> getTeam(ArrayList<TeamInfo> columnList) throws Exception;
	
}
