package controller.matchcontroller;

public class GetMatchSectionInfoRequest {
	
	private String[] sift;
	
	public GetMatchSectionInfoRequest(String[] sift) {
		this.sift = sift;
	}
	
	public String getName() {
		return "GetMatchSectionInfo";
	}

	public String[] getSift() {
		return sift;
	}
	
}
