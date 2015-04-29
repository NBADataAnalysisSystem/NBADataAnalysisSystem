package controller.teamcontroller;

import java.util.ArrayList;

import controller.controller.Response;

public class GetTeamSeasonRateInfoResponse implements Response {

	private static final String NAME = "GetTeamSuccess";
	ArrayList<String[]> list;
	
	public GetTeamSeasonRateInfoResponse(ArrayList<String[]> list) {
		this.list = list;
	}
	
	public String getName() {
		return NAME;
	}
	
	public ArrayList<String[]> getList() {
		return list;
	}

}
