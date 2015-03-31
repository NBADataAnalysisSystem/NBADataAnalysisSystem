package serviceimp.teamserviceimp;

import java.util.ArrayList;
import java.util.Map;

import dao.teamdao.TeamDao;
import dao.teamdao.TeamDaoJdbcImp;
import entity.SortType;
import entity.TeamInfo;
import service.teamservice.GetTeamService;

public class GetTeamServiceImp implements GetTeamService {

	public ArrayList<Map<TeamInfo, String>> getTeam(
			ArrayList<TeamInfo> columnList, SortType sortType, TeamInfo sortBy) throws Exception {
		TeamDao dao = new TeamDaoJdbcImp();
		try {
			return dao.getTeam(columnList, sortType, sortBy);
		} finally {
			dao.close();
		}
	}

}
