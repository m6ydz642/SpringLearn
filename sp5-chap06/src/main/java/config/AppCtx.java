package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.Client;
import spring.Client2;


@Configuration
public class AppCtx {
	
	@Bean
	public Client client() {
		Client client = new Client();
		client.setHost("host");
		return client;
	}
	
	@Bean(initMethod = "connect", destroyMethod = "close")
	// 말 그대로 Client2에 정의되어있는 메소드 명을 적어서 사용 함
	// initMethod = "connect" - 초기화할 메서드 
	// destroyMethod = "close" - 소멸 메서드
	
	public Client2 client2() {
		Client2 client2 = new Client2();
		client2.setHost("host");
		return client2;
	}
	
}
