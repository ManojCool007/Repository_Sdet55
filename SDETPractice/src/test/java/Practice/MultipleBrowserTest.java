package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleBrowserTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		for(int i=1;i<=5;i++)
		{
			
			driver.switchTo().newWindow(WindowType.WINDOW);
		}
		
	}

}
