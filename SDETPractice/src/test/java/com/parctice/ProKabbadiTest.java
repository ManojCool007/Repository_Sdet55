package com.parctice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ProKabbadiTest {
	@Test
	public void script() throws InterruptedException
	{
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		String team="Bengaluru Bulls";
		driver.get("https://www.prokabaddi.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> teams = driver.findElements(By.xpath("//p[.='"+team+"']/ancestor::div[@class='table-body']/div[contains(@class,'table-row')]/descendant::p[@class='name']"));
		Thread.sleep(3000);
		for(WebElement str:teams)
		{
			String text = str.getText();
			if(text.equalsIgnoreCase(team)) 
			{
			System.out.print(team);
			List<WebElement> indi = driver.findElements(By.xpath("//p[.='"+team+"']/../../../..//p[@class='count']"));
			for(WebElement str1:indi)
			{
				String txt = str1.getText();
				System.out.print(txt+" ");
			}
			}
			System.out.println();
		}
	}
}
