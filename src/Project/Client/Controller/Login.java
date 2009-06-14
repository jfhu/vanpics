package Project.Client.Controller;
import Project.Server.Database.*;
import Project.Client.Page.*;
import Project.Exception.Password_Error;

/**
*/
public final class Login extends Controller {
	public Account checkAccount(String username, String passWord) throws Password_Error , RuntimeException{
		
	
		
		AccountDAO accountDAO = new AccountDAO();
		
		Account account = accountDAO.findById(username);
			
		
		
		if (account.getPassWord().equalsIgnoreCase(passWord)) {
			
			return account;
		}
		
		else {
		
			throw new Password_Error(passWord);
		}
	}
}

