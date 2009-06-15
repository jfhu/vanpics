package Project.Server.Operator;

import java.util.ArrayList;

import Project.Exception.Illegal_Input;
import Project.Server.Database.Account;
import Project.Server.Database.AccountDAO;
import Project.Server.Database.AccountIdCourseId;
import Project.Server.Database.AccountIdCourseIdDAO;
import Project.Server.Database.StudentGrade;
import Project.Server.Database.StudentGradeDAO;

/**
*/
public final class Delete_Element extends Database_Operator{
public static void modifyAccount(String id ) throws Illegal_Input{
		
		if (id.equals("")) throw new Illegal_Input("empty");
		
		AccountDAO  accountDAO = new AccountDAO();
		
		
		
		AccountIdCourseIdDAO acDAO = new AccountIdCourseIdDAO();
		
		ArrayList list = (ArrayList) acDAO.findByAccountId(id);
		
		for (Object link:list){
			AccountIdCourseId a = (AccountIdCourseId) link;
			acDAO.delete(a);
		}
		
		acDAO.getSession().beginTransaction().commit();
		acDAO.getSession().close();
		
		
		StudentGradeDAO sgDAO = new StudentGradeDAO();
		
		list = (ArrayList) sgDAO.findByStudentId(id);
		
		for (Object link:list){
			StudentGrade a = (StudentGrade) link;
			sgDAO.delete(a);
		}
		sgDAO.getSession().beginTransaction().commit();
		sgDAO.getSession().close();
		
		
		Account acc = accountDAO.findById(id);
		accountDAO.delete(acc);
		accountDAO.getSession().beginTransaction().commit();
		accountDAO.getSession().close();
	
		
	}
}

