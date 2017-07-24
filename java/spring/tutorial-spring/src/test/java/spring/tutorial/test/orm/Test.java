package spring.tutorial.test.orm;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.tutorial.orm.ORMConfig;

public class Test {

    private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ORMConfig.class);

    @org.junit.Test
    public void test() {
        SessionFactory bean = (SessionFactory) context.getBean("sessionFactoryBean");
        System.out.println(bean);
    }
}
