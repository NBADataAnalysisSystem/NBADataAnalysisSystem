package controller.teamcontroller;

import java.util.HashMap;
import java.util.Map;

import controller.controller.Controller;
import controller.controller.ErrorResponse;
import controller.controller.Request;
import controller.controller.RequestHandler;
import controller.controller.Response;

public class TeamController implements Controller {

	private Map<String, RequestHandler> requestHandlers;
	
	public TeamController() {
		requestHandlers = new HashMap<String, RequestHandler>();
		requestHandlers.put("GetTeam", new GetTeamHandler());
	}
	
	protected RequestHandler getHandler(Request request) {
		if (!this.requestHandlers.containsKey(request.getName())) {
			String message = "Cannot find handler for request name "
					+ "[" + request.getName() + "]";
			throw new RuntimeException(message);
		}
		return (RequestHandler) this.requestHandlers.get(request.getName());
	}
	
	public Response processRequest(Request request) {
		Response response;
		try {
			response = getHandler(request).process(request);
		} catch(Exception exception) {
			response = new ErrorResponse(request, exception);
		}
		return response;
	}
	
	public void addHandler(Request request, RequestHandler requestHandler) {
		if (this.requestHandlers.containsKey(request.getName())) {
			throw new RuntimeException("A request handler has "
					+ "already been registered for request name "
					+ "[" + request.getName() + "]");
		} else {
			this.requestHandlers.put(request.getName(), requestHandler);
		}
	}
	
}
