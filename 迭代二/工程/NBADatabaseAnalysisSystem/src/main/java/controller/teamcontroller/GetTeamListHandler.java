package controller.teamcontroller;

import service.teamservice.GetTeamListService;
import serviceimp.teamserviceimp.GetTeamListServiceImp;
import controller.controller.ErrorResponse;
import controller.controller.Request;
import controller.controller.RequestHandler;
import controller.controller.Response;

public class GetTeamListHandler implements RequestHandler {

	public Response process(Request request) throws Exception {
		Response response;
		GetTeamListService getTeamService = new GetTeamListServiceImp();
		try {
			response = new GetTeamListResponse(
					getTeamService.getTeam());
		} catch (Exception e) {
			response = new ErrorResponse(request, e);
		}
		return response;
	}

}
