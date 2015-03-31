package controller.playercontroller;

import java.util.ArrayList;

import controller.controller.Request;
import entity.SortType;
import entity.player.PlayerInfo;

public class GetPlayerRequest implements Request {

	private ArrayList<PlayerInfo> columnList;
	private SortType sortType;
	private PlayerInfo sortBy;
	
	public GetPlayerRequest(ArrayList<PlayerInfo> columnList, SortType sortType, PlayerInfo sortBy) {
		this.columnList = columnList;
		this.sortType = sortType;
		this.sortBy = sortBy;
	}
	
	public String getName() {
		return "GetPlayer";
	}
	
	public ArrayList<PlayerInfo> getColumnList() {
		return columnList;
	}
	
	public SortType getSortType() {
		return sortType;
	}
	
	public PlayerInfo getSortBy() {
		return sortBy;
	}

}
