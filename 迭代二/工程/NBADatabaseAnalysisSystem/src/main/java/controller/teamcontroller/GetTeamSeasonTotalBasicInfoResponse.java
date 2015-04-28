package controller.teamcontroller;

import java.util.ArrayList;

import controller.controller.Response;

public class GetTeamSeasonTotalBasicInfoResponse implements Response {

	private static final String NAME = "GetTeamSuccess";
	ArrayList<String[]> list;
	
	public GetTeamSeasonTotalBasicInfoResponse(ArrayList<String[]> list) {
		this.list = list;
	}
	
	public String getName() {
		return NAME;
	}
	
	public ArrayList<String[]> getList() {
		return list;
	}

}
