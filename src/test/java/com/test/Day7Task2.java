package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day7Task2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions c = new ChromeOptions();
		c.addArguments("Incognito","start-maximized");
		WebDriver driver = new ChromeDriver(c);
		
		driver.get("http://toolsqa.com/");
		
		WebDriverWait w = new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//button[@class='modal__close'])[2]"))));
		
		driver.findElement(By.xpath("(//button[@class='modal__close'])[2]")).click();
		
		WebElement element = driver.findElement(By.xpath("//a[@class='btn btn-border active']"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		
		Thread.sleep(2000);
		
		driver.close();
		
	}
	
}
