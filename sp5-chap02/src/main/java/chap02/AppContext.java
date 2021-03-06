package chap02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 스프링 설정 클래스로 지정
public class AppContext {

	@Bean // 스프링이 관리하는 빈객체
	public Gretter gretter() { 
		Gretter g = new Gretter();
		g.setFormat("님 안녕");
		return g;
		
	}
	
	@Bean // 스프링이 관리하는 빈객체
	public Gretter gretter2() { // gretter2이름으로 객체 한개 더 생성 
		Gretter g = new Gretter();
		g.setFormat("%s 님 안녕? (2번째 객체) ");
		return g;
		
	}
}
