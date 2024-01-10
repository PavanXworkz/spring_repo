package com.xworkz.resort1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ComponentScan("com.xworkz")
@Configuration
public class Resort1Configuration {

	public Resort1Configuration() {
		System.out.println("Configuration of resort");
	}

	@Bean
	public ViewResolver viewResolver() {
		System.out.println("View Resolver bean ");
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean bean() {
		System.out.println("Local Container Entity Manager Factory Bean");
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		return bean;
	}
}
