package com.xworkz.product.configuration;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.xworkz")
public class ProductConfiguration {

	public ProductConfiguration() {
	System.out.println("new project on product bill");
	}
}
