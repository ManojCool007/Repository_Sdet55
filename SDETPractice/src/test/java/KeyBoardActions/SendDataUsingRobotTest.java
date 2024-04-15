package KeyBoardActions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendDataUsingRobotTest {

	public static void main(String[] args) throws AWTException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/ui/keyboard");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.id("email")).click();
		Robot rbt=new Robot();
		rbt.keyPress(KeyEvent.VK_A);
		rbt.keyRelease(KeyEvent.VK_A);
		rbt.keyPress(KeyEvent.VK_B);
		rbt.keyRelease(KeyEvent.VK_B);

	}

}
