package com.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task1 {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.greenstechnologys.com/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1650)", "");
		System.out.println(driver.findElement(By.xpath("//span[text()='Greens Technologies Porur']//ancestor::p")).getText());
		System.out.println("-------------------------------");
		System.out.println(driver.findElement(By.xpath("(//strong)[24]")).getText());
		System.out.println(driver.findElement(By.xpath("(//strong)[25]//parent::b")).getText());
		
	}
}
