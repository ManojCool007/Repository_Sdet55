package myFirstProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample4 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//p[text()=\"UI Testing Concepts\"]")).click();
		driver.findElement(By.xpath("//section[text()='Popups']")).click();
		driver.findElement(By.xpath("//section[text()='Javascript']")).click();
		driver.findElement(By.id("buttonAlert2")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Confirm")).click();
		driver.findElement(By.id("buttonAlert5")).click();
		Alert con_alert = driver.switchTo().alert();
		con_alert.dismiss();
		Thread.sleep(2000);
		boolean text = driver.findElement(By.xpath("//p[text()='You selected Cancel']")).isDisplayed();
		System.out.println(text);
		Thread.sleep(2000);
		driver.findElement(By.linkText("Prompt")).click();
		driver.findElement(By.id("buttonAlert1")).click();
		Alert prompt_alert = driver.switchTo().alert();
		prompt_alert.sendKeys("yes");
		prompt_alert.accept();
		driver.quit();
	}

}
