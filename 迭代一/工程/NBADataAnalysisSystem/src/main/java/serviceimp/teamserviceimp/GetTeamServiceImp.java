package serviceimp.teamserviceimp;

import java.util.ArrayList;
import java.util.Map;

import dao.teamdao.TeamDao;
import dao.teamdao.TeamDaoJdbcImp;
import entity.TeamInfo;
import service.teamservice.GetTeamService;

public class GetTeamServiceImp implements GetTeamService {

	public ArrayList<Map<TeamInfo, String>> getTeam(
			ArrayList<TeamInfo> columnList) throws Exception {
		TeamDao dao = new TeamDaoJdbcImp();
		try {
			return dao.getTeam(columnList);
		} finally {
			dao.close();
		}
	}

}
