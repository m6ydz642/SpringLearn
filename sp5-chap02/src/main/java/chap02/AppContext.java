package chap02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 스프링 설정 클래스로 지정
public class AppContext {

	@Bean // 스프링이 관리하는 빈객체
	public Gretter gretter() { 
		Gretter g = new Gretter();
		g.setFormat("%s,님 안녕");
		return g;
		
	}
}
