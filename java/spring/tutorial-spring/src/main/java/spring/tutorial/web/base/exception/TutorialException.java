package spring.tutorial.web.base.exception;

public class TutorialException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String statusCode = "400";

	private String errorCode = "bad request";
	
	private String errorMsg = "occur error";
	
	public TutorialException() {
		super();
	}
	

	public TutorialException(String errorMsg) {
		super();
		this.errorMsg = errorMsg;
	}


	public TutorialException(String errorCode, String errorMsg) {
		super();
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public TutorialException(String statusCode, String errorCode, String errorMsg) {
		super();
		this.statusCode = statusCode;
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
	
}
