package controller.matchcontroller;

import service.matchservice.GetMatchSectionInfoService;
import serviceimp.matchserviceimp.GetMatchSectionInfoServiceImp;
import controller.controller.ErrorResponse;
import controller.controller.Request;
import controller.controller.Response;

public class GetMatchSectionInfoHandler {

	public Response process(Request request) throws Exception {
		Response response;
		GetMatchSectionInfoService getMatchSectionInfoService = new GetMatchSectionInfoServiceImp();
		try {
			GetMatchSectionInfoRequest getMatchSectionInfoRequest = (GetMatchSectionInfoRequest) request;
			response = new GetMatchSectionInfoResponse(
					getMatchSectionInfoService.getMatch(getMatchSectionInfoRequest.getSift()));
		} catch (Exception e) {
			response = new ErrorResponse(request, e);
		}
		return response;
	}

}
