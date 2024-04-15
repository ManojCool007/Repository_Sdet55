package myFirstProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChecPlaceHolderTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//p[text()=\"UI Testing Concepts\"]")).click();
		driver.findElement(By.xpath("//p[contains(text(),'place')]")).click();
		String text = driver.findElement(By.id("name")).getAttribute("placeholder");
		if(text.equals("Enter your name"))
		{
			System.out.println(text);
		}
		
		driver.quit();

	}

}
