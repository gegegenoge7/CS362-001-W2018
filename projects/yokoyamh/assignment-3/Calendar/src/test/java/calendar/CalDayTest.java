package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */

import java.util.GregorianCalendar;
import java.util.Iterator;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Calendar;
import java.util.LinkedList;
import org.junit.runner.RunWith;


public class CalDayTest 
{
	
	 
	@Test
	public void test01()  throws Throwable  
	{
		int year;
		int month;
		int day;
		int startHour=21;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		Calendar cal = Calendar.getInstance();
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH)+1;
		day = cal.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar gregCal = new GregorianCalendar(year,month,day);
		CalDay calDay = new CalDay(gregCal);
		CalDay calDay2 = new CalDay();
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		Appt appt2 = new Appt( 23,1,1,1,1,"none","none");
			calDay.addAppt(appt);
			assertEquals(1,calDay.getSizeAppts());
			calDay.addAppt(appt2);
			assertEquals(2,calDay.getSizeAppts());
			assertEquals(null,calDay2.iterator());
			StringBuilder sb = new StringBuilder();
			String todayDate = month + "/" + day + "/" + year;
			sb.append("\t --- " + todayDate + " --- \n");
			sb.append(" --- -------- Appointments ------------ --- \n");
			Iterator<Appt> iterator = calDay.appts.iterator();
			while(iterator.hasNext())
			{
				Object element = iterator.next();
				sb.append(element + "");
			}
			sb.append("\n");
			assertNotEquals(sb.toString(),calDay.toString());
		
	}
	
	 @Test
	  public void test02()  throws Throwable  
	 {
			int year;
			int month;
			int day;
			int startHour=21;
			int startMinute=30;
			int startDay=15;
			int startMonth=01;
			int startYear=2018;
			Calendar cal = Calendar.getInstance();
			year = cal.get(Calendar.YEAR);
			month = cal.get(Calendar.MONTH)+1;
			day = cal.get(Calendar.DAY_OF_MONTH);
			GregorianCalendar gregCal = new GregorianCalendar(year,month,day);
			CalDay calDay = new CalDay(gregCal);
			Appt appt2 = new Appt(23,1,1,1,1,"none","none");
			calDay.addAppt(appt2);
			calDay.iterator();
			Iterator<Appt> iterator = calDay.appts.iterator();
			assertTrue(iterator.hasNext());
			Appt appt4 = new Appt(25,1,1,1,1,"none","none");
			calDay.addAppt(appt4);
			assertEquals(1,calDay.getSizeAppts());
			Appt appt5 = new Appt(23,5,5,5,5,"none","none");
			calDay.addAppt(appt5);
			assertEquals(2,calDay.getSizeAppts());
	 }

	 @Test
	  public void test03()  throws Throwable  
	 {
		GregorianCalendar gregCal = new GregorianCalendar(1,1,1);
		CalDay day1 = new CalDay(gregCal);
		Appt appt1 = new Appt(23,1,1,1,1,"none","none");
		Appt appt2 = new Appt(10,1,1,1,1,"none","none");
		day1.addAppt(appt1);
		day1.addAppt(appt2);
		assertEquals(appt2, day1.getAppts().get(0));
		CalDay day2 = new CalDay();
		String s = day2.toString();

	 }
	 
	 @Test
	  public void test04() throws Throwable
	  {
		 GregorianCalendar gregCal = new GregorianCalendar(1,1,1);
		 CalDay day = new CalDay(gregCal);
		 assertEquals(1, day.getDay());
		 assertEquals(1, day.getMonth());
		 assertEquals(1, day.getYear());
		 
	  }
	 @Test
	  public void test05() throws Throwable
	  {
		  GregorianCalendar gregCal = new GregorianCalendar(1,1,1);
		  CalDay day = new CalDay(gregCal);
		  Appt appt1 = new Appt(11,1,1,1,1,null,null);
		  Appt appt3 = new Appt(12,1,1,1,1,null,null);
		  Appt appt4 = new Appt(10,1,1,1,1,null,null);
		  day.addAppt(appt1);
		  //day.addAppt(appt3);
		  day.addAppt(appt4);
		  assertEquals(appt1, day.getAppts().getLast());
	  }
	  
	 @Test
	  public void test06() throws Throwable
	  {
		  GregorianCalendar gregCal = new GregorianCalendar(1,1,1);
		  CalDay day = new CalDay(gregCal);

	  }
}