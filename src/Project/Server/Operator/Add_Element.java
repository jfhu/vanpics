package Project.Server.Operator;

import Project.Server.Database.Account;
import Project.Server.Database.AccountDAO;

/**
*/
public final class Add_Element extends Database_Operator{
	public static void addAccount(String id , String type , String userName , String passWord , String name , String phone, String email){
		AccountDAO  accountDAO = new AccountDAO();
		Account account = new Account (id , type , userName ,passWord , name ,phone, email);
		System.err.println(passWord);
		accountDAO.save(account);
		
	}
}

