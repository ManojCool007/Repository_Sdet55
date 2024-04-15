package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class ThreeBrowsersTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.flipkart.in/");
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.facebook.in/");
		
	}

}
