package appModules;

import Common_Utility.Constants;
import Common_Utility.ExcelUtils;
import Common_Utility.Log;
import Common_Utility.Utils;
import pageObjects.Home_page;
import pageObjects.SignIn_page;
import pageObjects.SignUp_page;
import testData.Verification_Data;

public class SignUp_Actions {
	
	private static  String sName;
	private static  String sEmail;
	private static  String sPassword;
	
	public static void Execute_SignUp(int iTestCaseRow)
	{
		
		sName = ExcelUtils.getCellData(iTestCaseRow,Constants.SignUp_name_col);
		sEmail = ExcelUtils.getCellData(iTestCaseRow,Constants.SignUp_email_col);
		sPassword = ExcelUtils.getCellData(iTestCaseRow, Constants.SignUp_password_col);
		 
		   SignUp_page.txt_name().sendKeys(sName);
		   Log.info(sName + " : entered in Full Name textbox");	 
		
		   SignUp_page.txt_email().sendKeys(sEmail);
		   Log.info(sEmail + " : entered in Email textbox");		   
		   
		   
		   SignUp_page.txt_password().sendKeys(sPassword);
		   Log.info(sPassword + " : entered in password textbox");
		   
		 
		   SignUp_page.btn_SignUp().click();
		   Log.info("Login button is clicked");
		   		   
	}
	
	public static void Execute_FB_SignUp(int iTestCaseRow) throws InterruptedException
	{
		   SignUp_page.btn_SignUp_FB().click();
		   Log.info( "Sign Up with Facebook button is clicked");	
		  
		   Thread.sleep(3000);
		   //Utils.waitForElement(Home_page.txt_mainTitle()); 
		   		   
	}
	
	public static void Execute_Google_SignUp(int iTestCaseRow) throws InterruptedException
	{		 
		   SignUp_page.btn_SignUp_Google().click();
		   Log.info( "Sign Up with Google button is clicked");		   
		  
		   Thread.sleep(3000);
		 // Utils.waitForElement(Home_page.txt_mainTitle()); 
		   		   
	}

	/*public static void verify_SignUp(int iTestCaseRow )
	{
		 Utils.waitForElement(Home_page.txt_mainTitle()); 
		 Utils.verify_Data(Home_page.txt_mainTitle(), Verification_Data.Home_title);
		Log.info("Sign in action verified successfully");
		
	}*/
	
	public static void goToSignIn()
	{
		SignUp_page.lnk_login().click();
		 Log.info( "Sign In link is clicked");	
		
	}
	
	public static void goToPrivacyPolicy()
	{
		SignUp_page.lnk_privacy_policy().click();
		 Log.info( "Privacy policy link is clicked");	
		
	}
	
	public static void close_PrivacyPolicy()
	{
		SignUp_page.btn_privacy_policy_Close().click();
		 Log.info( "Privacy policy close button is clicked");	
		
	}
	
	public static void goTo_TandC()
	{
		SignUp_page.lnk_T_and_C().click();
		 Log.info( "Terms and Conditions link is clicked");	
		
	}
	
	public static void close_TandC()
	{
		SignUp_page.btn_T_and_C_Close().click();
		 Log.info( "Terms and Conditions close button is clicked");	
		
	}
}
