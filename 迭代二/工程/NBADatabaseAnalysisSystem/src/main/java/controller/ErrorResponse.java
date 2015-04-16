package controller;

public class ErrorResponse implements Response {

	private Request originalRequest;
	private Exception originalException;
	private static final String NAME = "Error";
	
	public ErrorResponse(Request request, Exception exception) {
		this.originalRequest = request;
		this.originalException = exception;
	}

	public Request getOriginalRequest() {
		return this.originalRequest;
	}

	public Exception getOriginalException() {
		return this.originalException;
	}

	public String getName() {
		return NAME;
	}
	
}
