package controller.teamcontroller;

import java.util.ArrayList;

import controller.controller.Request;
import entity.TeamInfo;

public class GetTeamRequest implements Request {

	private ArrayList<TeamInfo> columnList;
	
	public GetTeamRequest(ArrayList<TeamInfo> columnList) {
		this.columnList = columnList;
	}
	
	public String getName() {
		return "GetTeam";
	}
	
	public ArrayList<TeamInfo> getColumnList() {
		return columnList;
	}

}
