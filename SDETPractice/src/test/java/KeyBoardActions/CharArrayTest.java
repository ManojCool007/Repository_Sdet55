package KeyBoardActions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CharArrayTest {

	public static void main(String[] args) throws AWTException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/ui/keyboard");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.id("email")).click();
		String text="hello@gmail.com";
		Robot rbt=new Robot();
        for(char c:text.toCharArray())
        {
        	int finaltext=KeyEvent.getExtendedKeyCodeForChar(c);
        			
        				rbt.keyPress(finaltext);
        				rbt.keyRelease(finaltext);
        		
        }
	}

}
