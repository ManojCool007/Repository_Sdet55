package Frames;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchFramesTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//p[text()=\"UI Testing Concepts\"]")).click();
		driver.findElement(By.xpath("//section[text()='Frames']")).click();
		driver.findElement(By.xpath("//section[text()='iframes']")).click();
		driver.findElement(By.xpath("//a[text()='Multiple iframe']")).click();
	    Thread.sleep(3000);
	    driver.switchTo().frame(0);
	    driver.findElement(By.name("email")).sendKeys("abc@gmail.com");
	    driver.switchTo().parentFrame();
	    Thread.sleep(2000);
	    driver.switchTo().frame(1);
	    driver.findElement(By.name("username")).sendKeys("abc@gmail.com");
	}

}
