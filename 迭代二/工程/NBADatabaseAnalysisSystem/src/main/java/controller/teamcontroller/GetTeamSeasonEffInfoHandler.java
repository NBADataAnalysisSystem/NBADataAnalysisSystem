package controller.teamcontroller;

import service.teamservice.GetTeamSeasonEffInfoService;
import serviceimp.teamserviceimp.GetTeamSeasonEffInfoServiceImp;
import controller.controller.ErrorResponse;
import controller.controller.Request;
import controller.controller.RequestHandler;
import controller.controller.Response;

public class GetTeamSeasonEffInfoHandler implements RequestHandler {

	public Response process(Request request) throws Exception {
		Response response;
		GetTeamSeasonEffInfoService getTeamService = new GetTeamSeasonEffInfoServiceImp();
		try {
			GetTeamSeasonEffInfoRequest getTeamRequest = (GetTeamSeasonEffInfoRequest) request;
			response = new GetTeamSeasonEffInfoResponse(
					getTeamService.getTeam(getTeamRequest.getSift()));
		} catch (Exception e) {
			response = new ErrorResponse(request, e);
		}
		return response;
	}

}

