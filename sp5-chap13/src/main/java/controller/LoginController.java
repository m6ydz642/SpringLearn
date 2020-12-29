package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.AuthInfo;
import spring.AuthService;
import spring.WrongIdPasswordException;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	private AuthService authService;
	
	
	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}


	@GetMapping
	public String form(@ModelAttribute("login") LoginCommand loginCommand) {
		System.out.println("loginController Form호출");
		return "login/loginForm";
	}

@PostMapping
public String submit(LoginCommand loginCommand, Errors errors) {
	new LoginCommandValidator().validate(loginCommand, errors);
	if (errors.hasErrors()) {
		return "login/loginForm";
	}
	try {
		AuthInfo autoInfo = authService.authenticate(loginCommand.getEmail(), loginCommand.getPassword());
		
		// TODO 세션에 authinfo 저장해야 함
		return "login/loginSuccess";
	} catch (WrongIdPasswordException e) {
		errors.reject("idPasswordNotMatching");
		return "loign/loginForm";
		}
	}

}
