package controller.hotcontroller;

import controller.controller.Request;

public class GetHotPlayerRequest implements Request {
	
	private String sift;
	
	public GetHotPlayerRequest(String sift) {
		this.sift = sift;
	}
	
	public String getName() {
		return "GetHotPlayer";
	}

	public String getSift() {
		return sift;
	}
	
}
