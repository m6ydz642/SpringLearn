package config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.RegisterController;



@Configuration
public class ControllerConfig {
	
	@Bean // 빈 등록
	public RegisterController registerController() {
		System.out.println("ControllerConfig호출 ");
		return new RegisterController();

	}
}
