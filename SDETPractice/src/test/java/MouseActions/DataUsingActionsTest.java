package MouseActions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DataUsingActionsTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//p[text()=\"UI Testing Concepts\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//section[text()='Mouse Actions']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//section[text()='Mouse Hover']")).click();
		Thread.sleep(15000);
		WebElement pass = driver.findElement(By.xpath("//input[@placeholder='Enter Password']"));
		Actions act=new Actions(driver);
		act.sendKeys(pass, "Password").perform();
	}

}
