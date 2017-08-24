package pageObjects;
import Common_Utility.Log;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignIn_page extends Base_Class{
	
public SignIn_page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	
private static WebElement element =null;
	
	public static WebElement txt_email()
	{
		
		try{
			element = driver.findElement(By.xpath("html/body/app-root/div/div/div/ng-component/div/div/div/div[4]/div/form/div[1]/div/div/input"));
			Log.info("Email id textbox is found on Login page");
			return element;
		}
		catch (Exception e)
		{
			Log.error("Email id  textbox is not found on Login page. And error is : " + e.getMessage());
			throw(e);
		}
	}
	public static WebElement txt_password()
	{
		try {
			element = driver.findElement(By.xpath("html/body/app-root/div/div/div/ng-component/div/div/div/div[4]/div/form/div[2]/div/div/input"));
			Log.info("Password textbox is found on login page");
			return element;
		}
		catch (Exception e)
		{
			Log.error("Password textbox is not found on not Login page. And error is : " + e.getMessage());
			throw(e);
		}
	}
	public static WebElement btn_login()
	{
		try{
			element = driver.findElement(By.xpath("html/body/app-root/div/div/div/ng-component/div/div/div/div[4]/div/form/div[3]/div/div/button"));
			Log.info("Login button is found on login page");
			return element;
		}
		catch (Exception e)
		{
			Log.error("Login button is not found on login page.And error is : " + e.getMessage());
			throw(e);
		}
		
	}
	public static WebElement error_msg_email()
	{
		try{
			element = driver.findElement(By.xpath("html/body/app-root/div/div/div/ng-component/div/div/div/div[4]/div/form/div[1]/div/div/div"));
			Log.info("Validation message for email id is found on login page");
			return element;
		}
		catch (Exception e)
		{
			Log.error("Validation message for email id is not found on login page.And error is : " + e.getMessage());
			throw(e);
		}
		
	}
	public static WebElement error_msg_password()
	{
		try{
			element = driver.findElement(By.xpath("html/body/app-root/div/div/div/ng-component/div/div/div/div[4]/div/form/div[2]/div/div/div"));
			Log.info("Validation message for password is found on login page");
			return element;
		}
		catch (Exception e)
		{
			Log.error("Validation message for password is not found on login page.And error is : " + e.getMessage());
			throw(e);
		}
		
	}
	
	public static WebElement alert_invalid()
	{
		try{
			element = driver.findElement(By.xpath("html/body/app-root/div/div/div/ng-component/div/div/div/div[4]/div/alert/div"));
			Log.info("Validation message for wrong credentials is found on login page");
			return element;
		}
		catch (Exception e)
		{
			Log.error("Validation message for wrong credentials is not found on login page.And error is : " + e.getMessage());
			throw(e);
		}
		
	}
	
	public static  WebElement lnk_SignUp()
	{
		try{
			element = driver.findElement(By.linkText("SIGN UP"));
			Log.info("Signup link is found on login page");
			return element;
		}
		catch (Exception e)
		{
			Log.error("Signup link is not found on login page. And error is : " + e.getMessage());
			throw(e);
		}
	}
	
	public static  WebElement lnk_Forgot_Password()
	{
		try{
			element = driver.findElement(By.linkText("Forgot password?"));
			Log.info("Forgot password link is found on login page");
			return element;
		}
		catch (Exception e)
		{
			Log.error("Forgot password link is not found on login page. And error is : " + e.getMessage());
			throw(e);
		}
	}

	public static  WebElement btn_login_FB()
	{
		try{
			element = driver.findElement(By.xpath(".//*[@class='facebook']"));
			Log.info("Sign in with Facebook button is found on Login page");
			return element;
		}
		catch (Exception e)
		{
			Log.error("Sign in with Facebook button is not found on login page. And error is : " + e.getMessage());
			throw(e);
		}
	}

	public static  WebElement btn_login_Google()
	{
		try{
			element = driver.findElement(By.xpath(".//*[@class='google']"));
			Log.info("Sign in with Google button is found on Login page");
			return element;
		}
		catch (Exception e)
		{
			Log.error("Sign in with Google button is not found on login page. And error is : " + e.getMessage());
			throw(e);
		}
	}
	
	public static class Facebook{
		
		public static WebElement txt_FB_email()
		{
			
			try{
				element = driver.findElement(By.xpath(".//*[@id='email']"));
				Log.info("Email id textbox is found on Facebook Login page");
				return element;
			}
			catch (Exception e)
			{
				Log.error("Email id  textbox is not found on Facebook Login page. And error is : " + e.getMessage());
				throw(e);
			}
		}
		public static WebElement txt_FB_password()
		{
			try {
				element = driver.findElement(By.xpath(".//*[@id='pass']"));
				Log.info("Password textbox is found on Facebook login page");
				return element;
			}
			catch (Exception e)
			{
				Log.error("Password textbox is not found on Facebook Login page. And error is : " + e.getMessage());
				throw(e);
			}
		}
		public static WebElement btn_FB_login()
		{
			try{
				element = driver.findElement(By.xpath(".//*[@name='login']"));
				Log.info("Login button is found on Facebook login page");
				return element;
			}
			catch (Exception e)
			{
				Log.error("Login button is not found on Facebook login page.And error is : " + e.getMessage());
				throw(e);
			}
			
		}
		
	}

}
