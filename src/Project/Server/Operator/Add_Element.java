package Project.Server.Operator;

import javax.security.auth.login.Configuration;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import Project.Exception.*;
import Project.Server.Database.*;


/**
*/
public final class Add_Element extends Database_Operator{
	public static void addAccount(String id , String type , String userName , String passWord , String name , String phone, String email) throws Illegal_Input{
		
		if (id.equals("")||type.equals("")||userName.equals("")||passWord.equals("")
				||name.equals("")||phone.equals("")||email.equals("")) throw new Illegal_Input("empty");
		
		AccountDAO  accountDAO = new AccountDAO();
		Account account = new Account (id , type , userName ,passWord , name ,phone, email);
	//	System.err.println(passWord);
		accountDAO.save(account);
		accountDAO.getSession().beginTransaction().commit();
		accountDAO.getSession().close();
	
		
	}
	
	public static void addCourse(String courseId , String courseName , String instructorId 
			, String term , String description) throws Illegal_Input, No_Such_Instructor{
		
		if (courseId.equals("") || courseName.equals("") || description.equals("")
				|| instructorId.equals("") || term.equals("") ){
			throw new Illegal_Input("empty");
		}
		AccountDAO accountDAO = new AccountDAO();
		AccountIdCourseIdDAO accountIdCourseIdDAO = new AccountIdCourseIdDAO();
		CourseDAO courseDAO = new CourseDAO();
		
		try{
			Account account = accountDAO.findById(instructorId);
	
			if (!account.getType().equals("Instructor")){
				throw new No_Such_Instructor(instructorId);
			}
		}
		catch (RuntimeException re){
			throw new No_Such_Instructor(instructorId);
		}
		Course course = new Course(courseId , courseName , description , term);
		courseDAO.save(course);
	
		
		try{
			
		AccountIdCourseId a = new AccountIdCourseId(instructorId+"#"+courseId , instructorId , courseId );
		
		accountIdCourseIdDAO.save(a);
		accountIdCourseIdDAO.getSession().beginTransaction().commit();
		accountIdCourseIdDAO.getSession().close();
		}
		catch(RuntimeException re){
			re.printStackTrace();
			courseDAO.delete(course);
			courseDAO.getSession().beginTransaction().commit();
			courseDAO.getSession().close();
			throw re;
		}
		
		courseDAO.getSession().beginTransaction().commit();
		courseDAO.getSession().close();
			
	}
	
	public static void addActivityGroup(String id, String courseId , String percent){
		
	}
}

