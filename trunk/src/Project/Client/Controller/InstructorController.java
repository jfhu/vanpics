package Project.Client.Controller;

import java.util.List;
import Project.Server.Database.AccountIdCourseIdDAO;

public class InstructorController extends Controller {
	public String[] getCourses(String accountId) {
		
		//MUSTDO: return the course IDs of the accountID
		String [] res = {"course1", "course2"};
		return res;
		
	}
}
