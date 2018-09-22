package com.example.demo.controller;


import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}
	
	@RequestMapping("/challenge")
	public String challenge(@RequestParam(value = "name") String name, Model model) {
		model.addAttribute("name", name);
		return "challenge";
	}
	
	@RequestMapping(value = {"/challenge", "/challenge/{name}"})
	public String challengePath (@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		}else {
			model.addAttribute("name", "KB");
		}
		return "challenge";
	}
	
	@RequestMapping("/generator")
	public String generator(@RequestParam(value = "a", defaultValue = "0") int a, @RequestParam(value = "b", defaultValue = "0") int b, Model model) {
		
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		String text = "h";
		
		if (a==0) {
			text += "m";
		}else {
			for (int i = 0; i<a; i++) {
				text += "m";
			}
		}
		String text2 = text;
		for(int j = 1; j<b; j++) {
			text2 = text2 + " " +text;
		}
		
		model.addAttribute("text", text2);
		
		return "generator";
	}
}
