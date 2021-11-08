package com.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Day10Task1 {
	
	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("Incognito","start-maximized");
		WebDriver driver = new ChromeDriver(options);
		Actions actions = new Actions(driver);
		Robot robot = new Robot();
		driver.get("https://www.amazon.com/");
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchBox.sendKeys("iphone x");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		WebElement iphoneX = driver.findElement(By.xpath("//span[text()='Apple iPhone X, 64GB, Space Gray - Fully Unlocked (Renewed Premium)']"));
		File f = new File("C:\\Users\\Karthiksofia\\eclipse-workspace\\SeleniumTaskDay3\\screenshots\\karthik.png");
		File src = iphoneX.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, f);
		String window1 = driver.getWindowHandle();
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2)).ignoring(Throwable.class);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Apple iPhone X, 64GB, Space Gray - Fully Unlocked (Renewed Premium)']")));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		actions.contextClick(iphoneX).perform();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		Set<String> windowHandles = driver.getWindowHandles();
		for (String string : windowHandles) {
			if(!string.equals(window1))
				driver.switchTo().window(string);
		}
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		System.out.println("Cost of Selected phone: "+driver.findElement(By.xpath("(//span[text()='$366.00'])[2]")).getText());
		driver.close();
		driver.switchTo().window(window1);
		driver.close();
		
		
		
		
	}

}
