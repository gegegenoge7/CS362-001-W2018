package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
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
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription()); 
		 
	 }

	/**
	 * Test that the set methods work as expected.
	 */
	 @Test
	  public void test02()  throws Throwable  {
		 int startHour=24;
		 int startMinute=60;
		 int startDay=32;
		 int startMonth=02;
		 int startYear=2020;
		 String title=null;
		 String description=null;
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(15, 00, 01, 01, 2018, "New Years Party", "This is the New Years day");
		 assertTrue(appt.getValid());

		 appt.setStartHour(startHour);
		 assertFalse(appt.getValid());
		 assertEquals(24, appt.getStartHour());
		 appt.setStartHour(15);
		 
		 appt.setStartMinute(startMinute);
		 assertFalse(appt.getValid());
		 assertEquals(60, appt.getStartMinute());
		 appt.setStartMinute(00);
		 
		 appt.setStartDay(startDay);
		 assertFalse(appt.getValid());
		 assertEquals(32, appt.getStartDay());
		 appt.setStartDay(29);
		 
		 appt.setStartMonth(startMonth);
		 assertEquals(02, appt.getStartMonth());
		 assertFalse(appt.getValid());
		 
		 appt.setStartYear(startYear);
		 assertEquals(2020, appt.getStartYear());
		 assertTrue(appt.getValid());
		 
		 
		 appt.setTitle(title);
		 assertEquals("", appt.getTitle());
		 
		 appt.setDescription(description);
		 assertEquals("", appt.getDescription());
		 
	 }
	/**
	 * Test that the isValid/getValid method work as expected.
	 */
	 @Test
	  public void test03()  throws Throwable  {
		  //valid appointments
		  Appt appt = new Appt(00, 00, 01, 01, 2018, "New Years Party", "This is the New Years day");
		  assertEquals(true, appt.getValid());
		  
		  Appt apptA = new Appt(1,1,1,1,1, "none", "none");
		  Appt apptA_2 = new Appt(1,1,1,12,1, "none", "none");
		  assertEquals(true, apptA.getValid());
		  assertEquals(true, apptA_2.getValid());
		  
		  Appt apptB = new Appt(23,1,1,1,1, "none", "none");
		  Appt apptB_2 = new Appt(0,1,1,1,1, "none", "none");
		  assertEquals(true, apptB.getValid());
		  assertEquals(true, apptB_2.getValid());
		  
		  Appt apptC = new Appt(1,0,1,1,1, "none", "none");
		  Appt apptC_2 = new Appt(1,59,1,1,1, "none", "none");
		  assertEquals(true, apptC.getValid());
		  assertEquals(true, apptC_2.getValid());
		  
		  Appt apptD = new Appt(1,1,1,1,1, "none", "none");
		  Appt apptD_2 = new Appt(1,1,28,2,2018, "none", "none");
		  assertEquals(true, apptD.getValid());
		  assertEquals(true, apptD_2.getValid());
		  
		  //invalid appointments
		  Appt appt1 = new Appt(24,1,1,1,1, "none", "none");
		  Appt appt1_2 = new Appt(-1,1,1,1,1, "none", "none");
		  assertEquals(false, appt1.getValid());
		  assertEquals(false, appt1_2.getValid());
		  
		  Appt appt2 = new Appt(1,60,1,1,1, "none", "none");
		  Appt appt2_2 = new Appt(1,-1,1,1,1, "none", "none");
		  assertEquals(false, appt2.getValid());
		  assertEquals(false, appt2_2.getValid());
		  
		  Appt appt3 = new Appt(1,1,29,2,2018, "none", "none");
		  Appt appt3_2 = new Appt(1,1,-1,1,1, "none", "none");
		  assertEquals(false, appt3.getValid());
		  //assertEquals(false, appt3_2.getValid());
		  
		  //can't test months due to call onto NumDaysInMonth
		  //this function doesn't validate title or description
	  }
	  
	/**
	 * Test that the compareTo method work as expected.
	 */
	 @Test
	  public void test04()  throws Throwable  {
		  Appt appt1 = new Appt(15, 00, 01, 01, 2018, "New Years Party", "This is the New Years day");
		  Appt appt2 = new Appt(15, 00, 01, 01, 2018, "New Years Party", "This is the New Years day");
		  assertEquals(0,appt1.compareTo(appt2));
		  
	  }
	  
	/**
	 * Test that the toString and represntationApp method work as expected.
	 */
	 @Test
	  public void test05()  throws Throwable  {
		 Appt appt1 = new Appt(21, 30, 15, 01, 2018, "Birthday Party", "This is my birthday party.");
		 String testString1 = "\t" + 01 + "/" + 15 + "/" + 2018 +" at " + 9 + ":" + 30 + "pm" + " ," + "Birthday Party" + ", " + "This is my birthday party." + "\n";
		 assertEquals(testString1, appt1.toString());
		 
		 Appt appt2 = new Appt(0, 30, 15, 01, 2018, "Birthday Party", "This is my birthday party.");
		 String testString2 = "\t" + 01 + "/" + 15 + "/" + 2018 +" at " + 12 + ":" + 30 + "am" + " ," + "Birthday Party" + ", " + "This is my birthday party." + "\n";
		 assertEquals(testString2, appt2.toString());
		
		 Appt appt3 = new Appt(11, 30, 15, 01, 2018, "Birthday Party", "This is my birthday party.");
		 String testString3 = "\t" + 01 + "/" + 15 + "/" + 2018 +" at " + 11 + ":" + 30 + "am" + " ," + "Birthday Party" + ", " + "This is my birthday party." + "\n";
		 assertEquals(testString3, appt3.toString());
		 
		 Appt appt4 = new Appt(12, 30, 15, 01, 2018, "Birthday Party", "This is my birthday party.");
		 String testString4 = "\t" + 01 + "/" + 15 + "/" + 2018 +" at " + 12 + ":" + 30 + "pm" + " ," + "Birthday Party" + ", " + "This is my birthday party." + "\n";
		 assertEquals(testString4, appt4.toString());
		 
		 Appt appt_invalid = new Appt(24,1,1,1,1, "none", "none");
		 assertEquals(null, appt_invalid.toString());
	  }
	  /**
	   * Tests
	   */
	  @Test
		public void test06()  throws Throwable {
			Appt appt = new Appt(15, 00, 01, 01, 2018, "New Years Party", "This is the New Years day");
			int[] RecurDay = {1,2,3};
			assertEquals(2, appt.getRecurBy());
			assertEquals(0, appt.getRecurIncrement());
			appt.setRecurrence(RecurDay, 1, 1, 1);
			assertEquals(1, appt.getRecurDays()[0]);
			appt.setRecurrence(null, 1,1,0);
			assertEquals(0, appt.getRecurDays().length);
			assertEquals(1, appt.getRecurIncrement());
		}
//add more unit tests as you needed
	
}