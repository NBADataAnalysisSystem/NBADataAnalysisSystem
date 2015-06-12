package serviceimp.matchserviceimp;

import java.util.ArrayList;

import dao.matchdao.MatchDao;
import dao.matchdao.MatchDaoJdbcImpV2;
import service.matchservice.GetMatchSectionInfoService;
import serviceimp.MappingTable;

public class GetMatchSectionInfoServiceImp implements GetMatchSectionInfoService {

	public ArrayList<String[]> getMatch(String[] sift) {
		MatchDao dao = new MatchDaoJdbcImpV2();
		try {
			MappingTable mappingTable = new MatchMappingTable();
			sift[0] = mappingTable.get(sift[0]);
			return dao.getMatchSectionInfo(sift);
		} finally {
			dao.close();
		}
	}

}
