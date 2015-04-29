package controller.teamcontroller;

import service.teamservice.GetTeamSeasonTotalBasicInfoService;
import serviceimp.teamserviceimp.GetTeamSeasonTotalBasicInfoServiceImp;
import controller.controller.ErrorResponse;
import controller.controller.Request;
import controller.controller.RequestHandler;
import controller.controller.Response;

public class GetTeamSeasonTotalBasicInfoHandler implements RequestHandler {

	public Response process(Request request) throws Exception {
		Response response;
		GetTeamSeasonTotalBasicInfoService getTeamService = new GetTeamSeasonTotalBasicInfoServiceImp();
		try {
			GetTeamSeasonTotalBasicInfoRequest getTeamRequest = (GetTeamSeasonTotalBasicInfoRequest) request;
			response = new GetTeamSeasonTotalBasicInfoResponse(
					getTeamService.getTeam(getTeamRequest.getSift()));
		} catch (Exception e) {
			response = new ErrorResponse(request, e);
		}
		return response;
	}

}
