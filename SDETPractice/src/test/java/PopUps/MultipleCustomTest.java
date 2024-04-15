package PopUps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleCustomTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//p[text()=\"UI Testing Concepts\"]")).click();
		driver.findElement(By.xpath("//section[text()='Popups']")).click();
		driver.findElement(By.xpath("//section[text()='Modal']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Multiple Modal")).click();
		driver.findElement(By.id("multiModalButton")).click();
		driver.findElement(By.id("multiClosemodal")).click();
		String text = driver.findElement(By.xpath("//p[text()='This is the secondary modal']")).getText();
		System.out.println(text);
		driver.findElement(By.xpath("//p[text()='This is the secondary modal']/../following-sibling::section/button")).click();
		driver.findElement(By.id("multiclose2")).click();
	}

}
