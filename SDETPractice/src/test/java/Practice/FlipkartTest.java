package Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.name("q")).sendKeys("Shirts");
		List<WebElement> lists = driver.findElements(By.xpath("//ul[@class='_1sFryS _2x2Mmc_3ofZy1']/li/div/a/div[2]/div[@class='_3idirA']"));
		for(WebElement list:lists)
		{
			
			System.out.print(list.getText());
			if(list.getText().contains("in Casual Shirts"))
			{
				list.click();
			}
		}
		
	

	}

}
//li[@class='Y5N33s']/div/a//span