package serviceimp.playerserviceimp;

import java.util.ArrayList;
import java.util.Map;

import dao.playerdao.PlayerDao;
import dao.playerdao.PlayerDaoJdbcImp;
import entity.PlayerEntity;
import service.playerservice.GetPlayerBasicInfoService;

public class GetPlayerBasicInfoServiceImp implements GetPlayerBasicInfoService {

	public ArrayList<Map<PlayerEntity, String>> getPlayer(String[] sift) {
		PlayerDao dao = new PlayerDaoJdbcImp();
		try {
			return dao.getPlayerBasicInfo(sift);
		} finally {
			dao.close();
		}
	}

}
