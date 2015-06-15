package serviceimp.matchdetailserviceimp;

import java.util.ArrayList;

import dao.matchdetaildao.MatchDetailDao;
import dao.matchdetaildao.MatchDetailDaoJdbcImpV2;
import service.matchdetailservice.MatchDetailService;

public class MatchDetailServiceImp implements MatchDetailService {

	MatchDetailDao dao;
	
	public MatchDetailServiceImp() {
		dao = new MatchDetailDaoJdbcImpV2();
	}
	
	public ArrayList<String[]> getTeamMatchPerformance(String matchID) {
		return dao.getTeamMatchPerformance(matchID);
	}

	public ArrayList<String[]> getRivalTeamMatchPerformance(String matchID) {
		return dao.getRivalTeamMatchPerformance(matchID);
	}

	public void close() {
		dao.close();
	}

}
