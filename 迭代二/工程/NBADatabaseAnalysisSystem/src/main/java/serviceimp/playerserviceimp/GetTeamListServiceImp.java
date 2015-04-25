package serviceimp.playerserviceimp;

import java.util.ArrayList;

import dao.playerdao.PlayerDao;
import dao.playerdao.PlayerDaoJdbcImp;
import service.playerservice.GetTeamListService;

public class GetTeamListServiceImp implements GetTeamListService {

	public ArrayList<String> getTeamList() {
		PlayerDao dao = new PlayerDaoJdbcImp();
		try {
			return dao.getTeamList();
		} finally {
			dao.close();
		}
	}

}
