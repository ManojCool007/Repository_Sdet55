package com.parctice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SelectorsHubTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://selectorshub.com/xpath-practice-page/");
		WebElement UN = driver.findElement(By.xpath("//div[@id='userName']"));
		SearchContext shadow = UN.getShadowRoot();
		shadow.findElement(By.id("kils")).sendKeys("Lucifer");
		WebElement pizza = shadow.findElement(By.cssSelector("#app2"));
		SearchContext shadow2 = pizza.getShadowRoot();
		shadow2.findElement(By.id("pizza")).sendKeys("Dominoes");
	}

}
