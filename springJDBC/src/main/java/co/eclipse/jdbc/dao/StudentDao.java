package co.eclipse.jdbc.dao;

import co.eclipse.jdbc.entities.Student;
import java.util.List;

public interface StudentDao {
	
	public int insert(Student student);
	public int change(Student student);
	public int remove(int studentId); 
	public Student getStudent(int studentId);
	public List<Student> getAllStudents();
	

}
