package controller.teamdetailcontroller;

import controller.controller.DefaultController;

public class TeamDetailController extends DefaultController {
	
	public TeamDetailController() {
		addHandler(new GetTeamDetailInfoRequest(null), new GetTeamDetailInfoHandler());
	}
	
}
