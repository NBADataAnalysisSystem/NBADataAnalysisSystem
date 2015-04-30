package controller.teamdetailcontroller;

import java.util.ArrayList;

import controller.controller.Response;

public class GetTeamDetailInfoResponse implements Response {

	private static final String NAME = "GetTeamDetailSuccess";
	String[] basicInfo;
	ArrayList<String[]> seasonAvgInfo;
	ArrayList<String[]> seasonTotalInfo;
	ArrayList<String[]> playerInfo;
	
	public GetTeamDetailInfoResponse(String[] basicInfo, ArrayList<String[]> seasonAvgInfo,
			ArrayList<String[]> seasonTotalInfo,ArrayList<String[]> playerInfo) {
		this.basicInfo = basicInfo;
		this.seasonAvgInfo = seasonAvgInfo;
		this.seasonTotalInfo = seasonTotalInfo;
		this.playerInfo = playerInfo;
	}
	
	public String getName() {
		return NAME;
	}

	public String[] getBasicInfo() {
		return basicInfo;
	}

	public ArrayList<String[]> getSeasonAvgInfo() {
		return seasonAvgInfo;
	}

	public ArrayList<String[]> getSeasonTotalInfo() {
		return seasonTotalInfo;
	}

	public ArrayList<String[]> getPlayerInfo() {
		return playerInfo;
	}

}
