package com.selenium.training.selenium_training;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class LoginTest 
{
	WebDriver w;
 
  @BeforeTest
  public void precondition()
  {
	  System.setProperty("webdriver.chrome.driver", ".\\Browser_Driver\\chromedriver.exe");
	  w=new ChromeDriver();
  }
  
  @Test(priority=0,description="test case to verify login functiolity with 'admin' user",groups="LoginModule",invocationCount=2)
  public void logintest()throws Exception
  {
	  w.get("http://altoromutual.com:8080/login.jsp");
	  w.findElement(By.id("uid")).sendKeys("admin");
	  w.findElement(By.name("passw")).sendKeys("admin");
	  w.findElement(By.xpath("//*[@id=\"login\"]/table/tbody/tr[3]/td[2]/input")).click();
	  Thread.sleep(3000);
	  w.findElement(By.linkText("Sign Off")).click();
	 
  }
  
  @Test(priority=1,description="test case to verify login functiolity with 'tuser' user",dependsOnMethods="logintest",enabled=false)
  public void logintestuser()throws Exception
  {
	  w.get("http://altoromutual.com:8080/login.jsp");
	  w.findElement(By.id("uid")).sendKeys("tuser");
	  w.findElement(By.name("passw")).sendKeys("tuser");
	  w.findElement(By.xpath("//*[@id=\"login\"]/table/tbody/tr[3]/td[2]/input")).click();
	  Thread.sleep(3000);
	  w.findElement(By.linkText("Sign Off")).click();
  }
  
  @Test(priority=2,description="test case to verify login functiolity with 'jsmith' user",dependsOnMethods="logintest")
  public void loginjsmithuser()throws Exception
  {
	  w.get("http://altoromutual.com:8080/login.jsp");
	  w.findElement(By.id("uid")).sendKeys("jsmith");
	  w.findElement(By.name("passw")).sendKeys("Demo1234");
	  w.findElement(By.xpath("//*[@id=\"login\"]/table/tbody/tr[3]/td[2]/input")).click();
	  Thread.sleep(3000);
	  w.findElement(By.linkText("Sign Off")).click();
  }
  
  @Test(priority=3,description="test case to verify login functiolity with 'invalid' user")
  public void logininvaliduser()throws Exception
  {
	  w.get("http://altoromutual.com:8080/login.jsp");
	  w.findElement(By.id("uid")).sendKeys("test");
	  w.findElement(By.name("passw")).sendKeys("test@123");
	  w.findElement(By.xpath("//*[@id=\"login\"]/table/tbody/tr[3]/td[2]/input")).click();
	  Thread.sleep(3000);
	  w.findElement(By.linkText("Sign Off")).click();
  }

   @AfterTest
  public void postcondition()
  {
	  w.close();
  }

}
