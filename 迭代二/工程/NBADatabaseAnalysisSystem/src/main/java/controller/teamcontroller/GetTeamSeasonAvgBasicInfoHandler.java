package controller.teamcontroller;

import service.teamservice.GetTeamSeasonAvgBasicInfoService;
import serviceimp.teamserviceimp.GetTeamSeasonAvgBasicInfoServiceImp;
import controller.controller.ErrorResponse;
import controller.controller.Request;
import controller.controller.RequestHandler;
import controller.controller.Response;

public class GetTeamSeasonAvgBasicInfoHandler implements RequestHandler {

	public Response process(Request request) throws Exception {
		Response response;
		GetTeamSeasonAvgBasicInfoService getTeamService = new GetTeamSeasonAvgBasicInfoServiceImp();
		try {
			GetTeamSeasonAvgBasicInfoRequest getTeamRequest = (GetTeamSeasonAvgBasicInfoRequest) request;
			response = new GetTeamSeasonAvgBasicInfoResponse(
					getTeamService.getTeam(getTeamRequest.getSift()));
		} catch (Exception e) {
			response = new ErrorResponse(request, e);
		}
		return response;
	}

}
