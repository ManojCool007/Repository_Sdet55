package com.parctice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class IrctcCalPopTest {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://www.irctc.co.in/nget/train-search");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='ng-tns-c58-10 ui-calendar']")).click();
		for(;;)
			try
		{
				driver.findElement(By.xpath("//span[text()='July']"));
				driver.findElement(By.xpath("//a[text()='20']")).click();
				break;
		}
		catch(Exception e)
		{
			driver.findElement(By.xpath("//span[contains(@class,'chevron-right')]")).click();
		}
		
	}

}
