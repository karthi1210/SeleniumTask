package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day5Task2 {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Actions a = new Actions(driver);
		driver.get("http://www.amazon.in");
		driver.manage().window().maximize();
		WebElement element1 = driver.findElement(By.xpath("//span[text()='Prime']"));
		a.moveToElement(element1).perform();
		WebElement element2 = driver.findElement(By.xpath("//img[@id='multiasins-img-link']"));
		a.moveToElement(element2).click().perform();
		
		
	}

}
