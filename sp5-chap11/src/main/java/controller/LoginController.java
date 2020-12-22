package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class LoginController {
	@GetMapping
	public String form(@ModelAttribute("login") LoginCommand loginCommand) {
		return "login/loginForm";
	}
	
	@PostMapping
	public String form(@ModelAttribute("login") LoginCommand loginCommand) {
		
	}
}
