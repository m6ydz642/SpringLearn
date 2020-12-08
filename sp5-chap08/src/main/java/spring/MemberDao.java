package spring;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MemberDao {
	
	JdbcTemplate jdbcTemplate;

	public Member selectByEmail(String email) {
		List<Member> results = jdbcTemplate.query("select * from MEMBER where EMAIL = ?", new RowMapper<Member>() {		
		

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
					Member member = new Member(rs.getString("EMAIL"), rs.getString("PASSWORD"), 
							rs.getString("NAME"), rs.getTimestamp("REGDATE").toLocalDateTime() ); // new 연산 끝
					
					
					member.setId(rs.getLong("ID"));
					
				return member;
			}
			}, email);
		
		return null;

	}
	
	public void insert(Member member){

	}
	
	public void update(Member member){
	
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
	
	
}
