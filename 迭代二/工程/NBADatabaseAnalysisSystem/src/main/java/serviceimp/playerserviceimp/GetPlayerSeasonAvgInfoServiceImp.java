package serviceimp.playerserviceimp;

import java.util.ArrayList;

import service.playerservice.GetPlayerSeasonAvgInfoService;
import dao.playerdao.PlayerDao;
import dao.playerdao.PlayerDaoJdbcImp;

public class GetPlayerSeasonAvgInfoServiceImp implements GetPlayerSeasonAvgInfoService {

	public ArrayList<String[]> getPlayer(String[] sift) {
		PlayerDao dao = new PlayerDaoJdbcImp();
		try {
			MappingTable mappingTable = new PlayerSeasonAvgInfoMappingTable();
			sift[0] = mappingTable.get(sift[0]);
			sift[1] = mappingTable.get(sift[1]);
			sift[2] = mappingTable.get(sift[2]);
			sift[3] = mappingTable.get(sift[3]);
			return dao.getPlayerSeasonAvgInfo(sift);
		} finally {
			dao.close();
		}
	}

}
