package co.eclipse.jdbc.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import co.eclipse.jdbc.entities.Student;


@Component("studentDao")
public class StudentDaoImpl implements StudentDao {
	
	
//	@Autowired
	private JdbcTemplate jdbctemplate;
	
	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}

	@Autowired
	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	
	
	@Override
	public int insert(Student student) {
		//insert query
        String query = "insert into student(id,name,city) values(?,?,?)";
        int r = this.jdbctemplate.update(query, student.getId(),student.getName(),student.getCity());
		return r;
	}

	@Override
	public int change(Student student) {
		//update query
		String query = "update student set name=?, city=? where id=?";
		int r = this.jdbctemplate.update(query,student.getName(),student.getCity(),student.getId());
		return r;
	}

	@Override
	public int remove(int studentId) {
		//Delete query
		String query = "delete from student where id=?";
		int r = this.jdbctemplate.update(query, studentId);
		return r;
	}

	@Override
	public Student getStudent(int studentId) {
		
		RowMapper<Student> rowMapper = new RowMapperImpl();
		// select single student
		String query = "select * from student where id=?";
		Student student = this.jdbctemplate.queryForObject(query, rowMapper,studentId);
		return student;
	}

	@Override
	public List<Student> getAllStudents() {
		//select all student
		String query = "select * from student";
		List<Student> students = this.jdbctemplate.query(query, new RowMapperImpl());
		return students;
	}

}
