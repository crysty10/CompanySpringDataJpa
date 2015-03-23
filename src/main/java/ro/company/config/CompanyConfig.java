package ro.company.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import ro.company.web.*;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Cristian.Dumitru on 2/17/2015.
 */
@Configuration
@EnableJpaRepositories(basePackages = "ro.company.repository")
//@EnableAspectJAutoProxy//(proxyTargetClass = true)
@ComponentScan(value = {"ro.company.repository", "ro.company.aspects", "ro.company.service", "ro.company"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)})
//@PropertySource("classpath:/resources/jpaConnection.properties")
@EnableJpaAuditing
@EnableTransactionManagement
//@EnableLoadTimeWeaving
public class CompanyConfig implements LoadTimeWeavingConfigurer {

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
    public ConversionService conversionService() {
        FormattingConversionServiceFactoryBean conversionService = new FormattingConversionServiceFactoryBean();
        Set<Converter> converters = new HashSet<>();
        converters.add(new StringDeptConverter());
        converters.add(new StringCarConverter());
        converters.add(new StringAddressConverter());
        conversionService.setConverters(converters);
        return conversionService.getObject();
    }

    @Bean
    public CustomWebBindingInitializer customWebBindingInitializer(){
        return new CustomWebBindingInitializer();
    }

    @Inject
    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter(CustomWebBindingInitializer customWebBindingInitializer){

        RequestMappingHandlerAdapter requestMappingHandlerAdapter = new RequestMappingHandlerAdapter();
        requestMappingHandlerAdapter.setWebBindingInitializer(customWebBindingInitializer);
        return requestMappingHandlerAdapter;
    }


    @Bean
    public MessageSource messageSource() {

        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        //messageSource.setCacheSeconds(1);
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.setValidationMessageSource(messageSource());
        localValidatorFactoryBean.setParameterNameDiscoverer(new LocalVariableTableParameterNameDiscoverer());

        return localValidatorFactoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }

    @Override
    public LoadTimeWeaver getLoadTimeWeaver() {
        return new InstrumentationLoadTimeWeaver();
    }
}
