package ro.company.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import ro.company.web.StringAddressConverter;
import ro.company.web.StringCarConverter;
import ro.company.web.StringDeptConverter;

/**
 * Created by Cristian.Dumitru on 3/9/2015.
 */
@Configuration
@EnableWebMvc
@ComponentScan("ro.company.web")
public class CompanyWebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(
                org.springframework.web.servlet.view.JstlView.class);
        resolver.setExposeContextBeansAsAttributes(true);

        return resolver;
    }

    @Bean
    public StringCarConverter stringCarConverter(){
        return new StringCarConverter();
    }

    @Bean
    public StringDeptConverter stringDeptConverter(){
        return new StringDeptConverter();
    }

    @Bean
    public StringAddressConverter stringAddressConverter(){
        return new StringAddressConverter();
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(stringCarConverter());
        registry.addConverter(stringDeptConverter());
        registry.addConverter(stringAddressConverter());
    }

    /**
     * Ask DispatcherServlet to forward requests for static resources to the servlet
     * container's default servlet and not to try to handle them itself.
     *
     * @param configurer - the default servlet.
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

        configurer.enable();
    }
}
