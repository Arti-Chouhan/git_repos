package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Common_Utility.Log;

public class Home_page extends Base_Class {

	public Home_page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

private static WebElement element =null;
	
	
	public static WebElement txt_mainTitle()
	{
	
		try
		{
			element = driver.findElement(By.xpath(".//*[@class='main-title']"));
			Log.info("Main title text is found on Home page");
			return element;
		}
		catch (Exception e)
		{
			Log.error("Main title text is not found on Home page. And error is : " + e.getMessage());
			throw(e);
		}
	}
}