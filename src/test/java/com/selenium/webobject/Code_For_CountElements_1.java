package com.selenium.webobject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class Code_For_CountElements_1 {

	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\BrowserDriver\\chromedriver.exe");
		w = new ChromeDriver();
		w.manage().window().maximize();

	}

	@Test(priority = 0, description = "Test case to Count WebElements ")
	public void CountWebElement() throws Exception {

		w.get("http://demo.automationtesting.in/Register.html");
		Thread.sleep(2000);

		// Count number of radio button on web page.

		List<WebElement> countRadioButton = w.findElements(By.name("radiooptions"));
		int countR = countRadioButton.size();
		System.out.println("Number of Radio Button : " + countR);

		// Count number of checkbox on web page.
		int countC = w.findElements(By.cssSelector("input[type='checkbox']")).size();
		System.out.println("Count Checkbox : " + countC);

		// Count number of Dropdown on web page.

		List<WebElement> countDropdown = w.findElements(By.tagName("select"));
		int countD = countDropdown.size();
		System.out.println("Number of Dropdown : " + countD);

		// Count number of links on web page.

		List<WebElement> countlinks = w.findElements(By.tagName("a"));
		int links = countlinks.size();
		System.out.println("Number of links : " + links);

		Thread.sleep(2000);

	}

	@AfterTest
	public void afterTest() {

		w.quit();
	}

}
