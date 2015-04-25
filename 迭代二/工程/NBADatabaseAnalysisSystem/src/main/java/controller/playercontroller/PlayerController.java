package controller.playercontroller;

import controller.controller.DefaultController;

public class PlayerController extends DefaultController {
	
	public PlayerController() {
		this.addHandler(new GetPlayerBasicInfoRequest(null), new GetPlayerBasicInfoHandler());
		this.addHandler(new GetTeamListRequest(), new GetTeamListHandler());
	}
	
}
