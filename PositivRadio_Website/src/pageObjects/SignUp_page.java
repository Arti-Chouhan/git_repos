package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Common_Utility.Log;

public class SignUp_page extends Base_Class {

	public SignUp_page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

private static WebElement element =null;
	
	
	public static WebElement txt_name()
	{
	
		try{
			element = driver.findElement(By.xpath(".//*[@name='fullName']"));
			Log.info("Email id textbox is found on SignUp page");
			return element;
		}
	catch (Exception e)
	{
		Log.error("Email id  textbox is not found on SignUp page. And error is : " + e.getMessage());
		throw(e);
	}
}
	public static WebElement txt_email()
	{
		
		try{
			element = driver.findElement(By.xpath(".//*[@name='email']"));
			Log.info("Email id textbox is found on SignUp page");
			return element;
		}
		catch (Exception e)
		{
			Log.error("Email id  textbox is not found on SignUp page. And error is : " + e.getMessage());
			throw(e);
		}
	}
	public static WebElement txt_password()
	{
		try {
			element = driver.findElement(By.xpath(".//*[@name='password']"));
			Log.info("Password textbox is found on SignUp page");
			return element;
		}
		catch (Exception e)
		{
			Log.error("Password textbox is not found on not SignUp page. And error is : " + e.getMessage());
			throw(e);
		}
	}
	
	public static WebElement btn_SignUp()
	{
		try{
			element = driver.findElement(By.xpath("html/body/app-root/div/div/div/ng-component/div/div/div[1]/div[4]/div/form/div[4]/div/div/button"));
			Log.info("SignUp button is found on SignUp page");
			return element;
		}
		catch (Exception e)
		{
			Log.error("SignUp button is not found on SignUp page.And error is : " + e.getMessage());
			throw(e);
		}
		
	}
	
	public static  WebElement lnk_login()
	{
		try{
			element = driver.findElement(By.linkText("SIGN IN"));
			Log.info("SignIn link is found on SignUp page");
			return element;
		}
		catch (Exception e)
		{
			Log.error("SignIn link is not found on SignUp page. And error is : " + e.getMessage());
			throw(e);
		}
	}
	
	public static  WebElement btn_SignUp_FB()
	{
		try{
			element = driver.findElement(By.xpath(".//*[@class='facebook']"));
			Log.info("Sign Up with Facebook button is found on SignUp page");
			return element;
		}
		catch (Exception e)
		{
			Log.error("Sign Up in with Facebook button is not found on SignUp page. And error is : " + e.getMessage());
			throw(e);
		}
	}

	public static  WebElement btn_SignUp_Google()
	{
		try{
			element = driver.findElement(By.xpath(".//*[@class='google']"));
			Log.info("Sign Up in with Google button is found on SignUp page");
			return element;
		}
		catch (Exception e)
		{
			Log.error("Sign Up with Google button is not found on SignUp page. And error is : " + e.getMessage());
			throw(e);
		}
	}
	
	public static  WebElement lnk_T_and_C()
	{
		try{
			element = driver.findElement(By.linkText("Terms and Conditions"));
			Log.info("Terms and Conditions link is found on SignUp page");
			return element;
		}
		catch (Exception e)
		{
			Log.error("Terms and Conditions link is not found on SignUp page. And error is : " + e.getMessage());
			throw(e);
		}
	}
	
	public static  WebElement lnk_privacy_policy()
	{
		try{
			element = driver.findElement(By.linkText("Privacy Policy"));
			Log.info("Privacy Policy link is found on SignUp page");
			return element;
		}
		catch (Exception e)
		{
			Log.error("Privacy Policy link is not found on SignUp page. And error is : " + e.getMessage());
			throw(e);
		}
	}
	
	public static  WebElement btn_T_and_C_Close()
	{
		try{
			element = driver.findElement(By.xpath(".//*[@id='termsAndConditions']/div/div/div[1]/button"));
			Log.info("Close button in Terms and Conditions popup is found on SignUp page");
			return element;
		}
		catch (Exception e)
		{
			Log.error("Close button in Terms and Conditions popup is not found on SignUp page. And error is : " + e.getMessage());
			throw(e);
		}
	}
	
	public static  WebElement btn_privacy_policy_Close()
	{
		try{
			element = driver.findElement(By.xpath(".//*[@id='privacyPolicy']/div/div/div[1]/button"));
			Log.info("Close button in Privacy Policy popup is found on SignUp page");
			return element;
		}
		catch (Exception e)
		{
			Log.error("Close button in Privacy Policy popup is not found on SignUp page. And error is : " + e.getMessage());
			throw(e);
		}
	}
	
	public static WebElement error_msg_Name()
	{
		try{
			element = driver.findElement(By.xpath("html/body/app-root/div/div/div/ng-component/div/div/div[1]/div[4]/div/form/div[1]/div/div/div"));
			Log.info("Validation message for Full Name is found on SignUp page");
			return element;
		}
		catch (Exception e)
		{
			Log.error("Validation message for Full Name is not found on SignUp page.And error is : " + e.getMessage());
			throw(e);
		}
		
	}
	
	public static WebElement error_msg_email()
	{
		try{
			element = driver.findElement(By.xpath("html/body/app-root/div/div/div/ng-component/div/div/div[1]/div[4]/div/form/div[2]/div/div/div"));
			Log.info("Validation message for email id is found on SignUp page");
			return element;
		}
		catch (Exception e)
		{
			Log.error("Validation message for email id is not found on SignUp page.And error is : " + e.getMessage());
			throw(e);
		}
		
	}
	public static WebElement error_msg_password()
	{
		try{
			element = driver.findElement(By.xpath("html/body/app-root/div/div/div/ng-component/div/div/div[1]/div[4]/div/form/div[3]/div"));
			Log.info("Validation message for password is found on SignUp page");
			return element;
		}
		catch (Exception e)
		{
			Log.error("Validation message for password is not found on SignUp page.And error is : " + e.getMessage());
			throw(e);
		}
		
	}
	
	public static WebElement alert_invalid()
	{
		try{
			element = driver.findElement(By.xpath("html/body/app-root/div/div/div/ng-component/div/div/div[1]/div[4]/div/alert/div"));
			Log.info("Validation message for wrong credentials is found on SignUp page");
			return element;
		}
		catch (Exception e)
		{
			Log.error("Validation message for wrong credentials is not found on SignUp page.And error is : " + e.getMessage());
			throw(e);
		}
		
	}
}
