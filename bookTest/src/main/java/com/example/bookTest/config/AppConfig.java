package com.example.bookTest.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class AppConfig {
//위 애러테이션을 붙여야 서버 시작 전에 일종의 환경설정을 진행해줌
	@Bean
	public DataSource dataSource() {
		//드라이버 로드와 접속을 같이 해주는 방법임
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUsername("burnout");
		ds.setPassword("1234");
		ds.setUrl("jdbc:mysql://localhost:3306/burnout");
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
		
}
