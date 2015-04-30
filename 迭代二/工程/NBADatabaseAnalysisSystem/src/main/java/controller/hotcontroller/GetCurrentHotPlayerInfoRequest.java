package controller.hotcontroller;

import controller.controller.Request;

public class GetCurrentHotPlayerInfoRequest implements Request {
	
	private String sift;
	
	public GetCurrentHotPlayerInfoRequest(String sift) {
		this.sift = sift;
	}
	
	public String getName() {
		return "GetCurrentHotPlayerInfo";
	}

	public String getSift() {
		return sift;
	}
	
}
