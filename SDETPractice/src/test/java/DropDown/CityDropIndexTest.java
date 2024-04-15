package DropDown;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CityDropIndexTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//p[text()=\"UI Testing Concepts\"]")).click();
		driver.findElement(By.xpath("//section[text()='Dropdown']")).click();
		WebElement Countdrop = driver.findElement(By.xpath("//select[@id='select3']"));
		Select sel1=new Select(Countdrop);
		sel1.selectByVisibleText("India");
		WebElement Statedrop = driver.findElement(By.xpath("//select[@id='select5']"));
		Select sel2=new Select(Statedrop);
		sel2.selectByValue("Karnataka");
		WebElement Citydrop = driver.findElement(By.xpath("//label[text()='City']/following-sibling::select"));
		Select sel3=new Select(Citydrop);
		sel3.selectByIndex(20);
		Thread.sleep(2000);
		driver.quit();
	}

}
