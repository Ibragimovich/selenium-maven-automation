package com.dice;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiceJobSearch {
	public static void main(String[] args) {
		
	  //Set up chrome driver path
		WebDriverManager.chromedriver().setup();
		
	  //invoke selenium webdriver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  //=================================================================================

		String url ="https://dice.com";
		driver.get(url);
	  //=================================================================================
		String actualTitle = driver.getTitle();
		String expectedTitle = "Job Search for Technology Professionals | Dice.com";
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Step PASS. Dice homepage successfully loaded");
		}else {
			System.out.println("Step FAIL. Dice homepage didnt load successfully");
			throw new RuntimeException("Step FAIL. Dice homepage didnt load successfully");
		}
	  //=================================================================================

		
		String keyword = "java developer";
		driver.findElement(By.id("search-field-keyword")).clear();
		driver.findElement(By.id("search-field-keyword")).sendKeys(keyword);
      //=================================================================================

		String location = "22102";
		driver.findElement(By.id("search-field-location")).clear();
		driver.findElement(By.id("search-field-location")).sendKeys(location);
		driver.findElement(By.id("findTechJobs")).click();
		
		String count = driver.findElement(By.id("posiCountId")).getText();
		System.out.println(count);
		int countResult = Integer.parseInt(count.replaceAll(",", ""));
		
		if(countResult > 0) {
			System.out.println("STEP PASS: keyword" + keyword+" search returned " + countResult+ " results in "+ location);
		}else {
			System.out.println("STEP FAIL: keyword" + keyword+" search returned " + countResult+ " results in "+ location);
		}
		
	  //=================================================================================
		
		driver.close();
		System.out.println("TEST COMPLITED - " + LocalDateTime.now());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
