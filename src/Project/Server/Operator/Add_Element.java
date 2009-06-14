package Project.Server.Operator;

import javax.security.auth.login.Configuration;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import Project.Exception.Illegal_Input;
import Project.Server.Database.Account;
import Project.Server.Database.AccountDAO;

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
}

