package com.parctice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksTest {

	public static void main(String[] args) throws IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		List<WebElement> alllinks = driver.findElements(By.xpath("//a"));
		System.out.println(alllinks.size());
	    for (WebElement link : alllinks) 
	    {
			String url = link.getAttribute("href");
			try
			{
			URL links = new URL(url);
			HttpURLConnection httpcon= (HttpURLConnection) links.openConnection();
			int statuscode = httpcon.getResponseCode();
			if(statuscode>=400)
			{
				System.out.println(statuscode+"------->"+link);
			}
				
			}
			catch(Exception e)
			{
				
			}
	    }	

	}

}
