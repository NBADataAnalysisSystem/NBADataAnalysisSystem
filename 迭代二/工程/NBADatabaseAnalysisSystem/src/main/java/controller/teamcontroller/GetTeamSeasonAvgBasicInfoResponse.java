package controller.teamcontroller;

import java.util.ArrayList;

import controller.controller.Response;

public class GetTeamSeasonAvgBasicInfoResponse implements Response {

	private static final String NAME = "GetTeamSuccess";
	ArrayList<String[]> list;
	
	public GetTeamSeasonAvgBasicInfoResponse(ArrayList<String[]> list) {
		this.list = list;
	}
	
	public String getName() {
		return NAME;
	}
	
	public ArrayList<String[]> getList() {
		return list;
	}

}
