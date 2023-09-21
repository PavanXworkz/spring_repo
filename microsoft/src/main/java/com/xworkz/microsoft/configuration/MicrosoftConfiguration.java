package com.xworkz.microsoft.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xworkz")
public class MicrosoftConfiguration {
	public MicrosoftConfiguration() {
		System.out.println("MicroSoft Configuration");
	}
}
