package controller.teamcontroller;

import java.util.ArrayList;
import java.util.Map;

import controller.controller.Response;
import entity.team.TeamInfo;

public class GetTeamResponse implements Response {

	private static final String NAME = "GetTeamSuccess";
	ArrayList<Map<TeamInfo, String>> list;
	
	public GetTeamResponse(ArrayList<Map<TeamInfo, String>> list) {
		this.list = list;
	}
	
	public String getName() {
		return NAME;
	}
	
	public ArrayList<Map<TeamInfo, String>> getList() {
		return list;
	}

}
