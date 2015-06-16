package controller.hotcontroller;

import service.hotservice.GetHotInfoService;
import serviceimp.hotserviceimp.GetHotInfoServiceImp;
import controller.controller.ErrorResponse;
import controller.controller.Request;
import controller.controller.RequestHandler;
import controller.controller.Response;

public class GetHotInfoHandler implements RequestHandler {

	public Response process(Request request) throws Exception {
		Response response;
		GetHotInfoService getHotInfoService = new GetHotInfoServiceImp();
		try {
			if (request.getName().equals("GetCurrentHotPlayerInfo")) {
				GetCurrentHotPlayerInfoRequest getHotInfoRequest = (GetCurrentHotPlayerInfoRequest) request;
				response = new GetHotInfoResponse(
						getHotInfoService.getCurrentHotPlayerInfo(getHotInfoRequest.getSift()));
			} else if (request.getName().equals("GetSeasonHotPlayerInfo")) {
				GetSeasonHotPlayerInfoRequest getHotInfoRequest = (GetSeasonHotPlayerInfoRequest) request;
				response = new GetHotInfoResponse(
						getHotInfoService.getSeasonHotPlayerInfo(getHotInfoRequest.getSift()));
			} else if (request.getName().equals("GetHotPlayer")) {
				GetHotPlayerRequest getHotInfoRequest = (GetHotPlayerRequest) request;
				response = new GetHotInfoResponse(
						getHotInfoService.getHotPlayer(getHotInfoRequest.getSift()));
			} else {
				GetSeasonHotTeamInfoRequest getHotInfoRequest = (GetSeasonHotTeamInfoRequest) request;
				response = new GetHotInfoResponse(
						getHotInfoService.getSeasonHotTeamInfo(getHotInfoRequest.getSift()));
			}
		} catch (Exception e) {
			response = new ErrorResponse(request, e);
		}
		return response;
	}

}
