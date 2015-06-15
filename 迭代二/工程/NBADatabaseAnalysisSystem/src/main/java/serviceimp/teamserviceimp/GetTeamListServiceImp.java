package serviceimp.teamserviceimp;

import java.util.ArrayList;

import dao.teamdao.TeamDao;
import dao.teamdao.TeamDaoJdbcImpV2;
import service.teamservice.GetTeamListService;

public class GetTeamListServiceImp implements GetTeamListService {

	public ArrayList<String[]> getTeam() {
		TeamDao dao = new TeamDaoJdbcImpV2();
		try {
			return dao.getTeamList();
		} finally {
			dao.close();
		}
	}

}
