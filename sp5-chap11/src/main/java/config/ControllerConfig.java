package config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.RegisterController;



@Configuration
public class ControllerConfig {
	
	@Bean // 빈 등록
	public RegisterController registerController() {
		return new RegisterController();

	}
}
