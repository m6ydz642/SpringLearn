package spring;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;


import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class MemberDao {
	
	JdbcTemplate jdbcTemplate;

	public Member selectByEmail(String email) {
		List<Member> results = jdbcTemplate.query("select * from MEMBER where EMAIL = ? ", new RowMapper<Member>() {		
		

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
					Member member = new Member(rs.getString("EMAIL"), rs.getString("PASSWORD"), 
							rs.getString("NAME"), rs.getTimestamp("REGDATE").toLocalDateTime() ); // new 연산 끝
					
					
					member.setId(rs.getLong("ID"));
					
				return member;
			}
			}, email);
		
		return results.isEmpty() ? null : results.get(0); // empty면 null반환

	}
	
	public void insert(Member member){
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			//	PreparedStatement pstmt = con.prepareStatement("insert into MEMBER values(?, ?, ?, ?)", 
				/* 위 타입처럼 테이블명 지정 없이 ?, ?, ?, ?로 끝나면
				 * email, password, name, regdate로 저장되는게 아니라 
				 * id, email, password,name 이런식으로 밀리는거 같음 
				 * 테이블명 정확하게 지정해서 하니 insert예외 오류 해결 
				 * (사실 처음부터 책 그대로 했으면 될것을..........)  
				*/
				PreparedStatement pstmt = con.prepareStatement(
						"insert into MEMBER (EMAIL, PASSWORD, NAME, REGDATE) " +
						"values (?, ?, ?, ?)",
				new String[] {"ID"});
				pstmt.setString(1, member.getEmail());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getName());
				pstmt.setTimestamp(4, Timestamp.valueOf(member.getRegisterDateTime() ));
				return pstmt;
			}
		}, keyHolder);
		Number keyValue = keyHolder.getKey();
		member.setId(keyValue.longValue());
		
	}
	
	public void update(Member member){
		jdbcTemplate.update("update MEMBER set NAME = ?, PASSWORD = ? where EMAIL = ?", 
				member.getName(), member.getPassword(), member.getEmail());
	}
	
	public List<Member> selectAll() {
		List<Member> results = jdbcTemplate.query("select * from MEMBER",  new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member(rs.getString("EMAIL"), rs.getString("PASSWORD"), 
						rs.getString("NAME"), rs.getTimestamp("REGDATE").toLocalDateTime());
				member.setId(rs.getLong("ID"));
				return member;
			}
			
		});
		return results; // 조회 리스트
		
	}
	
	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource); // 인자 넣어서 전달
}
	public int count() {
		Integer count = jdbcTemplate.queryForObject("select count(*) from MEMBER", Integer.class);
		return count;
	}
	
	
}
