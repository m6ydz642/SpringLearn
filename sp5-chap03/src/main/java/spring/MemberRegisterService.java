package spring;

import java.time.LocalDateTime;

public class MemberRegisterService {
	private MemberDao memberDao;
	
	public MemberRegisterService(MemberDao memberDao){ // 생성자
		this.memberDao = memberDao;
	}
	
	public Long regist(RegisterRequest req){
		Member member = memberDao.selectByEmail(req.getEmail());
		if (member != null) { // member가 널이면 중복이 아니고 null이 아니면 중복이란 말
			throw new DuplicateMemberException("dup email : " + req.getEmail() ); 
			// 중복전용으로 만든 예외 클래스로 중복 예외를 던짐
		}
		Member newMember = new Member(req.getEmail(), req.getPassword(),  LocalDateTime.now(), req.getName());
		// 맴버 클래스에 생성자에 인자 넣어서 전달
		
		memberDao.insert(newMember);
		return newMember.getId();
		
	}
}
