package com.parctice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DDTTest {
	public static WebDriver driver;
	public static void main(String[] args) throws IOException {
		 FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		 Properties prop = new Properties();
		 prop.load(fis);
		 String BROWSER = prop.getProperty("browser");
		 String URL = prop.getProperty("url");
		 String USERNAME = prop.getProperty("username");
		 String PWD = prop.getProperty("password");
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
	}

}
