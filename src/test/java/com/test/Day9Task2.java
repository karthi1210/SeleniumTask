package com.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day9Task2 {
	
	public static void main(String[] args) throws InterruptedException, AWTException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("Incognito","--disable-notifications","start-maximized");
		WebDriver driver = new ChromeDriver(options);
		driver.get("http://demoqa.com/automation-practice-form/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,750)", "");
		driver.findElement(By.xpath("//div[text()='Select State']")).click();
		WebElement element1 = driver.findElement(By.xpath("//label[text()='State and City']/following::div[1]"));
		String text1 = element1.getText().trim();
		String txt1[] = text1.split("\\n");
		System.out.println("Odd position of States");
		for(int i=1; i<txt1.length; i+=2)
			System.out.println(txt1[i]);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Select City']")).click();
		WebElement element2 = driver.findElement(By.xpath("//label[text()='State and City']/following::div[11]"));
		String text2 = element2.getText().trim();
		String txt2[] = text2.split("\\n");
		System.out.println("Odd position of Cities");
		for(int i=1; i<txt2.length; i+=2)
			System.out.println(txt2[i]);
		/*driver.get("https://www.guru99.com/");
		List<WebElement> elements1 = driver.findElements(By.xpath("(//div[@class='kt-row-column-wrap kt-has-6-columns kt-gutter-default kt-v-gutter-default kt-row-valign-top kt-row-layout-equal kt-tab-layout-inherit kt-m-colapse-left-to-right kt-mobile-layout-row'])[1]//parent::a"));
		List<WebElement> elements2 = driver.findElements(By.xpath("(//div[@class='kt-row-column-wrap kt-has-6-columns kt-gutter-default kt-v-gutter-default kt-row-valign-top kt-row-layout-equal kt-tab-layout-inherit kt-m-colapse-left-to-right kt-mobile-layout-row'])[2]//ancestor::a"));
		elements1.stream().forEach(k -> System.out.println(k.getText()));
		elements2.stream().forEach(k -> System.out.println(k.getText()));
		driver.close();*/
		
	}

}
