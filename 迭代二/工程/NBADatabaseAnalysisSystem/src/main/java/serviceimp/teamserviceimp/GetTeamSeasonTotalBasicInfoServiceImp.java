package serviceimp.teamserviceimp;

import java.util.ArrayList;

import service.teamservice.GetTeamSeasonTotalBasicInfoService;
import serviceimp.MappingTable;
import dao.teamdao.TeamDao;
import dao.teamdao.TeamDaoJdbcImpV2;

public class GetTeamSeasonTotalBasicInfoServiceImp implements GetTeamSeasonTotalBasicInfoService {
	
	public ArrayList<String[]> getTeam(String[] sift) {
		TeamDao dao = new TeamDaoJdbcImpV2();
		try {
			MappingTable mappingTable = new TeamSeasonInfoMappingTable();
			sift[0] = mappingTable.get(sift[0]);
			sift[1] = mappingTable.get(sift[1]);
			if (sift[0] == null) {
				sift[0] = "20142015";
			}
			if (sift[1] == null) {
				sift[1] = "";
			}
			return dao.getTeamSeasonTotalBasicInfo(sift);
		} finally {
			dao.close();
		}
	}

}
