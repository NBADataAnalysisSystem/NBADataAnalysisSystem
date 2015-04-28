package controller.playercontroller;

import controller.controller.DefaultController;

public class PlayerController extends DefaultController {
	
	public PlayerController() {
		this.addHandler(new GetTeamListRequest(), new GetTeamListHandler());
		this.addHandler(new GetPlayerBasicInfoRequest(null), new GetPlayerBasicInfoHandler());
		this.addHandler(new GetPlayerSeasonTotalInfoRequest(null), new GetPlayerSeasonTotalInfoHandler());
		this.addHandler(new GetPlayerSeasonAvgInfoRequest(null), new GetPlayerSeasonAvgInfoHandler());
	}
	
}
