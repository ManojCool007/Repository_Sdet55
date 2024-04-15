package Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ShopTest {

	 @Test
	    public void question3() throws InterruptedException {
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	     driver.get("https://www.maccosmetics.com");
	     Thread.sleep(3000);
	     driver.findElement(By.xpath("//span[.='SHOP']/..")).click();
		}
}
