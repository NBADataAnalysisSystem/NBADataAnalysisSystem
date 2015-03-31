package dao.teamdao;

import java.util.ArrayList;
import java.util.Map;

import entity.TeamInfo;

public interface TeamDao {

	public ArrayList<Map<TeamInfo, String>> getTeam(ArrayList<TeamInfo> columnList) throws Exception;
	public void close() throws Exception;
	
}