package controller.hotcontroller;

import controller.controller.Request;

public class GetSeasonHotTeamInfoRequest implements Request {
	
	private String sift;
	
	public GetSeasonHotTeamInfoRequest(String sift) {
		this.sift = sift;
	}
	
	public String getName() {
		return "GetSeasonHotTeamInfo";
	}

	public String getSift() {
		return sift;
	}
	
}
