package Common_Utility;

public class Constants {
	
	public static final String url = "http://positivradio.test.gate6.com/web";
	//public static final String sUsername = "Arti.Chouhan";
	//public static final String sPassword = "argate6@123";
	
	
	// Defining Chrome webdriver
	
	public static final String chrome_driver = "webdriver.chrome.driver";
	public static final String chrome_driver_path = "C:\\Users\\Owner\\Downloads\\chromedriver_win32\\chromedriver.exe";
	
	

	// Defining Firefox webdriver
	
	public static final String firefox_driver = "webdriver.gecko.drive";
	public static final String firefox_driver_path = "C:\\Users\\Owner\\Downloads\\geckodriver-v0.18.0-win64\\geckodriver.exe";
	
	// Defining IE webdriver
	
		public static final String IE_driver = "webdriver.ie.driver";
		public static final String IE_driver_path = "C:\\Users\\Owner\\Downloads\\IEDriverServer_x64_3.4.0\\IEDriverServer.exe";
	
	//constants for test_data excel sheet
	
	//public static final String path_testData = "user.dir" +"\\"+"C:\\Users\\Owner\\eclipse-workspace\\PositivRadio_Website\\src\\testData";
	public static final String path_testData = "\\src\\testData";
	public static final String fileName_testData = "PositivRadio_Website_testData.xlsx";
	public static final String SheetName_TestData = "TestData";
	
	//constants for screenshot
	public static final String Path_ScreenShot = "C:\\Users\\Owner\\eclipse-workspace\\PositivRadio_Website\\src";
	
	
	//constants for Login_TestData sheet
	public static final int testModule_col = 0;
	public static final int testcasename_col = 1;
	public static final int email_col = 3;
	public static final int password_col = 4;
	public static final int browsername_col = 5;
	public static final int Login_TestData_Result_col = 6;
	
	
	//constants for SignUp_TestData sheet
	public static final int SignUp_name_col = 3;
	public static final int SignUp_email_col = 4;
	public static final int SignUp_password_col = 5;
	public static final int SignUp_browsername_col = 6;
	public static final int SignUp_TestData_Result_col = 7;
	

	

	

}
