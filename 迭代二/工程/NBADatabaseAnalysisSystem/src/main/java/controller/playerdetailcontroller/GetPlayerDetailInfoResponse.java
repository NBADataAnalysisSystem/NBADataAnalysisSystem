package controller.playerdetailcontroller;

import controller.controller.Response;

public class GetPlayerDetailInfoResponse implements Response {

	private static final String NAME = "GetPlayerDetailSuccess";
	String[] basicInfo;
	String[][] seasonInfo;
	String[][] matchInfo;
	
	public GetPlayerDetailInfoResponse(String[] basicInfo, String[][] seasonInfo, String[][] matchInfo) {
		this.basicInfo = basicInfo;
		this.seasonInfo = seasonInfo;
		this.matchInfo = matchInfo;
	}
	
	public String getName() {
		return NAME;
	}

	public String[] getBasicInfo() {
		return basicInfo;
	}

	public String[][] getSeasonInfo() {
		return seasonInfo;
	}

	public String[][] getMatchInfo() {
		return matchInfo;
	}

}
