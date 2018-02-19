package calendar;

import java.util.Calendar;
import java.util.Random;
import java.util.*;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	
    /**
     * Generate Random Tests that tests TimeTable Class.
     */
	 
	 //generate for deleteAppt() and getApptRange

	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod2(Random random){
        String[] methodArray2 = new String[] {"deleteAppt","getApptRange"};// The list of the of methods to be tested in the Appt class

    	int n = random.nextInt(methodArray2.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)
    	            
        return methodArray2[n] ; // return the method name 
	}
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
				
				TimeTable t = new TimeTable();
			    LinkedList<CalDay> calDays = new LinkedList<CalDay>();
				LinkedList<CalDay> calDays2 = new LinkedList<CalDay>();
			    LinkedList<Appt> ListAppts = new LinkedList<Appt>();
				LinkedList<Appt> ListAppts2 = new LinkedList<Appt>();
				
				int sizeArray = ValuesGenerator.RandInt(random);

				int startHour=ValuesGenerator.getRandomIntBetween(random, 0, 23);
				int startMinute=ValuesGenerator.getRandomIntBetween(random, 0, 59);
				int startDay=ValuesGenerator.getRandomIntBetween(random, 1, 28);
				int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int startYear=ValuesGenerator.RandInt(random);
				String title="Birthday Party";
				String description="This is my birthday party.";
				
				Appt appt = new Appt(startHour,
						startMinute ,
						startDay ,
						startMonth ,
						startYear ,
						title,
						description);
				
				ListAppts.add(appt);
				
				ListAppts.add(appt);
				
				int startHour2=ValuesGenerator.getRandomIntBetween(random, 0, 23);
			    int startMinute2=ValuesGenerator.getRandomIntBetween(random, 0, 59);
			    int startDay2=ValuesGenerator.getRandomIntBetween(random, startDay, 28);
			    int startMonth2=ValuesGenerator.getRandomIntBetween(random, startMonth, 11);
			    int startYear2=ValuesGenerator.getRandomIntBetween(random, startYear, startYear+100);
			    String title2="Birthday Party";
			    String description2="This is my birthday party.";
			
			    Appt appt2 = new Appt(startHour2,
					startMinute2 ,
					startDay2 ,
					startMonth2 ,
					startYear2 ,
					title2,
					description2);

				ListAppts.add(appt2);
				
				ListAppts2.add(appt2);
				
				int startHour3=ValuesGenerator.getRandomIntBetween(random, 24, 50);
				int startMinute3=ValuesGenerator.getRandomIntBetween(random, 60, 100);
				int startDay3=ValuesGenerator.getRandomIntBetween(random, 32, 50);
				int startMonth3=ValuesGenerator.getRandomIntBetween(random, startMonth, startMonth2);
				int startYear3=ValuesGenerator.getRandomIntBetween(random, startYear, startYear2);
				String title3="Birthday Party";
				String description3="This is my birthday party.";
			
				Appt appt3 = new Appt(startHour3,
					startMinute3 ,
					startDay3 ,
					startMonth3 ,
					startYear3 ,
					title3,
					description3);

				ListAppts.add(appt3);
				
				ListAppts2.add(appt3);
				
				int startHour4=ValuesGenerator.getRandomIntBetween(random, 0, 23);
			    int startMinute4=ValuesGenerator.getRandomIntBetween(random, 0, 59);
			    int startDay4=ValuesGenerator.getRandomIntBetween(random, startDay, 28);
			    int startMonth4=ValuesGenerator.getRandomIntBetween(random, startMonth, 11);
			    int startYear4=ValuesGenerator.getRandomIntBetween(random, startYear, startYear+100);
				String title4="Birthday Party";
				String description4="This is my birthday party.";
				
				Appt appt4 = new Appt(startHour4,
					startMinute4 ,
					startDay4 ,
					startMonth4 ,
					startYear4 ,
					title4,
					description4);
				
							
				for (int i = 0; i < sizeArray-2; i++) {
					int newstartHour=ValuesGenerator.getRandomIntBetween(random, 0, 23);
					int newstartMinute=ValuesGenerator.getRandomIntBetween(random, 0, 59);
					int newstartDay=ValuesGenerator.getRandomIntBetween(random, 1, 28);
					int newstartMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
					int newstartYear=ValuesGenerator.RandInt(random);
					String newtitle="Birthday Party";
					String newdescription="This is my birthday party.";

					ListAppts.add(new Appt(newstartHour,
							newstartMinute ,
							newstartDay ,
							newstartMonth ,
							newstartYear ,
							newtitle,
							newdescription));
					ListAppts2.add(new Appt(newstartHour,
							newstartMinute ,
							newstartDay ,
							newstartMonth ,
							newstartYear ,
							newtitle,
							newdescription));
				}
				
				
			for (int i = 0; i < NUM_TESTS; i++) {
					String methodName2 = TimeTableRandomTest.RandomSelectMethod2(random);
					   if (methodName2.equals("deleteAppt")){
						   assertEquals(ListAppts2.size()+1, t.deleteAppt(ListAppts, appt).size());
						   assertEquals(null, t.deleteAppt(ListAppts, null));
						   assertEquals(null, t.deleteAppt(null, appt));
						   assertEquals(null, t.deleteAppt(ListAppts, appt3));
						   assertEquals(null, t.deleteAppt(ListAppts, appt4));
						   
						}else if (methodName2.equals("getApptRange")){
							GregorianCalendar gregCal = new GregorianCalendar(startYear,startMonth,startDay);
							GregorianCalendar gregCal2 = new GregorianCalendar(startYear2,startMonth2,startDay2);

							calDays = t.getApptRange(ListAppts,gregCal, gregCal2);
							calDays2 = t.getApptRange(ListAppts,gregCal2, gregCal);
							//assertEquals(appt, calDays.getFirst().getAppts().getFirst());
							//assertEquals(appt2, calDays.getLast().getAppts().getLast());
					   }
			}
				
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        //if((iteration%10000)==0 && iteration!=0 )
			          //    System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			 
			}
		}catch(NullPointerException e){
			
		}catch(DateOutOfRangeException e) {
			
		}
	 
		 System.out.println("Done testing...");
	 }


	
}
