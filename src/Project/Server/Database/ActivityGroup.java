package Project.Server.Database;
import java.util.ArrayList;

import Project.Exception.Illegal_Length;
import Project.Exception.Only_Alphabet;
import Project.Exception.Only_Integer;
import Project.Exception.Out_of_Range;
import Project.Server.Object.*;
/**
 * ActivityGroup entity. @author MyEclipse Persistence Tools
 */

public class ActivityGroup implements java.io.Serializable {

	// Fields

	private String id;
	private Double percent;
	private String courseId;

	// Constructors

	/** default constructor */
	public ActivityGroup() {
	}
	
	public ActivityGroup(double percent){
		this.setPercent(percent);
	}

	/** full constructor */
	public ActivityGroup(String id, Double percent, String courseId) {
		this.id = id;
		this.percent = percent;
		this.courseId = courseId;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getPercent() {
		return this.percent;
	}

	public void setPercent(Double percent) {
		this.percent = percent;
	}

	public String getCourseId() {
		return this.courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	
	public Grade getGrade(String studentId) throws Illegal_Length, Out_of_Range, Only_Alphabet, Only_Integer{
		StudentGradeDAO gradesDAO = new StudentGradeDAO();
		ActivityDAO activityDAO = new ActivityDAO();
		ArrayList activities =  (ArrayList) activityDAO.findByProperty("activityGroupId", this.id);
		Grade maxScore = new Grade_with_Character("Z" , "A");
		for(Object theActivity :  activities)
		{
			Activity activity = (Activity) theActivity;
			StudentGradeDAO studentGradeDAO = new StudentGradeDAO();
			StudentGrade studentGrade = studentGradeDAO.findById(studentId+activity.getId()+this.courseId);
			Grade score = studentGrade.getGrade();
			if (!maxScore.getState() || score.getPercentage() > maxScore.getPercentage()){
				maxScore = score;
			}
		}
		return maxScore;
		
	}

}