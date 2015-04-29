package controller.teamcontroller;

import java.util.ArrayList;

import controller.controller.Response;

public class GetTeamSeasonEffInfoResponse implements Response {

	private static final String NAME = "GetTeamSuccess";
	ArrayList<String[]> list;
	
	public GetTeamSeasonEffInfoResponse(ArrayList<String[]> list) {
		this.list = list;
	}
	
	public String getName() {
		return NAME;
	}
	
	public ArrayList<String[]> getList() {
		return list;
	}

}
