package Project.Server.Operator;
import java.util.ArrayList;

import Project.Exception.Illegal_Length;
import Project.Exception.No_Such_Student;
import Project.Exception.Only_Alphabet;
import Project.Exception.Only_Integer;
import Project.Exception.Out_of_Range;
import Project.Server.Database.*;
import Project.Server.Object.*;
/**
*/
public final class Calculation extends Grade_Operator{
	static Grade calculateSum(Activity_List activityList , String id , int high , int low) throws No_Such_Student, Out_of_Range, Illegal_Length, Only_Integer, Only_Alphabet
	{	
		
		double sum = 0;
		
		ArrayList <ActivityGroup> activityGroups = activityList.getActivitGroups();
		for (ActivityGroup activityGroup : activityGroups)
		{
			Grade grade = activityGroup.getGrade(id);
			sum = sum + grade.getPercentage() * activityGroup.getPercent();
		}
		Grade_with_Integer ret =  new Grade_with_Integer( Integer.toString(high) , Integer.toString(low) );
		ret.set(Integer.toString(  (int)(sum + 0.5) )  );
		StudentGrade studentGrade = new StudentGrade(id , activityGroups.get(0).getCourseId() , "SUM" , ret , 0);
		StudentGradeDAO studentGradeDAO = new StudentGradeDAO();
		studentGradeDAO.save(studentGrade);
		
		return ret;
		
	}
	
	
}

