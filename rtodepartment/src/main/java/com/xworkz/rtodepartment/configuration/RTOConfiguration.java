package com.xworkz.rtodepartment.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ComponentScan("com.xworkz")
@Configuration
public class RTOConfiguration {
	public RTOConfiguration() {
		System.out.println("RTO Configuration Constructor");
	}

	@Bean
	public ViewResolver ViewResolver() {
		System.out.println("view Resolver method");
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean bean() {
		System.out.println("Local Container Entity Mange Factory Bean");
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		return bean;

	}

}
