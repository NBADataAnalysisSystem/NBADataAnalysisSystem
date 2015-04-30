package controller.teamdetailcontroller;

import service.teamdetailservice.GetTeamDetailInfoService;
import serviceimp.teamdetailserviceimp.GetTeamDetailInfoServiceImp;
import controller.controller.ErrorResponse;
import controller.controller.Request;
import controller.controller.RequestHandler;
import controller.controller.Response;

public class GetTeamDetailInfoHandler implements RequestHandler {

	public Response process(Request request) throws Exception {
		Response response;
		GetTeamDetailInfoService getTeamService = new GetTeamDetailInfoServiceImp();
		try {
			GetTeamDetailInfoRequest getTeamRequest = (GetTeamDetailInfoRequest) request;
			response = new GetTeamDetailInfoResponse(
					getTeamService.getTeamBasicInfo(getTeamRequest.getTeamName()),
					getTeamService.getTeamSeasonAvgInfo(getTeamRequest.getTeamName()),
					getTeamService.getTeamSeasonTotalInfo(getTeamRequest.getTeamName()),
					getTeamService.getTeamPlayerInfo(getTeamRequest.getTeamName()));
			getTeamService.close();
		} catch (Exception e) {
			response = new ErrorResponse(request, e);
		}
		return response;
	}

}
