package controller.playerdetailcontroller;

import controller.controller.DefaultController;

public class PlayerDetailController extends DefaultController {
	
	public PlayerDetailController() {
		addHandler(new GetPlayerDetailInfoRequest(null), new GetPlayerDetailInfoHandler());
	}
	
}
