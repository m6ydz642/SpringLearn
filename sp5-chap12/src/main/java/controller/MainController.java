package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	/*사실 이 메인 컨트롤러는 MvcConfig/addViewControllers() 함수에서 
	 * 컨트롤러 구현 없이 메인으로 오게하는 역할을 이미 하고 있기 때문에 별도로 여기에 
	 * 
	 * 필요없으나 지금 무슨 오류인지는 모르겠지만
	 * MvcConfig에서 addViewControllers가 오버라이딩이 안되서 되는지 안되는지를 모르겠음
	 * 
	 * 
	 * */
	@RequestMapping("/mains")
	public String main(){
		return "main";
	}
}
