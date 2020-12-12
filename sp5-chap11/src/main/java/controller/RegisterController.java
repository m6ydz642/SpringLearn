package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {
	
	@RequestMapping("/register/step1")
	public String handleStep1(){
		return "register/step1";
	}
	
	public String handleStep2(){ // 준비중
		return null;
		
	}
	
public String handleStep3(){ // 준비중
	return null;
	}
	
	
}
