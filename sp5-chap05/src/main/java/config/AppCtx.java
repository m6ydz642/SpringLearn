package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberListPrinter;
import spring.MemberPrinter;
import spring.MemberRegisterService;
import spring.MemberSummaryPrinter;
import spring.VersionPrinter;

@Configuration
@ComponentScan(basePackages = {"spring"} ) // 스프링폴더에 클래스들을 다 가져옴

public class AppCtx {
	
	@Bean
	@Qualifier("memberDao2")
	public MemberDao memberDao2(){ // 다른 이름으로 사용해보기
		MemberDao memberDao = new MemberDao();
		return memberDao;
	}
	
	@Bean
	@Qualifier("printer") // 자동 주입빈이 2개 이상일때 붙이는 어노테이션
	// MemberListPrinter클래스에 또 정의가 되어있음
	// Qualifier로 한정자 이름 정의안하면 메서드 이름을 자동으로 읽어서 한정자로 지정해 줌
	public MemberPrinter memberPrinter1(){
		return new MemberPrinter();
	}
/*	@Bean
	public MemberPrinter memberPrinter2(){
		return new MemberPrinter();
	}*/

	@Bean 
	@Qualifier("summaryPrinter")
	public MemberSummaryPrinter memberPrinter2() {
		return new MemberSummaryPrinter();
	}
	
	
	/*@ComponentScan(basePackages = {"spring"} ) 으로 spring폴더에 있는 항목들을 정의? 했기 때문에 
	 * spring 폴더에 MemberDao나 RegisterService클래스 같은 항목들은 빈으로 이전처럼 정의할 필요가 없어서 다 삭제 함
	 * 
	 * */
	
	@Bean
	public VersionPrinter versionPrinter(){
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter; // 객체로 리턴
	}

}
