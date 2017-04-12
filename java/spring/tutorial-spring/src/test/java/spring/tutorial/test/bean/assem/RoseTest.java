package spring.tutorial.test.bean.assem;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.tutorial.bean.assem.JavaConfig;
import spring.tutorial.bean.assem.manager.impl.Rose;

public class RoseTest {

	
	@Test
	public void test() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		Rose rose = (Rose) context.getBean("flower");
		rose.sayName();
	}
}
