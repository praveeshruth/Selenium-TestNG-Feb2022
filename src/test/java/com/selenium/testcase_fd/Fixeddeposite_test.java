package com.selenium.testcase_fd;

import org.testng.annotations.Test;

import com.selenium.pageobject.FixedDepositepageObject;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;



public class Fixeddeposite_test 
{
	FixedDepositepageObject fd;
	  
 
  @BeforeTest
  public void beforeTest() throws Exception 
  {
      fd=new FixedDepositepageObject();
	  
	  fd.openBrowser("chrome");
	  
	  fd.callPageFactoryElements_FD();
  }
  
  @Test(priority = 0,description = "Test case to verify Fixed Deposit module for 1 lakhs")
  public void fixeddeposite_1lakh() throws Exception 
  {
      fd.openApplication();
	  
	  fd.handleTextBox(fd.principleTextBox, "100000");
	  
	  fd.handleTextBox(fd.interestTextBox, "6");
	  
	  fd.handleTextBox(fd.tenureTextBox, "3");
	  
	  fd.handleDropDownList(fd.tenurePeriodDropDown, "year(s)");
	  
	  fd.handleDropDownList(fd.frequencyDropDown, "Simple Interest");
	  
	  fd.handleClickEvent(fd.calculateBtn);
	  
	  fd.waitSec(2);
	  
	  Assert.assertEquals(fd.returnElementText(fd.outputValue), "118000.00");
  
  }
  
  @Test(priority = 1,description = "Test case to verify Fixed Deposit module for 2 lakhs")
  public void fixeddeposite_2lakh() throws Exception 
  {
      fd.openApplication();
	  
	  fd.handleTextBox(fd.principleTextBox, "200000");
	  
	  fd.handleTextBox(fd.interestTextBox, "6");
	  
	  fd.handleTextBox(fd.tenureTextBox, "3");
	  
	  fd.handleDropDownList(fd.tenurePeriodDropDown, "year(s)");
	  
	  fd.handleDropDownList(fd.frequencyDropDown, "Simple Interest");
	  
	  fd.handleClickEvent(fd.calculateBtn);
	  
	  fd.waitSec(2);
	  
	  Assert.assertEquals(fd.returnElementText(fd.outputValue), "236000.00");
  
  }
  
  @Test(priority = 2,description = "Test case to verify Fixed Deposit module for 3 lakhs")
  public void fixeddeposite_3lakh() throws Exception 
  {
      fd.openApplication();
	  
	  fd.handleTextBox(fd.principleTextBox, "300000");
	  
	  fd.handleTextBox(fd.interestTextBox, "6");
	  
	  fd.handleTextBox(fd.tenureTextBox, "3");
	  
	  fd.handleDropDownList(fd.tenurePeriodDropDown, "year(s)");
	  
	  fd.handleDropDownList(fd.frequencyDropDown, "Simple Interest");
	  
	  fd.handleClickEvent(fd.calculateBtn);
	  
	  fd.waitSec(2);
	  
	  Assert.assertEquals(fd.returnElementText(fd.outputValue), "396000.00");
  
  }
  

  @AfterTest
  public void afterTest() 
  {
	  fd.closeBrowser();
  }

}
