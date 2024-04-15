package DropDown;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StateDropTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//p[text()=\"UI Testing Concepts\"]")).click();
		driver.findElement(By.xpath("//section[text()='Dropdown']")).click();
		WebElement dropdown1 = driver.findElement(By.xpath("//select[@id='select3']"));
		Select sel=new Select(dropdown1);
		sel.selectByValue("India");
		WebElement dropdown2 = driver.findElement(By.xpath("//select[@id='select5']"));
		Select sel1=new Select(dropdown2);
		List<WebElement> options = sel1.getOptions();
		for(WebElement option:options)
		{
			String text = option.getText();
			System.out.println(text);
		}
		
	}

}
