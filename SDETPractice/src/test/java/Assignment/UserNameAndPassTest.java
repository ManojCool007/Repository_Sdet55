package Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UserNameAndPassTest {

	 @Test
	    public void question9() {
		 WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get("https://www.facebook.com/");
			driver.findElement(By.id("email")).sendKeys("manojmanu77137@gmail.com");
			driver.findElement(By.id("pass")).sendKeys("MsDhoni@007");
			driver.findElement(By.name("login")).click();
			if(driver.getTitle().equals("Facebook – log in or sign up"))
				System.out.println("Invalid Credentials");
			else
				System.out.println("Valid Credentials");

		}
}
