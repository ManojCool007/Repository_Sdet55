package com.parctice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLink2Test {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.epfindia.gov.in/site_en/index.php");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		System.out.println(links.size());
		for (WebElement link : links) 
		{
			String text = link.getAttribute("href");
			try
			{
			URL url=new URL(text);
			HttpURLConnection conn=(HttpURLConnection) url.openConnection();
			int status = conn.getResponseCode();
			if(status>=400 && status!=0)
			{
				System.out.println(status+"-------->"+text);
			}
		}
			catch(Exception e)
			{
				
			}
		}
		
	}

}
