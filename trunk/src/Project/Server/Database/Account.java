package Project.Server.Database;

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

	public void setType(String type) {
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

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		
		this.email = email;
	}

}