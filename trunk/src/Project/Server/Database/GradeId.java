package Project.Server.Database;

/**
 * GradeId entity. @author MyEclipse Persistence Tools
 */

public class GradeId implements java.io.Serializable {

	// Fields

	private String id;
	private String high;
	private String low;
	private String type;

	// Constructors

	/** default constructor */
	public GradeId() {
	}

	/** full constructor */
	public GradeId(String id, String high, String low, String type) {
		this.id = id;
		this.high = high;
		this.low = low;
		this.type = type;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHigh() {
		return this.high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getLow() {
		return this.low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}