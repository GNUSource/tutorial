package spring.tutorial.test.bean.assem;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.tutorial.bean.assem.JavaConfig;
import spring.tutorial.bean.assem.manager.impl.OnePlus;

public class OnePlusTest {

	@Test
	public void test() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		
		OnePlus onePlus = (OnePlus) context.getBean("phone");
		onePlus.sayName();
		onePlus.getIcar().sayName();
	}
}
