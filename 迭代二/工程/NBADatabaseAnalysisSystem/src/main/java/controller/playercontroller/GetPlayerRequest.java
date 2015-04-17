package controller.playercontroller;

import java.util.ArrayList;

import controller.controller.Request;
import entity.PlayerEntity;

public class GetPlayerRequest implements Request {

	private ArrayList<PlayerEntity> columnList;
	
	public GetPlayerRequest(ArrayList<PlayerEntity> columnList) {
		this.columnList = columnList;
	}
	
	public String getName() {
		return "GetPlayer";
	}
	
	public ArrayList<PlayerEntity> getColumnList() {
		return columnList;
	}

}
