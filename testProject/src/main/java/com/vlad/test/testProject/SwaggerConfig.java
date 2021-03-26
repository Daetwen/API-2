package com.vlad.test.testProject;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.web.context.request.async.DeferredResult;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Collections;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableAutoConfiguration
@Configuration
@EnableSwagger2
//@EnableWebMvc
// extends WebMvcConfigurerAdapter
//extends WebMvcConfigurationSupport
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.vlad"))
                .build()
                .pathMapping("/")
                .apiInfo(apiDetails());
    }

//    @Bean
//    public UiConfiguration uiConfig() {
//        return UiConfigurationBuilder.builder().build();
//    }

//    @Bean
//    public Docket swaggerConfiguration() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.vlad"))
//                .build()
//                .apiInfo(apiDetails());
//    }
//
    private ApiInfo apiDetails() {
        return new ApiInfo(
                "My first Persons API",
                "Sample first API for test",
                "1.0",
                "Free to use",
                new springfox.documentation.service.Contact("Vladislav Makarei","", "123.vlad.123.vlad.123@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0\"",
                Collections.emptyList());
    }


//    @Override
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/webjars.springfox-swagger-ui");
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars.springfox-swagger-ui");
//    }

//    @Override
//    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("**").addResourceLocations("classpath:/dist/");
//
//        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars.springfox-swagger-ui/");
//    }

//    @Override
//    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/doc/v1/**").addResourceLocations("classpath:/doc/v1/");
//        registry.addResourceHandler("/doc/v1/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }
}
