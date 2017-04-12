package spring.tutorial.test.bean.assem;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.tutorial.bean.assem.JavaConfig;
import spring.tutorial.bean.assem.manager.impl.Bwm;

public class BWMTest {

	@Test
	public void test() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		Bwm bwm = (Bwm) context.getBean("car");
		bwm.getIflower().sayName();
		bwm.sayName();
	}
}
