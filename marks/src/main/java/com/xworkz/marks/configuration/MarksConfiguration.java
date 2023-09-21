package com.xworkz.marks.configuration;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.xworkz")
public class MarksConfiguration {

	public MarksConfiguration() {
		System.out.println("new marks configuration");
	}
}
