package dbquery;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.tomcat.jdbc.pool.DataSource;



public class DbQuery {
	private DataSource dataSource;

	public DbQuery(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public int count() {
		Connection conn = null;
		try {
			System.out.println("DB접속 성공");
			conn = dataSource.getConnection(); // 풀
			Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select count(*) from MEMBER");
				rs.next();
				return rs.getInt(1);
		
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
		}finally {
			if(conn != null) 
				try {  // 자원해제 부분
					conn.close(); // 풀에 반환 
				} catch (SQLException e2) {
					System.out.println("자원해제 실패");
				}
		}
	}
}
