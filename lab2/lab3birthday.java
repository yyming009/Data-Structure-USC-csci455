import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.xml.crypto.*;
import java.sql.*;
import javax.sql.rowset.*;
import java.text.*;
import java.util.*;


public class lab3birthday {
	public static void main(String[] args) {
		Calendar gaincalender = new GregorianCalendar();
		/*
		gaincalender.set(Calendar.YEAR, 1995);
		gaincalender.set(Calendar.MONDAY, 0);
		gaincalender.set(Calendar.DAY_OF_MONTH, 20);
		
		// 1.2  gain the date
		Date date = gaincalender.getTime();
		//int year= gaincalender.get(Calendar.YEAR);
		System.out.println(date);
		*/
		
		/*
		//1.3  get method to print out the date
		int year= gaincalender.get(Calendar.YEAR);
		int month= gaincalender.get(Calendar.MONDAY);
		int dayofmonth= gaincalender.get(Calendar.DAY_OF_MONTH);
		Date date = gaincalender.getTime();
		System.out.println(date);
		System.out.println("The date is "+ year + "-" + month + "-" + dayofmonth );
		*/
		
		//1.4  Jan-0  month: 0-11
		
		//2.1 
		/*
		gaincalender.set(Calendar.YEAR, 1995);
		gaincalender.set(Calendar.MONDAY, 0);
		gaincalender.set(Calendar.DAY_OF_MONTH, 20);
		Date date = gaincalender.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("M/dd/yyyy");
		String dateformat = formatter.format(date);
		System.out.println(dateformat);
	
		//after 20 days
		gaincalender.add(Calendar.DAY_OF_MONTH, 20);
		Date date2 = gaincalender.getTime();
		SimpleDateFormat formatter2 = new SimpleDateFormat("M/d/yyyy");
		String dateformat2 = formatter2.format(date2);
		System.out.println(dateformat2);
		*/
		
		// 3.1
		Scanner s = new Scanner(System.in);
		
		SimpleDateFormat dateformat = new SimpleDateFormat("MM-dd");
		SimpleDateFormat dateformatyear = new SimpleDateFormat("MM-dd-yyyy");
		String nowdateyear = dateformatyear.format(new Date());
		//4  year
		SimpleDateFormat justyear = new SimpleDateFormat("yyyy");
		String nowdatejustyear = justyear.format(new Date());
		//4  month
		SimpleDateFormat justmonth = new SimpleDateFormat("M");
		String nowdatejustmonth = justmonth.format(new Date());
		System.out.println(nowdatejustyear);

				//SimpleDateFormat dateformat = new SimpleDateFormat("MM-dd");
		
		String nowdate = dateformat.format(new Date());
		System.out.println(nowdate);
	
		//String date = s.next();
		
		System.out.print("Enter your birth month [1...12]:");
		String month = s.next();
		System.out.print("Enter your birth day of month:");
		String day = s.next();
		System.out.print("Enter your birth year[4-digit year]:");
		String year = s.next();
		String birthday = month + "-" + day ;
		Date dt1 = null;
		Date dt2 = null;
		Date dtyear = null;
		try {
			 dt1 = dateformat.parse(nowdate);
			 dt2 = dateformat.parse(birthday);
			dtyear = dateformatyear.parse(nowdateyear);

		} catch (ParseException pe) {
			System.out.println(pe.getMessage());  
		}
	
		System.out.println(dtyear);
		if (dt1.getTime()> dt2.getTime()) {
			System.out.println("Your birthday has already happened this year.");
		}
		
		else if (dt1.getTime() < dt2.getTime()) {
			System.out.println("Your birthday has not yet happened this year.");
		}
		else if (dt1.getTime() == dt2.getTime()) {
			System.out.println("Today is your birthday.");
		}
		
		//4 
		int age=0;
		age = Integer.parseInt(nowdatejustyear) - Integer.parseInt(year);
		
		if (nowdatejustmonth.compareTo(month)<0) {
			age -= 1;
		}
		System.out.println("You're "+ age + "years old.");
		
		
		
		}
}