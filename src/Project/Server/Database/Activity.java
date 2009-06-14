package Project.Server.Database;

import java.sql.Timestamp;

/**
 * Activity entity. @author MyEclipse Persistence Tools
 */

public class Activity implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String information;
	private Timestamp beginTime;
	private Timestamp endTime;
	private String activityGroupId;

	// Constructors

	/** default constructor */
	public Activity() {
	}

	/** full constructor */
	public Activity(String id, String name, String information,
			Timestamp beginTime, Timestamp endTime, String activityGroupId) {
		this.id = id;
		this.name = name;
		this.information = information;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.activityGroupId = activityGroupId;
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

	public Timestamp getBeginTime() {
		return this.beginTime;
	}

	public void setBeginTime(Timestamp beginTime) {
		this.beginTime = beginTime;
	}

	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public String getActivityGroupId() {
		return this.activityGroupId;
	}

	public void setActivityGroupId(String activityGroupId) {
		this.activityGroupId = activityGroupId;
	}

}