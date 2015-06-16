package serviceimp.hotserviceimp;

import java.util.ArrayList;

import dao.hotdao.HotDao;
import dao.hotdao.HotDaoJdbcImp;
import service.hotservice.GetHotInfoService;
import serviceimp.MappingTable;

public class GetHotInfoServiceImp implements GetHotInfoService {

	HotDao dao;
	MappingTable mappingTable;
	
	public GetHotInfoServiceImp() {
		dao = new HotDaoJdbcImp();
	}

	public ArrayList<String[]> getCurrentHotPlayerInfo(String sift) {
		mappingTable = new HotPlayerMappingTable();
		sift = mappingTable.get(sift);
		return dao.getCurrentKingPlayerInfo(sift);
	}

	public ArrayList<String[]> getSeasonHotPlayerInfo(String sift) {
		mappingTable = new HotPlayerMappingTable();
		sift = mappingTable.get(sift);
		return dao.getSeasonHotPlayerInfo(sift);
	}

	public ArrayList<String[]> getSeasonHotTeamInfo(String sift) {
		mappingTable = new HotTeamMappingTable();
		sift = mappingTable.get(sift);
		return dao.getSeasonHotTeamInfo(sift);
	}

	public void close() {
		dao.close();
	}

}
