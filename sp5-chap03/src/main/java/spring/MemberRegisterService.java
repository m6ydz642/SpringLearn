package spring;

public class MemberRegisterService {
	private MemberDao memberDao;
	
	public MemberRegisterService(MemberDao memberDao){ // 생성자
		this.memberDao = memberDao;
	}
	
	public Long regist(RegisterRequest req){
		
		return null;
		
	}
}
