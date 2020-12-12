package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import spring.MemberDao;

public class MemberConfig {
	@Configuration
	@EnableTransactionManagement // 플랫폼 트랜잭션 매니저 빈 설정
	// @Tranactional사용하려면 위와같이 설정 해야함
	public class AppCtx {

		@Bean(destroyMethod = "close")
		public DataSource dataSource() {
			DataSource ds = new DataSource();
			ds.setDriverClassName("com.mysql.jdbc.Driver");
			ds.setUrl("jdbc:mysql://192.168.0.70/spring5fs?characterEncoding=utf8");
			ds.setUsername("spring5");
			ds.setPassword("spring5");
			ds.setInitialSize(2); // 최대 커넥션 개수
			ds.setMaxActive(10); // 활성 가능한 최대 커넥션 개수 지정
			ds.setTestWhileIdle(true); // 유휴 커넥션 검사
			ds.setMinEvictableIdleTimeMillis(1000 * 60 * 3); // 최소 유휴시간 3분
			ds.setTimeBetweenEvictionRunsMillis(1000 * 10); // 10초 주기
			return ds;
		}

		@Bean
		public MemberDao memberDao() {
			return new MemberDao(dataSource());
		}

		@Bean
		public PlatformTransactionManager transactionManager() { // 트랜잭션 매니저
																	// 인터페이스
			DataSourceTransactionManager tm = new DataSourceTransactionManager();
			tm.setDataSource(dataSource());
			return tm;
		}
	}
}
