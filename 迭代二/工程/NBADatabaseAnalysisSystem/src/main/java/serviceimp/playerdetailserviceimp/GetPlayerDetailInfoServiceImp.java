package serviceimp.playerdetailserviceimp;

import dao.playerdetaildao.PlayerDetailDao;
import dao.playerdetaildao.PlayerDetailDaoJdbcImpV2;
import service.playerdetailservice.GetPlayerDetailInfoService;

public class GetPlayerDetailInfoServiceImp implements GetPlayerDetailInfoService {

	PlayerDetailDao dao;
	
	public GetPlayerDetailInfoServiceImp() {
		dao = new PlayerDetailDaoJdbcImpV2();
	}
	
	public String[][] getPlayerSeasonInfo(String playerName) {
		return dao.getPlayerSeasonInfo(playerName);
	}

	public String[][] getPlayerLatestFiveMatchInfo(String playerName) {
		return dao.getPlayerLatestFiveMatchInfo(playerName);
	}

	public String[] getPlayerBasicInfo(String playerName) {
		return dao.getPlayerBasicInfo(playerName);
	}
	
	public void close() {
		dao.close();
	}

}
