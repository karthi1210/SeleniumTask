package com.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day10Task3 {
	
	public static void main(String[] args) throws AWTException, InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("Incognito","start-maximized","--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		Actions actions = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("https://www.homedepot.com/");
		WebElement search = driver.findElement(By.id("headerSearch"));
		search.sendKeys("Celling Fan");
		String window1 = driver.getWindowHandle();
		driver.findElement(By.xpath("//button[@id='headerSearchButton']")).click();
		driver.findElement(By.xpath("//span[text()='Ashby Park 52 in. White Color Changing Integrated LED Brushed Nickel Ceiling Fan with Light Kit and Remote Control']")).click();
		Set<String> allWindows = driver.getWindowHandles();
		for (String string : allWindows) 
			if(!string.equals(window1))
				driver.switchTo().window(string);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//img[@alt='close delivery zip drop down']")).click();
		js.executeScript("window.scrollBy(0,500)", "");
		WebElement remote = driver.findElement(By.xpath("//span[text()='Remote Included']"));
		actions.click(remote).perform();
		Thread.sleep(3000);
		driver.quit();
		
		
		
		
	}

}
