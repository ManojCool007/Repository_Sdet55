package PopUps;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTabTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//p[text()=\"UI Testing Concepts\"]")).click();
		driver.findElement(By.xpath("//section[text()='Popups']")).click();
		driver.findElement(By.xpath("//section[text()='Browser Windows']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='New Tab']")).click();
		driver.findElement(By.xpath("//button[text()='Open window in new Tab']")).click();
		String parent_id = driver.getWindowHandle();
		Set<String> all_id = driver.getWindowHandles();
		for(String id:all_id)
		{
			if(parent_id.equals(id))
			{
				driver.close();
			}
			else
			{
				driver.switchTo().window(id);
				Thread.sleep(2000);
				driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
				driver.findElement(By.id("password")).sendKeys("54698");
				driver.findElement(By.id("confirm-password")).sendKeys("54698");
				driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
			}
	}
	}

}
