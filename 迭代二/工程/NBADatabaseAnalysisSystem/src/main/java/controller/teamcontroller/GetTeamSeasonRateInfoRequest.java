package controller.teamcontroller;

import controller.controller.Request;

public class GetTeamSeasonRateInfoRequest implements Request {
	
	private String[] sift;
	
	public GetTeamSeasonRateInfoRequest(String[] sift) {
		this.sift = sift;
	}
	
	public String getName() {
		return "GetTeamSeasonRateInfo";
	}

	public String[] getSift() {
		return sift;
	}
	
}
