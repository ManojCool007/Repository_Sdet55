package KeyBoardActions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OPenTaskManagerTest {

	public static void main(String[] args) throws AWTException {
		
		Robot rbt=new Robot();
		rbt.keyPress(KeyEvent.VK_CONTROL);
		rbt.keyPress(KeyEvent.VK_SHIFT);
		rbt.keyPress(KeyEvent.VK_ESCAPE);
		rbt.keyRelease(KeyEvent.VK_CONTROL);
		rbt.keyRelease(KeyEvent.VK_SHIFT);
		rbt.keyRelease(KeyEvent.VK_ESCAPE);

	}

}
