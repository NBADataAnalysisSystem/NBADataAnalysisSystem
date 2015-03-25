package controller.playercontroller;

import service.playerservice.GetPlayerService;
import serviceimp.playerserviceimp.GetPlayerServiceImp;
import controller.controller.ErrorResponse;
import controller.controller.Request;
import controller.controller.RequestHandler;
import controller.controller.Response;

public class GetPlayerHandler implements RequestHandler {

	public Response process(Request request) {
		Response response;
		GetPlayerService getPlayerService = new GetPlayerServiceImp();
		try {
			response = new GetPlayerResponse(
					getPlayerService.getPlayer(((GetPlayerRequest) request).getColumnList()));
		} catch (Exception e) {
			response = new ErrorResponse(request, e);
		}
		return response;
	}

}
