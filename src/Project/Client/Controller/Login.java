package Project.Client.Controller;
import Project.Server.Database.*;
import Project.Client.Page.*;
import Project.Exception.Password_Error;

/**
*/
public final class Login extends Controller {
	public String checkAccount(String username, String passWord) throws Password_Error , RuntimeException{
		//MUSTDO: replace with a real checking function
		//should return USER TYPE
		
		AccountDAO accountDAO = new AccountDAO();
		
		Account account = accountDAO.findById(username);
			
		if (account.getPassWord() == passWord) return account.getType();
		
		else throw new Password_Error(passWord);
	}
}

