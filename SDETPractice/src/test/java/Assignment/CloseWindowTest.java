package Assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CloseWindowTest {

	@Test
	public void Script1()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		for(int i=0;i<9;i++)
		{
		driver.switchTo().newWindow(WindowType.TAB);
		}
		
		Set<String> windows = driver.getWindowHandles();
		ArrayList<String> list = new ArrayList<String>();
		for(String window:windows)
		{
			list.add(window);
		}
		String seventh_win = list.get(6);
		driver.switchTo().window(seventh_win);
		driver.close();
	}

}
