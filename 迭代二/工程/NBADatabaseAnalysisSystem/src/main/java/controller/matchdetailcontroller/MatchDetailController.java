package controller.matchdetailcontroller;

import controller.controller.DefaultController;

public class MatchDetailController extends DefaultController {
	
	public MatchDetailController() {
		addHandler(new GetMatchDetailInfoRequest(null), new GetMatchDetailInfoHandler());
	}
	
}
