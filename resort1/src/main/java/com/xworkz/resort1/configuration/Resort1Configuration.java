package com.xworkz.resort1.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.xworkz")
@Configuration
public class Resort1Configuration {

	public Resort1Configuration() {
		System.out.println("Configuration of resort");
	}
}
