package Project.Server.Database;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */

public class Course implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String information;
	private String term;

	// Constructors

	/** default constructor */
	public Course() {
	}

	/** full constructor */
	public Course(String id, String name, String information, String term) {
		this.id = id;
		this.name = name;
		this.information = information;
		this.term = term;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInformation() {
		return this.information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public String getTerm() {
		return this.term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

}