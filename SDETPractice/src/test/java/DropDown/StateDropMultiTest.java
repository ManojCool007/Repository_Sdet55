package DropDown;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StateDropMultiTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//p[text()=\"UI Testing Concepts\"]")).click();
		driver.findElement(By.xpath("//section[text()='Dropdown']")).click();
		driver.findElement(By.xpath("//a[text()='Multi Select']")).click();
		WebElement Country = driver.findElement(By.xpath("//label[text()='Country']/following-sibling::div/select"));
		Select sel=new Select(Country);
		if(sel.isMultiple())
		{
			sel.selectByVisibleText("India");
			sel.selectByVisibleText("Canada");
			sel.selectByVisibleText("Germany");
		}
			Thread.sleep(3000);
			WebElement Statedrop = driver.findElement(By.xpath("//label[text()='State']/following-sibling::div/select"));
			Select sel2=new Select(Statedrop);
			if(sel2.isMultiple())
			{
				sel2.selectByVisibleText("Bihar");
				sel2.selectByVisibleText("Karnataka");
			}
			Thread.sleep(2000);
			driver.quit();
			
	}

}
