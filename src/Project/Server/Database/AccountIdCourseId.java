package Project.Server.Database;

import Project.Exception.Permission_Denied;

/**
 * AccountIdCourseId entity. @author MyEclipse Persistence Tools
 */

public class AccountIdCourseId implements java.io.Serializable {

	// Fields

	private String id;
	private String accountId;
	private String courseId;

	// Constructors

	/** default constructor */
	public AccountIdCourseId() {
	}

	/** full constructor */
	public AccountIdCourseId( String accountId, String courseId) {
		this.id = accountId + "#" + courseId;
		this.accountId = accountId;
		this.courseId = courseId;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) throws Permission_Denied {
		this.id = id;
	}

	public String getAccountId() {
		return this.accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
		this.id = this.accountId+"#"+this.courseId;
	}

	public String getCourseId() {
		return this.courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
		this.id = this.accountId+"#"+this.courseId;
	}

}