package spring.tutorial.test.bean.assem;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.tutorial.bean.assem.JavaConfig;
import spring.tutorial.bean.assem.manager.IPlant;
import spring.tutorial.bean.assem.manager.impl.Tree;

public class TreeTest {
	
	@SuppressWarnings("resource")
	@Test
	public void test() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		IPlant plant = (IPlant) context.getBean(Tree.class);
		plant.getName();
	}
}
