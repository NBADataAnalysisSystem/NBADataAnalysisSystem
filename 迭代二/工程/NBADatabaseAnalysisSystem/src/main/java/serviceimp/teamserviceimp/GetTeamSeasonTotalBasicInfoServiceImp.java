package serviceimp.teamserviceimp;

import java.util.ArrayList;

import serviceimp.playerserviceimp.MappingTable;
import serviceimp.playerserviceimp.PlayerSeasonTotalInfoMappingTable;
import dao.playerdao.PlayerDao;
import dao.playerdao.PlayerDaoJdbcImp;
import dao.teamdao.TeamDao;
import dao.teamdao.TeamDaoJdbcImp;

public class GetTeamSeasonTotalBasicInfoServiceImp {
	
	public ArrayList<String[]> getPlayer(String[] sift) {
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
