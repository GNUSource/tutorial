package spring.tutorial.web.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@ResponseBody
	@RequestMapping(value={"/", "/hello"}, method=RequestMethod.GET)
	public String sayHello() {
		return "say hello";
	}
	
	@RequestMapping(value="/helloWorld", method=RequestMethod.GET)
	public String helloWorld() {
		return "hello world";
	}

}
