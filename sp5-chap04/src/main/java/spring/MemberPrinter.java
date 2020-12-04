package spring;

import org.springframework.beans.factory.annotation.Qualifier;

public class MemberPrinter {
	public void memberprint(Member member) { // 콘솔로 찍을 printf문
		System.out.printf("회원정보 : 아이디 %d, 이메일 %d 이름 %s 등록일 %tF \n", 
				member.getId(), member.getEmail(), member.getName(), member.getRegisterDateTime());
		
	}
}
