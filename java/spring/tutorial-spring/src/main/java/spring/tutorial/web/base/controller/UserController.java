package spring.tutorial.web.base.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import spring.tutorial.web.base.exception.TutorialException;
import spring.tutorial.web.base.vo.UserVO;

@Controller
@RequestMapping(value="/test")
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
	
	@ResponseBody
	@RequestMapping(value="/upload/byte", method=RequestMethod.POST)
	public String uploadFile1(
			@RequestPart("avatar") byte[] file,
			@RequestParam(value="name", required=true) String name,
			@RequestParam(value="gender", required=true) String gender) {
		return String.format("filesize is %s, name is %s, gender is %s", file.length, name, gender);
	}
	
	@ResponseBody
	@RequestMapping(value="/upload/multipartFile", method=RequestMethod.POST)
	public String uploadFile2(
			@RequestPart("avatar") MultipartFile file,
			@RequestParam(value="name", required=true) String name,
			@RequestParam(value="gender", required=true) String gender) {
		try {
			// 将文件保存到文件系统
			file.transferTo(new File("D:/workspace/kaifei/upload/" + file.getOriginalFilename()));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return String.format("filename is %s, name is %s, gender is %s", file.getOriginalFilename(), name, gender);
	}
	
	@ResponseBody
	@RequestMapping(value="/upload/multipartFile2", method=RequestMethod.POST)
	public String uploadFile3(UserVO requestVO) {
		return String.format("filename is %s, name is %s, gender is %s", requestVO.getAvatar().getOriginalFilename(), requestVO.getName(), requestVO.getGender());
	}

	@ResponseBody
	@RequestMapping(value="/exception1")
	public String handleException(){
		throw new TutorialException("this is test");
	}
}
