package co.eclipse.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import co.eclipse.jdbc.dao.StudentDao;
import co.eclipse.jdbc.dao.StudentDaoImpl;
import co.eclipse.jdbc.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
//        
//        ApplicationContext context = new ClassPathXmlApplicationContext("co/eclipse/jdbc/config.xml");
//        JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
//
//        StudentDaoImpl studentDao = context.getBean("studentDao",StudentDaoImpl.class);
        
        /* Insert */
//        Student student = new Student();
//        student.setId(66);
//        student.setName("mohann");
//        student.setCity("Delhi");
        
//        int result = studentDao.insert(student);
//        
//        System.out.println("Student added "+result);
//        
//       
        /* Update */
//        Student student = new Student();
//        student.setId(457);
//        student.setName("Aman Raj");
//        student.setCity("patna");
//        
//        int res = studentDao.change(student);
//        System.out.println("uupdated data "+res);
        
        /* Delete */
//        int result = studentDao.remove(66);
//        System.out.println("Deleted user "+result);
        	
        /* get single student */
//        Student student = studentDao.getStudent(222);
//        System.out.println(student);
        
        /*get all student */
//        List<Student> students = studentDao.getAllStudents();
//        
//        for(Student s:students) {
//        	System.out.println(s);
//        }
//        
        
        /* using java @Configuration */
        ApplicationContext context = new AnnotationConfigApplicationContext(jdbcConfig.class);
       
        StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
        
        List<Student> students  = studentDao.getAllStudents();
        for(Student s : students) {
        	System.out.println(s);
        }
        
        
    }
}
