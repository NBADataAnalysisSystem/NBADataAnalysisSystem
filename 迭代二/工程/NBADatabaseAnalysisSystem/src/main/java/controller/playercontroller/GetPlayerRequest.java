package controller.playercontroller;

import controller.controller.Request;
import dao.playerdao.PlayerInfoType;

public class GetPlayerRequest implements Request {

	private PlayerInfoType type;
	
	public GetPlayerRequest(PlayerInfoType type) {
		this.type = type;
	}
	
	public String getName() {
		return "GetPlayer";
	}
	
	public PlayerInfoType getType() {
		return type;
	}

}
