package controller.teamcontroller;

import java.util.ArrayList;

import controller.controller.Request;
import entity.SortType;
import entity.TeamInfo;

public class GetTeamRequest implements Request {

	private ArrayList<TeamInfo> columnList;
	private SortType sortType;
	private TeamInfo sortBy;
	
	public GetTeamRequest(ArrayList<TeamInfo> columnList, SortType sortType, TeamInfo sortBy) {
		this.columnList = columnList;
		this.sortType = sortType;
		this.sortBy = sortBy;
	}
	
	public String getName() {
		return "GetTeam";
	}
	
	public ArrayList<TeamInfo> getColumnList() {
		return columnList;
	}
	
	public SortType getSortType() {
		return sortType;
	}
	
	public TeamInfo getSortBy() {
		return sortBy;
	}
	
}
