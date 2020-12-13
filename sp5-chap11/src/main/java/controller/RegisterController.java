package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
	
	@RequestMapping("/register/step1")
	public String handleStep1(){
		System.out.println("handelStep1 호출");
		return "register/step1";
	}
	
	@PostMapping("/register/step2")
	public String handleStep2(@RequestParam(value="agree", defaultValue="false")
	Boolean agreeVal) { // agree요청 값을 읽어와 boolean타입으로 변환해서 agreeval파라메터에 전달함
		System.out.println("register step2 타입 결과 : " + agreeVal);
		if(!agreeVal){
			System.out.println("register step2 타입 결과 : " + agreeVal);
			return "register/step1";
		}

		return "register/step2";		
}
	
public String handleStep3(){ // 준비중
	return null;
	}
	
	
}
