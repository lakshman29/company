package com;

import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.company.config.JerseyConfig;


/*//@SpringBootApplication
@EnableAutoConfiguration
//@ComponentScan(basePackageClasses = {RestResource.class, MessageService.class,CompanyService.class,CompanyServiceImpl.class})
@ComponentScan("com.geowarin")
@EntityScan(basePackages = {"com.geowarin.domain"})
@EnableJpaRepositories(basePackages = {"com.geowarin.repository"})*/

/*@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages ="com.company.*")*/

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
        new SpringApplicationBuilder(Application.class)
                .showBanner(false)
                .run(args);
    }

    @Bean
    public ServletRegistrationBean jerseyServlet() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), "/rest/*");
        registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyConfig.class.getName());
        return registration;
    }
   /* @Bean
    public ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
        registration.addUrlMappings("/console/*");
        return registration;
    }*/
}
