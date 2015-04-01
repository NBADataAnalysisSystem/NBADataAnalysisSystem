package serviceimp.playerserviceimp;

import java.util.ArrayList;
import java.util.Map;

import dao.playerdao.PlayerDao;
import dao.playerdao.PlayerDaoJdbcImp;
import entity.PlayerInfo;
import entity.SiftingOfOth;
import entity.SiftingOfPosition;
import entity.SiftingOfUnion;
import service.playerservice.SiftPlayerService;

public class SiftPlayerServiceImp implements SiftPlayerService {

	public ArrayList<Map<PlayerInfo, String>> siftPlayer(
			ArrayList<PlayerInfo> columnList, SiftingOfPosition position,
			SiftingOfUnion union, SiftingOfOth sortBy) throws Exception {
		PlayerDao dao = new PlayerDaoJdbcImp();
		try {
			return dao.siftPlayer(columnList, position, union, sortBy);
		} finally {
			dao.close();
		}
	}

}
