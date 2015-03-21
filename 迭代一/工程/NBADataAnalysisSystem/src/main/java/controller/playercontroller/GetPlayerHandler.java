package controller.playercontroller;

import service.playerservice.GetPlayerService;
import serviceimp.playerserviceimp.GetPlayerServiceImp;
import controller.controller.Request;
import controller.controller.RequestHandler;
import controller.controller.Response;

public class GetPlayerHandler implements RequestHandler {

	public Response process(Request request) throws Exception {
		GetPlayerService getPlayerService = new GetPlayerServiceImp();
		Response response = new GetPlayerResponse(
				getPlayerService.getPlayer(((GetPlayerRequest) request).getColumnList()));
		return response;
	}

}
