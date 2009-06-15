package Project.Server.Operator;
import Project.Exception.Illegal_Input;
import Project.Exception.Illegal_Length;
import Project.Exception.No_Such_Activity;
import Project.Exception.No_Such_Course;
import Project.Exception.No_Such_Element;
import Project.Exception.No_Such_Student;
import Project.Exception.Only_Alphabet;
import Project.Exception.Only_Integer;
import Project.Exception.Out_of_Range;
import Project.Server.Database.*;
import Project.Server.Object.*;
import java.lang.*;
import java.util.*;
/**
*/
public abstract class Grade_Operator{

	public static boolean check(String studentId, String activityId , String courseId) throws No_Such_Student, No_Such_Activity, No_Such_Course{
		AccountDAO accountDAO = new AccountDAO();
		ActivityDAO activityDAO = new ActivityDAO();
		StudentGradeDAO studentGradeDAO = new StudentGradeDAO();
		CourseDAO courseDAO = new CourseDAO();
		
		try{
			if (accountDAO.findById(studentId).getType() != "Student"){
				throw new No_Such_Student(studentId);
			}
			
		}
		catch(RuntimeException re){
			throw new No_Such_Student(studentId);
		}
		
		try{
			activityDAO.findById(activityId);
		}
		catch(RuntimeException re){
			throw new No_Such_Activity(activityId);
		}
		
		try{
			courseDAO.findById(courseId);
		}
		catch(RuntimeException re){
			throw new No_Such_Course(courseId);
		}
		
		try{
			studentGradeDAO.findById(studentId+"#"+activityId+"#"+courseId);
		}
		catch (RuntimeException re){
			return false;
		}
		return true;
	}
	
	public static void modify(String grade, String studentId, String activityId , String courseId) throws No_Such_Element, Illegal_Input{
		
		
		Grade a = null;
		try {
			a = new Grade_with_Character("Z" , "A");
		} catch (Throwable e) {
			
		}	
	
		try {
			a.set(grade);
		} catch (Illegal_Length e) {
			throw new Illegal_Input(grade);
		} catch (Out_of_Range e) {
			throw new Illegal_Input(grade);
		} catch (Only_Alphabet e) {
			throw new Illegal_Input(grade);
		} catch (Only_Integer e) {
		}
		
		StudentGradeDAO studentGradeDAO = new StudentGradeDAO();
		try{
			if (check(studentId , activityId ,  courseId)){
				studentGradeDAO.delete(studentGradeDAO.findById(studentId +"#" +activityId+"#" +courseId));
			}
		}
		catch (No_Such_Element nse){
			throw nse;
		}
		
		studentGradeDAO.save(new StudentGrade(studentId, courseId , activityId , a , 0));
		studentGradeDAO.getSession().beginTransaction().commit();
		studentGradeDAO.getSession().close();
	}
}

