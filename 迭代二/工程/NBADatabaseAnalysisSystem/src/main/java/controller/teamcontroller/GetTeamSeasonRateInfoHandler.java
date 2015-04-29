package controller.teamcontroller;

import service.teamservice.GetTeamSeasonRateInfoService;
import serviceimp.teamserviceimp.GetTeamSeasonRateInfoServiceImp;
import controller.controller.ErrorResponse;
import controller.controller.Request;
import controller.controller.RequestHandler;
import controller.controller.Response;

public class GetTeamSeasonRateInfoHandler implements RequestHandler {

	public Response process(Request request) throws Exception {
		Response response;
		GetTeamSeasonRateInfoService getTeamService = new GetTeamSeasonRateInfoServiceImp();
		try {
			GetTeamSeasonRateInfoRequest getTeamRequest = (GetTeamSeasonRateInfoRequest) request;
			response = new GetTeamSeasonRateInfoResponse(
					getTeamService.getTeam(getTeamRequest.getSift()));
		} catch (Exception e) {
			response = new ErrorResponse(request, e);
		}
		return response;
	}

}
