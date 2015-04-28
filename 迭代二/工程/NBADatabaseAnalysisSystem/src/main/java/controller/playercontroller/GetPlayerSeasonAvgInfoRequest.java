package controller.playercontroller;

import controller.controller.Request;

public class GetPlayerSeasonAvgInfoRequest implements Request {
	
	private String[] sift;
	
	public GetPlayerSeasonAvgInfoRequest(String[] sift) {
		this.sift = sift;
	}
	
	public String getName() {
		return "GetPlayerSeasonAvgInfo";
	}

	public String[] getSift() {
		return sift;
	}
	
}
