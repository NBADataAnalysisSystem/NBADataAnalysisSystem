package serviceimp.playerserviceimp;

import java.util.ArrayList;
import java.util.Map;

import dao.playerdao.PlayerDao;
import dao.playerdao.PlayerDaoJdbcImp;
import entity.PlayerInfo;
import entity.SortType;
import service.playerservice.GetPlayerService;

public class GetPlayerServiceImp implements GetPlayerService {

	public ArrayList<Map<PlayerInfo, String>> getPlayer(ArrayList<PlayerInfo> columnList, SortType sortType, PlayerInfo sortBy) throws Exception {
		PlayerDao dao = new PlayerDaoJdbcImp();
		try {
			return dao.getPlayer(columnList, sortType, sortBy);
		} finally {
			dao.close();
		}
	}

}
