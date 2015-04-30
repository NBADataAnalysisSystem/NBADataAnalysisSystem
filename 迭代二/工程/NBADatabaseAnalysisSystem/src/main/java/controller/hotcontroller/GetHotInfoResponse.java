package controller.hotcontroller;

import java.util.ArrayList;

import controller.controller.Response;

public class GetHotInfoResponse implements Response {

	private static final String NAME = "GetHotSuccess";
	ArrayList<String[]> list;
	
	public GetHotInfoResponse(ArrayList<String[]> list) {
		this.list = list;
	}
	
	public String getName() {
		return NAME;
	}
	
	public ArrayList<String[]> getList() {
		return list;
	}

}
