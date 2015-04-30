package controller.matchdetailcontroller;

import service.matchdetailservice.MatchDetailService;
import serviceimp.matchdetailserviceimp.MatchDetailServiceImp;
import controller.controller.ErrorResponse;
import controller.controller.Request;
import controller.controller.RequestHandler;
import controller.controller.Response;

public class GetMatchDetailInfoHandler implements RequestHandler {

	public Response process(Request request) throws Exception {
		Response response;
		MatchDetailService getMatchService = new MatchDetailServiceImp();
		try {
			GetMatchDetailInfoRequest getMatchRequest = (GetMatchDetailInfoRequest) request;
			response = new GetMatchDetailInfoResponse(
					getMatchService.getTeamMatchPerformance(getMatchRequest.getMatchName()),
					getMatchService.getRivalTeamMatchPerformance(getMatchRequest.getMatchName()));
			getMatchService.close();
		} catch (Exception e) {
			response = new ErrorResponse(request, e);
		}
		return response;
	}

}
