package controller.playercontroller;

import java.util.ArrayList;

import controller.controller.Response;

public class GetPlayerSeasonAvgInfoResponse implements Response {

	private static final String NAME = "GetPlayerSuccess";
	ArrayList<String[]> list;
	
	public GetPlayerSeasonAvgInfoResponse(ArrayList<String[]> list) {
		this.list = list;
	}
	
	public String getName() {
		return NAME;
	}
	
	public ArrayList<String[]> getList() {
		return list;
	}

}
