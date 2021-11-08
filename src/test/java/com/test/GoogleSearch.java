package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearch {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions c = new ChromeOptions();
		
		c.addArguments("incognito");
		
		WebDriver driver = new ChromeDriver(c);
		
		driver.navigate().to("https://www.google.com/");
		
		driver.manage().window().setPosition(new Point(0, -1000));
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//div[@class='a4bIc']/input")).sendKeys("karthik");
		
	}
	

}
