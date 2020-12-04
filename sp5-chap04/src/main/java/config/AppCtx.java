package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
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
public class AppCtx {
	
	
	@Bean
	@Qualifier("printer1") // 자동 주입빈이 2개 이상일때 붙이는 어노테이션
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
	
	
	@Bean
	public MemberDao memberDao(){
		return new MemberDao(); // 리턴시 객체 생성?
	}
	
	@Bean
	public MemberRegisterService memberRegSvc(){
		return new MemberRegisterService(memberDao());
		
	}
	
	@Bean
	public ChangePasswordService changePwdSvc(){
		ChangePasswordService pwdSvc = new ChangePasswordService();
	//	pwdSvc.setMemberdao(memberDao()); // Auto와어드로 처리해서 메서드 호출 필요없음
		return pwdSvc;
	}
	
	@Bean
	public MemberPrinter memberPrinter(){
		return new MemberPrinter();
	}
	
	@Bean
	public MemberListPrinter listPrinter(){
		// return new MemberListPrinter(memberDao(), memberPrinter());
		return new MemberListPrinter();  // 이제 기본생성자로 호출함
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setPrinter(memberPrinter2()); // 초반에 memberPrinter()은 자동주입대상이라 밑에서 뺐는데 
												// 주석처리하고 책따라 다시 넣음
		// 그런데 MemberInfoPrinter에서 호출하면 memberPrinter2()가 아닌 1() 이 호출되는데 
		// 이는 세터메서드를 통해 의존을 주입해도 해당 세터 메서드에 Autowired때문에 자동주입으로 일치하는 
		// 빈이 알아서 자동으로 넣어졌기 때문임 
		
		// MemberInfoPrinter에서 @Autowired사용을 했기 때문에 메서드 호출 필요없음
	/*	infoPrinter.setMemDao(memberDao());
		infoPrinter.setPrinter(memberPrinter());*/
		return infoPrinter;
		
	}
	
	@Bean
	public VersionPrinter versionPrinter(){
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter; // 객체로 리턴
	}

}
