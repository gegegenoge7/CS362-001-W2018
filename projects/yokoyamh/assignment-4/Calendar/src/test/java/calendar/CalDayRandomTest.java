package calendar;

import java.util.Calendar;
import java.util.Random;
import org.junit.Test;


import static org.junit.Assert.*;

import java.util.*;


/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;
	
    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 
	 //generate for addAppt()

	 @Test
	  public void radnomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 
		 System.out.println("Start testing...");
		 
		try{ 
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);
				
				int year = ValuesGenerator.RandInt(random);
				int month = ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int day = ValuesGenerator.getRandomIntBetween(random, 1, 28);
				GregorianCalendar gregCal = new GregorianCalendar(year,month,day);
				CalDay day1 = new CalDay(gregCal);
				
				int startHour=ValuesGenerator.getRandomIntBetween(random, 1, 23);
				int startMinute=ValuesGenerator.getRandomIntBetween(random, 0, 59);
				String title="Birthday Party";
				String description="This is my birthday party.";
				//Construct a new Appointment object with the initial data	 
				Appt appt = new Appt(startHour,
				          startMinute ,
				          day ,
				          month ,
				          year ,
				          title,
				         description);
				
				int startHour2=ValuesGenerator.getRandomIntBetween(random, startHour, 23);
				int startMinute2=ValuesGenerator.getRandomIntBetween(random, startMinute, 59);
				Appt appt2 = new Appt(startHour2,
				          startMinute2 ,
				          day ,
				          month ,
				          year ,
				          title,
				         description);
						 
				int startHour3=ValuesGenerator.getRandomIntBetween(random, 24, 50);
				int startMinute3=ValuesGenerator.getRandomIntBetween(random, 60, 100);
				Appt appt3 = new Appt(startHour3,
				          startMinute3 ,
				          day ,
				          month ,
				          year ,
				          title,
				         description);
				
				for (int i = 0; i < NUM_TESTS; i++) {
					day1.addAppt(appt2);
					day1.addAppt(appt);
					day1.addAppt(appt3);
					
					assertFalse(appt3.getValid());
					assertEquals(appt3, day1.getAppts().getFirst());
					
				}
				
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			 
			}
		}catch(NullPointerException e){
			
		}
	 
		 System.out.println("Done testing...");
	 }


	
}

