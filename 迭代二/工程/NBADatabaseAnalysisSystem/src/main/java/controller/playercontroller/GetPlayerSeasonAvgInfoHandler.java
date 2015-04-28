package controller.playercontroller;

import service.playerservice.GetPlayerSeasonAvgInfoService;
import serviceimp.playerserviceimp.GetPlayerSeasonAvgInfoServiceImp;
import controller.controller.ErrorResponse;
import controller.controller.Request;
import controller.controller.RequestHandler;
import controller.controller.Response;

public class GetPlayerSeasonAvgInfoHandler implements RequestHandler {

	public Response process(Request request) throws Exception {
		Response response;
		GetPlayerSeasonAvgInfoService getPlayerService = new GetPlayerSeasonAvgInfoServiceImp();
		try {
			GetPlayerSeasonAvgInfoRequest getPlayerRequest = (GetPlayerSeasonAvgInfoRequest) request;
			response = new GetPlayerSeasonAvgInfoResponse(
					getPlayerService.getPlayer(getPlayerRequest.getSift()));
		} catch (Exception e) {
			response = new ErrorResponse(request, e);
		}
		return response;
	}

}
