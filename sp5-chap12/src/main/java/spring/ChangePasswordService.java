package spring;

import org.springframework.transaction.annotation.Transactional;

public class ChangePasswordService { // 암호 변경 클래스
	
	private MemberDao memberdao;

	@Transactional // 트랜잭션 설정
	public void changePassword(String email, String oldPwd, String newPwd){
		Member member = memberdao.selectByEmail(email);
		if (member == null) {
			
			throw new MemberNotFoundException();
		}
		
		
		member.changePassword(oldPwd, newPwd);

		memberdao.update(member);
	}
	public void setMemberdao(MemberDao memberdao) {
		this.memberdao = memberdao;
	}
	
}
