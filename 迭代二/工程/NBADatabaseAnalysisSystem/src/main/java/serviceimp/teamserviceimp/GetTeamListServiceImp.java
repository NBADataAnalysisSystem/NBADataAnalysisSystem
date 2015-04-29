package serviceimp.teamserviceimp;

import java.util.ArrayList;

import dao.teamdao.TeamDao;
import dao.teamdao.TeamDaoJdbcImp;
import service.teamservice.GetTeamListService;

public class GetTeamListServiceImp implements GetTeamListService {

	public ArrayList<String[]> getTeam() {
		TeamDao dao = new TeamDaoJdbcImp();
		try {
			return dao.getTeamList();
		} finally {
			dao.close();
		}
	}

}
