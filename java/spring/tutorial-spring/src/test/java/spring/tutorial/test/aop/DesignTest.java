package spring.tutorial.test.aop;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.tutorial.aop.annotation.JavaConfig;
import spring.tutorial.aop.annotation.manager.impl.DesignManagerImpl;

public class DesignTest {
	
	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

	@Test
	public void test() {
		DesignManagerImpl designManagerImpl = context.getBean(DesignManagerImpl.class);
		designManagerImpl.getDetail(1);
		designManagerImpl.getDetail(2);
		designManagerImpl.getDetail(1);
		designManagerImpl.getDetail(1);
		designManagerImpl.getDetail(3);
		designManagerImpl.getDetail(2);
	}
}


