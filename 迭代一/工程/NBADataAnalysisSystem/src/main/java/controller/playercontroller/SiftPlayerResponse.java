package controller.playercontroller;

import java.util.ArrayList;
import java.util.Map;

import controller.controller.Response;
import entity.PlayerInfo;

public class SiftPlayerResponse implements Response {

	private static final String NAME = "SiftPlayerSuccess";
	ArrayList<Map<PlayerInfo, String>> list;
	
	public SiftPlayerResponse(ArrayList<Map<PlayerInfo, String>> list) {
		this.list = list;
	}
	
	public String getName() {
		return NAME;
	}
	
	public ArrayList<Map<PlayerInfo, String>> getList() {
		return list;
	}

}