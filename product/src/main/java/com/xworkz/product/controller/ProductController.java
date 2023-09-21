package com.xworkz.product.controller;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/")
public class ProductController {

	@PostMapping("/bill")
	public String printBill(@RequestParam String productName, @RequestParam int rating, @RequestParam double price,
			@RequestParam int quantity, @RequestParam String reviews,Model model) {

		model.addAttribute("produtName",productName);
		model.addAttribute("rating",rating);
		model.addAttribute("price",price);
		model.addAttribute("quantity",quantity);
		model.addAttribute("reviews",reviews);
		int total=(int) (quantity*price);

		System.out.println(productName+"/"+rating+"/"+price+"/"+quantity+"/"+reviews+"/"+total);
		model.addAttribute("total",total);

		return "index.jsp";

	}
}
