package spring.tutorial.test.jdbc;

import java.util.List;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.tutorial.jdbc.DataSourceConfig;
import spring.tutorial.jdbc.dao.User;
import spring.tutorial.jdbc.dao.repository.IUserRepository;

public class IUserRepositoryTest {
	
	public static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
	
	@Test
	public void testGetUserList() {
		IUserRepository iUserRepository = context.getBean(IUserRepository.class);
		List<User> user = iUserRepository.getUserList(1000);
		
		System.out.println("this is test");
	}
	
	@Test
	public void testGetUserDetail() {
		IUserRepository iUserRepository = context.getBean(IUserRepository.class);
		List<User> user = iUserRepository.getUserList(1000);
		
		System.out.println("this is test");
	}

}
