package Project.Server.Operator;

import java.sql.Timestamp;

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
	
	public static void addStudent(String studentId , String courseId){
		AccountIdCourseIdDAO accountIdCourseIdDAO = new AccountIdCourseIdDAO();
		accountIdCourseIdDAO.save(new AccountIdCourseId(studentId , courseId) );
		accountIdCourseIdDAO.getSession().beginTransaction().commit();
		accountIdCourseIdDAO.getSession().close();
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
			
		AccountIdCourseId a = new AccountIdCourseId( instructorId , courseId );
		
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
	
	public static void addActivityGroup(String id, String courseId , String percent) throws Illegal_Input, No_Such_Course{
		
		if (id.equals("") || courseId.equals("") || percent.equals("") ){
			throw new Illegal_Input("empty");
		}

		CourseDAO courseDAO = new CourseDAO();
		try{
			Course course = courseDAO.findById(courseId);
			
		}
		catch (RuntimeException re){
			throw new No_Such_Course(courseId);
		}
		
		ActivityGroupDAO activityGroupDAO = new ActivityGroupDAO();
		activityGroupDAO.save(new ActivityGroup(id , Double.valueOf(percent), courseId));
		activityGroupDAO.getSession().beginTransaction().commit();
		activityGroupDAO.getSession().close();
	}
	
	public static void addActivity(String id, String activityGroupId , 
			String beginTime , String endTime , String name , String description) throws Illegal_Input, No_Such_Course, No_Such_ActivityGroup{
		
		if (id.equals("") || activityGroupId.equals("") || beginTime.equals("") || endTime.equals("") 
				|| name.equals("")|| description.equals("")){
			throw new Illegal_Input("empty");
		}

		ActivityGroupDAO ActivityGroupDAO = new ActivityGroupDAO();
		try{
			ActivityGroupDAO.findById(activityGroupId);
			
		}
		catch (RuntimeException re){
			throw new No_Such_ActivityGroup(activityGroupId);
		}
		
		ActivityDAO activityDAO = new ActivityDAO();
		activityDAO.save(new Activity(id , name , description , Timestamp.valueOf(beginTime) , 
				           Timestamp.valueOf(endTime) , activityGroupId));
		activityDAO.getSession().beginTransaction().commit();
		activityDAO.getSession().close();
	}
	
	
}

