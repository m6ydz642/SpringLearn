package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberListPrinter;
import spring.MemberPrinter;
import spring.MemberRegisterService;
import spring.VersionPrinter;

@Configuration
public class AppCtx {
	
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
