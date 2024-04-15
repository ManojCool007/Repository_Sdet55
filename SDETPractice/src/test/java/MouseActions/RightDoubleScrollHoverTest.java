package MouseActions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightDoubleScrollHoverTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//p[text()=\"UI Testing Concepts\"]")).click();
		driver.findElement(By.xpath("//section[text()='Button']")).click();
		driver.findElement(By.xpath("//a[text()='Right Click']")).click();
		WebElement right = driver.findElement(By.xpath("//button[@id='btn30']"));
		Actions act=new Actions(driver);
		act.contextClick(right).perform();
		driver.findElement(By.xpath("//button[@id='btn30']/div/div[text()='Yes']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Double Click']")).click();
		WebElement click = driver.findElement(By.xpath("//button[@id='btn20']"));
		Actions act2=new Actions(driver);
		act2.doubleClick(click).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//section[text()='Mouse Actions']")).click();
		driver.findElement(By.xpath("//section[text()='Mouse Hover']")).click();
		Thread.sleep(3000);
		WebElement hover = driver.findElement(By.xpath("//h1[text()='Password : ']/following-sibling::div/img[1]"));
		Actions act3=new Actions(driver);
		act3.moveToElement(hover).perform();
		driver.quit();
	}

}
