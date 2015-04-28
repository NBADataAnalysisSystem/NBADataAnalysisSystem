package controller.teamcontroller;

import controller.controller.DefaultController;

public class TeamController extends DefaultController {
	
	public TeamController() {
		addHandler(new GetTeamSeasonTotalBasicInfoRequest(null), new GetTeamSeasonTotalBasicInfoHandler());
	}
	
}