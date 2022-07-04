package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
			return "helloworld";
	}
	
	@RequestMapping("/processFormTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		String name = request.getParameter("studentName");
		
		String allCaps = "Yo " + name.toUpperCase();
		
		model.addAttribute("message", allCaps);
		
		return "helloworld";
	}
	
	@RequestMapping("/processFormThree")
	public String processFormVersionThree(@RequestParam("studentName") String studentName, Model model) {
		
		String allCaps = "Hey my friend! " + studentName.toUpperCase();
		
		model.addAttribute("message", allCaps);
		
		return "helloworld";
	}
}
