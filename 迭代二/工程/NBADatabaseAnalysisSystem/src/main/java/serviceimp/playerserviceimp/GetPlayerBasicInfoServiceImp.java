package serviceimp.playerserviceimp;

import java.util.ArrayList;

import dao.playerdao.PlayerDao;
import dao.playerdao.PlayerDaoJdbcImp;
import service.playerservice.GetPlayerBasicInfoService;
import serviceimp.MappingTable;

public class GetPlayerBasicInfoServiceImp implements GetPlayerBasicInfoService {

	public ArrayList<String[]> getPlayer(String[] sift) {
		PlayerDao dao = new PlayerDaoJdbcImp();
		try {
			MappingTable mappingTable = new PlayerSeasonTotalInfoMappingTable();
			sift[2] = mappingTable.get(sift[2]);
			return dao.getPlayerBasicInfo(sift);
		} finally {
			dao.close();
		}
	}

}
