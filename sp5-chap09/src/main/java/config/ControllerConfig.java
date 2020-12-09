package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import chap09.HelloController;

@Configuration
public class ControllerConfig {
	@Bean // 빈 등록
	public HelloController helloController() {
		return new HelloController();

	}
}
