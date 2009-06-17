package Project.Server.Object;
import java.util.*;
import Project.Server.Database.*;
/**
*/
public final class Course_List extends List{
/**
*/
private ArrayList<Course> courses;
/**
 * @param Return 
 * @return 
*/
public ArrayList <Course> getCourses() {
    return courses;
}

public Course_List()
{
	super();
	courses = new ArrayList<Course>();
}

public boolean addElement(Course course){
	return this.courses.add(course);
}

public boolean deleteElement(Course course){
	return this.courses.remove(course);
}


}

