package controller.teamcontroller;

import controller.controller.Request;

public class GetTeamSeasonAvgBasicInfoRequest implements Request {
	
	private String[] sift;
	
	public GetTeamSeasonAvgBasicInfoRequest(String[] sift) {
		this.sift = sift;
	}
	
	public String getName() {
		return "GetTeamSeasonAvgBasicInfo";
	}

	public String[] getSift() {
		return sift;
	}
	
}
