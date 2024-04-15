package com.parctice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class WriteDataUsingCmdTest 
{
	public  WebDriver driver;
	@Test
	public void writeData()
	{
		String BROWSER = System.getProperty("browser");
		 String URL = System.getProperty("url");
		 String USERNAME = System.getProperty("username");
		 String PWD = System.getProperty("password");
		 if(BROWSER.equalsIgnoreCase("chrome"))
		 {
			 driver=new ChromeDriver();
		 }
		 
		 else if(BROWSER.equalsIgnoreCase("firefox"))
		 {
			 driver=new FirefoxDriver();
		 }
		 else
		 {
			 System.out.println("Invalid Browser");	
		 }
		 driver.get(URL);
		 driver.findElement(By.name("user")).sendKeys(USERNAME);
		 driver.findElement(By.name("password")).sendKeys(PWD);
		 driver.findElement(By.name("btnlogin")).click();
		 System.out.println(BROWSER);
		 System.out.println(URL);
		 System.out.println(USERNAME);
		 System.out.println(PWD);

	}
}
