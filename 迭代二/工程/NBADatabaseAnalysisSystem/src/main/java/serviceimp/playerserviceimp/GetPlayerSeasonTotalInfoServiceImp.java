package serviceimp.playerserviceimp;

import java.util.ArrayList;

import dao.playerdao.PlayerDao;
import dao.playerdao.PlayerDaoJdbcImpV2;
import service.playerservice.GetPlayerSeasonTotalInfoService;
import serviceimp.MappingTable;

public class GetPlayerSeasonTotalInfoServiceImp implements GetPlayerSeasonTotalInfoService {

	public ArrayList<String[]> getPlayer(String[] sift) {
		PlayerDao dao = new PlayerDaoJdbcImpV2();
		try {
			MappingTable mappingTable = new PlayerSeasonTotalInfoMappingTable();
			if (sift[0] == null) {
				sift[0] = "";
			}
			sift[0] = mappingTable.get(sift[0]);
			if (sift[1] == null) {
				sift[1] = "";
			}
			sift[1] = mappingTable.get(sift[1]);
			sift[2] = mappingTable.get(sift[2]);
			sift[3] = mappingTable.get(sift[3]);
			return dao.getPlayerSeasonTotalInfo(sift);
		} finally {
			dao.close();
		}
	}

}

