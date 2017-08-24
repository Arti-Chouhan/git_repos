package pageObjects;

import org.openqa.selenium.WebDriver;

public class Base_Class {

	public static WebDriver driver;
	
	public static Boolean bResult ;
	
	public Base_Class(WebDriver driver)
	{
		Base_Class.driver = driver;
		Base_Class.bResult = true;
	}
}
