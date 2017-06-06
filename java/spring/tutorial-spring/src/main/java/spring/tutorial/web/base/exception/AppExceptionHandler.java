package spring.tutorial.web.base.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(TutorialException.class)
	@ResponseBody
	public String handlerTutorialException(TutorialException e) {
		return String.format("statusCode is %s, errorCode is %s, errorMsg is %s", e.getStatusCode(), e.getErrorCode(), e.getErrorMsg());
	}
}
