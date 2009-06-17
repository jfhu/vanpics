package Project.Server.Object;
import Project.Exception.*;
/**
*/
public final class Time extends Server_Object{
/**
*/
private int year;
/**
*/
private int month;
/**
*/
private int day;
/**
*/
private int hour;
/**
*/
private int minutes;
/**
 * @param Return 
 * @return 
*/
public int getYear() {
    return year;
}
/**
 * @param Return 
 * @param value 
 * 	value should be the format like : TYPE:NUMBER;
 * 	TYPE should be one of YEAR, MONTH, DAY,HOUR or MINUTES
 * 	NUMBER should not be illegal.
 * @return 
*/
public int setTime(String value) throws Illegal_Data , Illegal_Time { 
	int i;
	for (i = 0 ; i < value.length() ; i++)
	{
		if (value.charAt(i) ==':') break;
	}
	if (i == value.length()) throw new Illegal_Data("length");
	String type = value.substring(0 , i-1);
	String number = value.substring(i+1);
	if (number.matches("^\\d{1,4}")) throw new Only_Integer(number);
	int n = Integer.parseInt(number);
	
	type = type.toUpperCase();

	if (type == "YEAR") 
	{
		int tmp = year;
		year = n;
		try
		{
			check();
		}
		catch(Illegal_Time e)
		{
			year = tmp;
			throw e;
		}
	}
	else if (type == "MONTH")
	{
		int tmp = month;
		month = n;
		try
		{
			check();
		}
		catch(Illegal_Time e)
		{
			month = tmp;
			throw e;
		}

	}
	else if (type == "DAY")
	{
		int tmp = day;
		day = n;
		try
		{
			check();
		}
		catch(Illegal_Time e)
		{
			day = tmp;
			throw e;
		}

	}
	else if (type == "HOUR")
	{
		int tmp = hour;
		hour = n;
		try
		{
			check();
		}
		catch(Illegal_Time e)
		{
			hour = tmp;
			throw e;
		}

	}
	else if (type == "MINUTES")
	{
		int tmp = minutes;
		minutes = n;
		try
		{
			check();
		}
		catch(Illegal_Time e)
		{
			minutes = tmp;
			throw e;
		}

	}
	else throw new Illegal_Characters(type);

    return 0;
}
/**
 * @param Return 
 * @return 
*/
public int getMonth() {
    return month;
}
/**
 * @param Return 
 * @return 
*/
public int getDay() {
    return day;
}
/**
 * @param Return 
 * @return 
*/
public int getHour() {
    return hour;
}
/**
 * @param Return 
 * @return 
*/
public int getMinutes() {
    return minutes;
}
/**
 * @param month 
 * @param Return 
 * @param year 
 * @param hour 
 * @param hour 
 * @param day 
 * @param minutes 
*/
public Time(int year, int month, int day, int hour,  int minutes) throws Illegal_Time{
	super();
	this.year = year;
	this.month = month;
	this.day = day;
	this.hour = hour;
	this.minutes = minutes;
	check();
}
/**
 * @param value 
 * @param Return 
*/
public void check() throws Illegal_Time{
	if (!(year >= 1970 && year <= 2030)) throw new Illegal_Time("year");
	if (!(month >= 1   && month <= 12  )) throw new Illegal_Time("month");
	if (!(hour  >=  0  && hour  <= 23  )) throw new Illegal_Time("hour");
	if (!(minutes >= 0 && minutes <= 59)) throw new Illegal_Time("minutes");
	
		int totalDays= 0;
		switch (month)
		{
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				totalDays = 31;
				break;

			case 4:
			case 6:
			case 9:
			case 11:
				totalDays = 30;
				break;

			case 2:
				if (  ((year % 4 == 0) && (year % 100 != 0))
					||( year % 400 == 0) )
					totalDays = 29;
				else 
					totalDays = 28;
				break;
		}
		if (!(day >= 0 && day <= totalDays)) throw new Illegal_Time("day");
}
}

