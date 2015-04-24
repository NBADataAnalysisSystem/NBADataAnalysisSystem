package controller.playercontroller;

import service.playerservice.GetPlayerBasicInfoService;
import serviceimp.playerserviceimp.GetPlayerBasicInfoServiceImp;
import controller.controller.ErrorResponse;
import controller.controller.Request;
import controller.controller.RequestHandler;
import controller.controller.Response;

public class GetPlayerBasicInfoHandler implements RequestHandler {

	public Response process(Request request) throws Exception {
		Response response;
		GetPlayerBasicInfoService getPlayerService = new GetPlayerBasicInfoServiceImp();
		try {
			//GetPlayerBasicInfoRequest getPlayerRequest = (GetPlayerBasicInfoRequest) request;
			response = new GetPlayerBasicInfoResponse(
					getPlayerService.getPlayer());
		} catch (Exception e) {
			response = new ErrorResponse(request, e);
		}
		return response;
	}

}
