package Project.Server.Object;
import Project.Server.Object.*;
import Project.Exception.*;

import java.util.*;
/**
*/
public abstract class Grade  {
/**
*/


protected boolean unset;
/**
 * @param Return 
 * @throws Only_Alphabet 
 * @throws Only_Integer 
*/
public abstract int set(String value) throws Illegal_Length , Out_of_Range, Only_Alphabet, Only_Integer;
/**
 * @param Return 
 * @return 
*/
public boolean getState(){
	return unset;
}
public abstract String get();
public int id;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public abstract double getPercentage();

public Grade(){
}

}

