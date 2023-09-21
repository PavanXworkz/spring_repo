package com.xworkz.microsoft.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class MicrosoftController implements Software{

	@Bean
	@Override
	public String newSoftware() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(Linux.class,Mac.class);
		int countBean = context.getBeanDefinitionCount();
		System.out.println(countBean);
		String[] beansName=context.getBeanDefinitionNames();
		for (String bn : beansName) {
			System.out.println(bn);

		}
	}

}
