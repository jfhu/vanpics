package Project.Server.Object;
import java.util.ArrayList;
import Project.Server.Database.*;


public class Student extends Account {
	public static ArrayList <Student> find(String courseId){
		AccountDAO accountDAO = new AccountDAO();
		AccountIdCourseIdDAO accountIdCourseIdDAO = new AccountIdCourseIdDAO();
		
		ArrayList linkList = (ArrayList) accountIdCourseIdDAO.findByCourseId(courseId);
		ArrayList <Student> ret = new ArrayList() ;
		for (Object link : linkList){
			AccountIdCourseId a = (AccountIdCourseId) link;
			Account account = accountDAO.findById(a.getAccountId() );
			
			if (account.getType().equals("Student")){
				ret.add((Student) account);
			}
			
		}
		return ret;
	}

}