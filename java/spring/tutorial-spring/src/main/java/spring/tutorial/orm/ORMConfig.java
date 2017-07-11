package spring.tutorial.orm;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import spring.tutorial.jdbc.DataSourceConfig;

import javax.sql.DataSource;


@Configuration
@ComponentScan
@EnableJpaRepositories(
        basePackages = "spring.tutorial.orm.repository",
        entityManagerFactoryRef = "entityManagerFactoryBean"
)
@Import({DataSourceConfig.class})
public class ORMConfig {

    /**
     * 配置 Hibernate 的 SessionFactory
     * @return
     */
//    @Bean
//    public LocalSessionFactoryBean sessionFactoryBean(DataSource dataSource) {
//        LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
//        sfb.setDataSource(dataSource);
//        sfb.setPackagesToScan(new String[] {"spring.tutorial.orm.domain", "spring.tutorial.orm.repository"});
//        Properties properties = new Properties();
//        properties.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
//        properties.setProperty("show_sql", "true");
//        properties.setProperty("format_sql", "true");
//        sfb.setHibernateProperties(properties);
//        return sfb;
//    }

    @Bean
    public JpaVendorAdapter JpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(false);
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
        return adapter;
    }

    /**
     * 配置 JPA 的 EntityManager
     *
     * @param dataSource
     * @param adapter
     * @return
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource dataSource, JpaVendorAdapter adapter) {
        LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
        emfb.setDataSource(dataSource);
        emfb.setJpaVendorAdapter(adapter);
        emfb.setPackagesToScan("spring.tutorial.orm.domain");
        return emfb;
    }


}
