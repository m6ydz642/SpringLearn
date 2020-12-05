package spring;

import org.springframework.beans.factory.annotation.Autowired;

public class ChangePasswordService { // 암호 변경 클래스
	
	@Autowired // 이 어노테이션 붙이면 이제 설정클래스에서 의존 주입안해도 됨 (AppCtx)
	// AppCtx에서 pwdSvc.setMemberdao(memberDao()); 항목이 삭제됨 
	private MemberDao memberdao;

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
