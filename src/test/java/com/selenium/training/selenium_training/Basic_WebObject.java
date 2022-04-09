package com.selenium.training.selenium_training;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Basic_WebObject 
{
	private static final String Iterator = null;
	WebDriver w;
  @BeforeTest
  public void precondition() 
  {
	  System.setProperty("webdriver.chrome.driver", ".\\Browser_Driver\\chromedriver.exe");
	  w=new ChromeDriver();
  }
 
  
  @Test(priority=0,description="test case to handel testbox")
  public void handelTestbox()
  {
	  w.get("http://demo.automationtesting.in/Register.html");
	  
	  WebElement firstName=w.findElement(By.cssSelector("input[ng-model='FirstName']"));
	  firstName.clear();
	  firstName.sendKeys("shruti");
	  
	  w.findElement(By.cssSelector("input[ng-model='LastName']")).clear();
	  w.findElement(By.cssSelector("input[ng-model='LastName']")).sendKeys("pujari");
	  
  }
  
  @Test(priority=1,description="test case to handel testbox Area")
  public void handeltestboxarea()
  {
	  w.findElement(By.cssSelector("textarea[ng-model='Adress']")).clear();
	  w.findElement(By.cssSelector("textarea[ng-model='Adress']")).sendKeys("sample test adress");
  }
  
  @Test(priority=2,description="test case to email adress")
  public void emailadress()
  {
	 w.findElement(By.cssSelector("input[ng-model='EmailAdress']")).clear();
	 w.findElement(By.cssSelector("input[ng-model='EmailAdress']")).sendKeys("shruti@gmail.com");
  }
  
  @Test(priority=3,description="test case to phone number")
  public void phonenumber()
  {
	  w.findElement(By.cssSelector("input[ng-model='Phone']")).clear();
	  w.findElement(By.cssSelector("input[ng-model='Phone']")).sendKeys("9518923195");
  }
  
  @Test(priority=4,description="test case to radio button")
  public void radiobutton()
  {
	  w.findElement(By.cssSelector("input[value='FeMale']")).click();
	  
  }
  
  @Test(priority=5,description="test case to check box")
  public void checkbox()
  {
	  w.findElement(By.cssSelector("input[value='Cricket']")).click();
	  
  }
  
  @Test(priority=6,description="test case to drop down list")  
  public void hadledropdown()
  {
	  WebElement Skills=w.findElement(By.id("Skills"));
	  Select sel=new Select(Skills);
	  
	  List<WebElement> dataDropDown=sel.getOptions();
	  int numberOfValue=dataDropDown.size();
	  
	  System.out.println("\n value from skills drop down: \n");
	  
	  //using for loop 
	  
	  /* for (int i=0;i<numberOfValue;i++)
	   { 
	     System.out.println(dataDropDown.get(i).getText());
	   */
	  
	  //using for each loop
	 /* for(WebElement data:dataDropDown)
	  {
		  System.out.println(data.getText());
	  }
	  */
	  //using iterator
	  java.util.Iterator <WebElement> it=dataDropDown.iterator();
	  while(it.hasNext())
	  {
		  System.out.println(it.next().getText());
	  }
	  
	 
  }
  
  @Test(priority=7,description="test case to handel list box")  
  public void handellistbox()
  {
	  
  }
 
  @AfterTest
  public void afterTest() 
  {
	  w.close();
  }

}
