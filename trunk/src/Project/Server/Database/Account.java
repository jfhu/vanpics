package Project.Server.Database;
import Project.Exception.*;

/**
 * Account entity. @author MyEclipse Persistence Tools
 */

public class Account implements java.io.Serializable {

	// Fields

	private String id;
	private String type;
	private String userName;
	private String passWord;
	private String name;
	private String phone;
	private String email;

	// Constructors

	/** default constructor */
	public Account() {
	}

	/** full constructor */
	public Account(String id, String type, String userName, String passWord,
			String name, String phone, String email) {
		this.id = id;
		this.type = type;
		this.userName = userName;
		this.passWord = passWord;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) throws Invailed_Account_Type {
		if (type != "Student" || type != "Instructor" || type != "Administrator" || type != "SystemManager")
			throw  new Invailed_Account_Type(type);
		this.type = type;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return this.passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) throws Invailed_Phone_Number {
		if (! phone.matches("^[0-9]*$") ) throw new Invailed_Phone_Number(phone);
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) throws Invailed_Email_Address {
		if (! phone.matches("/^[a-z]([a-z0-9]*[-_]?[a-z0-9]+)*@([a-z0-9]*[-_]?[a-z0-9]+)+[\\.][a-z]{2,3}([\\.][a-z]{2})?$/i"))
			throw new Invailed_Email_Address(email);
		this.email = email;
	}

}