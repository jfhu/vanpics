package Project.Server.Object;
import java.util.*;
import java.lang.*;
import Project.Exception.*;
/**
*/
public final class Grade_with_Character extends Grade {
/**
*/


private char score;

private char highestScore;

private char lowestScore;

private int check(String value) throws Illegal_Length , Only_Alphabet
{
	if (value.length() > 1) throw new Illegal_Length(value);
	if ( !value.matches("[a-zA-Z]") ) throw new Only_Alphabet(value);
	
	return 0;
	}

public double getPercentage(){
	return (double)(score-'A')/(highestScore - lowestScore);
}

public int set(String value) throws Illegal_Length , Out_of_Range ,Only_Alphabet {
	check(value);
	value = value.toUpperCase();
	if (value.charAt(0) > highestScore || value.charAt(0) < lowestScore) throw new Out_of_Range(value);
	score = value.charAt(0);
	unset = false;
	return 0;
}

public String get(){
	String ret = String.valueOf(score);
	return ret ;
}

public Grade_with_Character( String low , String high) 
	throws Illegal_Length , Out_of_Range ,Only_Alphabet
{
	super();
	check(low);
	check(high);
	lowestScore = low.charAt(0);
	highestScore = high.charAt(0);
	unset = true;
}

}
