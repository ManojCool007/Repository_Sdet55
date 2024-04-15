package KeyBoardActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SEndDataUsingActionsTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/ui/keyboard");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebElement email = driver.findElement(By.id("email"));
		Actions act=new Actions(driver);
		act.sendKeys(email, "Hello@gmail.com").perform();

	}

}
