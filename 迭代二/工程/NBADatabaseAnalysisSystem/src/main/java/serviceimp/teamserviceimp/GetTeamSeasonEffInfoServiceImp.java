package serviceimp.teamserviceimp;

import java.util.ArrayList;

import service.teamservice.GetTeamSeasonEffInfoService;
import serviceimp.MappingTable;
import dao.teamdao.TeamDao;
import dao.teamdao.TeamDaoJdbcImp;

public class GetTeamSeasonEffInfoServiceImp implements GetTeamSeasonEffInfoService {
	public ArrayList<String[]> getTeam(String[] sift){
		TeamDao dao = new TeamDaoJdbcImp();
		try {
			MappingTable mappingTable = new TeamSeasonInfoMappingTable();
			sift[0] = mappingTable.get(sift[0]);
			sift[1] = mappingTable.get(sift[1]);
			return dao.getTeamSeasonEffInfo(sift);
		} finally {
			dao.close();
		}
	}

}
