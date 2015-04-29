package controller.matchcontroller;

import controller.controller.Request;

public class GetMatchSectionInfoRequest implements Request {
	
	private String[] sift;
	
	public GetMatchSectionInfoRequest(String[] sift) {
		this.sift = sift;
	}
	
	public String getName() {
		return "GetMatchSectionInfo";
	}

	public String[] getSift() {
		return sift;
	}
	
}
