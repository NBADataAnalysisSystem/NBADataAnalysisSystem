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
			 GetPlayerRequest getPlayerRequest = (GetPlayerRequest) request;
			response = new GetPlayerResponse(
					getPlayerService.getPlayer(
							getPlayerRequest.getColumnList(),
							getPlayerRequest.getSortType(), 
							getPlayerRequest.getSortBy()));
		} catch (Exception e) {
			response = new ErrorResponse(request, e);
		}
		return response;
	}

}
