package serviceimp.playerserviceimp;

import java.util.ArrayList;
import java.util.Map;

import dao.playerdao.PlayerDao;
import dao.playerdao.PlayerDaoJdbcImp;
import entity.PlayerEntity;
import service.playerservice.GetPlayerService;

public class GetPlayerServiceImp implements GetPlayerService {

	public ArrayList<Map<PlayerEntity, String>> getPlayer(
			ArrayList<PlayerEntity> columnList) {
		PlayerDao dao = new PlayerDaoJdbcImp();
		try {
			return dao.getPlayer(columnList);
		} finally {
			dao.close();
		}
	}

}
