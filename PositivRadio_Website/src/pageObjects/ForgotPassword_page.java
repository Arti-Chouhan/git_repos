package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Common_Utility.Log;

public class ForgotPassword_page extends Base_Class {
	public ForgotPassword_page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

private static WebElement element =null;
	
	
	public static WebElement btn_SendOTP()
	{
	
		try
		{
			element = driver.findElement(By.xpath("html/body/app-root/div/div/div/ng-component/div/div/div/div[2]/div/form/div[2]/div/div/button"));
			Log.info("Send OTP is found on Forgot Password page");
			return element;
		}
		catch (Exception e)
		{
			Log.error("Send OTP is not found on Forgot Password page. And error is : " + e.getMessage());
			throw(e);
		}
	}

}
