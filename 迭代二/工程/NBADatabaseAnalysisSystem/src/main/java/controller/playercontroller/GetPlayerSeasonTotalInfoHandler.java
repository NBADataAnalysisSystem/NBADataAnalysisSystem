package controller.playercontroller;

import service.playerservice.GetPlayerSeasonTotalInfoService;
import serviceimp.playerserviceimp.GetPlayerSeasonTotalInfoImp;
import controller.controller.ErrorResponse;
import controller.controller.Request;
import controller.controller.RequestHandler;
import controller.controller.Response;

public class GetPlayerSeasonTotalInfoHandler implements RequestHandler {

	public Response process(Request request) throws Exception {
		Response response;
		GetPlayerSeasonTotalInfoService getPlayerService = new GetPlayerSeasonTotalInfoImp();
		try {
			GetPlayerSeasonTotalInfoRequest getPlayerRequest = (GetPlayerSeasonTotalInfoRequest) request;
			response = new GetPlayerSeasonTotalInfoResponse(
					getPlayerService.getPlayer(getPlayerRequest.getSift()));
		} catch (Exception e) {
			response = new ErrorResponse(request, e);
		}
		return response;
	}

}
