package com.test;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice {
		
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("Incognito","--disable-notifications","start-maximized");
		WebDriver driver = new ChromeDriver(options);
		driver.get("http://demo.guru99.com/test/guru99home/");
		System.out.println(driver.findElement(By.xpath("//h2[contains(text(),'popular')]")).getText());
		List<WebElement> elements = driver.findElements(By.xpath("//h2[contains(text(),'popular')]//following-sibling::div"));
		elements.stream().forEach(k -> System.out.println(k.getText()));
		List<WebElement> elements2 = driver.findElements(By.xpath("(//div[@class='rt-grid-12 rt-alpha rt-omega'][2])[1]"));
		elements2.stream().forEach(k -> System.out.println(k.getText()));		
		List<WebElement> elements3 = driver.findElements(By.xpath("//div[.//a[text()='SELENIUM']]/ancestor::div[@class='rt-grid-2 rt-omega']/following-sibling::div"));
		elements3.stream().forEach(k -> System.out.println(k.getText()));
		System.out.println("-----------------");
		List<WebElement> elements4 = driver.findElements(By.xpath("//a[text()='SELENIUM']//ancestor::div/following-sibling::div"));
		elements4.stream().forEach(k -> System.out.println(k.getText()));
		
		}
		
		
	}


