package co.eclipse.jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import co.eclipse.jdbc.dao.StudentDao;
import co.eclipse.jdbc.dao.StudentDaoImpl;

@Configuration
@ComponentScan(basePackages = {"co.eclipse.jdbc.dao"})
public class jdbcConfig {
	
	@Bean("dataSource")
	public DataSource getDataSource() {
		
		DriverManagerDataSource ds = new DriverManagerDataSource();
		
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("Rider@123");
		
		return ds;
		
	}
	
	
	@Bean("jdbctemplate")
	public JdbcTemplate getTemplate() {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		
		return jdbcTemplate;
	}
	
	
	
	//created later by annotation in studentdaoimpl
	
//	@Bean(name={"studentDao"})
//	public StudentDao getStudentDao() {
//		
//		StudentDaoImpl studentDao = new StudentDaoImpl();
//		studentDao.setJdbctemplate(getTemplate());
//		
//		
//		return studentDao;
//	}
	
	

}
