package controller.playercontroller;

import java.util.ArrayList;

import controller.controller.Request;
import entity.PlayerInfo;
import entity.SiftingOfOth;
import entity.SiftingOfPosition;
import entity.SiftingOfUnion;

public class SiftPlayerRequest implements Request {

	private ArrayList<PlayerInfo> columnList;
	private SiftingOfPosition position;
	private SiftingOfUnion union;
	private SiftingOfOth sortBy;
	
	public SiftPlayerRequest(ArrayList<PlayerInfo> columnList, SiftingOfPosition position, SiftingOfUnion union, SiftingOfOth sortBy) {
		this.columnList = columnList;
		this.position = position;
		this.union = union;
		this.sortBy = sortBy;
	}
	
	public String getName() {
		return "SiftPlayer";
	}
	
	public ArrayList<PlayerInfo> getColumnList() {
		return columnList;
	}
	
	public SiftingOfPosition getPosition() {
		return position;
	}
	
	public SiftingOfUnion getUnion() {
		return union;
	}
	
	public SiftingOfOth getSortBy() {
		return sortBy;
	}

}
