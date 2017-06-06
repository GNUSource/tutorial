package spring.tutorial.web.base.vo;

import org.springframework.web.multipart.MultipartFile;

public class UserVO {

	
	private String name;
	
	private String gender;
	
	private MultipartFile avatar;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public MultipartFile getAvatar() {
		return avatar;
	}

	public void setAvatar(MultipartFile avatar) {
		this.avatar = avatar;
	}
	

}
