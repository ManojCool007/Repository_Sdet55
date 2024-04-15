package KeyBoardActions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendDataUsingSeleniumTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/ui/keyboard");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.id("email")).sendKeys("hello@gmail.com",Keys.CONTROL,"ac",Keys.TAB);
	}

}
//,Keys.CONTROL,"v",Keys.TAB,Keys.CONTROL,"v",Keys.ENTER