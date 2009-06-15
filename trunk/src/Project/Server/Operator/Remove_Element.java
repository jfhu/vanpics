package Project.Server.Operator;

import java.sql.Timestamp;

import javax.management.RuntimeErrorException;

import Project.Exception.Illegal_Input;
import Project.Exception.No_Such_Account;
import Project.Exception.No_Such_ActivityGroup;
import Project.Exception.No_Such_Course;
import Project.Exception.No_Such_Instructor;
import Project.Server.Database.Account;
import Project.Server.Database.AccountDAO;
import Project.Server.Database.AccountIdCourseId;
import Project.Server.Database.AccountIdCourseIdDAO;
import Project.Server.Database.Activity;
import Project.Server.Database.ActivityDAO;
import Project.Server.Database.ActivityGroup;
import Project.Server.Database.ActivityGroupDAO;
import Project.Server.Database.Course;
import Project.Server.Database.CourseDAO;

/**
*/
public final class Remove_Element extends List_Operator{
	
	public static void removeAccount(String id  , boolean force) throws Illegal_Input , No_Such_Account{
		
		if (id.equals("")) throw new Illegal_Input("empty");
		
		AccountDAO  accountDAO = new AccountDAO();
		Account account;
		try{
			account = accountDAO.findById(id);
		}
		catch (RuntimeErrorException re){
			throw new No_Such_Account(id);
		}
		
		accountDAO.delete(account);
		accountDAO.getSession().beginTransaction().commit();
		accountDAO.getSession().close();
	
		//TODO: delete accountidcourseid && studentidactivityid if type == studnet
	}
	
	public static void removeActivityGroup(String id , boolean force) throws Illegal_Input, No_Such_Course{
		//TODO: delelte activity
		
	}
	
	public static void addActivity(String id, boolean force) throws Illegal_Input, No_Such_Course, No_Such_ActivityGroup{
		//TODO: delelte related students' grade.
		
	}
	
	
	
}

