package PopUps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopUpTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//p[text()=\"UI Testing Concepts\"]")).click();
		driver.findElement(By.xpath("//section[text()='Popups']")).click();
		driver.findElement(By.xpath("//section[text()='Javascript']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		Alert al = driver.switchTo().alert();
		String text = al.getText();
		al.accept();
		System.out.println(text);
		driver.findElement(By.xpath("//a[text()='Confirm']")).click();
		driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
		Alert confirm = driver.switchTo().alert();
		String text_confirm = confirm.getText();
		al.dismiss();
		System.out.println(text_confirm);
		driver.findElement(By.xpath("//a[text()='Prompt']")).click();
		driver.findElement(By.xpath("//button[text()='Prompt Alert Box']")).click();
		Alert prompt = driver.switchTo().alert();
		String text_prompt = prompt.getText();
		al.sendKeys("yes");
		al.accept();
		System.out.println(text_prompt);
		driver.quit();
	}

}
