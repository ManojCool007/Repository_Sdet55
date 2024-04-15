package com.parctice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SriLankaFindTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.icc-cricket.com/rankings/team-rankings/mens/test");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		String SL_Country="Sri Lanka";
		Thread.sleep(3000);
		boolean flag = false;
		List<WebElement> countries = driver.findElements(By.xpath("//h3[@class='si-team-name']"));
		for(WebElement country:countries)
		{
			String all_country = country.getText();
			if(SL_Country.equalsIgnoreCase(all_country))
			{
				 flag = true;
				 break;
			}
			
		}
		if(flag)
		{
			System.out.println("Country is present");
		}
		else
		{
			System.out.println("Country is not present");
		}
		driver.quit();
	}

}
