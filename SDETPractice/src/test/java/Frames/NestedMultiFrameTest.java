package Frames;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedMultiFrameTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//p[text()=\"UI Testing Concepts\"]")).click();
		driver.findElement(By.xpath("//section[text()='Frames']")).click();
		driver.findElement(By.xpath("//section[text()='iframes']")).click();
		driver.findElement(By.xpath("//a[text()='Nested with Multiple iframe']")).click();
	    Thread.sleep(3000);
	    WebElement main = driver.findElement(By.xpath("//iframe[@class='w-full h-96']"));
	    driver.switchTo().frame(main);
	    String email = driver.findElement(By.xpath("//p[text()='Admin@gmail.com']")).getText();
	    Thread.sleep(2000);
	    WebElement child = driver.findElement(By.xpath("//section[@class='main_form_container']//iframe"));
	    driver.switchTo().frame(child);
	    driver.switchTo().frame(0);
	    driver.findElement(By.name("email")).sendKeys(email);
	    driver.switchTo().defaultContent();
	    driver.switchTo().frame(main);
	    String pass = driver.findElement(By.xpath("//p[text()='Admin@1234'][1]")).getText();
	    Thread.sleep(2000);
	    driver.switchTo().frame(child);
	    driver.switchTo().frame(1);
	    driver.findElement(By.name("password")).sendKeys(pass);
	    driver.switchTo().defaultContent();
	    driver.switchTo().frame(main);
	    String conpass = driver.findElement(By.xpath("//p[text()='Admin@1234'][2]")).getText();
	    Thread.sleep(2000);
	    driver.switchTo().frame(child);
	    driver.switchTo().frame(2);
	    driver.findElement(By.name("confirm")).sendKeys(conpass);
	    driver.switchTo().parentFrame();
	    driver.switchTo().frame(3);
	    driver.findElement(By.xpath("//button[text()='Submit']")).click();
	    driver.switchTo().defaultContent();
	}

}
