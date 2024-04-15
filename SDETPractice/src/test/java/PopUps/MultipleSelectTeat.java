package PopUps;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleSelectTeat {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//p[text()=\"UI Testing Concepts\"]")).click();
		driver.findElement(By.xpath("//section[text()='Popups']")).click();
		driver.findElement(By.xpath("//section[text()='File Uploads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Multiple select")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("fileInput")).sendKeys("C:\\Users\\Dell\\Downloads\\mytextfile.txt");
		driver.findElement(By.id("fileInput")).sendKeys("C:\\Users\\Dell\\Downloads\\Final_mock.postman_collection.json");
		Thread.sleep(2000);
		List<WebElement> lists = driver.findElements(By.xpath("//ul[@class='list-decimal']/li"));
		for(WebElement list:lists)
		{
			String text = list.getText();
			System.out.println(text);
		}
	}
}
