package ro.company.config;

import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.inject.Inject;
import javax.sql.DataSource;

//import ro.company.aspects.AuditableIntroducer;

/**
 * Created by Cristian.Dumitru on 2/17/2015.
 */
@Configuration
@EnableJpaRepositories(basePackages = "ro.company.repository")
@EnableAspectJAutoProxy//(proxyTargetClass = true)
@ComponentScan(value = {"ro.company.repository", "ro.company.aspects", "ro.company.service"}, excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)})
//@PropertySource("classpath:/resources/jpaConnection.properties")
@EnableJpaAuditing
@EnableTransactionManagement
//@EnableLoadTimeWeaving(aspectjWeaving = EnableLoadTimeWeaving.AspectJWeaving.ENABLED)
public class CompanyConfig { //implements LoadTimeWeavingConfigurer {

    @Inject
    Environment env;

    @Bean
    //@Profile("withProp")
    public DataSource dataSource() {

        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(org.postgresql.Driver.class);

//        dataSource.setUsername(env.getProperty("dataSource.username"));
//        dataSource.setUrl(env.getProperty("dataSource.url"));
//        dataSource.setPassword(env.getProperty("dataSource.password"));

        dataSource.setUsername("postgres");
        dataSource.setPassword("admin");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/Company");
        return dataSource;
    }

    @Bean
    //@Profile("withoutProp")
    public DataSource newDataSource() {

        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(org.postgresql.Driver.class);
        dataSource.setUsername("postgres");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/Company");
        dataSource.setPassword("admin");

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
        emfb.setPackagesToScan("ro/company/domain");

        return emfb;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }

    /*@Override
    public LoadTimeWeaver getLoadTimeWeaver() {
        return new InstrumentationLoadTimeWeaver();
    }*/
}
