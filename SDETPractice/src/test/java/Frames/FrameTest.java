package Frames;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//p[text()=\"UI Testing Concepts\"]")).click();
		driver.findElement(By.xpath("//section[text()='Frames']")).click();
		driver.findElement(By.xpath("//section[text()='iframes']")).click();
		WebElement frm = driver.findElement(By.tagName("iframe"));
	    driver.switchTo().frame(frm);
	    driver.findElement(By.id("username")).sendKeys("Hello");
	    Thread.sleep(1000);
	    driver.switchTo().defaultContent();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//a[text()='Nested iframe']")).click();
	    Thread.sleep(3000);
	    WebElement main = driver.findElement(By.xpath("(//iframe)[1]"));
	    driver.switchTo().frame(main);
	    Thread.sleep(3000);
	    WebElement child = driver.findElement(By.xpath("//iframe"));
	    driver.switchTo().frame(child);
	    Thread.sleep(3000);
	    driver.findElement(By.id("email")).sendKeys("Hello@gmail.com");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//a[text()='Multiple iframe']")).click();
	    Thread.sleep(3000);
	    driver.switchTo().frame(0);
	    driver.findElement(By.name("email")).sendKeys("abc@gmail.com");
	    driver.findElement(By.name("password")).sendKeys("abc1234");
	    driver.findElement(By.name("confirmPassword")).sendKeys("abc1234");
	    driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
	    driver.switchTo().parentFrame();
	    Thread.sleep(2000);
	    driver.switchTo().frame(1);
	    driver.findElement(By.name("username")).sendKeys("abc@gmail.com");
	    driver.findElement(By.name("password")).sendKeys("abc1234");
	    driver.findElement(By.xpath("//button[text()='Login']")).click();
	    driver.switchTo().parentFrame();
	}

}
