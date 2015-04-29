package controller.matchcontroller;

import java.util.ArrayList;

import controller.controller.Response;

public class GetMatchSectionInfoResponse implements Response {

	private static final String NAME = "GetMatchSuccess";
	ArrayList<String[]> list;
	
	public GetMatchSectionInfoResponse(ArrayList<String[]> list) {
		this.list = list;
	}
	
	public String getName() {
		return NAME;
	}
	
	public ArrayList<String[]> getList() {
		return list;
	}

}
