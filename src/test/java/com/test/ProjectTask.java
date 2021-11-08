package com.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjectTask {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		
		
//		driver.get("https://www.waterstones.com");
//		
//		driver.manage().window().maximize();
//		
//		driver.manage().deleteAllCookies();
//		
//		Thread.sleep(10000);
//		
//		Actions actions = new Actions(driver);
//		
//		WebElement element = driver.findElement(By.xpath("//a[@class='nav-item-stationery & gifts js-nav-item nav-item  has-dropdown']"));
//		
//		actions.moveToElement(element).perform();
//		
//		Thread.sleep(3000);
//		
//		driver.findElement(By.xpath("((//div[@class='group-wrap span3 alpha omega'])[10]/div/ul/li/a)[1]")).click();
//
		
		driver.get("https://en-gb.facebook.com");
		
		driver.manage().window().maximize();
		
		Actions actions = new Actions(driver);
		
		WebElement e = driver.findElement(By.id("email"));
		
		actions.sendKeys(e,"Karthik").perform();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement e2 = driver.findElement(By.id("pass"));
		
		js.executeScript("arguments[0].setAttribute('value','karthik@123')", e2);
		
	
		
	}

}
