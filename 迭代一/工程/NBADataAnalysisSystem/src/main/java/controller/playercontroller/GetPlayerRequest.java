package controller.playercontroller;

import java.util.ArrayList;

import controller.controller.Request;
import entity.player.PlayerInfo;

public class GetPlayerRequest implements Request {

	private ArrayList<PlayerInfo> columnList;
	
	public GetPlayerRequest(ArrayList<PlayerInfo> columnList) {
		this.columnList = columnList;
	}
	
	public String getName() {
		return "GetPlayer";
	}
	
	public ArrayList<PlayerInfo> getColumnList() {
		return columnList;
	}

}
