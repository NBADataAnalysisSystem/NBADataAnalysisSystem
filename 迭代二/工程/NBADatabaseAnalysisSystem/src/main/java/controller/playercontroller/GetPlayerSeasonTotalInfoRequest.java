package controller.playercontroller;

import controller.controller.Request;

public class GetPlayerSeasonTotalInfoRequest implements Request {
	
	private String[] sift;
	
	public GetPlayerSeasonTotalInfoRequest(String[] sift) {
		this.sift = sift;
	}
	
	public String getName() {
		return "GetPlayerSeasonTotalInfo";
	}

	public String[] getSift() {
		return sift;
	}
	
}
