package automation_Testcases;

import java.lang.reflect.Method;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.Base_Class;
import pageObjects.ForgotPassword_page;
import pageObjects.SignIn_page;
import pageObjects.SignUp_page;
import testData.Verification_Data;
import Common_Utility.Constants;
import Common_Utility.ExcelUtils;
import Common_Utility.Log;
import Common_Utility.Utils;
import appModules.SignIn_Actions;


public class SignIn_Test {
	
	public static WebDriver driver ;
	 
	private static int iTestCaseRow;
	public static String sTestModule;
	public static String sTestCaseName;
	
	@BeforeMethod
	public void BeforeMethod(Method method) throws Exception
	{
		DOMConfigurator.configure("log4j.xml");
		sTestCaseName = method.getName();
		System.out.println("Testcase name is : " + sTestCaseName );
		Log.StartTestCase(sTestCaseName);
		
		//This is to open the Excel file. Excel path, file name and the sheet name are parameters to this method
	    ExcelUtils.setFile(System.getProperty("user.dir")+ Constants.path_testData +"\\"+ Constants.fileName_testData, Constants.SheetName_TestData);			
		Log.info("Excel file is opened");
		
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, Constants.testcasename_col);
		driver = Utils.initiateBrowser(iTestCaseRow,Constants.browsername_col);
		
		new Base_Class(driver); //passing the above driver to all the modules/actions classes in which Base class is extended
	}

	@Test(priority=0) 
	public void SignIn_Successful_TC() throws Exception
	{
		try
		{
			SignIn_Actions.Execute_SignIn(iTestCaseRow);
			SignIn_Actions.verify_SignIn(iTestCaseRow);

			if(Base_Class.bResult==true)
			{
				System.out.println("Testcase passed"); 
				//This is to send the PASS value to the Excel sheet in the result column.
				ExcelUtils.setCellData("Pass", iTestCaseRow, Constants.Login_TestData_Result_col);
			}
			else
			{
				throw new Exception("Test Case Failed because of Verification");
			}
		}
		catch(Exception e)
		{
			Log.error("User is not Signed In successfully.Error is  : "+e.getMessage());
			 //This is to send the FAIL value to the Excel sheet in the result column.
			System.out.println("Testcase failed");
			ExcelUtils.setCellData("Fail", iTestCaseRow, Constants.Login_TestData_Result_col);
			
			//Taking screenshot of failed testcase
			//Utils.takeScreenshot(driver, sTestCaseName);			
			throw(e);
		}
					
	}
	
	@Test(priority=1,enabled=true) 
	public void Blank_Email_TC() throws Exception
	{
		try
		{
			SignIn_Actions.Execute_SignIn(iTestCaseRow);
			Utils.verify_errorMsg(SignIn_page.error_msg_email(), Verification_Data.BlankEmail_msg);

			if(Base_Class.bResult==true)
			{
				System.out.println("Testcase passed"); 
				//This is to send the PASS value to the Excel sheet in the result column.
				ExcelUtils.setCellData("Pass", iTestCaseRow, Constants.Login_TestData_Result_col);
			}
			else
			{
				throw new Exception("Test Case Failed because of Verification");
			}
		}
		catch(Exception e)
		{
			Log.error("Validation message for blank email id is not verified.Error is  : "+e.getMessage());
			 //This is to send the FAIL value to the Excel sheet in the result column.
			System.out.println("Testcase failed");
			ExcelUtils.setCellData("Fail", iTestCaseRow, Constants.Login_TestData_Result_col);		
			throw(e);
		}
					
	}
	
	@Test(priority=2,enabled=true) 
	public void Blank_Password_TC() throws Exception
	{
		try
		{
			SignIn_Actions.Execute_SignIn(iTestCaseRow);
			Utils.verify_errorMsg(SignIn_page.error_msg_password(), Verification_Data.BlankPsswrd_msg);

			if(Base_Class.bResult==true)
			{
				System.out.println("Testcase passed"); 
				//This is to send the PASS value to the Excel sheet in the result column.
				ExcelUtils.setCellData("Pass", iTestCaseRow, Constants.Login_TestData_Result_col);
			}
			else
			{
				throw new Exception("Test Case Failed because of Verification");
			}
		}
		catch(Exception e)
		{
			Log.error("Validation message for blank password.Error is  : "+e.getMessage());
			 //This is to send the FAIL value to the Excel sheet in the result column.
			System.out.println("Testcase failed");
			ExcelUtils.setCellData("Fail", iTestCaseRow, Constants.Login_TestData_Result_col);		
			throw(e);
		}
					
	}
	
	@Test(priority=3,enabled=true) 
	public void Invalid_EmailFormat_TC() throws Exception
	{
		try
		{
			SignIn_Actions.Execute_SignIn(iTestCaseRow);
			Utils.verify_errorMsg(SignIn_page.error_msg_email(), Verification_Data.InvalidEmail_msg);

			if(Base_Class.bResult==true)
			{
				System.out.println("Testcase passed"); 
				//This is to send the PASS value to the Excel sheet in the result column.
				ExcelUtils.setCellData("Pass", iTestCaseRow, Constants.Login_TestData_Result_col);
			}
			else
			{
				throw new Exception("Test Case Failed because of Verification");
			}
		}
		catch(Exception e)
		{
			Log.error("Validation message for invalid email id format is not verified.Error is  : "+e.getMessage());
			 //This is to send the FAIL value to the Excel sheet in the result column.
			System.out.println("Testcase failed");
			ExcelUtils.setCellData("Fail", iTestCaseRow, Constants.Login_TestData_Result_col);		
			throw(e);
		}
					
	}
	
	@Test(priority=4,enabled=true) 
	public void Incorrect_Password_TC() throws Exception
	{
		try
		{
			SignIn_Actions.Execute_SignIn(iTestCaseRow);
			Utils.verify_errorMsg(SignIn_page.alert_invalid(), Verification_Data.Wrong_credentials);

			if(Base_Class.bResult==true)
			{
				System.out.println("Testcase passed"); 
				//This is to send the PASS value to the Excel sheet in the result column.
				ExcelUtils.setCellData("Pass", iTestCaseRow, Constants.Login_TestData_Result_col);
			}
			else
			{
				throw new Exception("Test Case Failed because of Verification");
			}
		}
		catch(Exception e)
		{
			Log.error("Validation message for incorrect password is not verified.Error is  : "+e.getMessage());
			 //This is to send the FAIL value to the Excel sheet in the result column.
			System.out.println("Testcase failed");
			ExcelUtils.setCellData("Fail", iTestCaseRow, Constants.Login_TestData_Result_col);		
			throw(e);
		}
					
	}
	
	@Test(priority=5,enabled=true) 
	public void Unregistered_Email_TC() throws Exception
	{
		try
		{
			SignIn_Actions.Execute_SignIn(iTestCaseRow);
			Utils.verify_errorMsg(SignIn_page.alert_invalid(), Verification_Data.Wrong_credentials);

			if(Base_Class.bResult==true)
			{
				System.out.println("Testcase passed"); 
				//This is to send the PASS value to the Excel sheet in the result column.
				ExcelUtils.setCellData("Pass", iTestCaseRow, Constants.Login_TestData_Result_col);
			}
			else
			{
				throw new Exception("Test Case Failed because of Verification");
			}
		}
		catch(Exception e)
		{
			Log.error("Validation message for unregistered email is not verified.Error is  : "+e.getMessage());
			 //This is to send the FAIL value to the Excel sheet in the result column.
			System.out.println("Testcase failed");
			ExcelUtils.setCellData("Fail", iTestCaseRow, Constants.Login_TestData_Result_col);		
			throw(e);
		}
					
	}
	
	@Test(priority=6,enabled=true) 
	public void ForgotPassword_Navigate_TC() throws Exception
	{
		try
		{
			SignIn_Actions.goToForgotPassword();
			Utils.waitForElement(ForgotPassword_page.btn_SendOTP());

			if(Base_Class.bResult==true)
			{
				System.out.println("Testcase passed"); 
				//This is to send the PASS value to the Excel sheet in the result column.
				ExcelUtils.setCellData("Pass", iTestCaseRow, Constants.Login_TestData_Result_col);
			}
			else
			{
				throw new Exception("Test Case Failed because of Verification");
			}
		}
		catch(Exception e)
		{
			Log.error("Forgot password page is not verified.Error is  : "+e.getMessage());
			 //This is to send the FAIL value to the Excel sheet in the result column.
			System.out.println("Testcase failed");
			ExcelUtils.setCellData("Fail", iTestCaseRow, Constants.Login_TestData_Result_col);		
			throw(e);
		}
					
	}
	
	@Test(priority=7,enabled=true) 
	public void SignUp_Navigate_TC() throws Exception
	{
		try
		{
			SignIn_Actions.goToSignUp();
			Utils.waitForElement(SignUp_page.btn_SignUp());

			if(Base_Class.bResult==true)
			{
				System.out.println("Testcase passed"); 
				//This is to send the PASS value to the Excel sheet in the result column.
				ExcelUtils.setCellData("Pass", iTestCaseRow, Constants.Login_TestData_Result_col);
			}
			else
			{
				throw new Exception("Test Case Failed because of Verification");
			}
		}
		catch(Exception e)
		{
			Log.error("SignUp page is not verified.Error is  : "+e.getMessage());
			 //This is to send the FAIL value to the Excel sheet in the result column.
			System.out.println("Testcase failed");
			ExcelUtils.setCellData("Fail", iTestCaseRow, Constants.Login_TestData_Result_col);		
			throw(e);
		}
					
	}
	
	@AfterMethod
	public void AfterMethod() throws Exception
	{
		  
		driver.quit();
		   Log.info("Driver is closed");
	       
	       Log.endTestCase(sTestCaseName);
	}
}
