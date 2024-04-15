package DropDown;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectAllOptionsTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		 WebElement month_dropdown = driver.findElement(By.xpath("//select[@aria-label='Month']"));
		 Select sel=new Select(month_dropdown);
		 List<WebElement> options = sel.getOptions();
		 for(WebElement option:options)
		 {
			 String text = option.getText();
			 System.out.println(text);
		 }
		 driver.quit();
	}

}
