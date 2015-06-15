package controller.matchdetailcontroller;

import java.util.ArrayList;

import controller.controller.Response;

public class GetMatchDetailInfoResponse implements Response {

	private static final String NAME = "GetMatchDetailSuccess";
	ArrayList<String[]> infoA;
	ArrayList<String[]> infoB;
	
	public GetMatchDetailInfoResponse(ArrayList<String[]> infoA, ArrayList<String[]> infoB) {
		this.infoA = infoA;
		this.infoB = infoB;
		System.out.println(infoA);
	}
	
	public String getName() {
		return NAME;
	}

	public ArrayList<String[]> getInfoA() {
		return infoA;
	}

	public ArrayList<String[]> getInfoB() {
		return infoB;
	}
	
}
