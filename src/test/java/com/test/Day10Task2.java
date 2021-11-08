package com.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

public class Day10Task2 {

	public static void main(String[] args) throws AWTException, InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("Incognito","start-maximized","--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		Actions actions = new Actions(driver);
		Robot robot = new Robot();
		driver.get("https://www.snapdeal.com/");
		WebElement searchBox = driver.findElement(By.xpath("//input[@class='col-xs-20 searchformInput keyword']"));
		searchBox.sendKeys("iphone 7");
		String window1 = driver.getWindowHandle();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[@class='searchTextSpan']")).click();
		driver.findElement(By.xpath("(//p[@class='product-title'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Set<String> allWindows = driver.getWindowHandles();
		for (String string : allWindows) 
			if(!string.equals(window1))
				driver.switchTo().window(string);
		driver.findElement(By.xpath("(//span[@class='intialtext'])[2]")).click();
		System.out.println(driver.findElement(By.xpath("(//span[@class='price'])[2]")).getText());
		driver.quit();
		

		
		
		
	}

}
