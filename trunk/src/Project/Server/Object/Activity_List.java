package Project.Server.Object;
import java.util.*;
import Project.Server.Database.*;
import Project.Exception.*;
/**
*/
public final class Activity_List extends List{
/**
*/
private ArrayList <ActivityGroup> activityGroups;
/**
 * @param Return 
*/
public ArrayList <ActivityGroup> getActivitGroups() {
	return activityGroups;
}
/**
 * @param activityGroups
 */
public Activity_List() {
	super();
	this.activityGroups = new ArrayList <ActivityGroup> ();
	
}

public boolean addElement(ActivityGroup activityGroup){
	
	return this.activityGroups.add(activityGroup);
	
}

public boolean deleteElement(Activity activity){
	
	return this.activityGroups.remove(activity);

}

}

