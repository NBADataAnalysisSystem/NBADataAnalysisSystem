package controller.playercontroller;

import java.util.ArrayList;
import java.util.Map;

import controller.controller.Response;
import entity.player.PlayerInfo;

public class GetPlayerResponse implements Response {

	private static final String NAME = "GetPlayerSuccess";
	ArrayList<Map<PlayerInfo, String>> list;
	
	public GetPlayerResponse(ArrayList<Map<PlayerInfo, String>> list) {
		this.list = list;
	}
	
	public String getName() {
		return NAME;
	}
	
	public ArrayList<Map<PlayerInfo, String>> getList() {
		return list;
	}

}
