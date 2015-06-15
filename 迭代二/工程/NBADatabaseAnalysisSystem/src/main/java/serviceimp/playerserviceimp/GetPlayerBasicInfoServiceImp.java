package serviceimp.playerserviceimp;

import java.util.ArrayList;

import dao.playerdao.PlayerDao;
import dao.playerdao.PlayerDaoJdbcImpV2;
import service.playerservice.GetPlayerBasicInfoService;
import serviceimp.MappingTable;

public class GetPlayerBasicInfoServiceImp implements GetPlayerBasicInfoService {

	public ArrayList<String[]> getPlayer(String[] sift) {
		PlayerDao dao = new PlayerDaoJdbcImpV2();
		try {
			MappingTable mappingTable = new PlayerSeasonTotalInfoMappingTable();
			if (sift[0] == null) {
				sift[0] = "";
			}
			if (sift[1] == null) {
				sift[1] = "";
			}
			if (sift[2] == null) {
				sift[2] = "";
			} else {
				sift[2] = mappingTable.get(sift[2]);
			}
			return dao.getPlayerBasicInfo(sift);
		} finally {
			dao.close();
		}
	}

}
