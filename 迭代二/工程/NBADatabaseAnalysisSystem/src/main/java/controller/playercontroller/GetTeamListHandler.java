package controller.playercontroller;

import service.playerservice.GetTeamListService;
import serviceimp.playerserviceimp.GetTeamListServiceImp;
import controller.controller.ErrorResponse;
import controller.controller.Request;
import controller.controller.RequestHandler;
import controller.controller.Response;

public class GetTeamListHandler implements RequestHandler {

	public Response process(Request request) throws Exception {
		Response response;
		GetTeamListService getTeamListService = new GetTeamListServiceImp();
		try {
			response = new GetTeamListResponse(
					getTeamListService.getTeamList());
		} catch (Exception e) {
			response = new ErrorResponse(request, e);
		}
		return response;
	}

}
