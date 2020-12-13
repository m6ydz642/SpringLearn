package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

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
	Boolean agreeVal, HttpServletResponse response) { // agree요청 값을 읽어와 boolean타입으로 변환해서 agreeval파라메터에 전달함
		System.out.println("register step2 타입 결과 : " + agreeVal);

		if(!agreeVal){
			try {
				
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('가입 실패'); location.href='/sp5-chap11/register/step1';</script>");
				out.flush();
				
			} catch (IOException e) {
				System.out.println("예외 발생 : " + e);
				e.printStackTrace();
			}
			
			System.out.println("register step2 타입 결과 : " + agreeVal);
			return "register/step1";// 위에서 리다이렉션 해줘서 사실 필요없음	
		}else{
			return "register/step2";	
		}

				
}
	
public String handleStep3(){ // 준비중
	return null;
	}
	
	
}
