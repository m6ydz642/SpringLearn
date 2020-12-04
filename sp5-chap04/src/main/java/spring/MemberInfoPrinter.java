package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberInfoPrinter {
	private MemberDao memDao;
	private MemberPrinter printer;
	

	public void printMemberInfo(String email){
		Member member = memDao.selectByEmail(email);
		if (member == null) {
			System.out.println("데이터 없음");
			return;
		}
		printer.memberprint(member);
	}
	
	@Autowired 
	// setMemDao랑 setPrinter둘다
	// AppCtx측에서 알아서 호출됨

	public void setMemDao(MemberDao memDao) {
		this.memDao = memDao;
	}
	
	@Autowired
	@Qualifier("printer1") // 한정자 이름을 printer1로 정의함
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	
}
