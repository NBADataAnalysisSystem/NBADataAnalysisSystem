package serviceimp.playerserviceimp;

import java.util.ArrayList;
import java.util.Map;

import dao.playerdao.PlayerDao;
import dao.playerdao.PlayerDaoJdbcImp;
import dao.playerdao.PlayerInfoType;
import entity.PlayerEntity;
import service.playerservice.GetPlayerService;

public class GetPlayerServiceImp implements GetPlayerService {

	public ArrayList<Map<PlayerEntity, String>> getPlayer(
			PlayerInfoType type) {
		PlayerDao dao = new PlayerDaoJdbcImp();
		try {
			return dao.getPlayerInfo(type);
		} finally {
			dao.close();
		}
	}

}
