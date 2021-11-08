package com.test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day5Task14 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeOptions c = new ChromeOptions();

		c.addArguments("Incognito");

		WebDriver driver = new ChromeDriver(c);

		Actions a = new Actions(driver);
		
		driver.get("https://www.snapdeal.com/");
		
		driver.manage().window().maximize();
		
		WebElement element1 = driver.findElement(By.xpath("(//span[@class='catText'])[7]"));
		
		a.moveToElement(element1).perform();
		
		WebElement element2 = driver.findElement(By.xpath("(//span[text()='Heels'])[2]"));
		
		a.moveToElement(element2).click().perform();


	}
}
