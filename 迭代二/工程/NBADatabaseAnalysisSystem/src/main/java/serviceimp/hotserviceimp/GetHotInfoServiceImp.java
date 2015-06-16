package serviceimp.hotserviceimp;

import java.util.ArrayList;

import dao.hotdao.HotDao;
import dao.hotdao.HotDaoJdbcImpV2;
import service.hotservice.GetHotInfoService;
import serviceimp.MappingTable;

public class GetHotInfoServiceImp implements GetHotInfoService {

	HotDao dao;
	MappingTable mappingTable;
	
	public GetHotInfoServiceImp() {
		dao = new HotDaoJdbcImpV2();
	}

	public ArrayList<String[]> getCurrentHotPlayerInfo(String sift) {
		mappingTable = new KingPlayerMappingTable();
		sift = mappingTable.get(sift);
		return dao.getCurrentKingPlayerInfo(sift);
	}

	public ArrayList<String[]> getSeasonHotPlayerInfo(String sift) {
		mappingTable = new KingPlayerMappingTable();
		sift = mappingTable.get(sift);
		return dao.getSeasonHotPlayerInfo(sift);
	}

	public ArrayList<String[]> getSeasonHotTeamInfo(String sift) {
		mappingTable = new HotTeamMappingTable();
		sift = mappingTable.get(sift);
		return dao.getSeasonHotTeamInfo(sift);
	}
	
	public ArrayList<String[]> getHotPlayer(String sift) {
		mappingTable = new HotPlayerMappingTable();
		sift = mappingTable.get(sift);
		return dao.getSeasonHotPlayer(sift);
	}
	
	public void close() {
		dao.close();
	}

}
