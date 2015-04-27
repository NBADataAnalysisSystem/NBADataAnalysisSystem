package serviceimp.playerserviceimp;

import java.util.ArrayList;

import dao.playerdao.PlayerDao;
import dao.playerdao.PlayerDaoJdbcImp;
import service.playerservice.GetPlayerBasicInfoService;

public class GetPlayerBasicInfoServiceImp implements GetPlayerBasicInfoService {

	public ArrayList<String[]> getPlayer(String[] sift) {
		PlayerDao dao = new PlayerDaoJdbcImp();
		try {
			if (sift[2] != null) {
				if (sift[2].equals("前锋")) {
					sift[2] = "F";
				} else if (sift[2].equals("中锋")) {
					sift[2] = "C";
				} else if (sift[2].equals("后卫")) {
					sift[2] = "G";
				}
			}
			return dao.getPlayerBasicInfo(sift);
		} finally {
			dao.close();
		}
	}

}
