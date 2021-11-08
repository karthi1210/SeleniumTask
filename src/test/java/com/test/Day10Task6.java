package com.test;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day10Task6 {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("Incognito");
		WebDriver driver = new ChromeDriver(options);
		Actions actions = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("http://greenstech.in/selenium-course-content.html");
		driver.manage().window().maximize();
		String window1 = driver.getWindowHandle();
		js.executeScript("window.scrollBy(0,1000)", "");
		WebElement element = driver.findElement(By.xpath(""));
		driver.findElement(By.xpath("")).click();
		Set<String> allWindows = driver.getWindowHandles();
		for (String string : allWindows) 
			if(!string.equals(window1))
				driver.switchTo().window(string);
		
		
		
		
	}

}
