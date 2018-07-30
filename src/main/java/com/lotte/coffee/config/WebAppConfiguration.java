package com.lotte.coffee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.lotte.coffee"})
public class WebAppConfiguration extends WebMvcConfigurerAdapter {
	
	private static final String[] CLASSPATH_RESOURCE_LOCATIONS = { 
		      "classpath:/META-INF/resources/", 
		      "classpath:/resources/", 
		      "classpath:/static/" };
	
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
//        registry.addResourceHandler("/files/**")
//        		.addResourceLocations("file:///c:/attach/")
//        		.addResourceLocations("file:///c:/home/tensorflow2018/datasets/face/fromusers/");
    }

    
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}