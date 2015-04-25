package controller.playercontroller;

import controller.controller.Request;

public class GetPlayerBasicInfoRequest implements Request {
	
	private String[] sift;
	
	public GetPlayerBasicInfoRequest(String[] sift) {
		this.sift = sift;
	}
	
	public String getName() {
		return "GetPlayer";
	}

	public String[] getSift() {
		return sift;
	}
	
}
