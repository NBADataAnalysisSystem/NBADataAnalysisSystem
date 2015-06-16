package controller.hotcontroller;

import controller.controller.DefaultController;

public class HotController extends DefaultController {
	
	public HotController() {
		addHandler(new GetCurrentHotPlayerInfoRequest(null), new GetHotInfoHandler());
		addHandler(new GetSeasonHotPlayerInfoRequest(null), new GetHotInfoHandler());
		addHandler(new GetSeasonHotTeamInfoRequest(null), new GetHotInfoHandler());
		addHandler(new GetHotPlayerRequest(null), new GetHotInfoHandler());
	}
	
}
