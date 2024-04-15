package Frames;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchNameInsideFrameTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//p[text()=\"UI Testing Concepts\"]")).click();
		driver.findElement(By.xpath("//section[text()='Frames']")).click();
		driver.findElement(By.xpath("//section[text()='iframes']")).click();
		driver.findElement(By.xpath("//a[text()='Nested iframe']")).click();
	    Thread.sleep(3000);
	    WebElement main = driver.findElement(By.xpath("(//iframe)[1]"));
	    driver.switchTo().frame(main);
	    Thread.sleep(3000);
	     String email = driver.findElement(By.xpath("//p[text()='Admin@gmail.com']")).getText();
	    Thread.sleep(2000);
	    WebElement child = driver.findElement(By.xpath("//iframe"));
	    driver.switchTo().frame(child);
	    Thread.sleep(3000);
	    driver.findElement(By.id("email")).sendKeys(email);
	    Thread.sleep(1000);
	    driver.switchTo().parentFrame();
	    String pass = driver.findElement(By.xpath("//p[text()='Admin@1234'][1]")).getText();
	    Thread.sleep(2000);
	    driver.switchTo().frame(child);
	    Thread.sleep(3000);
	    driver.findElement(By.id("password")).sendKeys(pass);
	    Thread.sleep(1000);
	}

}
