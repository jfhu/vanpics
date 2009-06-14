package Project.Exception;
/**
*/
public class Illegal_Time extends Exception{
/**
 * @param message 
*/
String type;
public Illegal_Time(String message) {
	type = message;
}
/**
 * @param message 
 * @param cause 
*/
public Illegal_Time(String message, Throwable cause) {
}
}

