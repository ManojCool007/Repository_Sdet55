package myFirstProject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample9 {

	public static void main(String[] args) throws AWTException, InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		Robot rbt=new Robot();
		for(int i=0;i<3;i++)
		{
			rbt.keyPress(KeyEvent.VK_CONTROL);
			rbt.keyPress(KeyEvent.VK_T);
			rbt.keyRelease(KeyEvent.VK_CONTROL);
			rbt.keyRelease(KeyEvent.VK_T);
			Thread.sleep(1000);
		}
		Set<String> all_id = driver.getWindowHandles();
		ArrayList<String> arraylist=new ArrayList<String>(all_id);
		String third_tab = arraylist.get(2);
		driver.switchTo().window(third_tab);
		driver.get("https://www.facebook.com");
		Thread.sleep(1000);
		String first_tab = arraylist.get(0);
		driver.switchTo().window(first_tab);
		driver.get("https://www.youtube.com");
		Thread.sleep(1000);
		String second_tab = arraylist.get(1);
		driver.switchTo().window(second_tab);
		driver.close();
		Thread.sleep(1000);
		String fourth_tab = arraylist.get(3);
		driver.switchTo().window(fourth_tab);
		driver.close();
		Thread.sleep(2000);
		driver.quit();
	}

}
