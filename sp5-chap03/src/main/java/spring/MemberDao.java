package spring;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemberDao {

	private static long nextId = 0;
	private Map<String, Member> map = new HashMap<>();
	// String 타입 , Member객체 타입으로 Map선언 
	public Member selectByEmail(String email) {
		return map.get(email); // 인자로 이메일 받아서 리턴
	}
	
	public void insert(Member member){
		member.setId(++nextId);
		map.put(member.getEmail(), member); 
	}
	
	public void update(Member member){
		map.put(member.getEmail(), member);
	}
	
	public Collection<Member> selectAll() { // 조회 리스트
		return map.values();
	}
	
}
