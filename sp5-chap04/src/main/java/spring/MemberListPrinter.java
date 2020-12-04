package spring;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberListPrinter {

	private MemberDao memberDao;
	private MemberPrinter printer;
	
	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer){ // 인자들어간 생성자
		this.memberDao = memberDao;
		this.printer = printer;
	}
	
	public MemberListPrinter() {  // 이제 AppCtx에서 기본생성자로 호출함 위에 인자들어간 이제 생성자는 안씀

	}
	@Autowired
	@Qualifier("printer1")
	public void setMemberPrinter(MemberPrinter printer){
		this.printer = printer;
	}
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Autowired
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}


	public void printAll(){
		Collection<Member> members = memberDao.selectAll();
		members.forEach(m->printer.memberprint(m));
		
	}
}
