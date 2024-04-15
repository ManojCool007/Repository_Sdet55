package com.parctice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KsrtcCalPopTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.ksrtc.in/oprs-web/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.findElement(By.name("txtJourneyDate")).click();
		for(;;)
			try
		{
				//driver.findElement(By.xpath("//span[text()='April']")).click()
				driver.findElement(By.xpath("//a[text()='12']")).click();
				break;
		}
		catch(Exception e)
		{
			driver.findElement(By.xpath("//a[@title='Next']")).click();
		}
		

	}

}
