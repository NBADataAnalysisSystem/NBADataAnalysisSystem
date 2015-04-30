package controller.teamdetailcontroller;

import controller.controller.Request;

public class GetTeamDetailInfoRequest implements Request {
	
	private String teamname;
	
	public GetTeamDetailInfoRequest(String teamname) {
		this.teamname = teamname;
	}
	
	public String getName() {
		return "GetTeamDetailInfo";
	}

	public String getTeamName() {
		return teamname;
	}
	
}
