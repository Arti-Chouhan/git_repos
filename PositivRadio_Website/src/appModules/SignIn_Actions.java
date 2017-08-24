package appModules;
import pageObjects.Home_page;
import pageObjects.SignIn_page;
import testData.Verification_Data;
import Common_Utility.Constants;
import Common_Utility.ExcelUtils;
import Common_Utility.Log;
import Common_Utility.Utils;
public class SignIn_Actions {
	
	
	
	
	private static  String sEmail;
	private static  String sPassword;
	
	public static void Execute_SignIn(int iTestCaseRow)
	{
		
		sEmail = ExcelUtils.getCellData(iTestCaseRow,Constants.email_col);
		sPassword = ExcelUtils.getCellData(iTestCaseRow, Constants.password_col);
		 
		   SignIn_page.txt_email().sendKeys(sEmail);
		   Log.info(sEmail + " : entered in Username textbox");	
		  // System.out.println(sEmail + " : entered in Username textbox");
		   
		   
		   SignIn_page.txt_password().sendKeys(sPassword);
		   Log.info(sPassword + " : entered in password textbox");
		  // System.out.println(sPassword + " : entered in password textbox");
		   
		 
		   SignIn_page.btn_login().click();
		   Log.info("Login button is clicked");
		   		   
	}
	
	public static void Execute_FB_SignIn(int iTestCaseRow) throws InterruptedException
	{
		   SignIn_page.btn_login_FB().click();
		   Log.info( "Sign In with Facebook button is clicked");	
		  
		   Thread.sleep(2000);
		   Utils.waitForElement(Home_page.txt_mainTitle()); 
		   		   
	}
	
	public static void Execute_Google_SignIn(int iTestCaseRow) throws InterruptedException
	{
		
		//sEmail = ExcelUtils.getCellData(iTestCaseRow,Constants.email_col);
		//sPassword = ExcelUtils.getCellData(iTestCaseRow, Constants.password_col);
		 
		   SignIn_page.btn_login_Google().click();
		   Log.info( "Sign In with Google button is clicked");		   
		  
		   Thread.sleep(2000);
		  Utils.waitForElement(Home_page.txt_mainTitle()); 
		   		   
	}
	public static void verify_SignIn(int iTestCaseRow )
	{
		 Utils.waitForElement(Home_page.txt_mainTitle()); 
		 Utils.verify_Data(Home_page.txt_mainTitle(), Verification_Data.Home_title);
		Log.info("Sign in action verified successfully");
		
	}
	
	public static void goToForgotPassword()
	{
		 SignIn_page.lnk_Forgot_Password().click();
		 Log.info( "Forgot Password link is clicked");	
		
	}
	
	public static void goToSignUp()
	{
		 SignIn_page.lnk_SignUp().click();
		 Log.info( "Sign Up link is clicked");	
		
	}
	
	
	
	
	
}
