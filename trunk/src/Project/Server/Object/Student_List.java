package Project.Server.Object;
import java.util.*;
import Project.Server.Database.*;
import Project.Exception.*;
import Project.Server.Operator.*;
/**
*/
public final class Student_List extends List{
/**
*/
private ArrayList<Student> students;
/**
 * @param Return 
 * @return 
*/
public ArrayList<Student> getStudents() {
	return this.students;
}
/**
 * @param Return 
 * @return 
*/
public int sendEmail(String email , String passWord) {
    return 0;
}
/**
 * @param Return 
 * @return 
*/

public boolean addElement(Student student){
	return this.students.add(student);
	
}

public boolean deleteElement(Student student){
	return this.students.add(student);
	
}


}

