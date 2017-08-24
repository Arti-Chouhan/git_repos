package Common_Utility;
import org.apache.log4j.Logger;

public class Log {
	
	public static Logger Log = Logger.getLogger(Log.class.getName());
	
	public static void StartTestCase (String sTestCaseName)
	{
		Log.info("****************************************************************************************");
		 
		Log.info("****************************************************************************************");
	    System.out.println("****************************************************************************************");
		Log.info("$$$$$$$$$$$$$$$$$$$$$                 "+sTestCaseName + " testcase has started      $$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("$$$$$$$$$$$$$$$$$$$$$                 "+sTestCaseName+ " testcase has started      $$$$$$$$$$$$$$$$$$$$$$$$$");
		 System.out.println("****************************************************************************************");
		Log.info("****************************************************************************************");
	 
		Log.info("****************************************************************************************");
	 
		}
	 
		//This is to print log for the ending of the test case
	 
	 public static void endTestCase(String sTestCaseName)
	 {
	 
		Log.info("XXXXXXXXXXXXXXXXXXXXXXX---------      "+sTestCaseName +" has ENDED"+"       --------- XXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXX---------      "+sTestCaseName +" has ENDED"+"       --------- XXXXXXXXXXXXXXXXXXXXXX");
	    System.out.println();
		Log.info("X");
	 
		Log.info("X");
	 
		Log.info("X");
	 
		Log.info("X");
	 
		}
	 
		// Need to create these methods, so that they can be called  
	 
	 public static void info(String message) {
	 
			Log.info(message);
			System.out.println(message);
	 
			}
	 
	 public static void warn(String message) {
	 
	    Log.warn(message);
	    System.out.println(message);
	 
		}
	 
	 public static void error(String message) {
	 
	    Log.error(message);
	    System.out.println(message);
	 
		}
	 
	 public static void fatal(String message) {
	 
	    Log.fatal(message);
	    System.out.println(message);
	 
		}
	 
	 public static void debug(String message) {
	 
	    Log.debug(message);
	    System.out.println(message);
	 
		}
	}


