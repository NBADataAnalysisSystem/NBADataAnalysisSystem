package serviceimp.teamdetailserviceimp;

import java.util.ArrayList;

import dao.teamdetaildao.TeamDetailDao;
import dao.teamdetaildao.TeamDetailDaoJdbcImpV2;
import service.teamdetailservice.GetTeamDetailInfoService;

public class GetTeamDetailInfoServiceImp implements GetTeamDetailInfoService {

	TeamDetailDao dao;
	
	public GetTeamDetailInfoServiceImp() {
		dao = new TeamDetailDaoJdbcImpV2();
	}
	
	public String[] getTeamBasicInfo(String teamFullName) {
		return dao.getTeamBasicInfo(teamFullName);
	}

	public ArrayList<String[]> getTeamSeasonAvgInfo(String teamFullName) {
		return dao.getTeamSeasonAvgInfo(teamFullName);
	}

	public ArrayList<String[]> getTeamSeasonTotalInfo(String teamFullName) {
		return dao.getTeamSeasonTotalInfo(teamFullName);
	}

	public ArrayList<String[]> getTeamPlayerInfo(String teamFullName) {
		return dao.getTeamPlayerInfo(teamFullName);
	}

	public void close() {
		dao.close();
	}

}
