package spring;

import java.time.LocalDateTime;

public class Member {
	private Long id;
	private String email;
	private String password;
	private LocalDateTime registerDateTime;
private String name;


	public Member( String email, String password, LocalDateTime registerDateTime, String name) {
		// 객체 생성하면서 매개변수를 넣을 생성자 
	this.email = email;
	this.password = password;
	this.registerDateTime = registerDateTime;
	this.name = name;
}

	public String getName() {
	return name;
}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getRegisterDateTime() {
		return registerDateTime;
	}

	public void setRegisterDateTime(LocalDateTime registerDateTime) {
		this.registerDateTime = registerDateTime;
	}
	
	public void changePassword(String oldPassword, String newPassword){
		if(!password.equals(password)) {
			throw new WrongIdPasswordException(); // 패스워드 오류시 예외처리 발생
		}
		this.password = newPassword;
	}

	
}
