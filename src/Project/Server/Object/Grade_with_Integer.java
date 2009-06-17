package Project.Server.Object;
import Project.Exception.*;

/**
*/
public final class Grade_with_Integer extends Grade {
/**
*/



private int score;

private int highestScore;

private int lowestScore;

private int check(String value)throws Illegal_Length , Only_Integer{
	if ( !value.matches("^[0-9]*$") ) throw new Only_Integer(value);
	if (value.length() > 9) throw new Illegal_Length(value);
	return 0;
}

public double getPercentage(){
	return (double)score / (highestScore - lowestScore);
}

public int set(String value) throws Illegal_Length, Only_Integer
{
	check(value);
	score = Integer.parseInt(value);
	unset = false;
	return 0;
}

public String get(){
	return Integer.toString(score);
}


public Grade_with_Integer(String high , String low ) throws Illegal_Length, Only_Integer
{
	super();
	check(low);
	check(high);
	lowestScore = Integer.parseInt(low);
	highestScore = Integer.parseInt(high);
	unset = true;
}



}
