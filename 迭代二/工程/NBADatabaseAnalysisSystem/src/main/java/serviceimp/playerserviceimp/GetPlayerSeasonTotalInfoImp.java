package serviceimp.playerserviceimp;

import java.util.ArrayList;

import dao.playerdao.PlayerDao;
import dao.playerdao.PlayerDaoJdbcImp;
import service.playerservice.GetPlayerSeasonTotalInfoService;

public class GetPlayerSeasonTotalInfoImp implements GetPlayerSeasonTotalInfoService {

	public ArrayList<String> getPlayer(String[] sift) {
		PlayerDao dao = new PlayerDaoJdbcImp();
		try {
			return dao.getPlayerSeasonTotalInfo(sift);
		} finally {
			dao.close();
		}
	}

}

