package PopUps;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class IrctcDataTest {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.findElement(By.xpath("//a[text()=' BUSES ']")).click();
		Thread.sleep(2000);
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
				Thread.sleep(3000);
				WebElement dept = driver.findElement(By.xpath("//input[@id='departFrom']"));
				Actions act=new Actions(driver);
				act.moveToElement(dept).perform();
				act.sendKeys(dept, "Benga").perform();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[text()='Bengaluru']")).click();
	       }

}
		
	}
}
