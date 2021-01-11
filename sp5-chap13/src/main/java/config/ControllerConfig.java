package config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.ChangePwdController;
import controller.LoginController;
import controller.LogoutController;
import controller.RegisterController;
import spring.AuthService;
import spring.ChangePasswordService;
import spring.MemberRegisterService;
import survey.SurveyController;



@Configuration
public class ControllerConfig {
	
	@Autowired
	private MemberRegisterService memberRegSvc;
	@Autowired
	private AuthService authService;
	@Autowired
	private ChangePasswordService changePasswordService;
	
	// 패스워드 변경 컨트롤러 설정
	@Bean
		public ChangePwdController changePwdController() {
			ChangePwdController controller = new ChangePwdController();
			controller.setChangePasswordService(changePasswordService);
			return controller;
		}
	
	@Bean // 빈 등록
	public RegisterController registerController() {
		System.out.println("ControllerConfig호출 ");
		RegisterController controller = new RegisterController();
		controller.setMemberRegisterService(memberRegSvc);
		return controller;
	}
	
	@Bean
	public SurveyController surveyController(){
		return new SurveyController();
	}
	
	@Bean
	public LoginController loginController() {
		LoginController controller = new LoginController();
		controller.setAuthService(authService);
		return controller;
	}
	
	@Bean
	public LogoutController logoutController(){
		return new LogoutController();
	}
}
