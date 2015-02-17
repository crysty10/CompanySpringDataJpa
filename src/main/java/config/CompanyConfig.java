package config;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.inject.Inject;
import javax.sql.DataSource;

/**
 * Created by Cristian.Dumitru on 2/17/2015.
 */
@Configuration
@EnableJpaRepositories(basePackages = "repository")
@ComponentScan("repository")
@PropertySource("classpath:/jpaConnection.properties")
public class CompanyConfig {

    @Inject
    Environment env;

    @Bean
    public DataSource dataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(org.postgresql.Driver.class);

        /*dataSource.setUsername("postgres");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/Company");
        dataSource.setPassword("admin");*/

        dataSource.setUsername(env.getProperty("dataSource.username"));
        dataSource.setUrl(env.getProperty("dataSource.url"));
        dataSource.setPassword(env.getProperty("dataSource.password"));

        return dataSource;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {

        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.POSTGRESQL);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(false);
        adapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
        return adapter;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        LocalContainerEntityManagerFactoryBean emfb =
                new LocalContainerEntityManagerFactoryBean();
        emfb.setDataSource(dataSource());
        emfb.setJpaVendorAdapter(jpaVendorAdapter());
        //looking for classes with @Entity
        emfb.setPackagesToScan("domain");

        return emfb;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }
}
