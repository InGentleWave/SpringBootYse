package kr.or.ddit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping({"/","/main.do"})
	public String home(Model model) {
		model.addAttribute("msg","Hello Spring Boot!");
		return "home";
	}
}
