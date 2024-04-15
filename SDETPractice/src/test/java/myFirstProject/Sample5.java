package myFirstProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample5 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//p[text()=\"UI Testing Concepts\"]")).click();
		driver.findElement(By.xpath("//section[text()='Button']")).click();
		driver.findElement(By.linkText("Disabled")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[text()='Yes'])[1]")).click();
		driver.findElement(By.xpath("(//button[text()='Yes'])[2]")).click();
		driver.findElement(By.xpath("//button[text()='2']")).click();
		WebElement disabled = driver.findElement(By.xpath("//button[text()='Submit']"));
		JavascriptExecutor js=(JavascriptExecutor) driver;	
		js.executeScript("arguments[0].click()", disabled);
		Thread.sleep(2000);
		driver.quit();
	}

}
