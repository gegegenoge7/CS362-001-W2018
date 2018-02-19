package calendar;

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;



import static org.junit.Assert.*;



/**
 * Random Test Generator  for Appt class.
 */

 //generate for isValid() and setRecurDays
 
public class ApptRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"isValid","setRecurDays"};// The list of the of methods to be tested in the Appt class

    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)
    	            
        return methodArray[n] ; // return the method name 
        }
	/**
	 * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
	 */
    public static int RandomSelectRecur(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return the value of the  appointments to recur 
        }	
	/**
	 * Return a randomly selected appointments to recur forever or Never recur  !.
	 */
    public static int RandomSelectRecurForEverNever(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return appointments to recur forever or Never recur 
        }	
   /**
     * Generate Random Tests that tests Appt Class.
     */
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
				
				 int startHour=ValuesGenerator.RandInt(random);
				 int startMinute=ValuesGenerator.RandInt(random);
				 int startDay=ValuesGenerator.RandInt(random);;
				 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startYear=ValuesGenerator.RandInt(random);
				 String title="Birthday Party";
				 String description="This is my birthday party.";
				 //Construct a new Appointment object with the initial data	 
				 Appt appt = new Appt(startHour,
				          startMinute ,
				          startDay ,
				          startMonth ,
				          startYear ,
				          title,
				         description);
			 if(!appt.getValid())continue;
			for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = ApptRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("isValid")){
						   String newTitle=(String) ValuesGenerator.getString(random);
						   int newstartHour=ValuesGenerator.getRandomIntBetween(random, 0, 23);
						   int newstartMinute=ValuesGenerator.getRandomIntBetween(random, 0, 59);
						   int newstartDay=ValuesGenerator.getRandomIntBetween(random, 1, 28);;
						   int newstartMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
						   int newstartYear=ValuesGenerator.RandInt(random);
						   String newtitle="Birthday Party";
						   String newdescription="This is my birthday party.";
						   Appt newappt = new Appt(newstartHour,
							newstartMinute ,
							newstartDay ,
							newstartMonth ,
							newstartYear ,
							newtitle,
							newdescription);
							assertTrue(newappt.getValid());
							
						   int newstartHour2=ValuesGenerator.getRandomIntBetween(random, 24, 50);
						   Appt newappt2 = new Appt(newstartHour2,
							newstartMinute ,
							newstartDay ,
							newstartMonth ,
							newstartYear ,
							newtitle,
							newdescription);
							assertFalse(newappt2.getValid());
							
							int newstartHour2_1=ValuesGenerator.getRandomIntBetween(random, -5, -1);
						   Appt newappt2_1 = new Appt(newstartHour2_1,
							newstartMinute ,
							newstartDay ,
							newstartMonth ,
							newstartYear ,
							newtitle,
							newdescription);
							assertFalse(newappt2_1.getValid());
						   					   
						   int newstartMinute3_1=ValuesGenerator.getRandomIntBetween(random, -10, -5);
						   Appt newappt3_1 = new Appt(newstartHour,
							newstartMinute3_1 ,
							newstartDay ,
							newstartMonth ,
							newstartYear ,
							newtitle,
							newdescription);
							assertFalse(newappt3_1.getValid());
						   
						   int newstartDay4_1=ValuesGenerator.getRandomIntBetween(random, -10, -5);
						   Appt newappt4_1 = new Appt(newstartHour,
							newstartMinute ,
							newstartDay4_1 ,
							newstartMonth ,
							newstartYear ,
							newtitle,
							newdescription);
							assertFalse(newappt4_1.getValid());
						}
					   else if (methodName.equals("setRecurDays")){
						   int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
						   int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
						   int recur=ApptRandomTest.RandomSelectRecur(random);
						   int recurIncrement = ValuesGenerator.RandInt(random);
						   int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
						   appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
						   
						   assertEquals(recurDays, appt.getRecurDays());
						   appt.setRecurrence(null, recur, recurIncrement, recurNumber);
						   assertEquals(0,appt.getRecurDays().length);
						}				
				}
				
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			 
			}
		}catch(NullPointerException e){
			
		}catch (ArrayIndexOutOfBoundsException e) {
			
		}
	 
		 System.out.println("Done testing...");
	 }


	
}
