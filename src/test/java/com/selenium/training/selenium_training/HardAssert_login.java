package com.selenium.training.selenium_training;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class HardAssert_login
{
	WebDriver w;
 
  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("webdriver.chrome.driver", ".\\Browser_Driver\\chromedriver.exe");
	  w=new ChromeDriver();
  }
  
  @Test(priority=0,description="test case to verify login functiolity with 'admin' user",groups="LoginModule",invocationCount=1)
  public void loginAdmin()throws Exception 
  {
	  w.get("http://altoromutual.com:8080/login.jsp");
	  
	  WebElement signInButton=w.findElement(By.id("LoginLink"));
	  Assert.assertTrue(signInButton.isDisplayed(), "sign in link not displayed");
	  
	  String pageTitle=w.getTitle();
	  String pageURL=w.getCurrentUrl();
	  
	  Assert.assertEquals(pageTitle, "Altoro Mutual");
	  Assert .assertTrue(pageURL.contains("login.jsp"),"URL is different" );
	  
	  WebElement pageLabel=w.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/h1"));
	  String pageLabelText=pageLabel.getText();
	  Assert.assertTrue(pageLabelText.contains("Login"), "pageLabel does not contains login");
	  
	  
	  w.findElement(By.id("uid")).sendKeys("admin");
	  w.findElement(By.name("passw")).sendKeys("admin");
	  w.findElement(By.xpath("//*[@id=\"login\"]/table/tbody/tr[3]/td[2]/input")).click();
	 
  }
  
  @Test(priority=1,description="test case to verify logout functiolity with 'admin' user",groups="LoginModule",invocationCount=1)
  public void logout()throws Exception
  {
	  Thread.sleep(3000);
	  
	  String pageURL=w.getCurrentUrl();
	  Assert.assertTrue(pageURL.contains("main.jsp"),"URL is different" );
	  
	  WebElement pageLabel=w.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/div/h1"));
	  String pageLabelText=pageLabel.getText();
	  Assert.assertTrue(pageLabelText.contains("Admin"), "pageLabel does not contains admin");
	  
	  
	  
	  w.findElement(By.linkText("Sign Off")).click();
	  Reporter.log("Admin test case is executed..", true);
	  
  }

  @AfterTest
  public void afterTest() 
  {
	  w.close();
  }

}
