package spring.tutorial.test.bean.assem.advanced;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.tutorial.bean.assem.JavaConfig;
import spring.tutorial.bean.assem.advanced.manager.impl.ServiceRequest;

public class ServiceRequestTest {

	@Test
	public void test() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		ServiceRequest serviceRequest = context.getBean(ServiceRequest.class);
		Boolean hasPermission = serviceRequest.accessUri("user");
		if (hasPermission) {
			System.out.println("you have permisssion");
		} else {
			System.out.println("you don't have permission");
		}
	}
}
