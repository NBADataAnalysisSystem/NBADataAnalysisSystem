package serviceimp.teamserviceimp;

import java.util.ArrayList;

import service.teamservice.GetTeamSeasonTotalBasicInfoService;
import serviceimp.MappingTable;
import serviceimp.playerserviceimp.PlayerSeasonTotalInfoMappingTable;
import dao.teamdao.TeamDao;
import dao.teamdao.TeamDaoJdbcImp;

public class GetTeamSeasonTotalBasicInfoServiceImp implements GetTeamSeasonTotalBasicInfoService {
	
	public ArrayList<String[]> getTeam(String[] sift) {
		TeamDao dao = new TeamDaoJdbcImp();
		try {
			MappingTable mappingTable = new PlayerSeasonTotalInfoMappingTable();
			sift[0] = mappingTable.get(sift[0]);
			sift[1] = mappingTable.get(sift[1]);
			return dao.getTeamSeasonTotalBasicInfo(sift);
		} finally {
			dao.close();
		}
	}

}
