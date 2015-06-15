package serviceimp.playerserviceimp;

import java.util.ArrayList;
import java.util.Arrays;

import service.playerservice.GetPlayerSeasonAvgInfoService;
import serviceimp.MappingTable;
import dao.playerdao.PlayerDao;
import dao.playerdao.PlayerDaoJdbcImpV2;

public class GetPlayerSeasonAvgInfoServiceImp implements GetPlayerSeasonAvgInfoService {

	public ArrayList<String[]> getPlayer(String[] sift) {
		PlayerDao dao = new PlayerDaoJdbcImpV2();
		try {
			MappingTable mappingTable = new PlayerSeasonAvgInfoMappingTable();
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
			System.out.println(Arrays.asList(sift));
			return dao.getPlayerSeasonAvgInfo(sift);
		} finally {
			dao.close();
		}
	}

}
