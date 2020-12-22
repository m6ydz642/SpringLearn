package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import spring.DuplicateMemberException;
import spring.MemberRegisterService;
import spring.RegisterRequest;

@Controller
public class RegisterController {
	
	private MemberRegisterService MemberRegisterService;
	
	public void setMemberRegisterService (MemberRegisterService memberRegisterService) {
		this.MemberRegisterService = memberRegisterService;
	}
	
	@RequestMapping("/register/step1")
	public String handleStep1(){
		System.out.println("handelStep1 호출");
		return "register/step1";
	}
	
	@PostMapping("/register/step2")
	public String handleStep2(@RequestParam(value="agree", defaultValue="false")
	// value="agree"는 step1에 name값 받아 오는 거임 체크가 되어있지 않을경우는 기본으로 false를 줌
	Boolean agreeVal, HttpServletResponse response, RegisterRequest registerRequest) { // agree요청 값을 읽어와 boolean타입으로 변환해서 agreeval파라메터에 전달함
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
		//	model.addAttribute("registerRequest",new RegisterRequest() ); // 속성 추가
			// 모델 파라미터 지워서 addAttribute를 추가할 수 없기 때문에 주석 처리
			return "register/step2";	
		}

				
}
	
	@PostMapping("/register/step3")
	public String handleStep3(@ModelAttribute("formData") RegisterRequest regReg) { // 준비중
		try {
			MemberRegisterService.regist(regReg);
			return "register/step3";
		} catch (DuplicateMemberException e) {
			return "register/step2"; // 예외시 리턴, 동일한 주소를 가진 회원이 있으면
			// 직접 만든 DuplicateMemberException을 사용
		}

	} // handleStep3
	
	
} // 클래스 마지막
