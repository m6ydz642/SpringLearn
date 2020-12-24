package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebMvc // 스프링 MVC설정 활성화

public class MvcConfig implements WebMvcConfigurer{ // MVC개별설정을 조정할 때 사용
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
		//  디스패쳐서블릿의 매핑 경로를 /로 주었을 때, JSP/HTML/CSS등을 올바르게 처리하기 위한 설정
		configurer.enable();
		
	}
	@Override
	public void configureViewResolvers(ViewResolverRegistry registy){
		// JSP를 이용해서 컨트롤러의 실행 결과를 보여주기 위한 설정 추가
		registy.jsp("/WEB-INF/view/", ".jsp");
		System.out.println("configureViewResolvers() 경로 호출");
	}
	
	public void addViewControllers(ViewControllerRegistry registry){ 
		// 별도의 메인 컨트롤러 구현 없이 메인으로 오게하는 함수 
		System.out.println("별도의 메인 컨트롤러 구현 없이 메인으로 오게하는 함수호출");
		registry.addViewController("/main").setViewName("main");
	}
	


}
