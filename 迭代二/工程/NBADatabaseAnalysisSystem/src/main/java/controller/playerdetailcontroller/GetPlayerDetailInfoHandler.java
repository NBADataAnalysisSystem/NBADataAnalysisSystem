package controller.playerdetailcontroller;

import service.playerdetailservice.GetPlayerDetailInfoService;
import serviceimp.playerdetailserviceimp.GetPlayerDetailInfoServiceImp;
import controller.controller.ErrorResponse;
import controller.controller.Request;
import controller.controller.RequestHandler;
import controller.controller.Response;

public class GetPlayerDetailInfoHandler implements RequestHandler {

	public Response process(Request request) throws Exception {
		Response response;
		GetPlayerDetailInfoService getPlayerService = new GetPlayerDetailInfoServiceImp();
		try {
			GetPlayerDetailInfoRequest getPlayerRequest = (GetPlayerDetailInfoRequest) request;
			response = new GetPlayerDetailInfoResponse(
					getPlayerService.getPlayerBasicInfo(getPlayerRequest.getPlayerName()),
					getPlayerService.getPlayerSeasonInfo(getPlayerRequest.getPlayerName()),
					getPlayerService.getPlayerLatestFiveMatchInfo(getPlayerRequest.getPlayerName()));
			getPlayerService.close();
		} catch (Exception e) {
			response = new ErrorResponse(request, e);
		}
		return response;
	}

}
