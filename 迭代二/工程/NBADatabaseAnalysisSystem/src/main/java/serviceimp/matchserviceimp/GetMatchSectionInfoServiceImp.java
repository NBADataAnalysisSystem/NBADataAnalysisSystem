package serviceimp.matchserviceimp;

import java.util.ArrayList;

import dao.matchdao.MatchDaoJdbcImp;
import service.matchservice.GetMatchSectionInfoService;
import serviceimp.MappingTable;

public class GetMatchSectionInfoServiceImp implements GetMatchSectionInfoService {

	public ArrayList<String[]> getMatch(String[] sift) {
		MatchDaoJdbcImp dao = new MatchDaoJdbcImp();
		try {
			MappingTable mappingTable = new MatchMappingTable();
			sift[0] = mappingTable.get(sift[0]);
			return dao.getMatchSectionInfoV2(sift);
		} finally {
			dao.close();
		}
	}

}
