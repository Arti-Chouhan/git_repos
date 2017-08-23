package com.test1.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignIn_PageTest {
  @Test
  public void SignIn_test() throws InterruptedException {
	  
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\Owner\\Downloads\\chromedriver_win32\\chromedriver.exe");
	  WebDriver  driver = new ChromeDriver();
	  driver.get("http://positivradio.test.gate6.com/web/");
	  
	  WebElement txt_email = driver.findElement(By.xpath("html/body/app-root/div/div/div/ng-component/div/div/div/div[4]/div/form/div[1]/div/div/input"));
		System.out.println("Email id textbox is found on Login page");
		txt_email.sendKeys("arti.chouhan@gate6.com");
		
		WebElement txt_password = driver.findElement(By.xpath("html/body/app-root/div/div/div/ng-component/div/div/div/div[4]/div/form/div[2]/div/div/input"));
		System.out.println("Password textbox is found on login page");
		txt_password.sendKeys("Gatesix#12");
		
		WebElement btn_login = driver.findElement(By.xpath("html/body/app-root/div/div/div/ng-component/div/div/div/div[4]/div/form/div[3]/div/div/button"));
		System.out.println("Login button is found on login page");
		btn_login.click();
		Thread.sleep(2000);
		
		Assert.assertTrue( driver.findElement(By.xpath(".//*[@class='main-title']")).getText().contentEquals("Account Overview"));
		System.out.println("User is logged in successfully");
		
  }
}
