package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	@GetMapping
	public String form(@ModelAttribute("login") LoginCommand loginCommand) {
		return "login/loginForm";
	}
	
/*	@PostMapping
	public String form(@ModelAttribute("login") LoginCommand loginCommand) {
		
	}*/
}
