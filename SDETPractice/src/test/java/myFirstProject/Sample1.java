package myFirstProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//p[text()=\"UI Testing Concepts\"]")).click();
		driver.findElement(By.id("name")).sendKeys("Lucifer");
		driver.findElement(By.id("email")).sendKeys("lucifer.43@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Lucifer");
		driver.findElement(By.xpath("//button[text()=\"Register\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys("lucifer.43@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Lucifer");
		driver.findElement(By.xpath("//button[text()=\"Login\"]")).click();
		WebElement print = driver.findElement(By.xpath("//div[text()=\"Signin successful\"]"));
		String text = print.getText();
		System.out.println(text);
		driver.quit();
	}
}
