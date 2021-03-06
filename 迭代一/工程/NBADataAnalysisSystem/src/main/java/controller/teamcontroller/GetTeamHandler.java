package controller.teamcontroller;

import service.teamservice.GetTeamService;
import serviceimp.teamserviceimp.GetTeamServiceImp;
import controller.controller.ErrorResponse;
import controller.controller.Request;
import controller.controller.RequestHandler;
import controller.controller.Response;

public class GetTeamHandler implements RequestHandler {

	public Response process(Request request) {
		Response response;
		GetTeamService getTeamService = new GetTeamServiceImp();
		try {
			GetTeamRequest getTeamRequest = (GetTeamRequest) request;
			response = new GetTeamResponse(
					getTeamService.getTeam(
							getTeamRequest.getColumnList(), 
							getTeamRequest.getSortType(),
							getTeamRequest.getSortBy()));
		} catch (Exception e) {
			response = new ErrorResponse(request, e);
		}
		return response;
	}

}
