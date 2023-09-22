package com.xworkz.resort1.configuration;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class Resort1WebInit extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer{



@Override
protected Class<?>[] getRootConfigClasses() {
	// TODO Auto-generated method stub
	return null;
}

@Override
protected Class<?>[] getServletConfigClasses() {
	// TODO Auto-generated method stub
	return new Class[] {Resort1Configuration.class};
}

@Override
protected String[] getServletMappings() {
	// TODO Auto-generated method stub
	return new String[] {"/"};
}
}
