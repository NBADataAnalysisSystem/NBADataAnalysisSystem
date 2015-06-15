package serviceimp.teamserviceimp;

import java.util.ArrayList;

import service.teamservice.GetTeamSeasonAvgBasicInfoService;
import serviceimp.MappingTable;
import dao.teamdao.TeamDao;
import dao.teamdao.TeamDaoJdbcImpV2;

public class GetTeamSeasonAvgBasicInfoServiceImp implements GetTeamSeasonAvgBasicInfoService {
	
	public ArrayList<String[]> getTeam(String[] sift){
		TeamDao dao = new TeamDaoJdbcImpV2();
		try {
			MappingTable mappingTable = new TeamSeasonInfoMappingTable();
			sift[0] = mappingTable.get(sift[0]);
			sift[1] = mappingTable.get(sift[1]);
			return dao.getTeamSeasonAvgBasicInfo(sift);
		} finally {
			dao.close();
		}
	}

}
