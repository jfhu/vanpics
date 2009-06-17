package Project.Server.Object;
import java.util.ArrayList;

public class Instructor_List extends List {

	private ArrayList <Instructor>instructors;
	/**
	 * @param Return 
	 * @return 
	*/
	public ArrayList <Instructor> getInstuctor() {
	    return this.instructors;
	}


	public boolean addElement(Instructor instructor){
		return this.instructors.add(instructor);
		
	}

	public boolean deleteElement(Instructor instructor){
		return this.instructors.remove(instructor);
		
	}



}
