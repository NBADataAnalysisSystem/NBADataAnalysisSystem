package controller.playercontroller;

import java.util.ArrayList;
import java.util.Map;

import controller.controller.Response;
import entity.PlayerEntity;

public class GetPlayerSeasonTotalInfoResponse implements Response {

	private static final String NAME = "GetPlayerSuccess";
	ArrayList<Map<PlayerEntity, String>> list;
	
	public GetPlayerSeasonTotalInfoResponse(ArrayList<Map<PlayerEntity, String>> list) {
		this.list = list;
	}
	
	public String getName() {
		return NAME;
	}
	
	public ArrayList<Map<PlayerEntity, String>> getList() {
		return list;
	}

}
