package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day5Task3 {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
		
		
		WebDriver driver = new ChromeDriver(options);
		
		Actions a = new Actions(driver); 
		
		driver.get("http://www.flipkart.com");
		
		driver.manage().window().maximize();
		
		WebElement element1 = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		
		a.moveToElement(element1).click().perform();
		
		WebElement element2 = driver.findElement(By.xpath("//input[@class='_3704LK']"));
		
		a.moveToElement(element2).click().perform();
		
		element2.sendKeys("Home & Furniture");
		
		element2.sendKeys(Keys.ENTER);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Thread.sleep(3000);
		
		WebElement element4 = driver.findElement(By.xpath("(//*[@class='_2I9KP_'])[6]"));
		
		a.moveToElement(element4).perform();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[text()='Bath Towels']")).click();
		
		driver.findElement(By.xpath("(//a[@class='s1Q9rs'])[1]")).click();
		
		driver.close();
		
		
		
		
		
		
		
		
		
		
		
	}
	

}

