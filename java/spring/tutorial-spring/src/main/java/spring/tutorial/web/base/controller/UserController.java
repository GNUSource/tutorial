package spring.tutorial.web.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spring.tutorial.jdbc.dao.User;
import spring.tutorial.jdbc.dao.repository.IUserRepository;
import spring.tutorial.web.base.exception.TutorialException;
import spring.tutorial.web.base.vo.MessageVO;
import spring.tutorial.web.base.vo.UserVO;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value="/test")
public class UserController {
	
	@Autowired
	private IUserRepository iUserRepository;
	
	@ResponseBody
	@RequestMapping(value={"/", "/hello"}, method=RequestMethod.GET)
	public String sayHello() {
		System.out.println("This is test");
		return "say hello123s";
	}
	
	@RequestMapping(value="/helloWorld", method=RequestMethod.POST)
    @ResponseBody
	public MessageVO helloWorld(@RequestBody MessageVO messageVO) {
        messageVO.setMessage(String.format("original is ：%s", messageVO.getMessage()));
	    return messageVO;
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
	
	@ResponseBody
	@RequestMapping(value="/getUserList")
	public String getUserList() {
		List<User> users = iUserRepository.getUserList(1000);
		return null;
	}
}
