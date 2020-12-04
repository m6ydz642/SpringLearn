package spring;

public class MemberSummaryPrinter extends MemberPrinter{
	
@Override
public void memberprint(Member member) {
	System.out.printf("회원정보 : 아이디 %d, 이메일 %d 이름 %s 등록일 %tF \n", 
			member.getId(), member.getEmail(), member.getName(), member.getRegisterDateTime());
	
}

}
