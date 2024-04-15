package com.parctice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class BigBasketTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://www.bigbasket.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@placeholder='Search for Products...' and @type='text'])[1]")).sendKeys("apple",Keys.ENTER);
		Thread.sleep(3000);
	}

}
