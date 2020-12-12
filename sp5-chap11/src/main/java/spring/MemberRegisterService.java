package spring;

import java.time.LocalDateTime;

public class MemberRegisterService {
	private MemberDao memberDao;
	
	public MemberRegisterService(MemberDao memberDao){ // 생성자롤 통해 객체 의존 주입 받음
		this.memberDao = memberDao;
	}
	
	public Long regist(RegisterRequest req){ // 주입 받은 의존 객체의 메서드를 사용
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
