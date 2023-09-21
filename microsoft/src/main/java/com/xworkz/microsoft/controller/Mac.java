package com.xworkz.microsoft.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("/")
public class Mac implements Software{

	@Bean
	@Override
	public String newSoftware() {
		// TODO Auto-generated method stub
		return null;
	}

}
