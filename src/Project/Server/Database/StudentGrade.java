package Project.Server.Database;

import Project.Exception.Illegal_Length;
import Project.Exception.Only_Alphabet;
import Project.Exception.Only_Integer;
import Project.Exception.Out_of_Range;
import Project.Exception.Permission_Denied;
import Project.Server.Object.Grade;
import Project.Server.Object.Grade_with_Character;

/**
 * StudentGrade entity. @author MyEclipse Persistence Tools
 */

public class StudentGrade implements java.io.Serializable {

	// Fields

	private String id;   //studentid +  activityid +  gradeid
	private String studentId;
	private String courseId;
	private String activityId;
	private String grade;
	private Integer gradeId;

	// Constructors

	/** default constructor */
	public StudentGrade() {
	}

	/** full constructor */
	public StudentGrade( String studentId, String courseId,
			String activityId, Grade grade, Integer gradeId) {
		this.id = studentId + activityId+courseId;
		this.studentId = studentId;
		this.courseId = courseId;
		this.activityId = activityId;
		this.grade = grade.get();
		this.gradeId = 0;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) throws Permission_Denied {
		throw new Permission_Denied("Do not set id Manually");
	}

	public String getStudentId() {
		return this.studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
		this.id=this.studentId+this.activityId+this.courseId;
	}

	public String getCourseId() {
		return this.courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
		this.id=this.studentId+this.activityId+this.courseId;
	}

	public String getActivityId() {
		return this.activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
		this.id=this.studentId+this.activityId+this.courseId;
	}

	public Grade getGrade() throws Illegal_Length, Out_of_Range, Only_Alphabet, Only_Integer {
		GradeIdDAO gradeIdDAO = new GradeIdDAO();
		GradeId gradeId = gradeIdDAO.findById(this.id);
		Grade grade = new Grade_with_Character(gradeId.getLow() , gradeId.getHigh());
		grade.set(this.grade);
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade.get();
		this.setGradeId(grade.getId());
	}

	public Integer getGradeId() {
		return this.gradeId;
	}

	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}

}