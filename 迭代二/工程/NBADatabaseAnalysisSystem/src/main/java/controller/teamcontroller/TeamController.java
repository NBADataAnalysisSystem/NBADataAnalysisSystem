package controller.teamcontroller;

import controller.controller.DefaultController;

public class TeamController extends DefaultController {
	
	public TeamController() {
		addHandler(new GetTeamSeasonTotalBasicInfoRequest(null), new GetTeamSeasonTotalBasicInfoHandler());
		addHandler(new GetTeamSeasonAvgBasicInfoRequest(null), new GetTeamSeasonAvgBasicInfoHandler());
		addHandler(new GetTeamSeasonEffInfoRequest(null), new GetTeamSeasonEffInfoHandler());
		addHandler(new GetTeamSeasonRateInfoRequest(null), new GetTeamSeasonRateInfoHandler());
	}
	
}