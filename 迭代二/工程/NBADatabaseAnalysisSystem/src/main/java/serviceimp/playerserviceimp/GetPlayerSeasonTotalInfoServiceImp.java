package serviceimp.playerserviceimp;

import java.util.ArrayList;

import dao.playerdao.PlayerDao;
import dao.playerdao.PlayerDaoJdbcImp;
import service.playerservice.GetPlayerSeasonTotalInfoService;

public class GetPlayerSeasonTotalInfoServiceImp implements GetPlayerSeasonTotalInfoService {

	public ArrayList<String[]> getPlayer(String[] sift) {
		PlayerDao dao = new PlayerDaoJdbcImp();
		try {
			MappingTable mappingTable = new PlayerSeasonTotalInfoMappingTable();
			sift[0] = mappingTable.get(sift[0]);
			sift[1] = mappingTable.get(sift[1]);
			sift[2] = mappingTable.get(sift[2]);
			sift[3] = mappingTable.get(sift[3]);
			return dao.getPlayerSeasonTotalInfo(sift);
		} finally {
			dao.close();
		}
	}

}

