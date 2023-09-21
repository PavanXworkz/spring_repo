package com.xworkz.marks.controller;


import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/")
public class MarksController {

	@PostMapping("/marksCard")
	public String marksCard(@RequestParam int kannada, @RequestParam int english, @RequestParam int hindi,
			@RequestParam int maths, @RequestParam int science, @RequestParam int social, 
			Model model) {

		
		model.addAttribute("kannada", kannada);
		model.addAttribute("english", english);
		model.addAttribute("hindi", hindi);
		model.addAttribute("maths", maths);
		model.addAttribute("science", science);
		model.addAttribute("social", social);
		int total=kannada+english+hindi+maths+science+social;
			model.addAttribute("total", total);

		double percentage=(total*100)/600;
		model.addAttribute("persentage", percentage);

		 System.out.println(kannada+"--"+english+"--"+hindi+"--"+maths+"--"+science+"--"+social+"--"+total+"--"+percentage);
		int[] marks= {kannada,english,hindi,maths,science,social,};
		int large=marks[0];
		for(int i=0;i<marks.length;i++) {
			if (marks[i]>large) {
				large=marks[i];
			}
		}
		System.out.println("highest score="+large);
		
		int lowest=marks[0];
		for (int i = 0; i < marks.length; i++) {
			if (marks[i]<lowest) {
				lowest=marks[i];
			}
		}
		System.out.println("loewst sccore="+lowest);
		model.addAttribute("lowest", lowest);
		model.addAttribute("largest", large);
		 return "Result.jsp";

	}
}
