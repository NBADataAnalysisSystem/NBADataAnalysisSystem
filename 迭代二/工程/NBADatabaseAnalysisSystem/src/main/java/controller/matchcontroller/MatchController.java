package controller.matchcontroller;

import controller.controller.DefaultController;

public class MatchController extends DefaultController {
	
	public MatchController() {
		addHandler(new GetMatchSectionInfoRequest(null), new GetMatchSectionInfoHandler());
	}
	
}
