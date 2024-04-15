package MouseActions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//p[text()=\"UI Testing Concepts\"]")).click();
		driver.findElement(By.xpath("//section[text()='Mouse Actions']")).click();
		driver.findElement(By.xpath("//section[text()='Mouse Hover']")).click();
		Thread.sleep(5000);
		WebElement hover = driver.findElement(By.xpath("//h1[text()='Password : ']/following-sibling::div/img[1]"));
		Actions act=new Actions(driver);
		act.moveToElement(hover).perform();
		Thread.sleep(5000);
		List<WebElement> list = driver.findElements(By.xpath("//ul[@class='p-4']/li"));
		for(WebElement text:list)
		{
			String op = text.getText();
			System.out.println(op);
		}
		driver.quit();
	}
}
