package controller.hotcontroller;

import controller.controller.Request;

public class GetSeasonHotPlayerInfoRequest implements Request {
	
	private String sift;
	
	public GetSeasonHotPlayerInfoRequest(String sift) {
		this.sift = sift;
	}
	
	public String getName() {
		return "GetSeasonHotPlayerInfo";
	}

	public String getSift() {
		return sift;
	}
	
}
