package com.parctice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OlympicTest {

	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		String country="Canada";
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> teams = driver.findElements(By.xpath("//span[@data-cy='country-name']"));
		for(WebElement team:teams)
		{
			String text = team.getText();
			if(text.equalsIgnoreCase(country))
			{
				System.out.println(country);
				List<WebElement> medal = driver.findElements(By.xpath("(//span[.='"+country+"']/../following-sibling::div[@data-cy='medal']/descendant::span[@class='OcsTextstyles__StyledText-sc-1a1i41u-0 jjOloZ text--sm-body'])[position()<=4]"));
				for(WebElement str1:medal)
				{
					String txt = str1.getText();
					System.out.print(txt+" ");
				}
			}
			System.out.println();
		}

	}

}
