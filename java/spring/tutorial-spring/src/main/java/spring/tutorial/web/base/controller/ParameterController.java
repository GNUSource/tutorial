package spring.tutorial.web.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.tutorial.web.base.dao.User;

@Controller
@RequestMapping("/param")
public class ParameterController {

	/**
	 * `@RequestParam` 接收单个的查询参数
	 * 
	 * @param pageSize
	 * @param pageNum
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/queryParam", method = RequestMethod.GET)
	public String getQueryParam(@RequestParam(value = "pageSize", required = true) Integer pageSize,
			@RequestParam(value = "pageNum", defaultValue = "1", required = false) Integer pageNum) {
		return String.format("pageSize is %s, pageNum is %s", pageSize, pageNum);
	}

	/**
	 * `@PathVariable` 注解接收路径参数
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/pathVariableParam/pageNum/{pageNum}/pageSize/{pageSize}")
	public String getPathVariableParam(@PathVariable(value = "pageNum") Integer pageNum,
			@PathVariable(value = "pageSize") Integer pageSize) {
		return String.format("pageSize is %s, pageNum is %s", pageSize, pageNum);
	}

	/**
	 * `@RequestBody` 注解将请求体转换为对象
	 * 
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/requestBoay", method = RequestMethod.POST)
	public String getRequestBody(@RequestBody User user) {
		return "";
	}

	/**
	 * `@CookieValue` 注解接收 Cookie 值
	 * 
	 * @param sessionId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/cookieValue")
	public String getCookieValue(@CookieValue(value = "JSESSIONID", defaultValue = "") String sessionId) {
		return String.format("sessionId is %s", sessionId);
	}

	/**
	 * `@RequestHeader` 注解接收请求头
	 * 
	 * @param authorization
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/headerValue", method = RequestMethod.GET)
	public String getHeaderValue(@RequestHeader(value = "Authorization") String authorization) {
		return String.format("Authorization is %s", authorization);
	}
	
	/**
	 * 所有的请求信息都可以通过 HttpServletRequest 对象来获取
	 * 
	 * @param httpServletRequest
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/requestInfo", method = RequestMethod.GET)
	public String getRequestInfo(HttpServletRequest httpServletRequest) {
		return String.format("content-type is %s", httpServletRequest.getContentType());
	}

}
