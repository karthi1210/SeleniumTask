package com.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Day9Task1 {
	
	public static void main(String[] args) throws InterruptedException, AWTException {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("Incognito","start-maximized");
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("http://demoqa.com/automation-practice-form/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("window.scrollBy(0,750)", "");
		
		WebElement state = driver.findElement(By.xpath("//div[@class=' css-tlfecz-indicatorContainer']"));
		
		state.click();
		
		//Thread.sleep(3000);
		
		List<WebElement> elements = driver.findElements(By.xpath("//div[10]/div[2]"));
		
		//System.out.println(elements.size());
		
		String text = null;
		
		for (int i = 0; i < elements.size(); i++) {
			
			text = elements.get(i).getText().trim();
			
		}
		
		String[] split = text.split("\\n");
		System.out.println("Even position of State");
		for(int i=1;i<split.length;i++)
			if(i%2==0)
			System.out.println(split[i]);
		
		Robot r = new Robot();
		
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		WebElement city = driver.findElement(By.xpath("(//div[@class=' css-1hwfws3'])[2]"));
		
		city.click();
		
		List<WebElement> elements1 = driver.findElements(By.xpath("//div[10]/div[3]"));
		
		for(int i=0;i<elements1.size();i++)
		
		text = elements1.get(i).getText().trim();
		
		String[] split1 = text.split("\\n");
		
		System.out.println("Even position of Citites");
		for(int i=1;i<split1.length;i++)
			if(i%2==0)
			System.out.println(split1[i]);
		
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(2000);
		driver.close();
	}
	
}

