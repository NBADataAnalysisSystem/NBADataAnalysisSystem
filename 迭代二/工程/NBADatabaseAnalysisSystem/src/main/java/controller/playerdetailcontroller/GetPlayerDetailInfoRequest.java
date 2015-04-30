package controller.playerdetailcontroller;

import controller.controller.Request;

public class GetPlayerDetailInfoRequest implements Request {
	
	private String playername;
	
	public GetPlayerDetailInfoRequest(String playername) {
		this.playername = playername;
	}
	
	public String getName() {
		return "GetPlayerDetailInfo";
	}

	public String getPlayerName() {
		return playername;
	}
	
}
