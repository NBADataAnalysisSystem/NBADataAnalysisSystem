package controller.playercontroller;

import service.playerservice.GetPlayerService;
import serviceimp.playerserviceimp.GetPlayerServiceImp;
import controller.controller.ErrorResponse;
import controller.controller.Request;
import controller.controller.RequestHandler;
import controller.controller.Response;

public class GetPlayerHandler implements RequestHandler {

	public Response process(Request request) throws Exception {
		Response response;
		GetPlayerService getPlayerService = new GetPlayerServiceImp();
		try {
			GetPlayerRequest getPlayerRequest = (GetPlayerRequest) request;
			response = new GetPlayerResponse(
					getPlayerService.getPlayer(
							getPlayerRequest.getType()));
		} catch (Exception e) {
			response = new ErrorResponse(request, e);
		}
		return response;
	}

}
