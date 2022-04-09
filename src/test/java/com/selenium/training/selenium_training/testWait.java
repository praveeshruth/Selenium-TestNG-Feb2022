package com.selenium.training.selenium_training;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testWait 
{

	public static void main(String[] args) throws Exception 
	{

		WebDriverManager.chromedriver().setup();
		WebDriver w;
		w = new ChromeDriver();
		w.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		
		w.get("https://in.via.com/flight-tickets");

		w.findElement(By.id("wzrk-cancel")).click();

		// Select source location
		w.findElement(By.id("source")).clear();
		w.findElement(By.id("source")).sendKeys("Mumbai");
		

		w.findElement(By.id("ui-id-1")).click();

		// Select target location

		w.findElement(By.id("destination")).clear();
		w.findElement(By.id("destination")).sendKeys("Pune");
		
		
		Thread.sleep(2000);

		w.findElement(By.id("ui-id-2")).click();
		
		Thread.sleep(2000);
		

		w.findElement(By.xpath("//*[@id=\"depart-cal\"]/div[4]/div[2]/div[4]/div[1]")).click();


		w.findElement(By.id("search-flight-btn")).click();
		
		
		WebDriverWait wt=new WebDriverWait(w, 60);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cheap_flight_container\"]/div[2]/div/div[1]/div[3]/span[2]")));

		
		Wait<WebDriver> fluentwt = new FluentWait<WebDriver>(w)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class); // this defines the exception to ignore
		fluentwt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cheap_flight_container\"]/div[2]/div/div[1]/div[3]/span[2]")));

		
		String price = w.findElement(By.xpath("//*[@id=\"cheap_flight_container\"]/div[2]/div/div[1]/div[3]/span[2]"))
				.getText();

		System.out.println("Cheapest Flights is : " + price);

		

		w.quit();

	}

}
 

