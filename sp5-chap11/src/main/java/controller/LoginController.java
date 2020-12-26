package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@GetMapping
	public String form(@ModelAttribute("login") LoginCommand loginCommand) {
		System.out.println("loginController Form호출");
		return "login/loginForm";
	}
	
	/*@GetMapping("/login")
	public String form(Model model) {
		System.out.println("LoginCommand 폼 호출");
		List<String> loginTypes = new ArrayList<>();
		loginTypes.add("일반회원");
		loginTypes.add("기업회원");
		loginTypes.add("헤드헌터 회원");
		model.addAttribute("loginTypes", loginTypes);
		return "login/form";
	}
	*/
	
/*	@PostMapping
	public String form(@ModelAttribute("login") LoginCommand loginCommand) {
		
	}*/
}
