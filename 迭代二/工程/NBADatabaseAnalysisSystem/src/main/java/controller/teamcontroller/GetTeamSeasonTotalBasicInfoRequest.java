package controller.teamcontroller;

import controller.controller.Request;

public class GetTeamSeasonTotalBasicInfoRequest implements Request {
	
	private String[] sift;
	
	public GetTeamSeasonTotalBasicInfoRequest(String[] sift) {
		this.sift = sift;
	}
	
	public String getName() {
		return "GetTeamSeasonTotalBasicInfo";
	}

	public String[] getSift() {
		return sift;
	}
	
}
