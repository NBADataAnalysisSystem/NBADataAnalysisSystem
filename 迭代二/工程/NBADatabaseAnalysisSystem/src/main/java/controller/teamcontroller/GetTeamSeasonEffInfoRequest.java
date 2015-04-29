package controller.teamcontroller;

import controller.controller.Request;

public class GetTeamSeasonEffInfoRequest implements Request {
	
	private String[] sift;
	
	public GetTeamSeasonEffInfoRequest(String[] sift) {
		this.sift = sift;
	}
	
	public String getName() {
		return "GetTeamSeasonEffInfo";
	}

	public String[] getSift() {
		return sift;
	}
	
}
