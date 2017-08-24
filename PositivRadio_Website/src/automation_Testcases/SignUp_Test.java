package automation_Testcases;

import java.lang.reflect.Method;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common_Utility.Constants;
import Common_Utility.ExcelUtils;
import Common_Utility.Log;
import Common_Utility.Utils;
import appModules.SignIn_Actions;
import appModules.SignUp_Actions;
import pageObjects.Base_Class;
import pageObjects.SignIn_page;
import pageObjects.SignUp_page;
import testData.Verification_Data;

public class SignUp_Test {
	
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
	    ExcelUtils.setFile(Constants.path_testData + "\\" + Constants.fileName_testData, Constants.SheetName_TestData);			
		Log.info("Excel file is opened");
		
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, Constants.testcasename_col);
		driver = Utils.initiateBrowser(iTestCaseRow,Constants.SignUp_browsername_col);
		
		new Base_Class(driver); //passing the above driver to all the modules/actions classes in which Base class is extended
	}

	@Test(priority=0) 
	public void SignUp_Successful_TC() throws Exception
	{
		try
		{
			SignIn_Actions.goToSignUp();
			SignUp_Actions.Execute_SignUp(iTestCaseRow);
			//SignUp_Actions.verify_SignUp(iTestCaseRow);

			if(Base_Class.bResult==true)
			{
				System.out.println("Testcase passed"); 
				//This is to send the PASS value to the Excel sheet in the result column.
				ExcelUtils.setCellData("Pass", iTestCaseRow, Constants.SignUp_TestData_Result_col);
			}
			else
			{
				throw new Exception("Test Case Failed because of Verification");
			}
		}
		catch(Exception e)
		{
			Log.error("New User is registered successfully.Error is  : "+e.getMessage());
			 //This is to send the FAIL value to the Excel sheet in the result column.
			System.out.println("Testcase failed");
			ExcelUtils.setCellData("Fail", iTestCaseRow, Constants.SignUp_TestData_Result_col);		
			throw(e);
		}
					
	}
	

	@Test(priority=1) 
	public void SignUp_Blank_FullName_TC() throws Exception
	{
		try
		{
			SignIn_Actions.goToSignUp();
			SignUp_Actions.Execute_SignUp(iTestCaseRow);
			Utils.verify_errorMsg(SignUp_page.error_msg_Name(), Verification_Data.BlankName_msg);

			if(Base_Class.bResult==true)
			{
				System.out.println("Testcase passed"); 
				//This is to send the PASS value to the Excel sheet in the result column.
				ExcelUtils.setCellData("Pass", iTestCaseRow, Constants.SignUp_TestData_Result_col);
			}
			else
			{
				throw new Exception("Test Case Failed because of Verification");
			}
		}
		catch(Exception e)
		{
			Log.error("Validation message for Blank full name is not verified.Error is  : "+e.getMessage());
			 //This is to send the FAIL value to the Excel sheet in the result column.
			System.out.println("Testcase failed");
			ExcelUtils.setCellData("Fail", iTestCaseRow, Constants.SignUp_TestData_Result_col);		
			throw(e);
		}
					
	}
	
	@Test(priority=2) 
	public void SignUp_Blank_Email_TC() throws Exception
	{
		try
		{
			SignIn_Actions.goToSignUp();
			SignUp_Actions.Execute_SignUp(iTestCaseRow);
			Utils.verify_errorMsg(SignUp_page.error_msg_email(), Verification_Data.BlankEmail_msg);

			if(Base_Class.bResult==true)
			{
				System.out.println("Testcase passed"); 
				//This is to send the PASS value to the Excel sheet in the result column.
				ExcelUtils.setCellData("Pass", iTestCaseRow, Constants.SignUp_TestData_Result_col);
			}
			else
			{
				throw new Exception("Test Case Failed because of Verification");
			}
		}
		catch(Exception e)
		{
			Log.error("Validation message for Blank Email id is not verified.Error is  : "+e.getMessage());
			 //This is to send the FAIL value to the Excel sheet in the result column.
			System.out.println("Testcase failed");
			ExcelUtils.setCellData("Fail", iTestCaseRow, Constants.SignUp_TestData_Result_col);		
			throw(e);
		}
					
	}
	
	@Test(priority=3) 
	public void SignUp_Blank_Password_TC() throws Exception
	{
		try
		{
			SignIn_Actions.goToSignUp();
			SignUp_Actions.Execute_SignUp(iTestCaseRow);
			Utils.verify_errorMsg(SignUp_page.error_msg_password(), Verification_Data.BlankPsswrd_msg);

			if(Base_Class.bResult==true)
			{
				System.out.println("Testcase passed"); 
				//This is to send the PASS value to the Excel sheet in the result column.
				ExcelUtils.setCellData("Pass", iTestCaseRow, Constants.SignUp_TestData_Result_col);
			}
			else
			{
				throw new Exception("Test Case Failed because of Verification");
			}
		}
		catch(Exception e)
		{
			Log.error("Validation message for Blank Password is not verified.Error is  : "+e.getMessage());
			 //This is to send the FAIL value to the Excel sheet in the result column.
			System.out.println("Testcase failed");
			ExcelUtils.setCellData("Fail", iTestCaseRow, Constants.SignUp_TestData_Result_col);		
			throw(e);
		}
					
	}
	
	@Test(priority=4) 
	public void SignUp_Invalid_EmailFormat_TC() throws Exception
	{
		try
		{
			SignIn_Actions.goToSignUp();
			SignUp_Actions.Execute_SignUp(iTestCaseRow);
			Utils.verify_errorMsg(SignUp_page.error_msg_email(), Verification_Data.InvalidEmail_msg);

			if(Base_Class.bResult==true)
			{
				System.out.println("Testcase passed"); 
				//This is to send the PASS value to the Excel sheet in the result column.
				ExcelUtils.setCellData("Pass", iTestCaseRow, Constants.SignUp_TestData_Result_col);
			}
			else
			{
				throw new Exception("Test Case Failed because of Verification");
			}
		}
		catch(Exception e)
		{
			Log.error("Validation message for Invalid format email id is not verified.Error is  : "+e.getMessage());
			 //This is to send the FAIL value to the Excel sheet in the result column.
			System.out.println("Testcase failed");
			ExcelUtils.setCellData("Fail", iTestCaseRow, Constants.SignUp_TestData_Result_col);		
			throw(e);
		}
					
	}
	
	@Test(priority=5) 
	public void SignUp_Invalid_PasswordFormat_TC() throws Exception
	{
		try
		{
			SignIn_Actions.goToSignUp();
			SignUp_Actions.Execute_SignUp(iTestCaseRow);
			Utils.verify_errorMsg(SignUp_page.error_msg_password(), Verification_Data.SignUp_InvalidPsswrd_msg);

			if(Base_Class.bResult==true)
			{
				System.out.println("Testcase passed"); 
				//This is to send the PASS value to the Excel sheet in the result column.
				ExcelUtils.setCellData("Pass", iTestCaseRow, Constants.SignUp_TestData_Result_col);
			}
			else
			{
				throw new Exception("Test Case Failed because of Verification");
			}
		}
		catch(Exception e)
		{
			Log.error("Validation message for Invalid format Password is not verified.Error is  : "+e.getMessage());
			 //This is to send the FAIL value to the Excel sheet in the result column.
			System.out.println("Testcase failed");
			ExcelUtils.setCellData("Fail", iTestCaseRow, Constants.SignUp_TestData_Result_col);		
			throw(e);
		}
					
	}
	
	@Test(priority=6) 
	public void Registered_Email_TC() throws Exception
	{
		try
		{
			SignIn_Actions.goToSignUp();
			SignUp_Actions.Execute_SignUp(iTestCaseRow);
			Utils.verify_errorMsg(SignUp_page.alert_invalid(), Verification_Data.RegisteredEmail_msg);

			if(Base_Class.bResult==true)
			{
				System.out.println("Testcase passed"); 
				//This is to send the PASS value to the Excel sheet in the result column.
				ExcelUtils.setCellData("Pass", iTestCaseRow, Constants.SignUp_TestData_Result_col);
			}
			else
			{
				throw new Exception("Test Case Failed because of Verification");
			}
		}
		catch(Exception e)
		{
			Log.error("Validation message for already registered Email id is not verified.Error is  : "+e.getMessage());
			 //This is to send the FAIL value to the Excel sheet in the result column.
			System.out.println("Testcase failed");
			ExcelUtils.setCellData("Fail", iTestCaseRow, Constants.SignUp_TestData_Result_col);		
			throw(e);
		}
					
	}
	
	@Test(priority=7) 
	public void Popup_Privacy_Policy_TC() throws Exception
	{
		try
		{
			SignIn_Actions.goToSignUp();
			SignUp_Actions.goToPrivacyPolicy();
			Utils.waitForElement(SignUp_page.btn_privacy_policy_Close());

			if(Base_Class.bResult==true)
			{
				System.out.println("Testcase passed"); 
				//This is to send the PASS value to the Excel sheet in the result column.
				ExcelUtils.setCellData("Pass", iTestCaseRow, Constants.SignUp_TestData_Result_col);
			}
			else
			{
				throw new Exception("Test Case Failed because of Verification");
			}
		}
		catch(Exception e)
		{
			Log.error("Privacy policy popup is not verified.Error is  : "+e.getMessage());
			 //This is to send the FAIL value to the Excel sheet in the result column.
			System.out.println("Testcase failed");
			ExcelUtils.setCellData("Fail", iTestCaseRow, Constants.SignUp_TestData_Result_col);		
			throw(e);
		}
					
	}
	
	@Test(priority=8) 
	public void Popup_T_and_C_TC() throws Exception
	{
		try
		{
			SignIn_Actions.goToSignUp();
			SignUp_Actions.goTo_TandC();
			Utils.waitForElement(SignUp_page.btn_T_and_C_Close());

			if(Base_Class.bResult==true)
			{
				System.out.println("Testcase passed"); 
				//This is to send the PASS value to the Excel sheet in the result column.
				ExcelUtils.setCellData("Pass", iTestCaseRow, Constants.SignUp_TestData_Result_col);
			}
			else
			{
				throw new Exception("Test Case Failed because of Verification");
			}
		}
		catch(Exception e)
		{
			Log.error("Terms and conditions popup is not verified.Error is  : "+e.getMessage());
			 //This is to send the FAIL value to the Excel sheet in the result column.
			System.out.println("Testcase failed");
			ExcelUtils.setCellData("Fail", iTestCaseRow, Constants.SignUp_TestData_Result_col);		
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
