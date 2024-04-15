package DropDown;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownFlowTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//p[text()=\"UI Testing Concepts\"]")).click();
		driver.findElement(By.xpath("//section[text()='Dropdown']")).click();
		WebElement ph = driver.findElement(By.xpath("//select[@id='select1']"));
		Select sel1=new Select(ph);
		sel1.selectByIndex(2);
		driver.findElement(By.name("ph")).sendKeys("9898789545");
		WebElement gender = driver.findElement(By.xpath("//select[@id='select2']"));
		Select sel2=new Select(gender);
		sel2.selectByValue("male");
		WebElement Countdrop = driver.findElement(By.xpath("//select[@id='select3']"));
		Select sel3=new Select(Countdrop);
		sel3.selectByVisibleText("India");
		WebElement Statedrop = driver.findElement(By.xpath("//select[@id='select5']"));
		Select sel4=new Select(Statedrop);
		sel4.selectByValue("Karnataka");
		WebElement Citydrop = driver.findElement(By.xpath("//label[text()='City']/following-sibling::select"));
		Select sel5=new Select(Citydrop);
		sel5.selectByIndex(20);
		WebElement Qty = driver.findElement(By.xpath("//select[@id='select7']"));
		Select sel6=new Select(Qty);
		sel6.selectByVisibleText("4");
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		Thread.sleep(2000);
		driver.quit();
		}

}
