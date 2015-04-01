package controller.playercontroller;

import service.playerservice.SiftPlayerService;
import serviceimp.playerserviceimp.SiftPlayerServiceImp;
import controller.controller.ErrorResponse;
import controller.controller.Request;
import controller.controller.RequestHandler;
import controller.controller.Response;

public class SiftPlayerHandler implements RequestHandler {

	public Response process(Request request) {
		Response response;
		SiftPlayerService siftPlayerService = new SiftPlayerServiceImp();
		try {
			SiftPlayerRequest siftPlayerRequest = (SiftPlayerRequest) request;
			response = new SiftPlayerResponse(
					siftPlayerService.siftPlayer(
							siftPlayerRequest.getColumnList(), 
							siftPlayerRequest.getPosition(), 
							siftPlayerRequest.getUnion(),
							siftPlayerRequest.getSortBy()));
		} catch (Exception e) {
			response = new ErrorResponse(request, e);
		}
		return response;
	}

}
