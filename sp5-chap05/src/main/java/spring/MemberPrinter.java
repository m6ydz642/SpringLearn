package spring;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;

public class MemberPrinter {
/*	@Autowired(required = false)
	private Optional<DateTimeFormatter> formatterOpt; // 혹은
*/	
	@Nullable // 위 방식도 되지만 이런방식도 가능
	// Nullable어노테이션을 사용하면 일치하는 빈이 없을때 Null값을 할당함
	private DateTimeFormatter dateTimeFormatter;
	
	public MemberPrinter() {
	dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
	}
	
	
	public void memberprint(Member member) { // 콘솔로 찍을 printf문
		System.out.printf("회원정보 : 아이디 %d, 이메일 %d 이름 %s 등록일 %tF \n", 
				member.getId(), member.getEmail(), member.getName(), member.getRegisterDateTime());
		
	}
}
