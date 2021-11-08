package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TaskThree{
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Actions a = new Actions(driver);
		driver.navigate().to("http://demo.guru99.com/test/drag_drop.html");
		driver.manage().window().maximize();
		WebElement src = driver.findElement(By.xpath("(//a[@class='button button-orange'])[5]"));
		WebElement des = driver.findElement(By.xpath("(//li[@class='placeholder'])[1]"));
		a.dragAndDrop(src, des).perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement srcDebit = driver.findElement(By.xpath("(//a[@class='button button-orange'])[2]"));
		WebElement desDebit = driver.findElement(By.xpath("(//li[@class='placeholder'])[1]"));
		a.dragAndDrop(srcDebit, desDebit).perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement srcSales = driver.findElement(By.xpath("(//a[@class='button button-orange'])[6]"));
		WebElement desSales = driver.findElement(By.xpath("//li[@class='placeholder']"));
		a.dragAndDrop(srcSales, desSales).perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement srcCredit = driver.findElement(By.xpath("(//a[@class='button button-orange'])[4]"));
		WebElement desCredit = driver.findElement(By.xpath("//li[@class='placeholder']"));
		a.dragAndDrop(srcCredit, desCredit).perform();
		
	}
		
	
}	




