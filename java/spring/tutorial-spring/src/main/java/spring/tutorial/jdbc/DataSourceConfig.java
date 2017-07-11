package spring.tutorial.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@ComponentScan
public class DataSourceConfig {
	
	@Bean
	public DataSource dataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
			dataSource.setJdbcUrl("jdbc:mysql://localhost/data?useUnicode=true&characterEncoding=UTF-8&useSSL=true&serverTimezone=UTC");
			dataSource.setUser("root");
			dataSource.setPassword("admino0o0oo0");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		return dataSource;
	}

	@Bean
	public JdbcOperations jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
//	@Bean
//	public JndiObjectFactoryBean jdniObjectFactoryBean() {
//		JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
//		jndiObjectFactoryBean.setJndiName("jndi/test");
//		jndiObjectFactoryBean.setResourceRef(true);
//		jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
//		return jndiObjectFactoryBean;
//	}
//
//	@Bean
//	@Qualifier(Constants.BEAN_ID_DATA_SOURCE_JNDI)
//	public DataSource jndiDataSource(JndiObjectFactoryBean factoryBean) {
//		String driverClassName = factoryBean.getJndiEnvironment().getProperty("driverClassName");
//		String url = factoryBean.getJndiEnvironment().getProperty("url");
//		String user = factoryBean.getJndiEnvironment().getProperty("username");
//		String password = factoryBean.getJndiEnvironment().getProperty("password");
//		ComboPooledDataSource dataSource = new ComboPooledDataSource();
//		try {
//			dataSource.setDriverClass(driverClassName);
//			dataSource.setJdbcUrl(url);
//			dataSource.setUser(user);
//			dataSource.setPassword(password);
//		} catch (PropertyVetoException e) {
//			e.printStackTrace();
//		}
//		return dataSource;
//	}
	
}
