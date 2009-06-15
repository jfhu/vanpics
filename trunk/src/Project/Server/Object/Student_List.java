package Project.Server.Object;
import java.util.*;
import Project.Server.Database.*;
import Project.Exception.*;
import Project.Server.Operator.*;
/**
*/
public final class Student_List extends List{
/**
*/
/**
 * @param Return 
 * @return 
*/

/**
 * @param Return 
 * @return 
*/

public static ArrayList <Student> find(String courseId){
	AccountIdCourseIdDAO accountIdCourseIdDAO =  new AccountIdCourseIdDAO();
	ArrayList ids = (ArrayList) accountIdCourseIdDAO.findByCourseId(courseId);
	ArrayList <Student> ret = new ArrayList();
	for (Object id : ids){
		Account account = (Account) id;
		if (account.getType() == "Student"){
			ret.add((Student) account);
		}
	}
	return ret;
}


public int sendEmail(String email , String passWord) {
    return 0;
}



}

