package Common_Utility;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Common_Utility.ExcelUtils;;

public class Utils {
	
	public static WebDriver driver = null;
	
	
	
	public static WebDriver initiateBrowser(int iTestcaseRow,int browsername_col)
	{
		String sBrowserName;
		
		try
		{
			sBrowserName = ExcelUtils.getCellData(iTestcaseRow, browsername_col);
			
			if(sBrowserName.equalsIgnoreCase("chrome"))
			{
				System.setProperty(Constants.chrome_driver, Constants.chrome_driver_path);
				   driver= new ChromeDriver();
				   Log.info("Chrome driver is instantiated");				  
				  
			}
			if(sBrowserName.equalsIgnoreCase("firefox"))
			{
				System.setProperty(Constants.firefox_driver,  Constants.firefox_driver_path);
				driver=new FirefoxDriver();
				Log.info("Firefox driver is instantiated");			  
				  
			}
			else if(sBrowserName.equalsIgnoreCase("IE"))
			{
				System.setProperty(Constants.IE_driver, Constants.IE_driver_path);
				   driver= new InternetExplorerDriver();
				   Log.info("IE driver is instantiated");
				   
			} 
			else 
			{
				Log.error("Browser name is not defined");
				
			}
			 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			 driver.get(Constants.url);
			 Log.info("Website is launched");
		}
		
		catch (Exception e)
		{

            Log.error("Class Utils | Method initiateBrowser | Exception desc : "+e.getMessage());
		}
		
		return driver;
	}
	
	public static String getTestModule(String sTestModule)throws Exception
	{
		String value =  sTestModule;
		
		try
		{
			int pos = value.indexOf("@");
			value = value.substring(0,pos);
			
			pos = value.lastIndexOf(".");
			value=value.substring(pos+1);
			
			return value;
			
		}
		catch (Exception e)
		{
			Log.error("Class Utils | Method getTestModule | Exception desc : "+e.getMessage());
			
			throw(e);
		}
	}
	
	public static void MouseHoverAction(WebElement mainElement,String subElement)
	{
		Actions action = new Actions(driver);
		action.moveToElement(mainElement).perform();
		try
		{
		
			action.moveToElement(driver.findElement(By.linkText(subElement))); // Here subelements are Accessories,iMacs etc.
			System.out.println("Move over desired category");
			Log.info(subElement +" is found below Product category");
		}
		catch (Exception e)
		{
			Log.error(subElement +" is not found below Product category");
		}
		action.click().perform();
		System.out.println("Product category clicked");
		Log.info("Click operation is performed on desired Product category");
		
		
	}
	
	public static void waitForElement(WebElement element)
	{
		 ExpectedCondition<Boolean> pageLoadCondition = new
	                ExpectedCondition<Boolean>() 
		 {
	                    public Boolean apply(WebDriver driver) {
	                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	                    }
		 };
		
		WebDriverWait  wait =  new WebDriverWait(driver,30);
		
		try
		{
			
			wait.until(pageLoadCondition);
			wait.until(ExpectedConditions.visibilityOf(element));
			if(element.isDisplayed())
			{
			Log.info(element + " is visible ");
			}
			
		}
		catch (Exception e)
		{
			
			Log.error("For an element : "+element +" error is : " );
			e.getMessage();
		}		
	}
	
	 public static String takeScreenshot(WebDriver driver, String sTestCaseName) throws Exception{
			 
				try{
	 
					File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					
					String dest = Constants.Path_ScreenShot + sTestCaseName +".png";
					FileUtils.copyFile(scrFile, new File(dest));
					
					return dest ;
	 
				} catch (Exception e){
	 
					Log.error("Class Utils | Method takeScreenshot | Exception occured while capturing ScreenShot : "+e.getMessage());
					return e.getMessage();
					
	 
				}
	 
			}
		 
		 
	public static void compareStrings(String actual,String expected)
	{
						
		Log.info("Actual string is : "+actual +" and expected string is :"+expected);
		Assert.assertTrue(actual.contentEquals(expected),"Actual result doesnot match with the expected one");
		Log.info("Actual result  : " +actual + " matches with the expected result");
				
	}	 
	public static String verify_Data(WebElement element,String expected_data)
	{
		Utils.waitForElement(element);
		String actual_data = element.getText();
		Log.info("Actual result is : "+actual_data);
		Assert.assertTrue(actual_data.contains(expected_data),"Actual result doesnot match with the expected one");
		Log.info("Actual result  : " +actual_data + " matches with the expected result");
		
		return actual_data;
	}
	
	public static void verify_page_title(String expected_title)
	{
		String actual_title = driver.getTitle();
		Assert.assertTrue(actual_title.contains(expected_title),"Actual title of page is incorrect.Its not the expected page");
		Log.info("Page title  : " +actual_title + " is verified . You are landed to correct page");
		
	}
	
	public static void verify_errorMsg(WebElement element,String idealMessage)
	{
		Utils.waitForElement(element);
		String actual_message = element.getText();
		Assert.assertTrue(actual_message.contains(idealMessage),"Validation message for invalid credentials is incorrect");
		Log.info("Validation message : " +idealMessage + " is verified");
	}

}
