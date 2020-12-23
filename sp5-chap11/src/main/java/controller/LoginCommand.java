package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class LoginCommand {
	@GetMapping("/login")
	public String form(Model model) {
		System.out.println("로그인 폼 호출");
		List<String> loginTypes = new ArrayList<>();
		loginTypes.add("일반회원");
		loginTypes.add("기업회원");
		loginTypes.add("헤드헌터 회원");
		model.addAttribute("loginTypes", loginTypes);
		return "login/form";
	}
}
