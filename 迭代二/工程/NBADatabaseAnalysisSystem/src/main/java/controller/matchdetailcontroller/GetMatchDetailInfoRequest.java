package controller.matchdetailcontroller;

import controller.controller.Request;

public class GetMatchDetailInfoRequest implements Request {
	
	private String matchname;
	
	public GetMatchDetailInfoRequest(String matchname) {
		this.matchname = matchname;
	}
	
	public String getName() {
		return "GetMatchDetailInfo";
	}

	public String getMatchName() {
		return matchname;
	}
	
}
